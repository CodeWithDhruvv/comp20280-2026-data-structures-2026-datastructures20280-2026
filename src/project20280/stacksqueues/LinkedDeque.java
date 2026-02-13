package project20280.stacksqueues;

import project20280.interfaces.Deque;
import project20280.list.DoublyLinkedList;

public class LinkedDeque<E> implements Deque<E> {

    DoublyLinkedList<E> ll;

    public LinkedDeque() {
        ll = new DoublyLinkedList<>();
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        LinkedDeque<Integer> dq = new LinkedDeque<>();
        dq.addFirst(1);
        dq.addFirst(2);
        dq.addLast(3);
        dq.addLast(4);
        System.out.println(dq);
        System.out.println("First: " + dq.first());
        System.out.println("Last: " + dq.last());
        dq.removeFirst();
        System.out.println(dq);
        dq.removeLast();
        System.out.println(dq);

    }

    @Override
    public int size() {
        return ll.size();
    }

    @Override
    public boolean isEmpty() {
        return ll.isEmpty();
    }

    @Override
    public E first() {
        return ll.first();
    }

    @Override
    public E last() {
        return ll.last();
    }

    @Override
    public void addFirst(E e) {
        ll.addFirst(e);
    }

    @Override
    public void addLast(E e) {
        ll.addLast(e);
    }

    @Override
    public E removeFirst() {
        return ll.removeFirst();
    }

    @Override
    public E removeLast() {
        return ll.removeLast();
    }

    public String toString() {
        return ll.toString();
    }
}
