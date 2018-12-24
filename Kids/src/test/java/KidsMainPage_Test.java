import mainUtilities.categories.Smoke;
import mainUtilities.categories.SmokeKids;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

public class KidsMainPage_Test {

    @Category({Smoke.class, SmokeKids.class})
    @Test
    public void test_pageOfProperFormatOpened(){
        new KidsMainPage()
                .open()
                .clickOnTelevision()
                .isURLValid();
    }

}
