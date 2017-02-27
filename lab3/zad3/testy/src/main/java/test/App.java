package test;

public class App 
{
    public int search(String[] items, String target, int first, int last)
    {
    	try{
        int mid = (first + last)/2;
        if (first > last) {
            return -1;
        } else if (items[mid].equals(target)) {
            return mid;
        } else if (items[mid].compareTo(target) > 0) {
            return search(items,target,first,mid-1);
        } else {
            return search(items,target,mid+1,last);
        }
    	}
    	catch(Exception e)
    	{
    		throw new NullPointerException();
    	}
    }
}
