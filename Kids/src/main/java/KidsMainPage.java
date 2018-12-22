import com.codeborne.selenide.SelenideElement;
import mainUtilities.basicPages.BasePage;
import mainUtilities.pageNavigation.Domain;
import mainUtilities.urlChecker.URLPattern;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

@Domain("https://deti.mail.ru")
@URLPattern("https:\\/\\/deti\\.mail\\.ru\\/[^ \\/]+\\/[^ \\/]+\\/")
public class KidsMainPage extends BasePage<KidsMainPage> {

    private SelenideElement firstLinkInTelevision =
            $(By.xpath("//div[@class = 'daynews']/descendant::a[@class='photo photo_full photo_scale']"));

    public KidsMainPage open(){
        return super.open();
    }

    public KidsMainPage clickOnTelevision(){
        firstLinkInTelevision.click();
        return this;
    }

    public KidsMainPage isURLValid(){
        return super.isURLValid();
    }

}

