package com.LibraryCT.pages;

import com.LibraryCT.utilities.ConfigurationReader;
import com.LibraryCT.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

    public BasePage() {
        PageFactory.initElements(Driver.getDriver(), this);

    }


    @FindBy(id = "inputEmail")
    public WebElement inputUsername;

    @FindBy(id = "inputPassword")
    public WebElement inputPassword;

    @FindBy(xpath = "//*[.='Sign in']")
    public WebElement signInButton;


    public void loginAsStudent() {
        this.inputUsername.sendKeys(ConfigurationReader.getProperty("studentUsername"));
        this.inputPassword.sendKeys(ConfigurationReader.getProperty("studentPassword"));
        this.signInButton.click();
    }
    public void loginAsLibrarian() {
        this.inputUsername.sendKeys(ConfigurationReader.getProperty("librarianUsername"));
        this.inputPassword.sendKeys(ConfigurationReader.getProperty("librarianPassword"));
        this.signInButton.click();
    }
}