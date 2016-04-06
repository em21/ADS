import java.io.*;

public static void main(){
	writer();
}

public Writer(){
	Writer writer = new BufferedWriter(new OutputStreamWriter(
              new FileOutputStream("test.txt"), "utf-8"))) {
			  writer.write("something");}
}
			  


