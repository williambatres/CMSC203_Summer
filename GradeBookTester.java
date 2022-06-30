import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GradeBookTester {
	
	GradeBook g1;
	GradeBook g2;
	@BeforeEach
	void setUp() throws Exception {
		g1 = new GradeBook(5);
		g1.addScore(10.0);
		g1.addScore(20.0);
		g1.addScore(30.0);
		g1.addScore(75.0);
		g1.addScore(88.0);
		
		g2 = new GradeBook(5);
		g2.addScore(11.0);
		g2.addScore(30.0);
		g2.addScore(34.0);
		g2.addScore(44.0);
		g2.addScore(74.0);
		
	}

	@AfterEach
	void tearDown() throws Exception {
		g1 = null;
		g2 = null;
	}

	@Test
	void testAddScore() {
		assertTrue(g1.toString().equals("10.0 20.0 30.0 75.0 88.0 "));
		assertTrue(g2.toString().equals("11.0 30.0 34.0 44.0 74.0 "));
	}

	@Test
	void testSum() {
		assertEquals(223.0,g1.sum());
		assertEquals(193.0, g2.sum());
	}

	@Test
	void testMinimum() {
		assertEquals(10.0, g1.minimum());
		assertEquals(11.0, g2.minimum());
	}

	@Test
	void testFinalScore() {
		assertEquals(213.0, g1.finalScore());
		assertEquals(182.0, g2.finalScore());
		
	}

	@Test
	void testGetScoresSize() {
		assertEquals(5, g1.getScoresSize());
		assertEquals(5, g2.getScoresSize());
	}

	@Test
	void testToString() {
		assertTrue(g1.toString().equals("10.0 20.0 30.0 75.0 88.0 "));
		assertTrue(g2.toString().equals("11.0 30.0 34.0 44.0 74.0 "));
	}

}
