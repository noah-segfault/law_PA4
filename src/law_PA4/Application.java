package law_PA4;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Application {

	public static void main(String[] args) throws IOException {
		FileInputStream fileByteStream = null;
		FileOutputStream fileOutStream = null;
		DuplicateCounter duplicateCounter = new DuplicateCounter();
		DuplicateRemover duplicateRemover = new DuplicateRemover();
		try {
			System.out.println("Now opening up the file for problem 1");
			fileByteStream = new FileInputStream("problem1.txt");
			fileOutStream = new FileOutputStream("unique_words.txt");
			duplicateRemover.remove(fileByteStream);
			duplicateRemover.write(fileOutStream);
			fileOutStream.close();
			fileByteStream.close();
			
			System.out.println("Now opening up the file for problem 2");
			fileByteStream = new FileInputStream("problem2.txt");
			fileOutStream = new FileOutputStream("unique_words_counts.txt");
			duplicateCounter.count(fileByteStream);
			duplicateCounter.write(fileOutStream);
			fileOutStream.close();
			fileByteStream.close();
			
		}
		catch (IOException excpt){
			System.out.println("Caught IOException: " + excpt.getMessage());
		}
	}

}
