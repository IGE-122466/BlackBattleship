package iscteiul.ista.blackbattleship.selenide_122994;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;

public class UserStory9Selenide {

    public static final String URL = "https://papergames.io/en/battleship";

    // Botão "Login" na página inicial
    public SelenideElement loginButton =
            $(".btn-outline-dark");

    // Campo de email no diálogo de login
    public SelenideElement emailInput =
            $("#mat-input-serverApp0");

    // Campo de password no diálogo de login
    public SelenideElement passwordInput =
            $("#mat-input-serverApp1");

    // Botão "Login" dentro do diálogo
    public SelenideElement loginDialogButton =
            $(".w-100:nth-child(1) > .btn-secondary > .front");

    // Botão "Play vs robot"
    public SelenideElement playVsRobotButton =
            $(".w-100:nth-child(2) > .btn > .front");

    // Botão "Abort game" no canto inferior direito
    // Usamos texto parcial para garantir robustez
    public SelenideElement abortGameButton =
            $x("//button[contains(., 'Abort game')]");

    // Botão "Abort game" no diálogo de confirmação
    public SelenideElement abortGameConfirmButton =
            $(".btn-danger");
}
