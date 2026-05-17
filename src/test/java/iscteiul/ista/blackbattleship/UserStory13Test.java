package iscteiul.ista.blackbattleship;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Testes para a Utilizador História 13: Acesso à página do perfil e estatísticas do utilizador.
 * 
 * Esta classe de teste verifica que o utilizador consegue aceder correctamente à página do perfil
 * e que a URL e o código-fonte contêm as referências esperadas ao perfil e estatísticas.
 */
public class UserStory13Test {

    /**
     * O controlador do navegador Selenium utilizado para os testes.
     */
    private WebDriver driver;
    
    /**
     * A página de teste para a Utilizador História 13.
     */
    private UserStory13 page;

    /**
     * Configuração realizada antes de cada teste.
     * 
     * Inicializa o WebDriver Chrome e cria uma nova instância da página de teste.
     */
    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        page = new UserStory13(driver);
    }

    /**
     * Limpeza realizada após cada teste.
     * 
     * Fecha o navegador e liberta os recursos utilizados.
     */
    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    /**
     * Teste: Verifica se a página do perfil e estatísticas é aberta correctamente.
     * 
     * Este teste verifica que ao abrir a página de perfil, o URL contém "profile"
     * e o código-fonte contém referências às estatísticas (vitórias, derrotas ou empates).
     */
    @Test
    public void viewProfileStats() {
        page.openProfileStats();

        assertTrue(page.getUrl().contains("profile"));
        assertTrue(page.getPageSource().toLowerCase().contains("win")
                || page.getPageSource().toLowerCase().contains("loss")
                || page.getPageSource().toLowerCase().contains("draw"));
    }
}