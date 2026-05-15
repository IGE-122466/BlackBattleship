package iscteiul.ista.blackbattleship;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;

/**
 * Testes de Aceitação para a User Story 7.
 * Verifica se o utilizador consegue navegar corretamente para a secção de Avatares da Loja.
 */
public class UserStory7Test {
    private WebDriver driver;
    private UserStory7 us7;
    private JavascriptExecutor js;

    /**
     * Configuração inicial executada antes de cada teste.
     * Instancia o driver e navega para a página base do projeto.
     */
    @BeforeEach
    public void setUp() throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        js = (JavascriptExecutor) driver;

        driver.get("https://papergames.io/en/");
        us7 = new UserStory7(driver);
        Thread.sleep(3000);
    }

    /**
     * Finaliza a sessão do WebDriver após a execução de cada teste.
     */
    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    /**
     * Testa o fluxo de navegação até à loja de avatares.
     */
    @Test
    public void testarAcessoLojaEmojisEAvatares() throws InterruptedException {
        // Passo 1: Abrir o menu da Loja
        js.executeScript("arguments[0].click();", us7.shopButton);
        Thread.sleep(2000);

        // Passo 2: Selecionar a aba de Avatares/Emojis
        js.executeScript("arguments[0].click();", us7.avatarsAndEmojisTab);
        Thread.sleep(3000);

        // Validação: Verificar se o URL contém a palavra chave da página de destino

        boolean navegouCorretamente = driver.getCurrentUrl().contains("avatar") || driver.getCurrentUrl().contains("shop");
        assertTrue(navegouCorretamente, "A navegação para a página de Avatares/Emojis falhou! URL atual: " + driver.getCurrentUrl());
    }
}