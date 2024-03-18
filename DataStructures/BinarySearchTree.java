package MyJava.DataStructures;

public class BinarySearchTree {
    private class Node{
        private int value;
        private Node leftChild;
        private Node rightChild;
        public Node(int value){
            this.value=value;
        }
    }
    private Node root;

    public void insert(int value){
        Node newNode = new Node(value);

        if(isEmpty()){
            root=newNode;
            return;
        }

        Node current = root;
        while(true){
            if(newNode.value > current.value){
                if(current.rightChild == null){
                    current.rightChild = newNode;
                    break;
                }
                current = current.rightChild;
            } else if(newNode.value < current.value){
                if(current.leftChild == null){
                    current.leftChild = newNode;
                    break;
                }
                current = current.leftChild;
            }  else {
                break;
            }
        }
    }

    public boolean find(int value){
        if(isEmpty())
            return false;
        
        Node current = root;
        while(current!=null){
            if(value > current.value){
                current = current.rightChild;
            } else if(value < current.value){
                current = current.rightChild;
            } else {
                return true;
            }
        }

        return false;
    }

    public void preorderTraversal(){
        preorderTraversal(root);
    }

    private void preorderTraversal(Node root){
        if(root==null)
            return;
    
        System.out.print(root.value + " ");
        preorderTraversal(root.leftChild);
        preorderTraversal(root.rightChild);
    }

    public void inOrderTraversal(){
        inOrderTraversal(root);
    }

    private void inOrderTraversal(Node root){
        if(root==null)
            return;
        
        inOrderTraversal(root.leftChild);
        System.out.print(root.value + " ");
        inOrderTraversal(root.rightChild);
    }

    public void postOrderTraversal(){
        postOrderTraversal(root);
    }

    private void postOrderTraversal(Node root){
        if(root==null)
            return;
        
        postOrderTraversal(root.leftChild);
        postOrderTraversal(root.rightChild);
        System.out.print(root.value + " ");
    }

    public int height(){
        return height(root);
    }

    private int height(Node root){
        if(root==null)
            return 0;

        return 1 + Math.max(height(root.leftChild), height(root.rightChild));
    }

    public int minInTree(){
        return minInTree(root);
    }

    private int minInTree(Node root){
        if(root == null)
            return -1;
        
        if(root.leftChild == null && root.rightChild == null)
            return root.value;

        return Math.min(root.value, Math.min(minInTree(root.leftChild), minInTree(root.rightChild)));
        
    }

    public int minInBst(){
        if(isEmpty())
            return -1;

        Node current = root;
        Node previous = root;
        while(current != null){
            previous = current;
            current = current.leftChild;
        }

        return previous.value;
    }

    public boolean equals(BinarySearchTree other){
        return equals(root, other.root);
    }

    private boolean equals(Node root, Node other){
        if(root == null && other == null)
            return true;
        
        if(root != null && other != null){
            return root.value == other.value &&
                    equals(root.leftChild, other.leftChild) &&
                    equals(root.rightChild, other.rightChild);
        }

        return false;
    }

    public boolean isBinarySearchTree(){
        return isBinarySearchTree(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public void swapRoot(){
        Node temp = root.leftChild;
        root.leftChild = root.rightChild;
        root.rightChild = temp;
    }

    private boolean isBinarySearchTree(Node root, int min, int max){
        if(isLeafNode(root))
            return true;

        if(root.value  > min && root.value < max){
            return isBinarySearchTree(root.leftChild, min, root.value) &&
                    isBinarySearchTree(root.rightChild, root.value, max);
        }

        return false;
    }

    public void NodeAtKDistance(int k){
        NodeAtKDistance(root, k);
    }

    private void NodeAtKDistance(Node root, int k){
        if(root==null)
            return;

        if(k == 0){
            System.out.print(root.value + " ");
            return;
        }

        NodeAtKDistance(root.leftChild, k-1);
        NodeAtKDistance(root.rightChild, k-1);
    }

    private boolean isLeafNode(Node node){
        return node.leftChild == null && node.rightChild == null;
    }

    public void breathFirstSearch(){
        for(int i=0;i<height();i++){
            NodeAtKDistance(i);
        }
    }

    public boolean isEmpty(){
        return root==null;
    }
}
