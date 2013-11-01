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
            String sql = "INSERT INTO HAGMAN_DB.WORD (NOME,ERRORFREQUENCY) VALUES (?)(?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, word.getRealWord());
            preparedStatement.setFloat(2, word.getErrorFrequency());
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
            String sql = "UPDATE HAGMAN_DB.WORD SET (NOME,ERRORFREQUENCY) VALUES (?)(?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, word.getRealWord());
            preparedStatement.setFloat(2, word.getErrorFrequency());
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
    public void deletar(Integer id) throws PersistenceException {
        Connection connection = null;
        try {
            connection = ConnectionHangman.getInstance().getConnection();
            String sql = "DELETE FROM HANGMAN_DB.WORD WHERE IDWORD = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
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
                words.add(new Word(result.getString("WORD"), result.getFloat("ERRORFREQUENCY")));
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
    public Word buscarPorId(Integer id) throws PersistenceException {
        Connection connection = null;
        Word word = null;
        try {
            connection = ConnectionHangman.getInstance().getConnection();
            
            String sql = "SELECT * FROM HANGMAN_DB.WORD WHERE IDWORD = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet result = preparedStatement.executeQuery();
            while (result.next()){
                word = new Word(result.getString("WORD"), result.getFloat("ERRORFREQUENCY"));
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(br.mackenzie.hangman.DAO.WordDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new PersistenceException("Não foi possível listar todos!");
        }
        catch ( SQLException ex) {
            Logger.getLogger(br.mackenzie.hangman.DAO.WordDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new PersistenceException("Não foi possível listar todos!");
        }
        return word;
    }
    
}