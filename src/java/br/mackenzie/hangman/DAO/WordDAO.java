package br.mackenzie.hangman.DAO;

import br.mackenzie.hangman.model.Word;
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

public class WordDAO implements GenericDAO<Word>{

    @Override
    public void inserir(Word word) throws PersistenceException {
        Connection connection = null;
        try {
            connection = ConnectionHangman.getInstance().getConnection();
            String sql = "INSERT INTO HANGMAN_DB.WORD (REALWORD) VALUES (?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, word.getRealWord());
            preparedStatement.executeUpdate();
            connection.close();

        }catch (ClassNotFoundException ex) {
            Logger.getLogger(br.mackenzie.hangman.DAO.WordDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new PersistenceException("Inserção não realizada!");
        }
        catch ( SQLException ex) {
            Logger.getLogger(br.mackenzie.hangman.DAO.WordDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new PersistenceException("Inserção não realizada!");
        }
    }

    @Override
    public void atualizar(Word word) throws PersistenceException {
        Connection connection = null;
        try {
            connection = ConnectionHangman.getInstance().getConnection();
            String sql = "UPDATE HAGMAN_DB.WORD SET ERRORFREQUENCY = ? WHERE WORD = ?  ";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(2, word.getRealWord());
            preparedStatement.setFloat(1, word.getErrorFrequency());
            preparedStatement.executeUpdate();
            connection.close();

        }catch (ClassNotFoundException ex) {
            Logger.getLogger(br.mackenzie.hangman.DAO.WordDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new PersistenceException("Atualização não realizada!");
        }
        catch ( SQLException ex) {
            Logger.getLogger(br.mackenzie.hangman.DAO.WordDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new PersistenceException("Atualização não realizada!");
        }
    }

    public void deletar(String name) throws PersistenceException {
        Connection connection = null;
        try {
            connection = ConnectionHangman.getInstance().getConnection();
            String sql = "DELETE FROM HANGMAN_DB.WORD WHERE WORD = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, name);
            preparedStatement.executeUpdate();
            connection.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(br.mackenzie.hangman.DAO.WordDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new PersistenceException("Não foi possível excluir o registro!");
        }
        catch ( SQLException ex) {
            Logger.getLogger(br.mackenzie.hangman.DAO.WordDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new PersistenceException("Não foi possível excluir o registro!");
        }
    }

    @Override
    public List<Word> listarTodos() throws PersistenceException {
        Connection connection = null;
        List<Word> words = new ArrayList<Word>();
        try {
            connection = ConnectionHangman.getInstance().getConnection();
            String sql = "SELECT * FROM HANGMAN_DB.WORD";
            Statement select = connection.createStatement();
            ResultSet result = select.executeQuery(sql);
            
            while (result.next()){
                words.add(new Word(result.getString("REALWORD")));
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(br.mackenzie.hangman.DAO.WordDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new PersistenceException("Não foi possível listar todos!");
        }
        catch ( SQLException ex) {
            Logger.getLogger(br.mackenzie.hangman.DAO.WordDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new PersistenceException("Não foi possível listar todos!");
        }
        return words;
    }

    @Override
    public Word buscarPorNome(String name) throws PersistenceException {
        Connection connection = null;
        Word word = null;
        try {
            connection = ConnectionHangman.getInstance().getConnection();
            
            String sql = "SELECT * FROM HANGMAN_DB.WORD WHERE REALWORD = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, name);
            ResultSet result = preparedStatement.executeQuery();
            while (result.next()){
                word = new Word(result.getString("REALWORD"));
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(br.mackenzie.hangman.DAO.WordDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new PersistenceException("Não foi possível burcar!");
        }
        catch ( SQLException ex) {
            Logger.getLogger(br.mackenzie.hangman.DAO.WordDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new PersistenceException("Não foi possível burcar!");
        }
        return word;
    }
    
    public int retornaId (Word word) throws PersistenceException{
        Connection connection = null;
        int id = 0;
        try {
            connection = ConnectionHangman.getInstance().getConnection();
            
            String sql = "SELECT * FROM HANGMAN_DB.WORD WHERE REALWORD = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, word.getRealWord());
            ResultSet result = preparedStatement.executeQuery();
            while(result.next())
                id = result.getInt("IDWORD");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(br.mackenzie.hangman.DAO.WordDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new PersistenceException("Não foi possível burcar!");
        }
        catch ( SQLException ex) {
            Logger.getLogger(br.mackenzie.hangman.DAO.WordDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new PersistenceException("Não foi possível burcar!");
        }
        return id;
    }

    @Override
    public void deletar(Integer id) throws PersistenceException {
        throw new UnsupportedOperationException("Not supported yet.");
    }
	@Override
	public Word buscarPorId(Integer id) throws PersistenceException{
		Connection connection = null;
		Word word = null;
		try{
			connection = ConnectionHangman.getInstance().getConnection();
			
			String sql = "SELECT * FROM HANGMAN_DB.WORD WHERE IDWORD = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			ResultSet result = preparedStatement.executeQuery();
            while (result.next()) {
				word = new Word(result.getString("WORD"));
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(br.mackenzie.hangman.DAO.WordDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new PersistenceException("Não foi possível burcar!");
        }
        catch ( SQLException ex) {
            Logger.getLogger(br.mackenzie.hangman.DAO.WordDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new PersistenceException("Não foi possível burcar!");
        }
        return word;
	}
    
}