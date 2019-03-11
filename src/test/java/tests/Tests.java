package tests;

import org.testng.annotations.Test;
import pages.BasePage;
import pages.MainPage;
import support.BaseTest;
import support.Configure;

import static org.testng.Assert.assertEquals;

public class Tests extends BaseTest {

    BasePage base;
    MainPage main_page;

    @Test

    public void test(){

        main_page = new MainPage(Configure.getDriver()); // link to the PageObjects
        assertEquals("Luxoft | Digital Strategy, Consulting and Engineering at Scale", Configure.getDriver().getTitle());
    }



}
