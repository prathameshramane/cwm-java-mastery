package MyJava.DataStructures;

public class TriesArray {
    private class Node {
        public static int ALPHABET_CHAR = 26;
        private char value;
        private Node[] children = new Node[ALPHABET_CHAR];
        private boolean isEndOfNode; 

        public Node(char value) {
            this.value = value;
        }

        @Override
        public String toString(){
            return "value : " + value;
        }
    }

    Node root = new Node(' ');

    public void insert(String string){
        Node current = root;
        for(char ch : string.toCharArray()){
            int index = ch - 'a';
            if(current.children[index] == null)
                current.children[index] = new Node(ch);
            current = current.children[index];
        }
        current.isEndOfNode = true;
    }
}
