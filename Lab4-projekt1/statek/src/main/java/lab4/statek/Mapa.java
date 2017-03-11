package lab4.statek;

public class Mapa 
{
	public String[][] mapa = new String[10][10];

	/*    0  1  2  3  4  5  6  7  8  9 ---> Y
	 * 0 [L][L][L][L][W][W][P][W][W][L]
	 * 1 [L][L][L][L][L][W][W][W][W][L]
	 * 2 [L][L][W][W][W][W][W][W][P][L]
	 * 3 [L][W][W][W][W][P][W][W][W][l]
	 * 4 [L][W][W][W][W][W][W][W][W][L]
	 * 5 [W][W][W][W][W][W][W][P][W][L]
	 * 6 [W][W][W][S][L][W][W][W][W][L]
	 * 7 [W][W][W][L][L][W][W][W][W][L]
	 * 8 [P][W][W][L][L][W][W][W][W][W]
	 * 9 [W][W][W][W][W][W][W][P][W][W]
	 * |
	 * |
	 * X
	 * Legenda:
	 * S - statek
	 * W - woda
	 * L - ląd
	 * P - pirat / przeszkoda
	 * 
	 * Start punkt[6][3]
	 */
	
	public String[][] uzupelnij_mape()
	{
		mapa[0] = "L L L L W W P W W L".split(" ");
		mapa[1] = "L L L L L W W W W L".split(" ");
		mapa[2] = "L L W W W W W W P L".split(" ");
		mapa[3] = "L W W W W P W W W L".split(" ");
		mapa[4] = "L W W W W W W W W L".split(" ");
		mapa[5] = "W W W W W W W P W L".split(" ");
		mapa[6] = "W W W S L W W W W L".split(" ");
		mapa[7] = "W W W L L W W W W L".split(" ");
		mapa[8] = "P W W L L W W W W W".split(" ");
		mapa[9] = "W W W W W W W P W W".split(" ");
		return mapa;
	}
	
	public Mapa()
	{
		this.mapa = uzupelnij_mape();
	}
}
