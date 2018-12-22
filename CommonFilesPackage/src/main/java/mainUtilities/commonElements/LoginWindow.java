package mainUtilities.commonElements;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class LoginWindow {

    SelenideElement loginWindow = $(By.xpath("//form[@method='POST']"));

    private SelenideElement loginRow = $(By.xpath("//input[@class='c0152'][@type='text']"));

    private SelenideElement passwordRow = $(By.xpath("//input[@class='c0152'][@type='password']"));

    private SelenideElement submitButton = $(By.xpath("//div[@class='login-panel popup']/descendant::button[@type='submit']"));

    public void logIntoService(String login, String pass){
            loginRow.setValue(login);
            passwordRow.setValue(pass);
            submitButton.click();
    }

}
