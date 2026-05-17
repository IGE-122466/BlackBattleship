package iscteiul.ista.blackbattleship;

import org.openqa.selenium.WebDriver;

/** * Utilizador História 3: Como utilizador, desejo poder aceder à página do jogo Battleship para que possa jogar. *
 * Esta classe encapsula a funcionalidade necessária para interagir com a página do jogo Battleship * através do Selenium WebDriver. Fornece métodos para abrir o jogo e obter a URL atual. */
public class UserStory3 {

    /**     * O controlador do navegador Selenium utilizado para realizar operações no navegador.     */
    private WebDriver driver;

    /**     * Constrói uma nova instância de UserStory3 com o WebDriver fornecido.     *
     * @param driver o WebDriver a utilizar para controlar o navegador web     * @throws IllegalArgumentException se o driver for nulo     */
    public UserStory3(WebDriver driver) {
        this.driver = driver;
    }

    /**     * Abre a página do jogo Battleship no navegador.     *
     * Este método direciona o navegador para o URL do jogo Battleship disponível em papergames.io.     *
     * @throws org.openqa.selenium.WebDriverException se ocorrer um erro ao tentar aceder ao URL     */
    public void open() {
        driver.get("https://papergames.io/en/battleship");
    }

    /**     * Obtém o URL atual da página aberta no navegador.     *
     * @return uma String contendo o URL atual do navegador     */
    public String getUrl() {
        return driver.getCurrentUrl();
    }
}