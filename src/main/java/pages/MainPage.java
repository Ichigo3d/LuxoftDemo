package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends BasePage {



    @FindBy(xpath="//*[@id='menu-switch']")
    WebElement btnMenu;

    @FindBy(xpath="//a[@href = 'https://career.luxoft.com/']")
    WebElement btnCareers;


    public MainPage(WebDriver driver) {
        super(driver);
    }



}
