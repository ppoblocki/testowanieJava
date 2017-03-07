package lab4.statek;


public class Statek 
{
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
	 * parametry: string pole --> litera L, W lub P
	 * zwraca: true/false jezeli mozna/nie mozna przejsc
	 */
	public boolean radar(String pole)
	{
		
		
		return false;
	}
	
	/* plynie w wybranym kierunku(przód/tył)
	 * parametry: char kierunek
	 * 			litera n - do przodu
	 * 			litera w - do tyłu
	 * zwraca - true/false jeśli się udało/nie udało
	 */
	public boolean plyn(char kierunek)
	{
		
		return false;
	}
	
	/* obraca statek (w lewo/prawo)
	 * parametry: char kierunek
	 * 			litera l - w lewo
	 * 			litera p - w prawo
	 * zwraca: true/false jeśli się udało lub nie
	 */
	public boolean obrot(char kierunek)
	{
		
		return false;
	}
	
	/* Wykonuje sekwencje ruchów np.
	 * n n l n - powoduje przepłynięcie o 2 pola
	 * do przodu, obrót w lewo i przepłynięcie o 1 pole
	 * do przodu. Wykonuje sekwencje, przerywa jeżeli
	 * napotka przeszkodę. 
	 * parametry: string[] rozkazy
	 * 			tablica rozkazów np [n][n][l][n]
	 * zwraca: 
	 * 		0 - sukces
	 * 		1 - nie da sie
	 * 		2 - napotkano problem
	 */
	public int wykonaj(String[] rozkazy)
	{
		
		return 0;
	}
}
