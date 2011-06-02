package senet.game.element;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class SticksTest {

    public SticksTest() {
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
    public void testThrowThem() {
        Sticks sticks = new Sticks();
        int result;
        for(int i = 0; i < 50; i++) {
            result = sticks.getResultOfThrow();
            assertTrue(result >= 1 && result <= 5);
        }
    }

}