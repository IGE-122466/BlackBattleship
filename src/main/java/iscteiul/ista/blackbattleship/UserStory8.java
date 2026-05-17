package iscteiul.ista.blackbattleship;

import org.openqa.selenium.WebDriver;

/**
 * Utilizador História 8: Como utilizador, desejo poder aceder aos diferentes planos de preços (Plus e Grupo)
 * para que possa escolher o plano mais adequado às minhas necessidades.
 * 
 * Esta classe fornece funcionalidades para navegar até às páginas de preços disponíveis no site papergames.io,
 * permitindo aceder aos planos Plus e Grupo, bem como obter informações sobre a página atual.
 */
public class UserStory8 {

    /**
     * O controlador do navegador Selenium utilizado para realizar operações no navegador.
     */
    private WebDriver driver;

    /**
     * Constrói uma nova instância de UserStory8 com o WebDriver fornecido.
     * 
     * @param driver o WebDriver a utilizar para controlar o navegador web
     * @throws IllegalArgumentException se o driver for nulo
     */
    public UserStory8(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Abre a página do plano de preços Plus no navegador.
     * 
     * Este método direciona o navegador para a página de preços do plano Plus disponível em papergames.io.
     * 
     * @throws org.openqa.selenium.WebDriverException se ocorrer um erro ao tentar aceder ao URL
     */
    public void openPlusPlan() {
        driver.get("https://papergames.io/en/pricing/plus");
    }

    /**
     * Abre a página do plano de preços Grupo no navegador.
     * 
     * Este método direciona o navegador para a página de preços do plano Grupo disponível em papergames.io.
     * 
     * @throws org.openqa.selenium.WebDriverException se ocorrer um erro ao tentar aceder ao URL
     */
    public void openGruppoPlan() {
        driver.get("https://papergames.io/en/pricing/gruppo");
    }

    /**
     * Obtém o URL atual da página aberta no navegador.
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