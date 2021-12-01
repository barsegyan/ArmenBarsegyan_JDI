package lesson_jdi;

import com.epam.jdi.light.elements.init.PageFactory;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import lesson_jdi.entities.MetalsAndColorsInput;
import lesson_jdi.entities.User;
import lesson_jdi.forms.MetalsAndColorsDifferentElementsForm;
import org.testng.annotations.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

import static com.epam.jdi.light.driver.WebDriverUtils.killAllSeleniumDrivers;
import static com.epam.jdi.light.elements.init.PageFactory.initElements;


public class JdiSiteTest {

    public static final String TEST_DATA_SETS_JSON_PATH = ".\\src\\test\\resources\\JDI_ex8_metalsColorsDataSet.json";

    @DataProvider(name = "MetalsAndColorsDataProvider")
    public Object[] MetalsAndColorsDataProvider() {
        Map<String, MetalsAndColorsInput> inputDataSets = new HashMap<>();
        Gson gson = new Gson();
        try {
            BufferedReader br = new BufferedReader(new FileReader(TEST_DATA_SETS_JSON_PATH));
            Type type = new TypeToken<Map<String, MetalsAndColorsInput>>() {
            }.getType();
            inputDataSets = gson.fromJson(br, type);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return inputDataSets.values().toArray();
    }


    @BeforeSuite(alwaysRun = true)
    public static void setUp() {
        PageFactory.initElements(JdiSite.class);
    }

    @AfterSuite(alwaysRun = true)
    public static void tearDown() {
        killAllSeleniumDrivers();
    }


    @Test(dataProvider = "MetalsAndColorsDataProvider")
    public void testScenario(MetalsAndColorsInput inputData) {
        MetalsAndColorsDifferentElementsForm metalColor = new MetalsAndColorsDifferentElementsForm();
        User user = new User();
        JdiSite.open();
        JdiSite.homePage.login(user);
        JdiSite.homePage.goToMetalAndColorsPage();
        metalColor.submitData(inputData);

    }

    @AfterMethod(alwaysRun = true)
    public void logout() {
        JdiSite.logout();
    }

}
