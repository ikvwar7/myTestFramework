package framework.Printer;

public interface Writer {
    void writeTestFailed(String msg);

    void writeTestPassed(String msg);
}
