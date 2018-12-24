import mainUtilities.categories.Smoke;
import mainUtilities.categories.SmokeWeather;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        Smoke.class,
        SmokeWeather.class
})
public class Favourites_Test {

    @Before
    public void addFavouriteCity() {
        new Favourites()
                .open()
                .addCityToFavourites("Казань");
    }

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
