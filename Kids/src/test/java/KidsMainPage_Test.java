import org.junit.Test;

public class KidsMainPage_Test {

    @Test
    public void test_pageOfProperFormatOpened(){
        new KidsMainPage()
                .open()
                .clickOnTelevision()
                .isURLValid();
    }

}
