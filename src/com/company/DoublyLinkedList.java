package com.company;

public class DoublyLinkedList {

    Node head, tail = null;

    public void addNode(int key, int item) {
        Node newNode = new Node(key, item);

        if (head == null) {
            head = tail = newNode;
            head.previous = null;
            tail.next = null;
        } else {
            head.previous = newNode;
            newNode.next = head;
            head = newNode;
            head.previous = null;
        }
    }

    public void printNodes() {
        Node current = head;
        if (head == null) {
            System.out.println("Doubly linked list is empty");
            return;
        }
        System.out.println("Nodes of doubly linked list: ");
        while (current != null) {

            System.out.print(current.item + " ");
            current = current.next;
        }
    }

    public Node getNodeByIndex(int index) {
        Node current = head;
        int count = 0;
        while (current != null) {
            if (count == index)
                return current;
            count++;
            current = current.next;
        }
        return null;
    }

    public Node getHead() {
        return head;
    }

    public void deleteNode() {
        Node temp;
        temp = tail.previous;
        temp.item = tail.previous.item;
        temp.key = tail.previous.key;
        temp.previous = tail.previous.previous;
        temp.next = null;
        tail = temp;


    }
    public void setNodeByKey(int key, int value) {
        Node current = head;

        while (current != null) {
            if (current.key == key) {
                current.item = value;
                break;
            } else {
                current = current.next;
            }
        }
    }
    public int getNodeByKey(int key) {
        Node current = head;

        while (current != null) {
            if (current.key == key)
                return current.item;
            current = current.next;
        }
        return -1;
    }

    static class Node {
        int key;
        int item;
        Node previous;
        Node next;

        public Node(int key, int item) {
            this.key = key;
            this.item = item;
        }
    }

}