package service;

public class URLCreator {
    private static final String GOOGLE_URL = "testdata.google.url";
    public static final String WIKIPEDIA_URL = "testdata.wikipedia.url";
    private static final String JQUERY_URL = "testdata.jqueryui.url";
    private static final String TUTORIALSPOINT_URL = "testdata.tutorialspoint.url";

    public static String fromPropertyGOOGLE_URL() {
        return new String(TestDataReader.getTestData(GOOGLE_URL));
    }

    public static String fromPropertyWIKIPEDIA_URL() {
        return new String(TestDataReader.getTestData(WIKIPEDIA_URL));
    }

    public static String fromPropertyJQUERY_URL() {
        return new String(TestDataReader.getTestData(JQUERY_URL));
    }

    public static String fromPropertyTUTORIALSPOINT_URL() {
        return new String(TestDataReader.getTestData(TUTORIALSPOINT_URL));
    }
}
