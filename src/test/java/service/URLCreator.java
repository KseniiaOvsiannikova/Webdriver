package service;

public class URLCreator {

    public static String fromPropertyGOOGLE_URL() {
        return TestDataReader.getTestData("testdata.google.url");
    }

    public static String fromPropertyWIKIPEDIA_URL() {
        return TestDataReader.getTestData("testdata.wikipedia.url");
    }

    public static String fromPropertyJQUERY_URL() {
        return TestDataReader.getTestData("testdata.jqueryui.url");
    }

    public static String fromPropertyTUTORIALSPOINT_URL() {
        return TestDataReader.getTestData("testdata.tutorialspoint.url");
    }
}
