package com.company;

public interface Cache {

    //As the fields are implementation details it is better
    //to make Cache an interface and move fields in LRU

    void set(int key, int value);

    int get(int key);
}
