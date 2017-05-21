//package ch2classes3;

public interface KeyMode
{  public abstract KeyMode deepCopy(); // performs a deepCopy of the
                                       // invoking object
   public abstract int compareTo(Object targetKey); // returns 0 for
                                                    // equality
   public abstract String toString(); // added to prevent Objects toString
                                      // method from executing,
                                      // technically not necessary
}
	