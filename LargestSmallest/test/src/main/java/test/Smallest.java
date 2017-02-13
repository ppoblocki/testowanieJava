package test;

public class Smallest {

	int findMin(int[] array){
		
		int wynik = array[0];
		if (array.length == 1)
			return array[0];
		for (int i = 0; i < array.length; i++) {
			if (wynik > array[i]) {
				wynik = array[i];
			}
		}
		return wynik;
	}
}
