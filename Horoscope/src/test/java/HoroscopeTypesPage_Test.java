import mainUtilities.categories.Smoke;
import mainUtilities.categories.SmokeHoroscope;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        Smoke.class,
        SmokeHoroscope.class
})
public class HoroscopeTypesPage_Test {

    @Test
    public void test_requiredPageOpened(){
        new HoroscopeTypesPage()
                .open()
                .goToFlowerHoroscopePage()
                .urlCheck("https://horo.mail.ru/horoscope/flower/")
                .headerCheck("Цветочный гороскоп");
    }

}
