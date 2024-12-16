import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;

public class StepTest {
    private static final String REPOSITORY = "Maxkanzas/Lesson-AllureReport";
    private static final int ISSUE = 1;

    @Test
    void testStepSelenide() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        step("Открываем страницу Selenide в GitHub", ()-> {
            open("https://github.com");
        });
        step("Поиск репозитория" + REPOSITORY, ()->{
            $(".color-fg-muted").click();
            $("#query-builder-test").sendKeys("Maxkanzas/Lesson-AllureReport");
            $("#query-builder-test").submit();
        });
        step("Кликаем по ссылке репозитория" + REPOSITORY,() ->{
            $(linkText("Maxkanzas/Lesson-AllureReport")).click();
        });
        step("Открываем таб Issues" + REPOSITORY,()->{
            $("#issues-tab").click();
        });
        step("Проверяем наличие Issue с номером" + ISSUE, ()->{
                $(withText("#1")).should(Condition.exist);
        });
    }
    @Test
    public void testAnnotatedStep() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        WebSteps steps = new WebSteps();

        steps.openMainPage();
        steps.searchForRepository(REPOSITORY);
        steps.clickOnRepositoryLink(REPOSITORY);
        steps.openIssuesTab();
        steps.shouldSeeIssueWithNumber(ISSUE);
    }
}