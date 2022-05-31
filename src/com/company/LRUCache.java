package com.company;

public class LRUCache implements Cache {

    //As the fields are implementation details it is better
    //to make Cache an interface and bring fields in LRU

    public int cp;
    public DoublyLinkedList.Node head;
    public DoublyLinkedList.Node tail;
    public int sizeOfLinkedList;
    public DoublyLinkedList mp = new DoublyLinkedList();

    public LRUCache(int cp) {
        this.cp = cp;
    }

    @Override
    public void set(int key, int value) {

        if (sizeOfLinkedList <= cp) {
            if (head == null) {
                mp.addNode(key, value);
                head = mp.getHead();
                sizeOfLinkedList++;
                return;
            }
            for (int i = 0; i < cp; i++) {
                if (mp.getNodeByIndex(i) == null) break;
                if (mp.getNodeByIndex(i).key == key) {
                    mp.setNodeByKey(key, value);
                    break;
                }
            }

            mp.addNode(key, value);
            sizeOfLinkedList++;


        }
        if (sizeOfLinkedList > cp) {
            mp.deleteNode();
            sizeOfLinkedList--;
        }

    }


    @Override
    public int get(int key) {
        return mp.getNodeByKey(key);
    }

    public void printNodes() {
        mp.printNodes();
    }
}
