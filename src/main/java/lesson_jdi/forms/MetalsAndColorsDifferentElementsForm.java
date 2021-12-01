package lesson_jdi.forms;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.dropdown.Dropdown;
import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.pageobjects.annotations.FindBy;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.JDropdown;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.complex.RadioButtons;
import lesson_jdi.entities.MetalsAndColorsInput;

import java.util.List;

public class MetalsAndColorsDifferentElementsForm extends Form<MetalsAndColorsInput> {

    @FindBy(xpath = "//*[@id='elements-checklist']//label[contains(text(), '%s')]")
    private UIElement elementsOfNatureCheckboxes;

    @FindBy(name = "custom_radio_odd")
    private RadioButtons oddRadios;

    @FindBy(name = "custom_radio_even")
    private RadioButtons evenRadios;

    @JDropdown(root = "#colors",
            value = ".filter-option",
            list = "li",
            expand = ".caret")
    private Dropdown colorsDropdown;

    @JDropdown(root = "#metals",
            value = ".filter-option",
            list = "li",
            expand = ".caret")
    private Dropdown metalsDropdown;

    @JDropdown(root = "#vegetables",
            value = ".filter-option",
            list = "li",
            expand = ".caret")
    private Dropdown vegetablesDropdown;

    @FindBy(xpath = "//*[@id=\"submit-button\"]")
    private Button submit;

    private void clickOnElementsOfNature(List<String> elements) {
        for (String element : elements) {
            elementsOfNatureCheckboxes.select(element);
        }
    }

    private void selectSummaryNumbers(Integer odd, Integer even) {
        oddRadios.select(odd / 2 + 1);
        evenRadios.select(even / 2);
    }

    private void selectColor(String color) {
        colorsDropdown.select(color);
    }

    private void selectMetal(String metal) {
        metalsDropdown.select(metal);
    }

    private void selectVegetables(List<String> vegetables) {
        vegetablesDropdown.select(3);
        for (String vegetable : vegetables) {
            vegetablesDropdown.select(vegetable);
        }
    }

    @Override
    public void submit() {
        submit.click();
    }

    public void submitData(MetalsAndColorsInput input) {
        selectSummaryNumbers(input.getSummary().get(0), input.getSummary().get(1));
        clickOnElementsOfNature(input.getElements());
        selectColor(input.getColor());
        selectMetal(input.getMetals());
        selectVegetables(input.getVegetables());
        submit();
    }
}
