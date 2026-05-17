package iscteiul.ista.blackbattleship;

import org.openqa.selenium.WebDriver;

/**
 * Utilizador História 12: Como utilizador, desejo poder aceder à página de loja de potenciadores (boosters)
 * para que possa comprar itens que me ajudem a melhorar o meu desempenho no jogo.
 * 
 * Esta classe fornece funcionalidades para navegar até à página da loja de potenciadores no site papergames.io,
 * bem como obter informações sobre a página atual.
 */
public class UserStory12 {

    /**
     * O controlador do navegador Selenium utilizado para realizar operações no navegador.
     */
    private WebDriver driver;

    /**
     * Constrói uma nova instância de UserStory12 com o WebDriver fornecido.
     * 
     * @param driver o WebDriver a utilizar para controlar o navegador web
     * @throws IllegalArgumentException se o driver for nulo
     */
    public UserStory12(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Abre a página da loja de potenciadores (boosters) no navegador.
     * 
     * Este método direciona o navegador para a página da loja de potenciadores disponível em papergames.io,
     * permitindo ao utilizador visualizar e comprar potenciadores.
     * 
     * @throws org.openqa.selenium.WebDriverException se ocorrer um erro ao tentar aceder ao URL
     */
    public void openBoostersPage() {
        driver.get("https://papergames.io/en/shop/boosters");
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
