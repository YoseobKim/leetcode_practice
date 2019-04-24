import java.util.*; 

class IF<T> {
  private Iterator<T>[] iterlist = null;
  private int index = 0;
  
  public IF(Iterator<T>[] iterlist){
  	  this.iterlist = iterlist;
  }
  
  public T next() throws NoSuchElementException {
    for(int i = 0; i < iterlist.length; i++) {
        int newIndex = (index + i) % iterlist.length;
        Iterator<T> it = iterlist[newIndex];
        if(it.hasNext()) {
            index = newIndex + 1; 
            // this is important as we want to traverse one by one in iterlist step by step.
            return it.next();
        }
    }
    throw new NoSuchElementException();
  }
  
  public boolean hasNext(){
    for(Iterator<T> it : iterlist) {
        if(it.hasNext()) return true;
    }
    return false;
  }
}

public class App6 {
    public static void main(String[] args) {
      	Integer[] arr1 = {1, 2, 3};
      	Integer[] arr2 = {4, 5};
      	Integer[] arr3 = {6, 7, 8, 9};
      
		    Iterator<Integer> a = Arrays.stream(arr1).iterator();
		    Iterator<Integer> b = Arrays.stream(arr2).iterator();
		    Iterator<Integer> c = Arrays.stream(arr3).iterator();
		    Iterator<Integer>[] iterlist = new Iterator[3];
        iterlist[0] = a;
        iterlist[1] = b;
        iterlist[2] = c;
      
      	IF<Integer> itfl = new IF<Integer>(iterlist);
      
		    while(itfl.hasNext()){
  			    System.out.println(itfl.next());
		    }
		    // 1 4 6 2 5 7 3 8 9
    }
}
