package framework.TestClasses;

import framework.After;
import framework.Asserts.Assert;
import framework.Before;
import framework.Printer.WriteToConsole;
import framework.Test;

import static framework.Asserts.Assert.asserTrue;
import static framework.Asserts.Assert.assertEquals;
import static framework.Asserts.Assert.assertNotNull;

public class ArifmeticTest {
    private Assert asert;
    private Arifmetic ar;

    @Before
    public void before() {
        System.out.println("before test");
        WriteToConsole wtc = new WriteToConsole();
        asert = new Assert(wtc);
        ar = new Arifmetic();
    }

    @After
    public void after() {
        System.out.println("after test");
    }

    @Test
    public void asertTrueTest() {
        asserTrue(ar.condition(2, 5));
    }

    @Test
    public void asertEqualsTest() {
        assertEquals(ar.sum(2, 3), 5);
    }

    @Test
    public void asertNotNullTest() {
        assertNotNull(ar);
    }
}


