package com.LibraryCT.step_definitions;

import com.LibraryCT.utilities.DB_Utils;
import com.LibraryCT.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.cucumber.plugin.event.Node;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {

    @After
    public void teardownScenario(Scenario scenario){

        //scenario.isFailed() --> if scenario fails this method will return TRUE boolean value
        if (scenario.isFailed()){

            byte [] screenshot = ((TakesScreenshot)Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());

        }

        Driver.closeDriver();
        DB_Utils.destroy();


    }
}
