import mainUtilities.categories.Smoke;
import mainUtilities.categories.SmokePets;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class ShowMoreButton_Test {

    @Category(SmokePets.class)
    @Test
    public void test_moreNewsDisplayed(){
        new ShowMoreButton()
                .open()
                .checkMoreRecordsDisplayed();
    }

}
