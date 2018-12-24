import mainUtilities.categories.Smoke;
import mainUtilities.categories.SmokeKids;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        Smoke.class,
        SmokeKids.class
})
public class KidsMainPage_Test {

    @Test
    public void test_pageOfProperFormatOpened(){
        new KidsMainPage()
                .open()
                .clickOnTelevision()
                .isURLValid();
    }

}
