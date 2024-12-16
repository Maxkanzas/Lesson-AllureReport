import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;
import static org.openqa.selenium.By.linkText;

public class SelenideTest {
    @Test
    void TestSelenide() {
        SelenideLogger.addListener("allure", new AllureSelenide());

            open("https://github.com");
            $(".color-fg-muted").click();
            $("#query-builder-test").sendKeys("Maxkanzas/Lesson-AllureReport");
            $("#query-builder-test").submit();
            $(linkText("Maxkanzas/Lesson-AllureReport")).click();
            $("#issues-tab").click();
            $(withText("#1")).should(Condition.exist);
       }
}