package iscteiul.ista.blackbattleship;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Testes para a Utilizador História 17: Acesso à página dos meus torneios.
 * 
 * Esta classe de teste verifica que o utilizador consegue aceder correctamente à página dos torneios
 * e que a URL e o código-fonte contêm as referências esperadas.
 */
public class UserStory17Test {

    /**
     * O controlador do navegador Selenium utilizado para os testes.
     */
    private WebDriver driver;
    
    /**
     * A página de teste para a Utilizador História 17.
     */
    private UserStory17 page;

    /**
     * Configuração realizada antes de cada teste.
     * 
     * Inicializa o WebDriver Chrome e cria uma nova instância da página de teste.
     */
    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        page = new UserStory17(driver);
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
     * Teste: Verifica se a página dos meus torneios é aberta correctamente.
     * 
     * Este teste verifica que ao abrir a página de torneios, o URL contém "my-tournaments"
     * e o código-fonte contém referências a "tournament" ou "history".
     */
    @Test
    public void viewMyTournamentsHistory() {
        page.openMyTournaments();

        assertTrue(page.getUrl().contains("my-tournaments"));
        assertTrue(page.getPageSource().toLowerCase().contains("tournament")
                || page.getPageSource().toLowerCase().contains("history"));
    }
}
