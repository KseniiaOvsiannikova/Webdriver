package service;

public class URLCreator {
    private static final String GOOGLE_URL = "testdata.google.url";
    public static final String WIKIPEDIA_URL = "testdata.wikipedia.url";
    private static final String JQUERY_URL = "testdata.jqueryui.url";
    private static final String TUTORIALSPOINT_URL = "testdata.tutorialspoint.url";

    public static String fromProperty(){
        return new String(TestDataReader.getTestData(WIKIPEDIA_URL));
    }
}
