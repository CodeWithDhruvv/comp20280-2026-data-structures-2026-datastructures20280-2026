package project20280.list;

import project20280.interfaces.List;

import java.util.Iterator;

public class CircularlyLinkedList<E> implements List<E> {

    private class Node<T> {
        private T data;
        private Node<T> next;

        public Node(T e, Node<T> n) {
            data = e;
            next = n;
        }

        public T getData() {
            return data;
        }

        public void setNext(Node<T> n) {
            next = n;
        }

        public Node<T> getNext() {
            return next;
        }
    }

    private Node<E> tail = null;
    private int size = 0;

    public CircularlyLinkedList() {

    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public E get(int i) {
        if (i < 0 || i >= size) {
            return null;
        }
        Node<E> current = tail.next;
        for (int j = 0; j < i; j++) {
            current = current.getNext();
        }
        return current.getData();
    }

    @Override
    public void add(int i, E e) {
        if (i < 0 || i > size) {
            return;
        }
        if (i == 0) {
            addFirst(e);
            return;
        }
        if (i == size) {
            addLast(e);
            return;
        }
        Node<E> current = tail.next;
        for (int j = 0; j < i - 1; j++) {
            current = current.getNext();
        }
        Node<E> newest = new Node<>(e, current.next);
        current.next = newest;
        size++;
    }

    @Override
    public E remove(int i) {
        if (i < 0 || i >= size) {
            return null;
        }
        if (i == 0) {
            return removeFirst();
        }
        if (i == size - 1) {
            return removeLast();
        }
        Node<E> current = tail.next;
        for (int j = 0; j < i - 1; j++) {
            current = current.getNext();
        }
        E answer = current.next.getData();
        current.next = current.next.next;
        size--;
        return answer;
    }

    public void rotate() {
        if (tail != null) {
            tail = tail.getNext();
        }
    }

    private class CircularlyLinkedListIterator<E> implements Iterator<E> {
        Node<E> curr = (Node<E>) tail;
        int count = 0;

        @Override
        public boolean hasNext() {
            return count < size;
        }

        @Override
        public E next() {
            curr = curr.next;
            E res = curr.data;
            count++;
            return res;
        }

    }

    @Override
    public Iterator<E> iterator() {
        return new CircularlyLinkedListIterator<E>();
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public E removeFirst() {
        if (isEmpty()) {
            return null;
        }
        Node<E> head = tail.next;
        E answer = head.getData();
        if (head == tail) {
            tail = null;
        } else {
            tail.next = head.next;
        }
        size--;
        return answer;
    }

    @Override
    public E removeLast() {
        if (isEmpty()) {
            return null;
        }
        E answer = tail.getData();
        if (tail.next == tail) {
            tail = null;
        } else {
            Node<E> current = tail.next;
            while (current.next != tail) {
                current = current.next;
            }
            current.next = tail.next;
            tail = current;
        }
        size--;
        return answer;
    }

    @Override
    public void addFirst(E e) {
        if (isEmpty()) {
            tail = new Node<>(e, null);
            tail.next = tail;
        } else {
            Node<E> newest = new Node<>(e, tail.next);
            tail.next = newest;
        }
        size++;
    }

    @Override
    public void addLast(E e) {
        addFirst(e);
        tail = tail.next;
    }


    public String toString() {
        if (isEmpty()) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder("[");
        Node<E> curr = tail;
        do {
            curr = curr.next;
            sb.append(curr.data);
            if (curr != tail) {
                sb.append(", ");
            }
        } while (curr != tail);
        sb.append("]");
        return sb.toString();
    }


    public static void main(String[] args) {
        CircularlyLinkedList<Integer> ll = new CircularlyLinkedList<Integer>();
        for (int i = 10; i < 20; ++i) {
            ll.addLast(i);
        }

        System.out.println(ll);

        ll.removeFirst();
        System.out.println(ll);

        ll.removeLast();
        System.out.println(ll);

        ll.rotate();
        System.out.println(ll);

        ll.removeFirst();
        ll.rotate();
        System.out.println(ll);

        ll.removeLast();
        ll.rotate();
        System.out.println(ll);

        for (Integer e : ll) {
            System.out.println("value: " + e);
        }

    }
}