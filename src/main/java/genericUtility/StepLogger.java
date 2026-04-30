package genericUtility;

import com.aventstack.extentreports.Status;

public class StepLogger {

    public static void given(String step) {
        Listeners.extentTest.get().log(Status.INFO, "<b>Given:</b> " + step);
    }

    public static void when(String step) {
        Listeners.extentTest.get().log(Status.INFO, "<b>When:</b> " + step);
    }

    public static void then(String step) {
        Listeners.extentTest.get().log(Status.INFO, "<b>Then:</b> " + step);
    }

    public static void and(String step) {
        Listeners.extentTest.get().log(Status.INFO, "<b>And:</b> " + step);
    }
}