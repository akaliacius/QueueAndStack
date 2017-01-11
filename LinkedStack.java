
package part2;

import java.util.Iterator;

/**
 *
 * @author akali
 * @param <E>
 */


public class LinkedStack<E> implements Iterable<E> {
    private Node<E> head = null;
    private int size = 0;

    @Override
    public Iterator iterator() {return new StackIterator();}
    
    private class StackIterator implements Iterator<E> {
        
        private Node<E> current = head; 

        @Override
        public boolean hasNext() {
            return current.next != null;
        }

        @Override
        public E next() {
            E content = current.content;
            current = current.next;
            return content;
        }
    
    }
    
    private class Node<E>{
        E content;
        Node next;
    }
    
    public boolean isEmpty(){
        return head == null;
    }
    
    public void push(E content){
        Node n = new Node();
        n.content = content;
        n.next = head;
        head = n;
        size++;
    }
    
    public E pop(){
        if(size == 0)return null;
        E item = head.content;
        Node temp = head.next;
        head.next = null;
        head = temp;
        size--;
        return item;
    }
    
    public int size(){
        return size;
    }
    
    public E peek(){
        return head.content;
    }
    
}
