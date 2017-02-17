package zad5;

class Smallest
{
	public <E extends Comparable<E>> E min(E[] list) {
	    E minValue = list[0];
	    for(int i = 1; i < list.length; i++) {
	        if( minValue.compareTo(list[i]) > 0) {
	        	minValue = list[i];
	        }
	    }
	    return minValue;
	}
}
