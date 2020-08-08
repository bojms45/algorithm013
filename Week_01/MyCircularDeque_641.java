package LinkedList;

public class MyCircularDeque_641 {
    Node head, tail;
    int size;
    int capacity;

    /** Initialize your data structure here. Set the size of the deque to be k. */
    public MyCircularDeque_641(int k) {
        this.head = null;
        this.tail = null;
        this.size = 0;
        this.capacity = k;
    }

    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
        if (size < capacity) {
            if (head == null) {
                head = new Node(value);
                tail = head;
            } else {
                Node newNode = new Node(value);
                head.prev = newNode;
                newNode.next = head;
                head = newNode;
            }

            size++;
            return true;
        }
        return false;
    }

    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
        if (size < capacity) {
            if (tail == null) {
                tail = new Node(value);
                head = tail;
            } else {
                Node newNode = new Node(value);
                tail.next = newNode;
                newNode.prev = tail;
                tail = newNode;
            }

            size++;
            return true;
        }

        return false;
    }

    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        if (size > 0) {
            if (size == 1) {
                head = null;
                tail = null;
            } else {
                Node temp = head.next;
                head = null;
                head = temp;
            }

            size--;
            return true;
        }
        return false;
    }

    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
        if (size > 0) {
            if (size == 1) {
                head = null;
                tail = null;
            } else {
                Node temp = tail.prev;
                tail = null;
                tail = temp;
            }

            size--;
            return true;
        }
        return false;
    }

    /** Get the front item from the deque. */
    public int getFront() {
        return head == null ? -1 : head.val;
    }

    /** Get the last item from the deque. */
    public int getRear() {
        return tail == null ? -1 : tail.val;
    }

    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        return size == 0;
    }

    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        return size == capacity;
    }

    private class Node {
        int val;
        Node prev;
        Node next;
        public Node(int val) {
            this.val = val;
            this.prev = null;
            this.next = null;
        }
    }
}
/**
 *      建立doubly linkedlist, 前后插入，删除即可
 *      Time: O(1)
 *      Space: O(N)
 * */
