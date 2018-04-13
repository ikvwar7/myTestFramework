package framework.printer;

public class WriteToConsole implements Writer {
    @Override
    public void writeTestPassed(String msg) {
        System.out.println(msg + " - test passed succesfully");
    }

    @Override
    public void writeTestFailed(String msg) {
        System.out.println(msg + " - test failed");
    }

}
