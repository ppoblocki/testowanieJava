package test;

public class NWD {
	
	int nwd(int a, int b) {
		
		if(a <= 0 || b <= 0){
			throw new IllegalArgumentException();
		}
		
		while (a != b) {
			if (a > b)
				a -= b;
			else
				b -= a;
		}
		return a;
	}
}
