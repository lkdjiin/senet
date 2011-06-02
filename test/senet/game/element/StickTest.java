package senet.game.element;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class StickTest {

    public StickTest() {
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
    public void testThrow() {
        Stick s = new Stick();
        StickFace face = s.throwMe();
        assertTrue(face == StickFace.BLACK || face == StickFace.WHITE);
    }

}