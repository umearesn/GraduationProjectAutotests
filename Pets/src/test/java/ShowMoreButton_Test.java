import org.junit.Test;

public class ShowMoreButton_Test {

    @Test
    public void test_moreNewsDisplayed(){
        new ShowMoreButton()
                .open()
                .checkMoreRecordsDisplayed();
    }

}
