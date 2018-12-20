import org.junit.Test;

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
