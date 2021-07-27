package com.tan.lib.algorithm;

// head -> 1 -> 4 -> 3 -> 7 -> head
class CircularLinkedList {
    Node head;
    int size;

    // x = 1 => x < curr && x < next
    // x = 7 => curr <= x < next
    // x = 10 => x > curr && x > next
    // head -> 4 -> 6 -> 9 -> head
    public void insert(int val) {
        // empty
        Node newNode = new Node(val);
        if (head == null) {
            head = newNode;
            head.next = head;
        } else if (size == 1) {
            if (val > head.val) {
                head.next = newNode;
                newNode.next = head;
            } else {
                Node temp = head;
                head = newNode;
                newNode.next = temp;
                temp.next = head;
            }
        } else {
            Node prev = head;
            Node curr = head;
            while (val > curr.val && prev.val <= curr.val) {
                prev = curr;
                curr = curr.next;
            }
            prev.next = newNode;
            newNode.next = curr;

        }
        size++;
    }


    static class Node {
        int val;
        Node next;

        Node(int val) {
            this.val = val;
        }

    }
}
