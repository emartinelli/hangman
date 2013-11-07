package br.mackenzie.hangman.DAO;

import br.mackenzie.hangman.model.Tip;
import br.mackenzie.hangman.exception.PersistenceException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TipDAO implements GenericDAO <Tip>{

    @Override
    public void inserir(Tip tip) throws PersistenceException {
        Connection connection = null;
        try {
            connection = ConnectionHangman.getInstance().getConnection();
            String sql = "INSERT INTO HANGMAN_DB.TIP (INFORMATION,IDWORD) VALUES (?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,tip.getInformation());
            preparedStatement.setInt(2,new WordDAO().retornaId(tip.getWord()));
            preparedStatement.executeUpdate();
            connection.close();

        }catch (ClassNotFoundException ex) {
            Logger.getLogger(br.mackenzie.hangman.DAO.TipDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new PersistenceException("Inserção não realizada!");
        }
        catch ( SQLException ex) {
            Logger.getLogger(br.mackenzie.hangman.DAO.TipDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new PersistenceException("Inserção não realizada!");
        }
             
    }

    @Override
    public void atualizar(Tip tip) throws PersistenceException {
        Connection connection = null;
        try {
            connection = ConnectionHangman.getInstance().getConnection();
            String sql = "UPDATE HANGMAN_DB.TIP SET INFORMATION = ? WHERE IDTIP = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, tip.getInformation());
            preparedStatement.setInt(2,new WordDAO().retornaId(tip.getWord()));
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(br.mackenzie.hangman.DAO.TipDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new PersistenceException("Atualização não realizada!");
        }
        catch ( SQLException ex) {
            Logger.getLogger(br.mackenzie.hangman.DAO.TipDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new PersistenceException("Atualização não realizada!");
        }
    }

    public void deletar(Tip tip) throws PersistenceException {
        Connection connection = null;
        try {
            connection = ConnectionHangman.getInstance().getConnection();
            String sql = "DELETE FROM HANGMAN_DB.TIP WHERE IDWORD = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, new WordDAO().retornaId(tip.getWord()));
            preparedStatement.executeUpdate();
            connection.close();
            
        }catch (ClassNotFoundException ex) {
            Logger.getLogger(br.mackenzie.hangman.DAO.TipDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new PersistenceException("Não foi possível excluir o registro!");
        }
        catch ( SQLException ex) {
            Logger.getLogger(br.mackenzie.hangman.DAO.TipDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new PersistenceException("Não foi possível excluir o registro!");
        }
    }

    @Override
    public List<Tip> listarTodos() throws PersistenceException {
        Connection connection = null;
        List<Tip> tips = new ArrayList<Tip>();
        try {
            connection = ConnectionHangman.getInstance().getConnection();
            String sql = "SELECT HANGMAN_DB.TIP.INFORMATION, HANGMAN_DB.TIP.IDWORD FROM HANGMAN_DB.TIP INNER JOIN HANGMAN_DB.WORD ON HANGMAN_DB.WORD.IDWORD = HANGMAN_DB.TIP.IDWORD";
            Statement select = connection.createStatement();
            ResultSet result = select.executeQuery(sql);
            
            while(result.next()){
                tips.add(new Tip(result.getString("INFORMATION"),new WordDAO().buscarPorId(result.getInt("IDWORD"))));
            }
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(br.mackenzie.hangman.DAO.TipDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new PersistenceException("Não foi possível listar todos!");
        }
        catch ( SQLException ex) {
            Logger.getLogger(br.mackenzie.hangman.DAO.TipDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new PersistenceException("Não foi possível listar todos!");
        }
		return tips;
    }

    @Override
    public Tip buscarPorNome(String name) throws PersistenceException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void deletar(Integer id) throws PersistenceException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Tip buscarPorId(Integer id) throws PersistenceException {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}