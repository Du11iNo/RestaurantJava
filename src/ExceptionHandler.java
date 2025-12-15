import java.util.Arrays;

public class ExceptionHandler {

    public static void printStackedError(Exception e) {
        StackTraceElement[] el = e.getStackTrace();
        System.err.println("Error in:");

        for (StackTraceElement traceEl : el) {
            System.err.printf("%s%s.%s in line %d\n",
                    " ".repeat(5),
                    traceEl.getClassName(),
                    traceEl.getMethodName(),
                    traceEl.getLineNumber());
        }
        System.err.println(" ".repeat(5) + "-Context: " + e.getMessage());
    }

    public static void printGeneralException(String message, Exception e) {
        System.err.println(message
                + System.lineSeparator()
                + Arrays.toString(e.getStackTrace()));
    }
}
