package lesson_jdi.pages;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.Title;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;
import lesson_jdi.entities.MetalsAndColorsInput;
import lesson_jdi.forms.MetalsAndColorsDifferentElementsForm;

@Url("metals-and-colors.html")
@Title("Metal and Colors")
public class MetalsAndColorsPage extends WebPage {

    private MetalsAndColorsDifferentElementsForm differentElementsForm;

    public void submitData(MetalsAndColorsInput input) {
        differentElementsForm.submitData(input);
    }

}
