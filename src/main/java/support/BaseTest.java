package support;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;



public class BaseTest {

    @BeforeTest
    public void setUpBase() throws Exception {
        TestData testData = new TestData();
        Configure.initialize();
        Configure.getDriver().manage().deleteAllCookies(); // Driver delete cache from browser
        Configure.getDriver().manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(Configure.getDriver(), 20);
        Configure.getDriver().get(testData.BASE_URI);

    }

    @AfterTest
    public void testEnd() {

        Configure.close();//close TestContext file
    }

}