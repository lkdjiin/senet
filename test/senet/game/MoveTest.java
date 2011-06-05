package senet.game;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class MoveTest {

    public MoveTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testConstructor() {
        Move move = new Move(12,14);
        assertEquals(12, move.getFrom());
        assertEquals(14, move.getTo());
    }

    @Test(expected= IllegalArgumentException.class)
    public void testFromTooLow() {
        Move move = new Move(0,14);
    }

    @Test(expected= IllegalArgumentException.class)
    public void testFromTooBig() {
        Move move = new Move(31,14);
    }

    @Test(expected= IllegalArgumentException.class)
    public void testToTooLow() {
        Move move = new Move(12,0);
    }

    @Test(expected= IllegalArgumentException.class)
    public void testToTooBig() {
        Move move = new Move(12,31);
    }

    @Test
    public void testEquals() {
        Move m1 = new Move(10,12);
        Move m2 = new Move(10,12);
        assertTrue(m1.equals(m2));
    }

    @Test
    public void testNotEquals() {
        Move m1 = new Move(10,12);
        Move m2 = new Move(10,13);
        assertFalse(m1.equals(m2));
    }
}