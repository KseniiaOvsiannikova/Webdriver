package bdd.hooks;

import driver.DriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;

//import org.testng.annotations.Listeners;
//import util.TestListener;

public class DriverHooks {

    //@Listeners({TestListener.class})

    @Before
    public void getDriver() {
        DriverManager.getDriver();
    }

    @After
    public void closeDriver() {
        DriverManager.closeDriver();
    }
}
