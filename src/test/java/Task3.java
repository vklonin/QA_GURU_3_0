import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Coordinates;

import java.awt.*;

import static com.codeborne.selenide.Condition.cssClass;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;

public class Task3 {

    @Test

    void checkSoftAssertion(){


        Robot robot = null;
        try {
            robot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }

        //String browserPosition = Configuration.browserPosition;

        Configuration.timeout = 3000;
        Configuration.startMaximized = true; // надо для локатора мышки через робот

        // open  link
        open("https://the-internet.herokuapp.com/drag_and_drop");

        // check if it is what we expected
        $("h3",0).shouldHave(text("Drag and Drop"));

        // find column A
        SelenideElement columnA = $("#column-a");

        // find column B
        SelenideElement columnB = $("#column-b");

        Coordinates coordinates = columnB.getCoordinates();
        int offsetX = 5; // смещение внутрь прямоугольника
        int offsetY = 110; //смещение от угла экрана до окна браузера


        //sleep(4000);

        robot.mouseMove(coordinates.onPage().x+offsetX, coordinates.onPage().y+offsetY);

        actions().dragAndDrop(columnA, columnB).build().perform();


        // Check if it is worked out

        $("#column-b").shouldHave(text("A"));


    }

}
