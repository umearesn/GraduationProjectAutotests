import com.codeborne.selenide.SelenideElement;
import mainUtilities.basicPages.BasePage;
import mainUtilities.pageNavigation.Domain;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static org.junit.Assert.assertTrue;

@Domain("https://pogoda.mail.ru")
public class Favourites extends BasePage<Favourites> {

    private SelenideElement inputField = $(By.xpath("//input"));

    private SelenideElement suggestedCity = $(By.xpath("//span[@class='s-suggest__city']"));

    private SelenideElement addToFavourites = $(By.xpath("//span[@title='Добавить в избранные']"));

    private String addedCity = "";

    public Favourites addCityToFavourites(String name) {
        addedCity = name;
        inputField.setValue(name);
        suggestedCity.click();
        addToFavourites.click();
        return this;
    }

    private SelenideElement currentCityButton = $(By
            .xpath("//span[@class='js-button pm-toolbar__button  pm-toolbar__button_noicon" +
                    " pm-toolbar__button_dropdown pm-toolbar__button_first pm-toolbar__button_last-in-group']"));

    private SelenideElement firstFavouriteCity = $(By
            .xpath("//span[@class='city-select__item clearfix']/descendant::a[@class='city-select__item__link']"));

    private String cityOpened = "";

    public Favourites open(){
        return super.open();
    }

    public Favourites moveCursorToCities() {
        currentCityButton.hover();
        return this;
    }

    public Favourites checkThatCurrentCityPresented() {
        SelenideElement addedCity =
                $(By.xpath("//span[contains(text(), '(вы тут)')]"));
        assertTrue("Нет текущего города.", addedCity.exists());
        return this;
    }

    public Favourites checkThatFavouriteCityPresented() {
        SelenideElement addedCity =
                $(By.xpath("//span[contains(text(), '".concat(this.addedCity).concat("')]/ancestor::a[@class='city-select__item__link']")));
        assertTrue("Нет города в избранном.", addedCity.exists());
        return this;
    }

    public Favourites checkThatGuidePresented() {
        SelenideElement guide = $(By.xpath("//span[@class='icon icon_fav-flag-small']"));
        assertTrue("Нет инструкции по добавлению.", guide.exists());
        return this;
    }

    public Favourites openPageWithFavouriteCity() {
        cityOpened = $(By.xpath("//span[@class='city-select__item clearfix']/descendant::span[@class='city-select__item__city']"))
                .getText();
        firstFavouriteCity.click();
        return this;
    }

    public Favourites checkThatPageWithFavouriteCityOpened(){
        assertTrue("Открыта не та страница.", $(By.xpath("//span[contains(text(), '".concat(cityOpened).concat("')]"))).exists());
        return this;
    }

}
