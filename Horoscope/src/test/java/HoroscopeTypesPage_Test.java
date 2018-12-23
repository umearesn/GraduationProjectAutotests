import mainUtilities.categories.Smoke;
import mainUtilities.categories.SmokeHoroscope;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class HoroscopeTypesPage_Test {

    @Category(SmokeHoroscope.class)
    @Test
    public void test_requiredPageOpened(){
        new HoroscopeTypesPage()
                .open()
                .goToFlowerHoroscopePage()
                .urlCheck("https://horo.mail.ru/horoscope/flower/")
                .headerCheck("Цветочный гороскоп");
    }

}
