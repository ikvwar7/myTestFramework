package framework.asserts;

import framework.printer.Writer;

public class Assert {
    private static Writer writer;

    public Assert(Writer writer) {
        this.writer = writer;
    }

    public static void asserTrue(boolean condition) {
        String msg = "assertTrue";
        if (condition) writer.writeTestPassed(msg);
        else writer.writeTestFailed(msg);
    }

    public static void assertEquals(Object obj1, Object obj2) {
        String msg = "assertEquals";
        if (obj1.equals(obj2)) writer.writeTestPassed(msg);
        else writer.writeTestFailed(msg);
    }


    public static void assertNotNull(Object obj) {
        String msg = "assertNotNull";
        if (obj != null) writer.writeTestPassed(msg);
        else writer.writeTestFailed(msg);
    }
}

