package project20280.list;

import project20280.interfaces.List;

import java.util.Iterator;

public class SinglyLinkedList<E> implements List<E> {

    private static class Node<E> {

        private final E element;            // reference to the element stored at this node

        /**
         * A reference to the subsequent node in the list
         */
        private Node<E> next;         // reference to the subsequent node in the list

        /**
         * Creates a node with the given element and next node.
         *
         * @param e the element to be stored
         * @param n reference to a node that should follow the new node
         */
        public Node(E e, Node<E> n) {
            element = e;
            next  = n;
            // TODO
        }

        // Accessor methods

        /**
         * Returns the element stored at the node.
         *
         * @return the element stored at the node
         */
        public E getElement() {
            return element;
        }

        /**
         * Returns the node that follows this one (or null if no such node).
         *
         * @return the following node
         */
        public Node<E> getNext() {
            if (next != null){
                return next;
            }
            else return null;
        }

        // Modifier methods

        /**
         * Sets the node's next reference to point to Node n.
         *
         * @param n the node that should follow this one
         */
        public void setNext(Node<E> n) {
            next = n;
            // TODO
        }
    }

    //----------- end of nested Node class -----------
    /**
     * The head node of the list
     */
    private Node<E> head = null;               // head node of the list (or null if empty)


    /**
     * Number of nodes in the list
     */
    private int size = 0;                      // number of nodes in the list

    public SinglyLinkedList() {
    }              // constructs an initially empty list

    //@Override
    public int size() {
         return size;
    }

    //@Override
    public boolean isEmpty() {
        // TODO
        return head==null;
    }

    @Override
    public E get(int position) {
        // TODO
        if (position < 0 || position>=size){
            return null;
        }
        Node <E> current = head;
        for (int i=0; i<position; i++){
            current = current.getNext();
        }
        return current.getElement();
    }

    @Override
    public void add(int position, E e) {    //E =parameter type, e = parameter you want to add
        // TODO
        if (position > size||  position<0){
            return;
        }
        if(position == 0){
            addFirst(e);
            return;
        }

        Node<E> current = head;
        for (int i = 0; i<position-1 ;i++){
            current = current.getNext();
        }

        Node<E> newest = new Node<>(e, current.getNext());
        current.setNext(newest);
        size++;
    }

    @Override
    public void addFirst(E e) {
        // TODO
        head = new Node<>(e, head);
        size++;
    }

    @Override
    public void addLast(E e) {
        // TODO
        if(head == null){
            addFirst(e);
            return;
        }
        Node<E> current = head;
        while (current.next != null){
            current = current.getNext();
        }
        Node<E> newest = new Node<>(e, null);
        current.setNext(newest);
        size++;

    }

    @Override
    public E remove(int position) {
        if (position < 0 || position >= size) {
            return null;
        }

        if (position == 0) {
            return removeFirst();
        }

        Node<E> current = head;
        for (int i = 0; i < position - 1; i++) {
            current = current.getNext();
        }
        E answer = current.getNext().getElement();
        current.setNext(current.getNext().getNext());
        size--;
        return answer;
    }

    @Override
    public E removeFirst() {
        if (isEmpty()) return null;
        E answer = head.getElement();
        head = head.getNext();
        size--;
        return answer;
    }

    @Override
    public E removeLast() {
        if (isEmpty()) return null;
        if (size == 1) return removeFirst();

        Node<E> current = head;
        while (current.getNext().getNext() != null) {  // Stop at 2nd-to-last
            current = current.getNext();
        }
        E answer = current.getNext().getElement();
        current.setNext(null);
        size--;
        return answer;
    }

    //@Override
    public Iterator<E> iterator() {
        return new SinglyLinkedListIterator<E>();
    }

    private class SinglyLinkedListIterator<E> implements Iterator<E> {
        Node<E> curr = (Node<E>) head;

        @Override
        public boolean hasNext() {
            return curr != null;
        }

        @Override
        public E next() {
            E res = curr.getElement();
            curr = curr.next;
            return res;
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Node<E> curr = head;
        while (curr != null) {
            sb.append(curr.getElement());
            if (curr.getNext() != null)
                sb.append(", ");
            curr = curr.getNext();
        }
        sb.append("]");
        return sb.toString();
    }

    public static void main(String[] args) {
        SinglyLinkedList<Integer> ll = new SinglyLinkedList<Integer>();
        System.out.println("ll " + ll + " isEmpty: " + ll.isEmpty());
        //LinkedList<Integer> ll = new LinkedList<Integer>();

        ll.addFirst(0);
        ll.addFirst(1);
        ll.addFirst(2);
        ll.addFirst(3);
        ll.addFirst(4);
        ll.addLast(-1);
        //ll.removeLast();
        //ll.removeFirst();
        //System.out.println("I accept your apology");
        //ll.add(3, 2);
        System.out.println(ll);
        ll.remove(5);
        System.out.println(ll);
    }
}
