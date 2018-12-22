import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import mainUtilities.basicPages.BasePage;
import mainUtilities.pageNavigation.Domain;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static org.hamcrest.MatcherAssert.assertThat;

@Domain("https://pets.mail.ru")
public class ShowMoreButton extends BasePage<ShowMoreButton> {

    String path ="//a[@class='pypo-item__title link-holder']";

    private ElementsCollection defaultNews = $$(By.xpath(path));

    private SelenideElement showMoreButton = $(By.xpath("//button[@class='button js-pypo-feed__more-control']"));

    public ShowMoreButton open() {
        return super.open();
    }

    public ShowMoreButton checkMoreRecordsDisplayed(){
        int defaultSize = defaultNews.size();
        showMoreButton.click();
        WebDriverWait waiter = new WebDriverWait(WebDriverRunner.getWebDriver(), 5);
        waiter.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath(path), defaultSize));
        ElementsCollection updatedNews = $$(By.xpath(path));
        assertThat("Больше новостей не отобразилось.", defaultSize < updatedNews.size());
        return this;
    }

}
