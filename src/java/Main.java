
import br.mackenzie.hangman.DAO.PlayerDAO;
import br.mackenzie.hangman.DAO.SessionDAO;
import br.mackenzie.hangman.DAO.TipDAO;
import br.mackenzie.hangman.DAO.WordDAO;
import br.mackenzie.hangman.controller.Controller;
import br.mackenzie.hangman.exception.PersistenceException;
import br.mackenzie.hangman.model.Player;
import br.mackenzie.hangman.model.Session;
import br.mackenzie.hangman.model.Word;
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
        /*try {
         /*PlayerDAO playerDAO = new PlayerDAO();
         System.out.println("Teste" + playerDAO.buscarPorNome("emartinelli"));
         if(playerDAO.buscarPorNome("emartinelli") == null) {
         System.out.println("Test3");
         playerDAO.inserir(new Player("emartinelli", "123"));
         }
         for(int i = 0; i < 2; i++) new WordDAO().inserir(new Word("Teste"+i));
         for (Word word : new WordDAO().listarTodos()) {
         System.out.println(word.getRealWord());
         }
         for (int i = 0; i < new TipDAO().listarTodos().size(); i++) {
         new TipDAO().listarTodos().get(i).getWord();
         }
            
         } catch (PersistenceException ex) {
         Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
         }*/
        try {
            System.out.println(new TipDAO().retornaTip(new WordDAO().buscarPorNome("teste0")));
        } catch (PersistenceException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
