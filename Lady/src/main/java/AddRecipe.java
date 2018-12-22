import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import mainUtilities.basicPages.BasePage;
import mainUtilities.commonElements.LoginWindow;
import mainUtilities.pageNavigation.Domain;
import mainUtilities.pageNavigation.PageToOpenURL;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.codeborne.selenide.Selenide.$;
import static org.junit.Assert.assertTrue;

@Domain("https://lady.mail.ru")
@PageToOpenURL("/recipe/add")
public class AddRecipe extends BasePage<AddRecipe> {

    private String expected;

    private SelenideElement measurementUnit = $(By.xpath(
            "//div[@class='dropdown dropdown_scrollable dropdown_from-right dropdown_scrollable js-select js-module']"));

    public AddRecipe open(){
        return super.open();
    }

    public AddRecipe logInto(String login, String pass){
        WebDriverWait waiter = new WebDriverWait(WebDriverRunner.getWebDriver(), 5);
        waiter.until(ExpectedConditions.
                frameToBeAvailableAndSwitchToIt($(By.xpath("//iframe[@class='ag-popup__frame__layout__iframe']"))));
        new LoginWindow()
                .logIntoService(login, pass);
        return this;
    }

    public AddRecipe changeMeasurementUnit(String to){
        measurementUnit.click();
        this.expected = to;
        $(By.xpath("//div[contains(text(), '".concat(to).concat("')]")))
                .click();
        return this;
    }

    public AddRecipe checkDropdownDisabled(){
        assertTrue("Выпадающее меня не закрылось.",
                !$(By.xpath("//div[@class='dropdown dropdown_scrollable " +
                        "dropdown_from-right dropdown_scrollable js-select js-module dropdown_active']"))
                        .is(Condition.exist));
        return this;
    }

    public AddRecipe checkThatMeasurementUnitChanged() {
        SelenideElement field = $(By
                .xpath("//div[@class='dropdown__field js-select__selected']/descendant::div[contains(text(), '"
                        .concat(this.expected).concat("')]")));
        assertTrue("Отображается неверная единица измерения.", field.is(Condition.exist));
        return this;
    }

}
