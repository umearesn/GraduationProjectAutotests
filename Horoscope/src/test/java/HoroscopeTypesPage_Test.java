import mainUtilities.categories.Smoke;
import mainUtilities.categories.SmokeHoroscope;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

public class HoroscopeTypesPage_Test {

    @Category({Smoke.class, SmokeHoroscope.class})
    @Test
    public void test_requiredPageOpened(){
        new HoroscopeTypesPage()
                .open()
                .goToFlowerHoroscopePage()
                .urlCheck("https://horo.mail.ru/horoscope/flower/")
                .headerCheck("Цветочный гороскоп");
    }

}
