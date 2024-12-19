import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.*;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.attachment;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;

public class AttachmentsTest {
    private static final String REPOSITORY = "Maxkanzas/Lesson-AllureReport";
    private static final int ISSUE = 1;

    @Feature("Вход на сайт GitHub")
    @Story("Переход на страницу Selenide на GitHub")
    @Owner("Канцеляристов Максим Дмитривич")
    @Severity(SeverityLevel.MINOR)
    @Test
    void testStepSelenide() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        step("Открываем страницу Selenide в GitHub", ()-> {
            open("https://github.com");
            attachment("Source", webdriver().driver().source());
        });
    }
    @Test
    public void testAnnotatedStep() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        WebSteps steps = new WebSteps();

        steps.openMainPage();
        steps.takeSkreenshot();
    }
}