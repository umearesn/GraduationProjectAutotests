import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import mainUtilities.basicPages.BasePage;
import mainUtilities.pageNavigation.Domain;
import mainUtilities.pageNavigation.PageToOpenURL;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

@Domain("https://horo.mail.ru")
@PageToOpenURL("/horoscope")
public class HoroscopeTypesPage extends BasePage<HoroscopeTypesPage> {

    private SelenideElement flowerHoroscopeLink = $(By.xpath("//span[contains(text(), 'Цветочный гороскоп')]"));

    private SelenideElement pageHeader = $(By.xpath("//h1"));

    public HoroscopeTypesPage open(){
        return super.open();
    }

    public HoroscopeTypesPage goToFlowerHoroscopePage() {
        flowerHoroscopeLink.click();
        return this;
    }

    public HoroscopeTypesPage urlCheck(String desiredURL) {
        assertThat(desiredURL, is(WebDriverRunner.url()));
        return this;
    }

    public HoroscopeTypesPage headerCheck(String desiredText){
        assertThat(desiredText, is(pageHeader.getText()));
        return this;
    }


}
