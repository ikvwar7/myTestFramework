import framework.TestClasses.Arifmetic;
import framework.TestClasses.ArifmeticTest;
import framework.Testing.Testing;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        new Testing(Arrays.asList(new Class[]{ArifmeticTest.class, Arifmetic.class, ArifmeticTest.class})).runTests();
    }
}
