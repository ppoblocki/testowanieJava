package zad5;

class Largest
{
	public static <E extends Comparable<E>> E min(E[] list) {
	    E maxValue = list[0];
	    for(int i = 1; i < list.length; i++) {
	        if( maxValue.compareTo(list[i]) < 0) {
	        	maxValue = list[i];
	        }
	    }
	    return maxValue;
	}
}
