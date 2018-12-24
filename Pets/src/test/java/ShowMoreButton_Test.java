import mainUtilities.categories.Smoke;
import mainUtilities.categories.SmokePets;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        Smoke.class,
        SmokePets.class
})
public class ShowMoreButton_Test {

    @Test
    public void test_moreNewsDisplayed(){
        new ShowMoreButton()
                .open()
                .checkMoreRecordsDisplayed();
    }

}
