import mainUtilities.categories.Smoke;
import mainUtilities.categories.SmokeLady;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import java.util.Scanner;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        Smoke.class,
        SmokeLady.class
})
public class AddRecipe_Test {

    @Test
    public void test_addingNewRecipe(){
        ClassLoader cl = Thread.currentThread().getContextClassLoader();
        Scanner scan = new Scanner(cl.getResourceAsStream("loginInfo.txt"));
        new AddRecipe()
                .open()
                .logInto(scan.nextLine(), scan.nextLine())
                .changeMeasurementUnit("шт.")
                .checkDropdownDisabled()
                .checkThatMeasurementUnitChanged();
    }

}

