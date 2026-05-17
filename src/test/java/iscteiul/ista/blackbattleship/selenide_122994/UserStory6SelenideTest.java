package iscteiul.ista.blackbattleship.selenide_122994;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.WebDriverConditions.*;

public class UserStory6SelenideTest {

    private void doLogin(UserStory6Selenide us6) throws InterruptedException {
        sleep(5000);

        us6.loginButton.shouldBe(visible).click();
        sleep(1000);

        us6.emailInput.shouldBe(visible).setValue("goufrappocrugra-7205@y.w80.it");
        sleep(1000);

        us6.passwordInput.shouldBe(visible).setValue("12345678");
        sleep(1000);

        us6.loginDialogButton.shouldBe(visible).click();
        sleep(5000);
    }

    @AfterEach
    public void tearDown() {
        closeWebDriver();
    }

    // -------------------------------------------------------------------------
    // 1.º Torneio — Leaderboard
    // -------------------------------------------------------------------------

    @Test
    public void createLeaderboardTournamentSucceeds() throws InterruptedException {
        Configuration.browserSize = "1920x1080";
        Configuration.timeout = 8000;

        open(UserStory6Selenide.URL);
        UserStory6Selenide us6 = new UserStory6Selenide();

        doLogin(us6);

        // Botão de criar torneio
        us6.createTournamentButton.shouldBe(visible).click();
        sleep(1000);

        // Jogo
        us6.gameSelector.shouldBe(visible).click();
        sleep(1000);
        us6.battleshipOption.shouldBe(visible).click();
        sleep(1000);

        // Modo
        us6.modeSelector.shouldBe(visible).click();
        sleep(1000);
        us6.leaderboardOptionT1.shouldBe(visible).click();
        sleep(1000);

        // Nome
        us6.tournamentNameInput.shouldBe(visible).setValue("IGE_122994");
        sleep(1000);
        us6.tournamentNameInput.scrollIntoView(true);

        // Rondas
        us6.matchesPerRoundSelector.shouldBe(visible).click();
        sleep(1000);
        us6.bestOf3OptionT1.shouldBe(visible).click();
        sleep(1000);

        // Minutos
        us6.minutesPerPlayerSelector.shouldBe(visible).click();
        sleep(1000);
        us6.threeMinutesOptionT1.shouldBe(visible).click();
        sleep(1000);

        // Penalidades
        us6.penaltyPointsSelector.shouldBe(visible).click();
        sleep(1000);
        us6.fifteenPtsOptionT1.shouldBe(visible).click();
        sleep(1000);

        // Criação
        us6.createAndShareButton.shouldBe(visible).click();
        sleep(2500);

        us6.closePopupButton.shouldBe(visible).click();
        sleep(1000);

        webdriver().shouldHave(urlContaining("/en/t/"));
    }

    // -------------------------------------------------------------------------
    // 2.º Torneio — Single elimination
    // -------------------------------------------------------------------------

    @Test
    public void createSingleEliminationTournamentSucceeds() throws InterruptedException {
        Configuration.browserSize = "1920x1080";
        Configuration.timeout = 8000;

        open(UserStory6Selenide.URL);
        UserStory6Selenide us6 = new UserStory6Selenide();

        doLogin(us6);

        // Aba lateral de criar torneio
        us6.createTournamentNavLink.shouldBe(visible).click();
        sleep(1000);

        // Jogo
        us6.gameSelector.shouldBe(visible).click();
        sleep(1000);
        us6.battleshipOption.shouldBe(visible).click();
        sleep(1000);

        // Modo
        us6.modeSelector.shouldBe(visible).click();
        sleep(1000);
        us6.singleEliminationOptionT2.shouldBe(visible).click();
        sleep(1000);

        // Nome
        us6.tournamentNameInput.shouldBe(visible).setValue("IGE_122466");
        sleep(1000);
        us6.tournamentNameInput.scrollIntoView(true);

        // Rondas
        us6.matchesPerRoundSelector.shouldBe(visible).click();
        sleep(1000);
        us6.bestOf1OptionT2.shouldBe(visible).click();
        sleep(1000);

        // Minutos
        us6.minutesPerPlayerSelector.shouldBe(visible).click();
        sleep(1000);
        us6.oneMinuteOptionT2.shouldBe(visible).click();
        sleep(1000);

        // Criação
        us6.createAndShareButton.shouldBe(visible).click();
        sleep(2500);

        us6.closePopupButton.shouldBe(visible).click();
        sleep(1000);

        webdriver().shouldHave(urlContaining("/en/t/"));
    }

    // -------------------------------------------------------------------------
    // 3.º Torneio — Double elimination
    // -------------------------------------------------------------------------

    @Test
    public void createDoubleEliminationTournamentSucceeds() throws InterruptedException {
        Configuration.browserSize = "1920x1080";
        Configuration.timeout = 8000;

        open(UserStory6Selenide.URL);
        UserStory6Selenide us6 = new UserStory6Selenide();

        doLogin(us6);

        // Aba lateral dos meus torneios
        us6.myTournamentsNavLink.shouldBe(visible).click();
        sleep(1000);

        // Botão no canto superior direito de criar torneio
        us6.createTournamentPageButton.shouldBe(visible).click();
        sleep(1000);

        // Jogo
        us6.gameSelectorT3.shouldBe(visible).click();
        sleep(1000);
        us6.battleshipOptionT3.shouldBe(visible).click();
        sleep(1000);

        // Modo
        us6.modeSelectorT3.shouldBe(visible).click();
        sleep(1000);
        us6.doubleEliminationOptionT3.shouldBe(visible).click();
        sleep(1000);

        // Nome
        us6.tournamentNameInputT3.shouldBe(visible).setValue("IGE_110323");
        sleep(1000);
        us6.tournamentNameInput.scrollIntoView(true);

        // Rondas
        us6.matchesPerRoundSelectorT3.shouldBe(visible).click();
        sleep(1000);
        us6.bestOf5OptionT3.shouldBe(visible).click();
        sleep(1000);

        // Minutos
        us6.minutesPerPlayerSelectorT3.shouldBe(visible).click();
        sleep(1000);
        us6.fiveMinutesOptionT3.shouldBe(visible).click();
        sleep(1000);

        // Criação
        us6.createAndShareButton.shouldBe(visible).click();
        sleep(2500);

        us6.closePopupButton.shouldBe(visible).click();
        sleep(1000);

        webdriver().shouldHave(urlContaining("/en/t/"));
    }
}
