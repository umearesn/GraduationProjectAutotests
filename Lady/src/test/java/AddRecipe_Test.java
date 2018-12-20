import com.codeborne.selenide.Selenide;
import mainUtilities.commonElements.LoginWindow;
//import mainUtilities.wait.StandartWaiter;
import org.junit.Test;

import java.io.File;
import java.util.Scanner;

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

