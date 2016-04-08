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
	    if (size() >= n){
		    throw new ArrayQueueException();}
	    Q[rear]=element;
	    rear=(rear + 1) % n;
	    size ++;
	}
    
    public E dequeue() throws ArrayQueueException {
         E e = front();
		 front = (front + 1)% n;
         size --;
         return e;
    }
	//Can you check here so we not taking an element from an empty list please - that bad.	
   
    public String toString(){
	    String s ="[";
		for (int i = front; i < n; i=(i+1)%n ){
			s  += (Q[i].toString()) + ",";
			//i = (i + 1) % n;
		}		
		return s ;
	}
    //
    // IMPLEMENT ME
    //I don't think this is entirely correct 
    //
    // NOTE: if the queue contains 1,2,3 then return "[1,2,3]"
    //       if the queue contains 1 then return "[1]"
    //       if the queue is empty return "[]"
    //
}
	
