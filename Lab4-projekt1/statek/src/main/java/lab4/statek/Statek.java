package lab4.statek;


public class Statek 
{
	public Mapa M = new Mapa(); // mapa
	public Zwrot zwrot;
	public enum Zwrot { N, S, E, W } // zwrot statku
	
	// Wsp na mapie
	int x;
	int y;
	
	// Ustawienie parametrow startowych
	public Statek()
	{
		zwrot = Zwrot.N;
		x = 6;
		y = 3;
	}
	
	//====== PORUSZANIE SIE STATKU===============
	/* sprwadza czy mozna przejsc na dane pole
	 * parametry: int x, int y --> wsp X i Y pola
	 * zwraca: true/false jezeli mozna/nie mozna przejsc
	 */
	public boolean radar(int x, int y)
	{
		if (x < 0 || x > 9 || y < 0 || y > 9)
			return false;

		if (M.mapa[x][y].equals("L") || M.mapa[x][y].equals("P"))
			return false;
		else if (M.mapa[x][y].equals("W"))
			return true;
		else
			return false;
	}
	
	/* plynie w wybranym kierunku(przód/tył)
	 * parametry: string kierunek
	 * 			litera n - do przodu
	 * 			litera w - do tyłu
	 * zwraca - true/false jeśli się udało/nie udało
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
		} else if (kierunek.equals("S") || kierunek.equals("s"))
		{
			if (radar(this.x+1, this.y))
			{
				this.x += 1;
				return true;
			}
		}
		else
			return false;
		
		return false;
	}
	
	/* obraca statek (w lewo/prawo)
	 * parametry: string kierunek
	 * 			litera l - w lewo
	 * 			litera p - w prawo
	 * zwraca: true/false jeśli się udało lub nie
	 */
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
			return false;		
		}
	}
	
	/* Wykonuje sekwencje ruchów np.
	 * n n l n - powoduje przepłynięcie o 2 pola
	 * do przodu, obrót w lewo i przepłynięcie o 1 pole
	 * do przodu. Wykonuje sekwencje, przerywa jeżeli
	 * napotka przeszkodę. 
	 * parametry: string[] rozkazy
	 * 			tablica rozkazów np [n][n][l][n]
	 * zwraca: 
	 * 		1 - sukces
	 * 		0 - problem
	 */
	public int wykonajSekwencje(String rozkazy) throws Exception
	{
		int i = 0;
		boolean seq = true;
		String[] sekwencja = rozkazy.split(" ");
		
		while(seq || i != sekwencja.length)
		{
			if (sekwencja[i].contains("n w N W"))
			{
				seq = plyn(sekwencja[i]);
			}
			else if (sekwencja[i].contains("l p L P"))
			{
				seq = obrot(sekwencja[i]);
			}
			else
			{
				return 0;
			}
		}
		return 1;
	}
}
