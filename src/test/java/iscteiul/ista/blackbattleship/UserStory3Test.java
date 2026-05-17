package iscteiul.ista.blackbattleship;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Testes para a Utilizador História 3: Acesso à página do jogo Battleship.
 * 
 * Esta classe de teste verifica que o utilizador consegue aceder correctamente à página do jogo Battleship
 * e que a URL contém a referência esperada.
 */
public class UserStory3Test {

    /**
     * O controlador do navegador Selenium utilizado para os testes.
     */
    private WebDriver driver;
    
    /**
     * A página de teste para a Utilizador História 3.
     */
    private UserStory3 page;

    /**
     * Configuração realizada antes de cada teste.
     * 
     * Inicializa o WebDriver Chrome e cria uma nova instância da página de teste.
     */
    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        page = new UserStory3(driver);
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
     * Teste: Verifica se a página do jogo Battleship é aberta correctamente.
     * 
     * Este teste verifica que ao abrir a página do Battleship, o URL contém a palavra-chave "battleship".
     */
    @Test
    public void viewMatchHistory() {
        page.open();

        assertTrue(page.getUrl().contains("battleship"));
    }
}
