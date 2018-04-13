package framework.testing;

import framework.annotations.After;
import framework.annotations.Before;
import framework.exception.NoTest;
import framework.annotations.Test;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;


public class Testing {
    private final List<Class> testClasses;

    public Testing(List<Class> classes) {
        this.testClasses = classes;
    }

    public void runTests() {
        for (Class clas : testClasses) {
            try {
                Object testClass = clas.newInstance();
                List<Method> tests = findTestsMethod(clas, Test.class);
                Method before = ReflectionHelper.findAnnotatedMethod(clas, Before.class);

                if (before != null) {
                    before.invoke(testClass);
                }
                if (tests.size() == 0) {
                    throw new NoTest("Нет тестовых методов в классе " + clas.getName());
                }

                for (Method test : tests) {
                    test.invoke(testClass);
                }

                Method after = ReflectionHelper.findAnnotatedMethod(clas, After.class);
                if (after != null) {
                    after.invoke(testClass);
                }
            } catch (NoTest e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private List<Method> findTestsMethod(Class<?> testClass, Class annotate) {
        List<Method> methods = new ArrayList<>();
        for (Method m : testClass.getMethods()) {
            if (m.getAnnotation(annotate) != null) {
                methods.add(m);
            }
        }
        return methods;
    }
}

