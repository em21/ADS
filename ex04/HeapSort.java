import java.util.*;
import java.io.*;
public class HeapSort {
    
    public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(new File(args[0]));
		ArrayList<String> data = new ArrayList<String>();
		while (sc.hasNext()) data.add(sc.next());
		Heap<String> H = new Heap<String>(data.size());
		for(String s : data)
		H.insert(s);
		
		while(!H.isEmpty())
		System.out.println(H.removeMin());
	}
}