package MyJava.DataStructures.LinkedList;

import java.util.NoSuchElementException;

public class LinkedList {
    private class Node {
        private int value;
        private Node next=null;
        public Node(int value){
            this.value = value;
        }
    }
    private Node first;
    private Node last;
    private int size;

    public void addLast(int value) {
        Node newNode = new Node(value);
        if (isEmpty()) {
            initialiseLinkedList(newNode);
        } else {
            last.next = newNode;
            last = newNode;
        }
        size++;
    }

    public void addFirst(int value) {
        Node newNode = new Node(value);
        if (isEmpty()) {
            initialiseLinkedList(newNode);
        } else {
            newNode.next = first;
            first = newNode;
        }
        size++;
    }

    public void deleteFirst() {
        if (isEmpty()) {
            System.err.println("List is Empty!");
        } else {
            Node tempNode = first;
            first = first.next;
            tempNode.next = null;
        }
        size--;
    }

    public void deleteLast() {
        if (isEmpty()) {
            System.err.println("List is Empty!");
        } else if(first.next == null){
            first = null;
            last = null;
        } else {
            Node tempNode = first;
            while (tempNode.next != last) {
                tempNode = tempNode.next;
            }
            last = tempNode;
            last.next = null;
        }
        size--;
    }

    public int size(){
        return size;
    }

    public boolean contains(int value) {
        if(isEmpty()){
            return false;
        }else{
            Node tempNode=first;
            while(tempNode != null){
                if(tempNode.value == value)
                    return true;
                tempNode = tempNode.next;
            }
            return false;
        }
    }

    public int indexOf(int value){
        if(isEmpty()){
            return -1;
        }else{
            int index=0;
            Node tempNode=first;
            while(tempNode != null){
                if(tempNode.value == value)
                    return index;
                tempNode = tempNode.next;
                index++;
            }
            return -1;
        }
    }

    public void print(){
        if(!isEmpty()){
            Node tempNode = first;
            while(tempNode!=null){
                System.out.print(tempNode.value + " ");
                tempNode = tempNode.next;
            }
        }
    }

    public void reverse(){
        if(isEmpty()){
            throw new NoSuchElementException();
        }
        if(first == last) return;
        Node left = first;
        Node mid = first.next;
        Node right = mid.next;
        while(mid != null){
            mid.next = left;
            left = mid;
            mid = right;
            if(right != null)
                right = right.next;
        }
        Node temp = first;
        first.next=null;
        first = last;
        last = temp;
    }

    public int findKthNode(int k){
        if(k <= 0 || k>=size)
            throw new IllegalArgumentException();

        Node first=this.first;
        Node last=first;
        for(int i=0; i<k-1; i++)
            last=last.next;
        
        while(last!=this.last){
            first=first.next;
            last=last.next;
        }
        return first.value;
    }

    private boolean isEmpty(){
        if(first == null)
            return true;
        return false;
    }

    private void initialiseLinkedList(Node newNode){
        first = last = newNode;
    }
}
