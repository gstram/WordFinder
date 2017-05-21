// Giuseppe Stramandinoli
// Lab 4
// Question 4

public class WordListing implements KeyMode
{  
	private String word;
	private int timesWordAppears;
	
	public WordListing(String w, int a)
	{  
		word = w;
		timesWordAppears = a;
	}

	public String toString()
	{ 
		return("Word is '" + word + "'" +
          "\nTimes Appeared:  " + timesWordAppears);
	}
	
	public KeyMode deepCopy()
	{  
		WordListing clone = new WordListing (word, timesWordAppears);
		return clone;
	}
	
	public int compareTo(Object targetKey)
	{  
		String tKey = (String) targetKey; // targetKey is a String
		return(word.compareTo(tKey));
	} 
} 