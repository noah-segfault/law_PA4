package law_PA4;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;


public class DuplicateCounter {
	private String [] uniqueWords = new String [100];
	private int [] uniqueScore = new int [100];
	public void count(FileInputStream dataFile) throws IOException
	{
		HashMap<String, Integer> wordData = new HashMap<String, Integer>();
		System.out.println("Reading the file.");
		FileInputStream fileByteStream = null;
		Scanner inFS;
		int counter = 0;
		try {	
			fileByteStream = dataFile;
			inFS = new Scanner(dataFile);
			while (inFS.hasNextLine())
			{
				String temp = inFS.nextLine();
				if (!wordData.containsKey(temp))
				{
					wordData.put(temp, 1);
					counter++;
				}
				else
				{
					wordData.put(temp, wordData.get(temp) + 1);
				}
			}
			System.out.println("Created hashmap is" + wordData); 
			
			String [] uniqueWords = new String [counter];
			int [] uniqueScore = new int [counter];
			Iterator<Entry<String, Integer>> traversal = wordData.entrySet().iterator(); 
			int i = 0;
			while (traversal.hasNext())
			{
				Map.Entry traverseMap = (Map.Entry)traversal.next();
				uniqueWords[i] = (String) traverseMap.getKey();
				uniqueScore[i] = (int)traverseMap.getValue();
				System.out.print(uniqueWords[i] + " ");
				System.out.println(uniqueScore[i]);
				i++;
			}
			
			inFS.close();
			this.uniqueWords = uniqueWords.clone();
			this.uniqueScore = uniqueScore.clone();
			
			fileByteStream.close();
			inFS.close();
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
				outFS.print(this.uniqueWords[i] + " ");
				outFS.println(uniqueScore[i]);
			}
			outFS.flush();
			fileOutStream.close();
		} catch (IOException excpt){
			System.out.println("Caught IOException: " + excpt.getMessage());
		}
	}
}
