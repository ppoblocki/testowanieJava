package lab4.statek;


public class Statek 
{
	// Mapa
	public Mapa M = new Mapa();
	// Zwrot statku
	public Zwrot zwrot;
	public enum Zwrot {
		N, S, E, W
	}
	
	// Wsp na mapie
	int x;
	int y;
	
	// Ustawienie parametrow startowych
	public Statek()
	{
		zwrot = Zwrot.N;
		x = 3;
		y = 6;
	}
	
	//====== PORUSZANIE SIE STATKU===============
	/* sprwadza czy mozna przejsc na dane pole
	 * parametry: int x, int y --> wsp X i Y pola
	 * zwraca: true/false jezeli mozna/nie mozna przejsc
	 */
	public boolean radar(int x, int y) throws Exception
	{
		if (M.mapa[x][y] == "L" || M.mapa[x][y] == "P")
			return false;
		else if (M.mapa[x][y] == "W")
			return true;
		else
			throw new Exception("Out of map!");
	}
	
	/* plynie w wybranym kierunku(przód/tył)
	 * parametry: char kierunek
	 * 			litera n - do przodu
	 * 			litera w - do tyłu
	 * zwraca - true/false jeśli się udało/nie udało
	 */
	public boolean plyn(String kierunek) throws Exception
	{
		if (kierunek == "N" || kierunek == "n")
		{
			if (radar(this.x, this.y-1))
			{
				this.y -= 1;
				return true;
			}
		} else if (kierunek == "S" || kierunek == "s")
		{
			if (radar(this.x, this.y+1))
			{
				this.y += 1;
				return true;
			}
		}
		else
			return false;
		
		return false;
	}
	
	/* obraca statek (w lewo/prawo)
	 * parametry: char kierunek
	 * 			litera l - w lewo
	 * 			litera p - w prawo
	 * zwraca: true/false jeśli się udało lub nie
	 */
	public boolean obrot(String kierunek)
	{
		switch(this.zwrot)
		{
		case N:
			if (kierunek == "L" || kierunek == "l")
			{
				this.zwrot = Zwrot.W;
				return true;
			}
			else if (kierunek == "P" || kierunek == "p")
			{
				this.zwrot = Zwrot.E;
				return true;
			} 
		case S:
			if (kierunek == "L" || kierunek == "l")
			{
				this.zwrot = Zwrot.E;
				return true;
			}
			else if (kierunek == "P" || kierunek == "p")
			{
				this.zwrot = Zwrot.W;
				return true;
			} 
		case E:
			if (kierunek == "L" || kierunek == "l")
			{
				this.zwrot = Zwrot.N;
				return true;
			}
			else if (kierunek == "P" || kierunek == "p")
			{
				this.zwrot = Zwrot.S;
				return true;
			} 
		case W:
			if (kierunek == "L" || kierunek == "l")
			{
				this.zwrot = Zwrot.S;
				return true;
			}
			else if (kierunek == "P" || kierunek == "p")
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
