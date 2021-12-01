package lesson_jdi;

import com.epam.jdi.light.elements.pageobjects.annotations.JSite;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import lesson_jdi.pages.HomePage;
import lesson_jdi.pages.MetalsAndColorsPage;
import org.openqa.selenium.WebElement;

@JSite("https://jdi-testing.github.io/jdi-light/")
public class JdiSite {

    public static HomePage homePage;
    public static MetalsAndColorsPage metalsAndColorsPage;
    @Css(".dropdown-menu-login")
    public static WebElement logout;
    @Css("img#user-icon")
    public static WebElement userIcon;

    public static void open() {
        homePage.open();
    }

    public static void logout() {
        userIcon.click();
        logout.click();
    }
}
