package com.LibraryCT.pages;

import com.LibraryCT.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashBoard {


    public DashBoard() {
        PageFactory.initElements(Driver.getDriver(), this);

    }

    @FindBy(xpath = "//h2[@id='borrowed_books']")
    public WebElement borrowedBookCount;
}
