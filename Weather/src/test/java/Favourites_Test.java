import org.junit.Before;
import org.junit.Test;

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
