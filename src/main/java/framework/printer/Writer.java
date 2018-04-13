package framework.printer;

public interface Writer {
    void writeTestFailed(String msg);

    void writeTestPassed(String msg);
}
