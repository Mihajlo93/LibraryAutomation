package com.LibraryCT.step_definitions;

import com.LibraryCT.pages.BasePage;
import com.LibraryCT.pages.DashBoard;
import com.LibraryCT.utilities.BrowserUtils;
import com.LibraryCT.utilities.ConfigurationReader;
import com.LibraryCT.utilities.DB_Utils;
import com.LibraryCT.utilities.Driver;
import io.cucumber.java.en.*;
import org.testng.Assert;

public class US2 {

    BasePage basePage = new BasePage();
    DashBoard dashBoard = new DashBoard();
    @Given("I am in the homepage of the library app")
    public void i_am_in_the_homepage_of_the_library_app() {
        Driver.getDriver().get((ConfigurationReader.getProperty("env")));
        basePage.loginAsLibrarian();
    }
    @When("I take borrowed books number")
    public void i_take_borrowed_books_number() {
        BrowserUtils.sleep(3);
        System.out.println("dashBoard.borrowedBookCount.getText() = " + dashBoard.borrowedBookCount.getText());


    }
    @Then("borrowed books number information must match with DB")
    public void borrowed_books_number_information_must_match_with_db() {
        BrowserUtils.sleep(3);
        String actualResult = dashBoard.borrowedBookCount.getText();

        DB_Utils.createConnection(ConfigurationReader.getProperty("url"), ConfigurationReader.getProperty("db_username"), ConfigurationReader.getProperty("db_password"));
        DB_Utils.runQuery("select count(*) from book_borrow where is_returned=0");
        String expectedResult = DB_Utils.getFirstRowFirstColumn();

        Assert.assertEquals(actualResult, expectedResult);


    }
}
