package lab4.statek;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class StatekTest
{
	private Statek test;

	@Before
	public void before()
	{
		test = new Statek();
	}
	
	@After
	public void after()
	{
		test = null;
	}

	// region Statek()
	@Test
	public void StatekTest_check_start_X()
	{
		assertEquals(6, test.x);
	}
	@Test
	public void StatekTest_check_start_Y()
	{
		assertEquals(3, test.y);
	}
	@Test
	public void StatekTest_zwrot()
	{
		assertEquals(Statek.Zwrot.N, test.zwrot);
	}
	// endregion

	// region Statek.radar()
	public void StatekTest_Radar_test1_poza_mape()
	{
		boolean result = test.radar(-1, -1);
		assertEquals(false, result);
	}
	@Test
	public void StatekTest_Radar_test2_poza_mape()
	{
		boolean result = test.radar(10, 10);
		assertEquals(false, result);
	}
	@Test
	public void StatekTest_Radar_test3_woda()
	{
		boolean result = test.radar(9, 9);
		assertEquals(true, result);
	}
	@Test
	public void StatekTest_Radar_test4_lad()
	{
		boolean result = test.radar(0, 0);
		assertEquals(false, result);
	}
	@Test
	public void StatekTest_Radar_test5_pirat()
	{
		boolean result = test.radar(0, 6);
		assertEquals(false, result);
	}
	// endregion

	// region Statek.plyn()
	@Test
	public void StatekTest_plny_N_ok()
	{
		// z pola [6][3] na pole [5][3]
		boolean result = test.plyn("N");
		assertEquals(true, result);
		assertEquals(5, test.x);
		assertEquals(3, test.y);
	}
	@Test
	public void StatekTest_plny_n_ok()
	{
		// z pola [6][3] na pole [5][3]
		boolean result = test.plyn("n");
		assertEquals(true, result);
		assertEquals(5, test.x);
		assertEquals(3, test.y);
	}
	@Test
	public void StatekTest_plny_N_no()
	{
		test.x = 2;
		test.y = 2;
		boolean result = test.plyn("N");
		assertEquals(false, result);
		assertEquals(2, test.x);
		assertEquals(2, test.y);
	}
	@Test
	public void StatekTest_plny_n_no()
	{
		test.x = 2;
		test.y = 2;
		boolean result = test.plyn("n");
		assertEquals(false, result);
		assertEquals(2, test.x);
		assertEquals(2, test.y);
	}
	@Test
	public void StatekTest_plny_S_no()
	{
		// z pola [6][3] na pole [7][3]
		boolean result = test.plyn("S");
		assertEquals(false, result);
		assertEquals(6, test.x);
		assertEquals(3, test.y);
	}
	@Test
	public void StatekTest_plny_s_no()
	{
		// z pola [6][3] na pole [7][3]
		boolean result = test.plyn("s");
		assertEquals(false, result);
		assertEquals(6, test.x);
		assertEquals(3, test.y);
	}
	@Test
	public void StatekTest_plny_S_ok()
	{
		test.x = 0;
		test.y = 8;
		boolean result = test.plyn("s");
		assertEquals(true, result);
		assertEquals(1, test.x);
		assertEquals(8, test.y);
	}
	@Test
	public void StatekTest_plny_s_ok()
	{
		test.x = 0;
		test.y = 8;
		boolean result = test.plyn("s");
		assertEquals(true, result);
		assertEquals(1, test.x);
		assertEquals(8, test.y);
	}
	// endregion

	// region Statek.obrot()
	// region From N
	@Test
	public void StatekTest_formN_left1()
	{
		test.obrot("L");
		assertEquals(Statek.Zwrot.W, test.zwrot);
	}
	@Test
	public void StatekTest_formN_left2()
	{
		test.obrot("l");
		assertEquals(Statek.Zwrot.W, test.zwrot);
	}
	@Test
	public void StatekTest_formN_right1()
	{
		test.obrot("P");
		assertEquals(Statek.Zwrot.E, test.zwrot);
	}
	@Test
	public void StatekTest_formN_right2()
	{
		test.obrot("p");
		assertEquals(Statek.Zwrot.E, test.zwrot);
	}
	// endregion
	// region From E
	@Test
	public void StatekTest_formE_left1()
	{
		test.zwrot = Statek.Zwrot.E;
		test.obrot("L");
		assertEquals(Statek.Zwrot.N, test.zwrot);
	}
	@Test
	public void StatekTest_formE_left2()
	{
		test.zwrot = Statek.Zwrot.E;
		test.obrot("l");
		assertEquals(Statek.Zwrot.N, test.zwrot);
	}
	@Test
	public void StatekTest_formE_right1()
	{
		test.zwrot = Statek.Zwrot.E;
		test.obrot("P");
		assertEquals(Statek.Zwrot.S, test.zwrot);
	}
	@Test
	public void StatekTest_formE_right2()
	{
		test.zwrot = Statek.Zwrot.E;
		test.obrot("p");
		assertEquals(Statek.Zwrot.S, test.zwrot);
	}
	// endregion
	// region From S
	@Test
	public void StatekTest_formS_left1()
	{
		test.zwrot = Statek.Zwrot.S;
		test.obrot("L");
		assertEquals(Statek.Zwrot.E, test.zwrot);
	}
	@Test
	public void StatekTest_formS_left2()
	{
		test.zwrot = Statek.Zwrot.S;
		test.obrot("l");
		assertEquals(Statek.Zwrot.E, test.zwrot);
	}
	@Test
	public void StatekTest_formS_right1()
	{
		test.zwrot = Statek.Zwrot.S;
		test.obrot("P");
		assertEquals(Statek.Zwrot.W, test.zwrot);
	}
	@Test
	public void StatekTest_formS_right2()
	{
		test.zwrot = Statek.Zwrot.S;
		test.obrot("p");
		assertEquals(Statek.Zwrot.W, test.zwrot);
	}
	// endregion
	// region From W
	@Test
	public void StatekTest_formW_left1()
	{
		test.zwrot = Statek.Zwrot.W;
		test.obrot("L");
		assertEquals(Statek.Zwrot.S, test.zwrot);
	}
	@Test
	public void StatekTest_formW_left2()
	{
		test.zwrot = Statek.Zwrot.W;
		test.obrot("l");
		assertEquals(Statek.Zwrot.S, test.zwrot);
	}
	@Test
	public void StatekTest_formW_right1()
	{
		test.zwrot = Statek.Zwrot.W;
		test.obrot("P");
		assertEquals(Statek.Zwrot.N, test.zwrot);
	}
	@Test
	public void StatekTest_formW_right2()
	{
		test.zwrot = Statek.Zwrot.W;
		test.obrot("p");
		assertEquals(Statek.Zwrot.N, test.zwrot);
	}
	// endregion
	// endregion

	// region Statek.wykonajSekwencje()
	@Test
	public void StatekTest_wykonajSekwencje()
	{
		int result = test.wykonajSekwencje("n");
	}
	// endregion
}