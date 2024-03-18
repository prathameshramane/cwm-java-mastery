package MyJava.DataStructures;

public class Main {
    public static void main(String[] args){
        Graph g = new Graph();
        g.addNode("A");
        g.addNode("B");
        g.addNode("C");
        g.addNode("D");
        g.addEdge("A", "B");
        g.addEdge("B", "D");
        g.addEdge("D", "C");
        g.addEdge("A", "C");
        g.traverseBreadthFirst("A");
    }
}