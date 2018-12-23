import mainUtilities.categories.Smoke;
import mainUtilities.categories.SmokeLady;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import java.util.Scanner;

public class AddRecipe_Test {

    @Category(SmokeLady.class)
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

