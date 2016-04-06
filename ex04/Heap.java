public class Heap <E extends Comparable<E>> {
 
    private Object H[];   // contains the objects in the heap
    private int last;     // index of last element in heap
    private int capacity; // max number of elements in heap 
	
    public Heap(int n){
	capacity = n;
	H        = new Object[capacity+1];
	last     = 0;
	
    }
    //
    // create a heap with capacity n
    // NOTE: H is an array of objects
    //       must use casting when delivering the minimum
    //       See min() below.
    //       This must also be done in removeMin()
    //

    public Heap(){this(7);}
    //
    // by default, create a new heap with capacity 7
    //

    @SuppressWarnings("unchecked")
    private int compare(Object x,Object y){return ((E)x).compareTo((E)y);}
    
    public int size(){return last;}
    // returns the number of elements in the heap
    
    
    public boolean isEmpty(){return (last==0);}
    //checks if the heap is empty
    
    @SuppressWarnings("unchecked")
    public E min() throws HeapException {
	if (isEmpty()) throw new HeapException("underflow");
	return (E) H[1];
    }
    //
    // returns element with smallest key, without removal
    // NOTE: must use casting to class (E)
    //
    
    public void insert(E e){if (last==capacity){throw new HeapException("overflow");}
		last++;	
		H[last] = e;
		bubbleUp(last); 
    }
    //
    // inserts e into the heap
    // throws exception if heap overflow
    //
    
    @SuppressWarnings("unchecked")
    public E removeMin(){if (isEmpty()){throw new HeapException("underflow");}
		E min = (E) H[1];
		H[1]=H[last];
		bubbleDown(1);     //implement Use this to remove/delete overwrite
		last--;
	    return min;
    }
    //
    // removes and returns smallest element of the heap
    // throws exception if heap is empty
    // NOTE: must cast result to class (E)
    //       see min() above
    //
	
	private void bubbleUp(int i){   
		while (i>1 && ((compare(H[i],H[i/2]))<0)){  
			swap(i,i/2);
			i = i/2;
		}
	}
	
	
	private void bubbleDown(int i){
	if (i >= last){return;}
    if ((hasLeft(i)) && (hasRight(i)) && (compare(H[i*2],H[i*2+1])<0) && (compare(H[i*2],H[i])<0)){  //[1]
	    swap(i,i*2);
		bubbleDown(i*2);}
    else if((hasLeft(i)) && (hasRight(i)) && (compare(H[i*2+1],H[i*2])<0) && (compare(H[i*2+1],H[i])<0)){//[2]
		swap(i,(i*2+1));
	    bubbleDown(i*2+1);}
	else if((hasLeft(i)) && (compare(H[i*2], H[i]) < 0)){//[3]
        swap(i,i*2);
	    bubbleDown(i*2);}
	}
	
	//[1]Checks that H[i] has two children and compares the children. If the left child is a string which is lexicographically greater than the right. It compares left child with parent.
	//If the left child is a a string which is lexicographically greater than both the parent and the right child. Then then the left child and parent swap positions. 
	//[2]Checks that H[i] has two children and compares the children. If the right child a string which is lexicographically greater than the left. It compares right child with parent.
	// If the right child is a string which is lexicographically greater than both the parent and the left child then then the right child and parent swap positions. 
	//[3]Checks that H[i] has a child. Compares child to parent.
	// If the child has a string which is lexicographically greater than the parent. Then the parent and child swap positions. 
	
	private void swap(int i,int j){Object temp = H[i];H[i] = H[j];H[j] = temp;}
	
	private boolean hasLeft(int i){return (i*2 <= last);}
	private boolean hasRight(int i){return (i*2+1 <= last);}

    public String toString(){
	StringBuilder sb = new StringBuilder("[");
		for (int i = 1; i <= last; i++) {
			sb.append(H[i]);
		if (i!=last){sb.append(",");}
		}
		sb.append("]");
		return sb.toString();
    }
    //
    // outputs the entries in H in the order H[1] to H[last]
    // in same style as used in ArrayQueue
    // 
    
}


