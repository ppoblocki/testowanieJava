package lab4.statek;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class StatekTest
{
	private Statek test;

	@Before
	public void SetUp()
	{
		test = new Statek();
	}
	
	@After
	public void CleanUp()
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
		assertSame(Statek.Zwrot.N, test.zwrot);
	}
	@Test
	public void StatekTest_zwrot2()
	{
		assertNotNull(test.zwrot);
	}
	// endregion

	// region Statek.radar()
	@Test(expected=ArrayIndexOutOfBoundsException.class)
	public void StatekTest_Radar_test1_poza_mape()
	{
		test.radar(-1, -1);
	}
	@Test(expected=ArrayIndexOutOfBoundsException.class)
	public void StatekTest_Radar_test2_poza_mape()
	{
		test.radar(10, 10);
	}
	@Test
	public void StatekTest_Radar_test3_woda()
	{
		boolean result = test.radar(9, 9);
		assertTrue(result);
	}
	@Test
	public void StatekTest_Radar_test4_lad()
	{
		boolean result = test.radar(0, 0);
		assertFalse(result);
	}
	@Test
	public void StatekTest_Radar_test5_pirat()
	{
		boolean result = test.radar(0, 6);
		assertFalse(result);
	}
	// endregion

	// region Statek.plyn()
	@Test
	public void StatekTest_plny_N_ok()
	{
		// z pola [6][3] na pole [5][3]
		boolean result = test.plyn("N");
		assertTrue(result);
		assertEquals(5, test.x);
		assertEquals(3, test.y);
	}
	@Test
	public void StatekTest_plny_n_ok()
	{
		// z pola [6][3] na pole [5][3]
		boolean result = test.plyn("n");
		assertTrue(result);
		assertEquals(5, test.x);
		assertEquals(3, test.y);
	}
	@Test
	public void StatekTest_plny_N_no()
	{
		test.x = test.y = 2;
		boolean result = test.plyn("N");
		assertFalse(result);
		assertSame(test.x, test.y);
	}
	@Test
	public void StatekTest_plny_n_no()
	{
		test.x = test.y = 2;
		boolean result = test.plyn("n");
		assertFalse(result);
		assertSame(test.x, test.y);
	}
	@Test
	public void StatekTest_plny_S_no()
	{
		// z pola [6][3] na pole [7][3]
		boolean result = test.plyn("S");
		assertFalse(result);
		assertEquals(6, test.x);
		assertEquals(3, test.y);
	}
	@Test
	public void StatekTest_plny_s_no()
	{
		// z pola [6][3] na pole [7][3]
		boolean result = test.plyn("s");
		assertFalse(result);
		assertEquals(6, test.x);
		assertEquals(3, test.y);
	}
	@Test
	public void StatekTest_plny_S_ok()
	{
		test.x = 0;
		test.y = 8;
		boolean result = test.plyn("s");
		assertTrue(result);
		assertEquals(1, test.x);
		assertEquals(8, test.y);
	}
	@Test
	public void StatekTest_plny_s_ok()
	{
		test.x = 0;
		test.y = 8;
		boolean result = test.plyn("s");
		assertTrue(result);
		assertEquals(1, test.x);
		assertEquals(8, test.y);
	}
	@Test
	public void StatekTest_plny_unsupported_command()
	{
		boolean result = test.plyn("x");
		assertFalse(result);
	}
	// endregion

	// region Statek.obrot()
	@Test(expected = NullPointerException.class)
	public void StatekTest_obrot_zly_zwrot()
	{
		test.zwrot = null;
		test.obrot("L");
	}
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
	public void StatekTest_wykonajSekwencje_prosta_sekwencja_1()
	{
		int result = test.wykonajSekwencje("n");
		assertEquals(1, result);
	}
	@Test
	public void StatekTest_wykonajSekwencje_prosta_sekwencja_2()
	{
		int result = test.wykonajSekwencje("l");
		assertEquals(1, result);
	}
	@Test
	public void StatekTest_wykonajSekwencje_prosta_sekwencja_3_fail()
	{
		int result = test.wykonajSekwencje("s");
		assertEquals(0, result);
	}
	@Test
	public void StatekTest_wykonajSekwencje_dluga_sekwencja_1()
	{
		int result = test.wykonajSekwencje("n,n,l,n");
		assertEquals(1, result);
	}
	@Test
	public void StatekTest_wykonajSekwencje_dluga_sekwencja_2()
	{
		int result = test.wykonajSekwencje("n,n,n,p,n");
		assertEquals(1, result);
	}
	@Test
	public void StatekTest_wykonajSekwencje_dluga_sekwencja_3()
	{
		int result = test.wykonajSekwencje("L,N,N");
		assertEquals(1, result);
	}
	@Test
	public void StatekTest_wykonajSekwencje_dluga_sekwencja_4_ok_but_fail()
	{
		int result = test.wykonajSekwencje("n,n,n,n,n,p,n");
		assertEquals(2, result);
	}
	// endregion
}