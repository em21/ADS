import java.util.*;

public class Sort {
	
	private static void swap(int[]S,int i,int j){int temp = S[i]; S[i] = S[j]; S[j] = temp;}

    private static void bubbleSort(int[] A){
		int n = A.length;
		boolean swapped = true; 
		for (int i=n-1; i>0 && swapped; i--){
			swapped =false;
			for (int j=0; j<i; j++){
				if (A[j]> A[j+1]){
					swap(A,j,j+1);
					swapped = true;
				}
			}
		}
	}

    private static void radixSort(int[] A){
		ArrayList<Integer>[] bucket = new ArrayList [10];                       // (1)
		for (int i=0;i<10;i++) bucket[i] = new ArrayList<Integer>();		// (2)
		int maxDigits = numberOfDigitsIn(max(A));
	//System.err.println("maxDigits is " + maxDigits);
		for (int i=0; i<maxDigits; i++){
			for (int j =0; j<A.length; j++){
				int current = A[j];
				int s = getDthDigit(current,i);
				//System.err.println("Putting " + current + " in bucket " + s);
				bucket[s].add(current);
			}  
			int counter =0;
			for (int k =0; k<10; k++){
				for (int l = 0; l<bucket[k].size();l++){
					A[counter] = bucket[k].get(l);
					counter++;				
				}
				bucket[k].clear();
			}
		}
	}
                                                                                                                                                         // (6)
    //
    // radix sort the array of n integers A
    // (1) numbers are decimal so we have 10 buckets
    // (2) create the 10 buckets
    // (3) find the number of digits of the largest number in A
    // (4) now sort numbers in A by the ith digit, starting at least significant digit
    // (4.1) for each integer in A
    // (4.1.1) get the ith digit of the number, call it digit, and then ...
    // (4.1.2) put that number into the bucket for that digit, i.e. bucket[digit]
    // (4.4) now transfer the data in the buckets back into A
    // (4.4.1) get the numbers in bucket[k] and copy back to array A, and then ...
    // (4.4.2) clear out that bucket
    //
	
	private static int numberOfDigitsIn(int n){return (int)Math.log10((double)n) + 1;}
	
	private static int getDthDigit(int n,int d){
	for (int i=0;i<d;i++) n = n / 10;
	return n % 10;
    }
	
	private static int max(int[] x){
		int max = 0;
		for (int i=0; i<x.length;i++){
			if (x[i]>max){
				max = x[i];
			}
		}
		return max;
	}

    private static void pigeonholeSort(int[] A){
		int n = A.length;                                                   // (1)        
        int m = -999;                                                       // (2) 
                                                                            // (3)
	ArrayList<Integer>[] bucket = new ArrayList[m+1];                   // (4a)
	for (int i=0;i<=m;i++) bucket[i] = new ArrayList<Integer>();        // (4b)
                                                                            // 
																		// (6)
    }
    //
    // pigeonhole sort, aka bucket sort ... 
    // (1) to (3) get largest number in A and call it m
    // (4a) produce m+1 buckets, bucket[0] to bucket[m], 
    // (4b) where a bucket is an ArrayList of integers
    // (5) for every integer i in A, add i to bucket[i]
    // (6) recreate A, sorted!
    //
	

    public static void main(String[] args){
	String command = args[0];                   // algorithm name
	int n          = Integer.parseInt(args[1]); // number of numbers
	int m          = Integer.parseInt(args[2]); // biggest number in data
	Random gen     = new Random();
	int[] A        = new int[n];
	for (int i=0;i<n;i++) A[i] = gen.nextInt(m);
	if (args.length > 3){
	    for (int x : A) System.out.print(x +" ");
	    System.out.println();
	}
	long startTimeMs = System.currentTimeMillis();
	if (command.equals("arrays")) Arrays.sort(A);
	else if (command.equals("bubble")) bubbleSort(A);
	else if (command.equals("radix")) radixSort(A);
	else if (command.equals("pigeon")) pigeonholeSort(A);
	else if (command.equals("jsort")) Arrays.sort(A);
	else {System.out.println("invalid command"); return;}
	long elapsedTimeMs = System.currentTimeMillis() - startTimeMs;
	System.out.println("time (ms): "+ elapsedTimeMs);
	if (args.length > 3){
	    for (int x : A) System.out.print(x +" ");
	    System.out.println();
    }
	}
	
	
}
//
// See readme.txt
//
// to bubble sort 20 numbers, largest is 99
//
// > java Sort bubble 20 100
//
