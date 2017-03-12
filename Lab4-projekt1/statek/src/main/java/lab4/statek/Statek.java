package lab4.statek;

public class Statek 
{
	public enum Zwrot { N, S, E, W }

	public Mapa M = new Mapa();

	public Zwrot zwrot;

	int x, y;
	
	// Ustawienie parametrow startowych:
	// Statek znajduje się na pozycji [6][3]
	// oraz skierowany jest na północ.
	public Statek()
	{
		zwrot = Zwrot.N;
		x = 6;
		y = 3;
	}

	/* radar()
	 * opis: Funkcja sprawdza, czy wybrany punkt na mapie
	 * 		 jest bezpieczny.
	 *
	 * parametry:
	 * 	 	   	 int x
	 * 	 		 int y
	 * 	 		 Są to współrzędne na mapie[x][y].
	 * output:
	 * 			true - pole bezpieczne --> "W"
	 * 			false - pole niebezpieczne --> "L" lub "P"
	 * 			ArrayIndexOutOfBoundsException w przypadku
	 * 		    wyjścia poza mapę.
	 */
	public boolean radar(int x, int y)
	{
		if (x < 0 || x > 9 || y < 0 || y > 9)
			throw new ArrayIndexOutOfBoundsException();

		if (M.mapa[x][y].equals("L") || M.mapa[x][y].equals("P"))
			return false;
		else if (M.mapa[x][y].equals("W"))
			return true;
		else
			return false;
	}

	/* plyn()
	*  opis: Funkcja powoduje przemieszczenie statku
	*        o jedno pole do przodu (N) lub w tył (S).
	*
	* parametry:
	* 		 String kierunek --> litera N,n,S lub s
	* output:
	* 		 true - sukces
	* 		 false - napotkano problem np. przeszkodę
	* 		         lub podano zły kierunke np. "X"
	*/
	public boolean plyn(String kierunek)
	{
		if (kierunek.equals("N") || kierunek.equals("n"))
		{
			if (radar(this.x-1, this.y))
			{
				this.x -= 1;
				return true;
			}
			else
				return false;
		} else if (kierunek.equals("S") || kierunek.equals("s"))
		{
			if (radar(this.x+1, this.y))
			{
				this.x += 1;
				return true;
			}
			else
				return false;
		}
		else
			return false;
	}

	/* obrot()
	*  opis: Funkcja obraca statek.
	*
	*  parametry:
	*  		 String kierunek --> w lewo (L) lub w prawo (P)
	*
	* output:
	* 		 true - sukces
	* 		 false - podano zły kierunek np. "X"
	* */
	public boolean obrot(String kierunek)
	{
		switch(this.zwrot)
		{
		case N:
			if (kierunek.equals("L") || kierunek.equals("l"))
			{
				this.zwrot = Zwrot.W;
				return true;
			}
			else if (kierunek.equals("P") || kierunek.equals("p"))
			{
				this.zwrot = Zwrot.E;
				return true;
			} 
		case S:
			if (kierunek.equals("L") || kierunek.equals("l"))
			{
				this.zwrot = Zwrot.E;
				return true;
			}
			else if (kierunek.equals("P") || kierunek.equals("p"))
			{
				this.zwrot = Zwrot.W;
				return true;
			} 
		case E:
			if (kierunek.equals("L") || kierunek.equals("l"))
			{
				this.zwrot = Zwrot.N;
				return true;
			}
			else if (kierunek.equals("P") || kierunek.equals("p"))
			{
				this.zwrot = Zwrot.S;
				return true;
			} 
		case W:
			if (kierunek.equals("L") || kierunek.equals("l"))
			{
				this.zwrot = Zwrot.S;
				return true;
			}
			else if (kierunek.equals("P") || kierunek.equals("p"))
			{
				this.zwrot = Zwrot.N;
				return true;
			}
		default:
			throw new NullPointerException();
		}
	}

	/* wykonajSekwencje()
	 * opis: Wykonuje sekwencje ruchów np: n,n,l,n
	 *       czyli przejście o dwa pola do przodu, obrót
	 *       w lewo i przejście o 1 pole do przodu.
	 *
	 * parametry:
	 * 		 String rozkazy --> string z rozkazami, każdy rozkaz
	 * 		 					musi być oddzielony przecinkiem.
	 * output:
	 * 		 0 - błąd np. zła komenda
	 *       1 - sukces
	 *       2 - wykonano conajmniej jeden krok - ale nie ukończono
	 *           całej sekwencji ruchów.
	 */
	public int wykonajSekwencje(String rozkazy)
	{
		String[] sekwencja = rozkazy.split(",");
		boolean seq = true;
		int i = 0;
		int ilosc = sekwencja.length;

		while(seq && i != ilosc) {
			if (sekwencja[i].matches("[nwNW]+")) {
				seq = plyn(sekwencja[i]);
				if (seq)
					i += 1;
			} else if (sekwencja[i].matches("[lpLP]+")) {
				seq = obrot(sekwencja[i]);
				if (seq)
					i += 1;
			} else {
				return 0;
			}
		}
		if (i == 0)
			return 0;
		else if (i == ilosc)
			return 1;
		else
			return 2;
	}
}
