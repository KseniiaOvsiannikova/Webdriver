package service;

public class URLCreator {
    private static final String GOOGLE_URL = "testdata.google.url";
    private static final String WIKIPEDIA_URL = "testdata.wikipedia.url";
    private static final String JQUERYUI_URL = "testdata.jqueryui.url";
    private static final String TUTORIALSPOINT_URL = "testdata.tutorialspoint.url";
    private static final String CUCUMBER_URL = "testdata.cucumber.url";

    public static String fromPropertyGOOGLE_URL() {
        return TestDataReader.getTestData(GOOGLE_URL);
    }

    public static String fromPropertyWIKIPEDIA_URL() {
        return TestDataReader.getTestData(WIKIPEDIA_URL);
    }

    public static String fromPropertyJQUERY_URL() {
        return TestDataReader.getTestData(JQUERYUI_URL);
    }

    public static String fromPropertyTUTORIALSPOINT_URL() {
        return TestDataReader.getTestData(TUTORIALSPOINT_URL);
    }

    public static String fromPropertyCUCUMBER_URL() { return TestDataReader.getTestData(CUCUMBER_URL); }
}
