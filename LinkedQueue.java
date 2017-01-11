package part2;

import java.util.NoSuchElementException;

/**
 *
 * @author akali
 * @param <E>
 */

public class LinkedQueue<E> {
    private Node<E> first, last;
    
    private class Node<E>{
        E content;
        Node<E> next = null;
    }
    
    public boolean isEmpty(){
        return first == null;
    }
    
    public void enqueue(E content){
        Node<E> newNode = new Node<>();
        newNode.content = content;
        if(isEmpty()){
            first = newNode;
            last = newNode;
        }
        else{
            last.next = newNode;
            last = newNode;
        }
    }
    
    public E dequeue(){
        if(isEmpty())throw new NoSuchElementException("The queue is empty");
        else{
            Node<E> oldFirst = first;
            E content = first.content;
            first = first.next;
            if(isEmpty())last = null;
            else oldFirst.next = null;
            return content;
        }
    }
    
    @Override
    public String toString(){
        if(first == null && last == null)return "empty";
        String f = first.content.toString();
        String l = last.content.toString();
        return "First: " + f + "\t" + "Last: " + l;
    }
}
