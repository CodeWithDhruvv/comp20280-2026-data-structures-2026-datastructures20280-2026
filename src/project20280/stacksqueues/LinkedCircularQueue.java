package project20280.stacksqueues;

import project20280.interfaces.Queue;


/**
 * Realization of a circular FIFO queue as an adaptation of a
 * CircularlyLinkedList. This provides one additional method not part of the
 * general Queue interface. A call to rotate() is a more efficient simulation of
 * the combination enqueue(dequeue()). All operations are performed in constant
 * time.
 */

public class LinkedCircularQueue<E> implements Queue<E> {

    private static class Node<E> {
        E element;
        Node<E> next;

        Node(E e, Node<E> n) {
            element = e;
            next = n;
        }
    }

    private Node<E> tail = null;
    private int size = 0;

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        LinkedCircularQueue<Integer> q = new LinkedCircularQueue<>();
        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);
        System.out.println(q.first());
        System.out.println(q.dequeue());
        System.out.println(q.size());
    }

    @Override
    public int size() {
        // TODO Auto-generated method stub
        return size;
    }

    @Override
    public boolean isEmpty() {
        // TODO Auto-generated method stub
        return size == 0;
    }

    @Override
    public void enqueue(E e) {
        // TODO Auto-generated method stub
        Node<E> newest = new Node<>(e, null);
        if (tail == null) {
            newest.next = newest;
            tail = newest;
        } else {
            newest.next = tail.next;
            tail.next = newest;
            tail = newest;
        }
        size++;
    }

    @Override
    public E first() {
        // TODO Auto-generated method stub
        if (tail == null) return null;
        return tail.next.element;
    }

    @Override
    public E dequeue() {
        // TODO Auto-generated method stub
        if (tail == null) return null;
        Node<E> head = tail.next;
        E answer = head.element;
        if (head == tail) tail = null;
        else tail.next = head.next;
        size--;
        return answer;
    }

}
