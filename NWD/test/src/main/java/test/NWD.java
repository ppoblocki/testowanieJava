package test;

public class NWD {
	
	int nwd(int a, int b) {
		
		while (a != b) {
			if (a > b)
				a -= b;
			else
				b -= a;
		}
		return a;
	}
}
