package com.tan.lib.algorithm;

import com.tan.lib.PrintUtils;

class LinkedList {
    public static void main(String[] args) {
        Node node4 = new Node(4);
        Node node3 = new Node(3, node4);
        Node node2 = new Node(2, node3);
        Node node1 = new Node(1, node2);

//        print(node1);
//        PrintUtils.print("----reversed-----");
//        new LinkedList();
//        Node head = recursiveReverse(node1);
//        print(head);

        PrintUtils.print(hasLoop(node1));
        PrintUtils.print(hasLoop(createLoopList()));
    }

    /**
     * input:  1 -> 2 -> 3 -> 4
     * output: 1 <- 2 <- 3 <- 4
     * <p>
     * Use 2 pointer prev & curr. prev.next = null
     * At each step
     * cache curr.next
     * curr.next -> prev
     * update prev
     * update cur
     */
    private static Node reverse(Node node) {
        // 1 <- 2 <- 3 <- 4
        Node prev = null;       // 1, 2, 3, 4
        Node curr = node;  // 2, 3, 4, null
        while (curr != null) {
            Node next = curr.next; // 3, 4, null
            curr.next = prev;   // 2 -> 1, 3 -> 2, 4 -> 3

            // Update prev and curr
            prev = curr;        // 2, 3, 4
            curr = next;           // 3, 4, null
        }
        return prev;
    }

    /**
     * Divide the list into 2 parts: first node and the rest
     * Reverse the rest called rest
     * Update rest.next -> head
     * Update head.next -> null
     */
    private static Node recursiveReverse(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        Node rest = recursiveReverse(head.next);
        head.next.next = head;
        head.next = null;

        return rest;
    }

    private static Node recursiveReverse(Node prev, Node curr) {
        if (curr == null) {
            return null;
        }
        // Reach last node
        if (curr.next == null) {
            curr.next = prev;
            return curr;
        }
        Node next = curr.next;
        curr.next = prev;
        return recursiveReverse(curr, next);
    }

    /**
     * 2 pointers slow (1) and fast (2)
     * if one of them are null -> false
     * if they are met at a common -> true
     */
    //   1 -> 2 -> 3 -> 4
    //             |    |
    //             6 <- 5
    private static boolean hasLoop(Node head) {
        if (head == null || head.next == null) {
            return false;
        }
        Node slow = head;           // 1, 2, 3
        Node fast = head.next.next; // 3, 5, 3
        while (slow != null && fast != null) {
            if (slow.equals(fast)) {
                return true;
            }
            slow = slow.next;
            fast = fast.next != null ? fast.next.next : null;
        }
        return false;
    }

    private static Node createLoopList() {
        Node node6 = new Node(6);
        Node node5 = new Node(5, node6);
        Node node4 = new Node(4, node5);
        Node node3 = new Node(3, node4);
        Node node2 = new Node(2, node3);
        Node node1 = new Node(1, node2);
        node6.next = node3;
        return node1;
    }

    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) { return true; }
            if (o == null || getClass() != o.getClass()) { return false; }

            Node node = (Node) o;

            if (data != node.data) { return false; }
            return next != null ? next.equals(node.next) : node.next == null;
        }

        @Override
        public int hashCode() {
            int result = data;
            result = 31 * result + (next != null ? next.hashCode() : 0);
            return result;
        }
    }

    static void print(Node node) {
        if (node == null) {
            return;
        }
        System.out.println(node.data);
        print(node.next);
    }
}
