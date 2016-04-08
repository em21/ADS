import java.util.*;
import java.io.*;

public class ArrayQueue<E> {

    public static final int CAPACITY = 10;  // default queue capacity
    private E[] Q;                          // E array used to implement the queue  
    private int n;                          // actual capacity of queue
    private int front;                      // index for the top of queue
    private int rear;                       // rear of the queue
    private int size;                       // size of the queue
    
	
    public ArrayQueue(){this(CAPACITY);}

    @SuppressWarnings("unchecked")
    public ArrayQueue(int capacity){
	n = capacity;
	Q = (E[]) new Object [n]; 
	front = rear = size = 0;
    }
    //
    // NOTE: java does not allow creation of array with parametrised type!
    //
	
    public int size(){return size;}
  
	 
    public boolean isEmpty(){return size ==0;}
 

    public E front() throws ArrayQueueException {
		if (Q[front] != null) {return Q[front];}
		else{throw new ArrayQueueException("Array underflow");}
    }
	
    public void enqueue(E element) throws ArrayQueueException {
		if (rear<n){
			Q[rear]=element; 
			rear++;
			size++;
		}
		else{throw new ArrayQueueException ("Array overflow");}
	}
    
    public E dequeue() throws ArrayQueueException {
		if (Q[front] != null){
			rear--;
			E last = Q[rear];
			Q[rear] = null;
			size--;
			return last;
		}
		else{throw new ArrayQueueException("Cannot remove from an empty list");}
	}
   
    public String toString(){
		if (size() == 0){return "[]";}
		String s = "[";
		int i = 0; 
		while (Q[i+1] != null){
			s += Q[i].toString() + ",";
			i++;
		}
	    return s + (Q[rear-1]).toString() +"]";
	}
    //
    // IMPLEMENT ME
    //
    //
    // NOTE: if the queue contains 1,2,3 then return "[1,2,3]"
    //       if the queue contains 1 then return "[1]"
    //       if the queue is empty return "[]"
    //
}
	
