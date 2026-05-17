package iscteiul.ista.blackbattleship;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Testes para a Utilizador História 8: Acesso aos diferentes planos de preços (Plus e Grupo).
 * 
 * Esta classe de teste verifica que o utilizador consegue aceder correctamente às páginas dos planos
 * Plus e Grupo, e que as URLs contêm as referências esperadas.
 */
public class UserStory8Test {

    /**
     * O controlador do navegador Selenium utilizado para os testes.
     */
    private WebDriver driver;
    
    /**
     * A página de teste para a Utilizador História 8.
     */
    private UserStory8 page;

    /**
     * Configuração realizada antes de cada teste.
     * 
     * Inicializa o WebDriver Chrome e cria uma nova instância da página de teste.
     */
    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        page = new UserStory8(driver);
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
     * Teste: Verifica se a página do plano Plus é aberta correctamente.
     * 
     * Este teste verifica que ao abrir a página do plano Plus, o URL contém "pricing/plus".
     */
    @Test
    public void accessPlusPlan() {
        page.openPlusPlan();

        assertTrue(page.getUrl().contains("pricing/plus"));
    }

    /**
     * Teste: Verifica se a página do plano Grupo é aberta correctamente.
     * 
     * Este teste verifica que ao abrir a página do plano Grupo, o URL contém "pricing/gruppo".
     */
    @Test
    public void accessGruppoPlan() {
        page.openGruppoPlan();

        assertTrue(page.getUrl().contains("pricing/gruppo"));
    }
}