import com.codeborne.selenide.*;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class Task2 {

    @Test

    void checkSoftAssertion(){
        // open Selenide link in git with elements
        open("https://github.com");
        $(byName("q")).val("selenide").pressEnter();
        $("em").shouldHave(text("selenide")).click();

        // check if it is what we expected
        $("h1").shouldHave(text("selenide / selenide"));

        //find wiki link and follow
        $(byText("Wiki")).click();

        // check if it is what we expected
        $("h1",2).shouldHave(text("Welcome to the selenide wiki!"));

        //find SofAssertion link and go for it
        $(byText("SoftAssertions")).click();

        // check if it is what we expected
        $("h1",1).shouldHave(text("SoftAssertions"));

        // check for JUnit code sample

        $(withText("Using JUnit5")).parent().sibling(0).shouldHave(cssClass("highlight-source-java"));

    }

}
