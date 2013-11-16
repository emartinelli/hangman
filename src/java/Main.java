
import br.mackenzie.hangman.DAO.PlayerDAO;
import br.mackenzie.hangman.exception.PersistenceException;
import br.mackenzie.hangman.model.Player;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author elvio
 */
public class Main {
    public static void main(String[] args) {
        try {
            PlayerDAO playerDAO = new PlayerDAO();
                            System.out.println("Teste" + playerDAO.buscarPorNome("emartinelli"));
                            if(playerDAO.buscarPorNome("emartinelli") == null) {
                                System.out.println("Test3");
                                playerDAO.inserir(new Player("emartinelli", "123"));
                            }
        } catch (PersistenceException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
