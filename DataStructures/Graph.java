package MyJava.DataStructures;

import java.util.*;
import java.util.Stack;

public class Graph {

    private class Node{
        private String label;

        public Node(String label){
            this.label = label;
        }

        @Override
        public String toString(){
            return label;
        }
    }

    private Map<String, Node> nodes = new HashMap<>();
    private Map<Node, List<Node>> adjacencyList = new HashMap<>();

    public void addNode(String string){
        var node = new Node(string);
        nodes.putIfAbsent(string, node);
        adjacencyList.putIfAbsent(node, new ArrayList<>());
    }

    public void addEdge(String from, String to){
        Node fromNode = nodes.get(from);
        Node toNode = nodes.get(to);
        if(fromNode == null || toNode == null)
            throw new IllegalStateException();
        
        adjacencyList.get(fromNode).add(toNode);
    }

    public void removeNode(String string){
        Node sourceNode = nodes.get(string);
        if(sourceNode==null)
            return;
        
        for(var node : adjacencyList.keySet()){
            adjacencyList.get(node).remove(sourceNode);
        }

        adjacencyList.remove(sourceNode);
        nodes.remove(string);
    }

    public void removeEdge(String from, String to){
        Node fromNode = nodes.get(from);
        Node toNode = nodes.get(to);
        if(fromNode == null || toNode == null)
            return;
        
        adjacencyList.get(fromNode).remove(toNode);
    }

    public void print() {
        for(Node source : adjacencyList.keySet()){
            var targets = adjacencyList.get(source);
            if(!targets.isEmpty())
                System.out.println(source + " is connected to " + targets);
        }
    }

    public void traverseDepthFirst(String string){
        Node node = nodes.get(string);
        if(node==null)
            return;
        
        // traverseDepthFirst(node, new HashSet<>());
        traverseDepthFirstIter(node);
    }

    private void traverseDepthFirst(Node root, Set<Node> visited){
        System.out.println(root.label);
        visited.add(root);

        for(Node node : adjacencyList.get(root)){
            if(!visited.contains(node))
                traverseDepthFirst(node, visited);
        }
    }

    private void traverseDepthFirstIter(Node root){
        Stack<Node> st = new Stack<>();
        Set<Node> visited = new HashSet<>();
        st.push(root);

        while(!st.isEmpty()){
            Node current = st.pop();

            if(visited.contains(current))
                continue;

            System.out.println(current.label);
            visited.add(current);

            for(Node node : adjacencyList.get(current)){
                if(!visited.contains(node))
                    st.push(node);
            }
        }
    }

    public void traverseBreadthFirst(String string){
        Node root = nodes.get(string);

        if(root==null)
            return;

        Queue<Node> q = new ArrayDeque<>();
        Set<Node> visited = new HashSet<>();
        q.add(root);

        while(!q.isEmpty()) {
            Node current = q.remove();
            if(visited.contains(current))
                continue;
            
            System.out.println(current.label);
            visited.add(current);

            for(Node node : adjacencyList.get(current)){
                if(!visited.contains(node))
                    q.add(node);
            }
        }
    }
}
