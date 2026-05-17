package iscteiul.ista.blackbattleship;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Testes para a Utilizador História 12: Acesso à página de loja de potenciadores (boosters).
 * 
 * Esta classe de teste verifica que o utilizador consegue aceder correctamente à página da loja de boosters
 * e que o URL e o código-fonte contêm as referências esperadas.
 */
public class UserStory12Test {

    /**
     * O controlador do navegador Selenium utilizado para os testes.
     */
    private WebDriver driver;
    
    /**
     * A página de teste para a Utilizador História 12.
     */
    private UserStory12 page;

    /**
     * Configuração realizada antes de cada teste.
     * 
     * Inicializa o WebDriver Chrome e cria uma nova instância da página de teste.
     */
    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        page = new UserStory12(driver);
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
     * Teste: Verifica se a página da loja de potenciadores é aberta correctamente.
     * 
     * Este teste verifica que ao abrir a página de boosters, o URL contém "shop/boosters"
     * e o código-fonte contém as palavras-chave "booster" ou "shop".
     */
    @Test
    public void accessBoostersShop() {
        page.openBoostersPage();

        assertTrue(page.getUrl().contains("shop/boosters"));
        assertTrue(page.getPageSource().toLowerCase().contains("booster")
                || page.getPageSource().toLowerCase().contains("shop"));
    }
}