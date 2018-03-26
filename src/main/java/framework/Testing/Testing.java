package framework.Testing;

import framework.After;
import framework.Before;
import framework.Exception.NoTest;
import framework.Test;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;


public class Testing {
    private Class testClass;

    public Testing(Class clas) {
        this.testClass = clas;
    }

    public void runTests() {

        try {
            Object tc = testClass.newInstance();
            List<Method> tests = findTestsMethod(testClass, Test.class);
            Method before = ReflectionHelper.findAnnotatedMethod(testClass, Before.class);
            if (before != null)
                before.invoke(tc);
            if (tests.size() == 0) throw new NoTest("Нет тестовых методов");
            else {
                for (Method test : tests) {
                    test.invoke(tc);
                }
            }
            Method after = ReflectionHelper.findAnnotatedMethod(testClass, After.class);
            if (after != null)
                after.invoke(tc);

        } catch (NoTest e) {
            System.out.println("ошибка: " + e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static List<Method> findTestsMethod(Class<?> testClass, Class annotate) {
        List<Method> methods = new ArrayList<>();
        for (Method m : testClass.getMethods()) {
            if (m.getAnnotation(annotate) != null) {
                methods.add(m);
            }
        }
        return methods;
    }
}


