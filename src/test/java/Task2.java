import com.codeborne.selenide.*;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class Task2 {

    @Test

    void checkSoftAssertion(){
        // open Selenide link in git
        open("https://github.com/selenide/selenide");

        // check if it is what we expected
        $("h1",0).shouldHave(text("selenide / selenide"));

        //find wiki link and follow
        $(byText("Wiki")).click();

        // check if it is what we expected
        $("h1",2).shouldHave(text("Welcome to the selenide wiki!"));

        //find SofAssertion link and go for it
        $(byText("SoftAssertions")).click();

        // check if it is what we expected
        $("h1",1).shouldHave(text("SoftAssertions"));

        // check for JUnit code sample

        SelenideElement using_jUnit5 = $(withText("Using JUnit5"));
        SelenideElement parent = using_jUnit5.parent();
        SelenideElement sibling = parent.sibling(0);

        sibling.shouldHave(cssClass("highlight-source-java"));

        //String ownText = sibling.getAttribute("class");

       // using_jUnit5.shouldHave(text("Using JUnit5"));


    }

}
