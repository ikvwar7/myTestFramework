package framework.testclasses;

import framework.annotations.After;
import framework.asserts.Assert;
import framework.annotations.Before;
import framework.printer.WriteToConsole;
import framework.annotations.Test;

import static framework.asserts.Assert.asserTrue;
import static framework.asserts.Assert.assertEquals;
import static framework.asserts.Assert.assertNotNull;

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


