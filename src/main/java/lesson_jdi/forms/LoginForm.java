package lesson_jdi.forms;

import com.epam.jdi.light.elements.common.Label;
import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.common.Icon;
import com.epam.jdi.light.ui.html.elements.common.TextField;
import lesson_jdi.entities.User;
import org.openqa.selenium.support.FindBy;


public class LoginForm extends Form<User> {
    @FindBy(css = "#name")
    private TextField login;

    @FindBy(css = "#password")
    private TextField password;

    @FindBy(css = "#login-button")
    private Button submit;

    @Css("#user-name")
    private Label userName;

    @FindBy(id = "user-icon")
    private Icon userIcon;


    @Override
    public void login(User user) {
        userIcon.click();
        login.input(user.getLogin());
        password.input(user.getPassword());

        submit.click();
    }

    public Label getUserName() {
        return userName;
    }
}
