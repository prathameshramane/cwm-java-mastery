package MyJava.DataStructures;

import java.util.*;


public class TrieHashMap {
    private class Node {
        private char value;
        private HashMap<Character, Node> children = new HashMap<>();
        private boolean isEndOfNode; 

        public Node(char value) {
            this.value = value;
        }

        @Override
        public String toString(){
            return "value : " + value;
        }

        public boolean hasChild(char ch){
            return children.containsKey(ch);
        }

        public void addChild(char ch){
            children.put(ch, new Node(ch));
        }

        public Node getChild(char ch){
            return children.get(ch);
        }

        public Node[] getChildren() {
            return children.values().toArray(new Node[0]);
        }

        public void removeChild(char ch){
            children.remove(ch);
        }

        public boolean hasChildren(){
            return !children.isEmpty();
        }
    }

    Node root = new Node(' ');

    public void insert(String word){
        Node current = root;
        for(char ch : word.toCharArray()){
            if(!current.hasChild(ch))
                current.addChild(ch);
            current = current.getChild(ch);
        }
        current.isEndOfNode = true;
    }

    public void remove(String word){
        remove(word, root, 0);
    }

    public List<String> autocomplete(String word) {
        List<String> words = new ArrayList<>();
        var lastNode = getLastNode(word);
        if(lastNode != null)
            getWords(lastNode, word, words);
        return words;
    }

    public void getWords(Node currentNode, String currentString, List<String> words){
        if(currentNode.isEndOfNode){
            words.add(currentString);
        }
        
        for(var child : currentNode.getChildren()){
            getWords(child, currentString + child.value, words);
        }
    }

    private Node getLastNode(String word){
        if(word == null)
            return null;

        var current = root;
        for(char ch : word.toCharArray()){
            if(!current.hasChild(ch))
                return null;
            current = current.getChild(ch);
        }
        return current;
    }

    private void remove(String word, Node root, int index){
        if(index == word.length()){
            root.isEndOfNode = false;
            return;
        }

        char ch = word.charAt(index);
        Node child = root.getChild(ch);
        if(child == null)
            return;
        
        remove(word, child, index + 1);


        if(!child.hasChildren() && !child.isEndOfNode)
            root.removeChild(ch);

    }

    public boolean contains(String word){
        Node current = root;
        for(char ch : word.toCharArray()){
            if(!current.hasChild(ch))
                return false;
            current = current.getChild(ch);
        }
        return current.isEndOfNode;
    }

    public void preOrderTraverse(){
        preOrderTraverse(root);
    }

    private void preOrderTraverse(Node root){
        System.out.println(root.value);
        for(var child : root.getChildren())
            preOrderTraverse(child);
    }

    public void postOrderTraverse(){
        postOrderTraverse(root);
    }

    private void postOrderTraverse(Node root){
        for(var child : root.getChildren())
            postOrderTraverse(child);
        System.out.println(root.value);
    }

}

