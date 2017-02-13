package test;

public class Largest 
{
	int findMax(int[] array){
		
		int wynik = array[0];
		if (array.length == 1)
			return array[0];
		for (int i = 0; i < array.length; i++) {
			if (wynik < array[i]) {
				wynik = array[i];
			}
		}
		return wynik;
	}
}
