// Giuseppe Stramandinoli
// Lab 4
// Question 4

public class UOA<T>
{  private int next;
   private T[] data;
   private int size;
   private boolean expand;

   public UOA()
   {  next = 0;
      size = 100;
      data = (T[]) new Object[100];
      expand = false;
   }//end of constructor

   public UOA(int s)
   {  next = 0;
      data = (T[]) new Object[s];
      size = s;
      expand = false;
   }//end of constructor
   
   public UOA(boolean b)
   {
	   next = 0;
	   data = (T[]) new Object[100];
	   size = 100;
	   expand = b;
   }
   
   public UOA(boolean b, int s)
   {
	   next = 0;
	   data = (T[]) new Object[s];
	   size = s;
	   expand = b;
   }

   public boolean insert(T newListing)
   { 
	   if(expand == true)
	   {
		   if(next >= size)
		   {
			   doubleArray();
		   }
		   KeyMode node = (KeyMode) newListing;
		      if(next >= size)
		        return false;  // check for too many listings
		      data[next]= (T) node.deepCopy();
		      if(data[next] == null) // check for insufficient memory
		        return false;
		      next = next + 1;
		      return true;
	   }
	   else
	   {
		   KeyMode node = (KeyMode) newListing;
		      if(next >= size)
		        return false;  // check for too many listings
		      data[next]= (T) node.deepCopy();
		      if(data[next] == null) // check for insufficient memory
		        return false;
		      next = next + 1;
		      return true;
	   }
   } // end of insert method

   private void doubleArray()
   {
	   // Let user know what is being doubled
	   System.out.println("Doubling size from " + size + " to " + (size*2));
	   size = size * 2;
	   T[] newArray = (T[]) new Object[size];
	   
	   // Start loop to copy contents from old array to a temp array
	   // Set old array to new array   
	   for(int i = 0; i < data.length; i++)
	   {
           newArray [i] = data[i];
	   }
       data = newArray;
   }
   
   public KeyMode fetch(Object targetKey)
   { // access the node using a sequential search, returns null for
          // not found
      KeyMode node = (KeyMode) data[0];
      T temp;
      int i = 0;
      while(i < next && node.compareTo(targetKey) != 0)
      {  i++;
         node = (KeyMode) data[i];
      }
      if(i == next)  // the node with the given key was not found.
        return null;
     // deep copy the nodes information into returned node
      node = node.deepCopy();
     // move the node up one position in the array, unless it is the
          // first node
      if(i != 0)  // bubble-up accessed node
      {  temp =  data[i - 1];
         data[i - 1] = data[i];
         data[i] = temp;
      }
      return node;
   }// end of the fetch method

   public boolean delete(Object targetKey)
   { // access the node using a sequential search, returns null for
          // not found
      KeyMode node = (KeyMode) data[0];
      int i = 0;
      while (i < next && node.compareTo(targetKey) != 0)
      {  i++;
         node = (KeyMode) data[i];
      }
      if(i == next) // the node was not found
        return false;
     //move the last node into the deleted node\u0153s position
      data[i] = data[next - 1];
      data[next - 1] = null;
      next = next - 1;
      return true;
   }// end of delete method

   public boolean update(Object targetKey, T newNode)
   {  if(delete(targetKey) == false)
        return false;
      else if(insert(newNode) ==  false)
        return false;
      else
        return true;
   }// end of update method

   public void showAll()
   {  for(int i = 0; i < next; i++)
        System.out.println(data[i].toString());
   }// end of toString method
}// end of class UOA

