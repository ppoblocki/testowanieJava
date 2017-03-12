package lab4.statek;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MapaTest 
{
	private Mapa test;
	
	@Before
	public void SetUp()
	{
		test = new Mapa();
	}
	
	@After
	public void CleanUp()
	{
		test = null;
	}
	
	@Test
	public void Mapa_not_null_Test()
	{
		assertNotNull(test);
	}
	
	@Test
	public void Mapa_has_map_Test()
	{
		String[][] mapa = new String[10][10];
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
		
		assertArrayEquals(mapa, test.mapa);
	}
}
