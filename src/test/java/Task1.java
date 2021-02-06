import com.codeborne.selenide.*;
import org.junit.jupiter.api.Test;

import java.io.Console;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class Task1 {

    //Вопрос: Есть ли разница между $("h1 div"); и $("h1").$("div"); - может ли привести к тому что, поиск найдёт разные элементы?
    //Ответ: разница есть, если на странице будет как минимум 2 элемента h1 и в первом не будет тега div то эти поиски найдут разные элементы/
    // ниже пример для span  и div в ресурсах лежит файл ForTask1.html

    @Test
    void lookForDivs(){

        open("file:///Users/vladimirklonin/IdeaProjects/QA_GURU_3_0/src/test/resources/ForTask1.html");

        SelenideElement h1_div = $("span div");

        SelenideElement h1_2 = $("span").$("div");

        System.out.println(h1_div);
        System.out.println(h1_2);


    }


}
