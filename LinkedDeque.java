package part2;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 *
 * @author Andrius Kaliacius
 * @param <E>
 */

public class LinkedDeque<E> implements Iterable<E>{

    private final Node<E> first, last;
    private int size;

    private class Node<E> {
        E content;
        Node<E> next;
        Node<E> prev;
    }
    
    // construct an empty deque
    public LinkedDeque() {
        size = 0;
        first = new Node<>();
        last = new Node<>();
        first.content = null;
        last.content = null;
        first.next = null;
        last.prev = null;
        first.prev = last;
        last.next = first;
    }
    
    // is the deque empty?
    public boolean isEmpty() {
        return size == 0;
    }
    
    // return the number of items on the deque
    public int size() {
        return size;
    }
    
    // add the item to the front
    public void addFirst(E item) {
        if (item == null) {
            throw new NullPointerException("trying to add 'null' item");
        } else {
            Node<E> node = new Node<>();
            node.content = item;
            node.next = first;
            node.prev = first.prev;
            first.prev.next = node;
            first.prev = node;
            size++;
        }
    }
    
    // add the item to the end
    public void addLast(E item) {
        if (item == null) {
            throw new NullPointerException("trying to add 'null' item");
        } else {
            Node<E> node = new Node<>();
            node.content = item;
            node.prev = last;
            node.next = last.next;
            last.next.prev = node;
            last.next = node;
            size++;
        }
    }

    // remove and return the item from the front
    public E removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException("trying to remove item from empty queue");
        } else {
            Node<E> firstNode = first.prev;
            E result = firstNode.content;
            firstNode.prev.next = first;
            first.prev = firstNode.prev;
            firstNode.next = null;
            firstNode.prev = null;
            size--;
            return result;
        }
    }

    // remove and return the item from the end
    public E removeLast() {
        if (isEmpty()) {
            throw new NoSuchElementException("trying to remove item from empty queue");
        } else {
            Node<E> lastNode = last.next;
            E result = lastNode.content;
            lastNode.next.prev = last;
            last.next = lastNode.next;
            lastNode.next = null;
            lastNode.prev = null;
            size--;
            return result;
        }
    }
    
    // return an iterator over items in order from front to end
    @Override
    public Iterator<E> iterator() {
        return new LinkedDequeIterator();
    }
    
    
    private class LinkedDequeIterator implements Iterator<E>{
        Node<E> current = first.prev;
        
        @Override
        public boolean hasNext() {
            return current != last;
        }

        @Override
        public E next() {
            if(!hasNext())throw new NoSuchElementException(); 
            else{
                E item = current.content;
                current = current.prev;
                return item;
            }
        }
        
        @Override
        public void remove(){
            throw new UnsupportedOperationException();
        }
    
    }
}
