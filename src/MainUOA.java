// Giuseppe Stramandinoli
// Lab 4
// Question 4

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class MainUOA
{  
	public static void main(String[] args)
   {  
	  UOA <WordListing> NYC = new UOA<WordListing>(true, 10);

      load("words.txt", NYC);
      System.out.println(NYC.fetch("we"));
      System.out.println(NYC.fetch("and"));
      System.out.println(NYC.fetch("or"));
      System.out.println(NYC.fetch("I"));

   } 

	public static void load(String inName, UOA<WordListing> array)
		{
			String fileName = inName;
			
			// Read File
			try
			{
				Scanner inputStream = new Scanner(new File(fileName));
				while (inputStream.hasNext())
				{
					array.insert(new WordListing(inputStream.next(), inputStream.nextInt()));

				}
				inputStream.close();
			}
			catch(FileNotFoundException e)
			{
				System.out.println("Error opening file");
				System.exit(0);
			}
			catch(IOException e)
			{
				System.out.println("Error reading file");
			}
		} 
}
