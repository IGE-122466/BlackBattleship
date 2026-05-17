package iscteiul.ista.blackbattleship.selenide_122994;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;

public class UserStory6Selenide {

    public static final String URL = "https://papergames.io/en/battleship";

    // -------------------------------------------------------------------------
    // Login
    // -------------------------------------------------------------------------

    public SelenideElement loginButton =
            $(".btn-outline-dark");

    public SelenideElement emailInput =
            $("#mat-input-serverApp0");

    public SelenideElement passwordInput =
            $("#mat-input-serverApp1");

    public SelenideElement loginDialogButton =
            $(".w-100:nth-child(1) > .btn-secondary > .front");

    // -------------------------------------------------------------------------
    // Botões para aceder ao formulário dos torneios
    // -------------------------------------------------------------------------

    public SelenideElement createTournamentButton =
            $(".position-relative > .front");

    public SelenideElement createTournamentNavLink =
            $x("//span[contains(.,'Create tournament')]");

    public SelenideElement myTournamentsNavLink =
            $x("//span[contains(.,'My tournaments')]");

    public SelenideElement createTournamentPageButton =
            $(".btn");

    // -------------------------------------------------------------------------
    // Formulário dos primeiros dois torneios
    // -------------------------------------------------------------------------

    public SelenideElement gameSelector =
            $("#mat-select-serverApp0 svg");

    public SelenideElement battleshipOption =
            $("#mat-option-serverApp0 .c-gray-700");

    public SelenideElement modeSelector =
            $("#mat-select-serverApp1 svg");

    public SelenideElement leaderboardOptionT1 =
            $("#mat-option-serverApp6 .c-gray-700");

    public SelenideElement tournamentNameInput =
            $("#mat-input-serverApp2");

    public SelenideElement matchesPerRoundSelector =
            $("#mat-select-serverApp2 svg");

    public SelenideElement bestOf3OptionT1 =
            $("#mat-option-serverApp12");

    public SelenideElement minutesPerPlayerSelector =
            $("#mat-select-serverApp3 svg");

    public SelenideElement threeMinutesOptionT1 =
            $x("//mat-option[contains(.,'3 minutes')]");

    public SelenideElement penaltyPointsSelector =
            $("#mat-select-value-serverApp4");

    public SelenideElement fifteenPtsOptionT1 =
            $x("//mat-option[contains(.,'15 pts')]");

    public SelenideElement createAndShareButton =
            $(".btn");

    public SelenideElement closePopupButton =
            $x("//div/button/span[3]");

    public SelenideElement singleEliminationOptionT2 =
            $x("//*[@id='mat-option-serverApp7']");

    public SelenideElement bestOf1OptionT2 =
            $x("//*[@id='mat-option-serverApp11']");

    public SelenideElement oneMinuteOptionT2 =
            $x("//*[@id='mat-option-serverApp18']");

    // -------------------------------------------------------------------------
    // Formulário do 3.º torneio (My tournaments – Double elimination)
    // -------------------------------------------------------------------------

    public SelenideElement gameSelectorT3 =
            $("#mat-select-value-serverApp1");

    public SelenideElement battleshipOptionT3 =
            $x("//*[@id='mat-option-serverApp4']");

    public SelenideElement modeSelectorT3 =
            $("#mat-select-value-serverApp2");

    public SelenideElement doubleEliminationOptionT3 =
            $x("//*[@id='mat-option-serverApp12']");

    public SelenideElement tournamentNameInputT3 =
            $("#mat-input-serverApp2");

    public SelenideElement matchesPerRoundSelectorT3 =
            $("#mat-select-value-serverApp3");

    public SelenideElement bestOf5OptionT3 =
            $("#mat-option-serverApp17");

    public SelenideElement minutesPerPlayerSelectorT3 =
            $("#mat-select-value-serverApp4");

    public SelenideElement fiveMinutesOptionT3 =
            $x("//*[@id='mat-option-serverApp25']");
}
