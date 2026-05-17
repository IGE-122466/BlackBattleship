package iscteiul.ista.blackbattleship;

import org.openqa.selenium.WebDriver;

/**
 * Utilizador História 17: Como utilizador, desejo poder aceder à página dos meus torneios
 * para que possa visualizar e gerir os torneios aos quais estou a participar.
 * 
 * Esta classe fornece funcionalidades para navegar até à página dos torneios do utilizador no site papergames.io,
 * bem como obter informações sobre a página actual.
 */
public class UserStory17 {

    /**
     * O controlador do navegador Selenium utilizado para realizar operações no navegador.
     */
    private WebDriver driver;

    /**
     * Constrói uma nova instância de UserStory17 com o WebDriver fornecido.
     * 
     * @param driver o WebDriver a utilizar para controlar o navegador web
     * @throws IllegalArgumentException se o driver for nulo
     */
    public UserStory17(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Abre a página dos meus torneios no navegador.
     * 
     * Este método direciona o navegador para a página dos torneios do utilizador disponível em papergames.io,
     * permitindo visualizar e gerir os torneios actuais e anteriores.
     * 
     * @throws org.openqa.selenium.WebDriverException se ocorrer um erro ao tentar aceder ao URL
     */
    public void openMyTournaments() {
        driver.get("https://papergames.io/en/t/my-tournaments");
    }

    /**
     * Obtém o URL actual da página aberta no navegador.
     * 
     * @return uma String contendo o URL actual do navegador
     */
    public String getUrl() {
        return driver.getCurrentUrl();
    }

    /**
     * Obtém o código-fonte HTML da página atualmente carregada no navegador.
     * 
     * @return uma String contendo o código-fonte completo da página HTML
     */
    public String getPageSource() {
        return driver.getPageSource();
    }
}