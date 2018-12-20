package mainUtilities.commonElements;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.refresh;

public class LoginWindow {

    SelenideElement loginWindow = $(By.xpath("//form[@method='POST']"));

    private SelenideElement loginRow = $(By.xpath("//input[@class='c0152'][@type='text']"));

    private SelenideElement passwordRow = $(By.xpath("//input[@class='c0152'][@type='password']"));

    private SelenideElement submitButton = $(By.xpath("//div[@class='login-panel popup']/descendant::button[@type='submit']"));

    public void logIntoService(String login, String pass){
        //loginWindow.waitUntil(Condition.visible, 5000);
        //WebDriverRunner.getWebDriver().findElement(By.xpath("//input[@class='c0152'][@type='text']")).sendKeys(login);
            loginRow.setValue(login);
            passwordRow.setValue(pass);
            submitButton.click();
    }

}
