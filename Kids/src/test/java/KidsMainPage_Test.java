import mainUtilities.categories.Smoke;
import mainUtilities.categories.SmokeKids;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class KidsMainPage_Test {

    @Category(SmokeKids.class)
    @Test
    public void test_pageOfProperFormatOpened(){
        new KidsMainPage()
                .open()
                .clickOnTelevision()
                .isURLValid();
    }

}
