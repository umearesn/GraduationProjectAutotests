import mainUtilities.categories.Smoke;
import mainUtilities.categories.SmokeWeather;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class Favourites_Test {

    @Before
    public void addFavouriteCity() {
        new Favourites()
                .open()
                .addCityToFavourites("Казань");
    }

    @Category(SmokeWeather.class)
    @Test
    public void test_Favourites(){
        new Favourites()
                .open()
                .moveCursorToCities()
                .checkThatCurrentCityPresented()
                .checkThatFavouriteCityPresented()
                .checkThatGuidePresented()
                .openPageWithFavouriteCity()
                .checkThatPageWithFavouriteCityOpened();
    }

}
