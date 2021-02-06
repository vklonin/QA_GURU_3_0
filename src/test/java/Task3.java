import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.interactions.Actions;

import static com.codeborne.selenide.Condition.cssClass;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;

public class Task3 {

    @Test

    void checkSoftAssertion(){

        Configuration.timeout = 3000;
        Configuration.startMaximized = true;

        // open  link
        open("https://the-internet.herokuapp.com/drag_and_drop");

        // check if it is what we expected
        $("h3",0).shouldHave(text("Drag and Drop"));

        // find column A
        SelenideElement columnA = $("#column-a");

        // find column B
        SelenideElement columnB = $("#column-b");


        //sleep(4000);

        actions().dragAndDrop(columnA, columnB).build().perform();


        // Check if it is worked out

        $("#column-b").shouldHave(text("A"));


    }

}
