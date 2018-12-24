import mainUtilities.categories.Smoke;
import mainUtilities.categories.SmokePets;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

public class ShowMoreButton_Test {

    @Category({Smoke.class, SmokePets.class})
    @Test
    public void test_moreNewsDisplayed(){
        new ShowMoreButton()
                .open()
                .checkMoreRecordsDisplayed();
    }

}
