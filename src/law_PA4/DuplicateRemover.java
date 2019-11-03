package law_PA4;
import java.util.Scanner;
import java.util.Set;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.io.FileOutputStream;
import java.io.PrintWriter;


public class DuplicateRemover {
	private String [] uniqueWords = new String [100];
	public void remove(FileInputStream dataFile) throws IOException
	{
		Set<String> dupe = new HashSet<String>();
		System.out.println("Reading the file.");
		FileInputStream fileByteStream = null;
		Scanner inFS;
		try {
			fileByteStream = dataFile;
			inFS = new Scanner(dataFile);
			while (inFS.hasNextLine())
			{
				dupe.add(inFS.nextLine());
			}
			String [] uniqueWords = new String [dupe.size()];
			
			Iterator<String> words = dupe.iterator();
			int i = 0;
			while (words.hasNext())
			{
				uniqueWords[i] = words.next();
				System.out.println(uniqueWords[i]);
				i++;
			}
			
			fileByteStream.close();
			inFS.close();
			this.uniqueWords = uniqueWords.clone();
		}
		catch (IOException excpt){
			System.out.println("Caught IOException: " + excpt.getMessage());
		}
	
	}
	public void write(FileOutputStream dataFile) throws IOException
	{
		FileOutputStream fileOutStream = null;
		PrintWriter outFS = null;
		try {
			fileOutStream = dataFile;
			outFS = new PrintWriter(dataFile);
			for (int i = 0; i < this.uniqueWords.length; i++)
			{
				outFS.println(this.uniqueWords[i]);
			}
			outFS.flush();
			fileOutStream.close();
		} catch (IOException excpt){
			System.out.println("Caught IOException: " + excpt.getMessage());
		}
		
	}
}
