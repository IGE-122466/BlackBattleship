package iscteiul.ista.blackbattleship;

import org.openqa.selenium.WebDriver;

/**
 * Utilizador História 13: Como utilizador, desejo poder aceder à página do meu perfil e estatísticas
 * para que possa visualizar o meu progresso no jogo.
 * 
 * Esta classe fornece funcionalidades para navegar até à página do perfil e estatísticas do utilizador
 * no site papergames.io, bem como obter informações sobre a página atual.
 */
public class UserStory13 {

    /**
     * O controlador do navegador Selenium utilizado para realizar operações no navegador.
     */
    private WebDriver driver;

    /**
     * Constrói uma nova instância de UserStory13 com o WebDriver fornecido.
     * 
     * @param driver o WebDriver a utilizar para controlar o navegador web
     * @throws IllegalArgumentException se o driver for nulo
     */
    public UserStory13(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Abre a página do perfil e estatísticas do utilizador no navegador.
     * 
     * Este método direciona o navegador para a página de perfil disponível em papergames.io,
     * permitindo ao utilizador visualizar as suas estatísticas e progresso.
     * 
     * @throws org.openqa.selenium.WebDriverException se ocorrer um erro ao tentar aceder ao URL
     */
    public void openProfileStats() {
        driver.get("https://papergames.io/en/profile");
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