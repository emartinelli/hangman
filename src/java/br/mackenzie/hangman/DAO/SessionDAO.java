package br.mackenzie.hangman.DAO;


import br.mackenzie.hangman.model.Session;
import br.mackenzie.hangman.exception.PersistenceException;
import br.mackenzie.hangman.model.Admin;
import br.mackenzie.hangman.model.Player;
import br.mackenzie.hangman.model.Word;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SessionDAO implements GenericDAO<Session>{

    @Override
    public void inserir(Session session) throws PersistenceException {
        Connection connection = null;
        try {
            connection = ConnectionHangman.getInstance().getConnection();
            String sql = "INSERT INTO HANGMAN_DB.SESSION (TIMESESSION,SCORE,IDPLAYER,IDWORD) VALUES (?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, session.getTime());
            preparedStatement.setInt(2,session.getScore());
            preparedStatement.setInt(3,new PlayerDAO().retornaId(session.getPlayer()));
            preparedStatement.setInt(4,new WordDAO().retornaId(session.getWord()));
            preparedStatement.executeUpdate();
            connection.close();

        }catch (ClassNotFoundException ex) {
            Logger.getLogger(br.mackenzie.hangman.DAO.SessionDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new PersistenceException("Inserção não realizada!");
        }
        catch ( SQLException ex) {
            Logger.getLogger(br.mackenzie.hangman.DAO.SessionDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new PersistenceException("Inserção não realizada!");
        }
    }

    @Override
    public void atualizar(Session session) throws PersistenceException {
        Connection connection = null;
        try {
            connection = ConnectionHangman.getInstance().getConnection();
            String sql = "UPDATE HANGMAN_DB.SESSION SET TIMESESSION = ?, SCORE = ?, IDPLAYER = ?, IDWORD = ? WHERE IDSESSION = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, session.getTime());
            preparedStatement.setInt(2, session.getScore());
            preparedStatement.setInt(3, new PlayerDAO().retornaId(session.getPlayer()));
            preparedStatement.setInt(4, new WordDAO().retornaId(session.getWord()));
            preparedStatement.setInt(5, session.getId());
            preparedStatement.executeUpdate();
            connection.close();

        }catch (ClassNotFoundException ex) {
            Logger.getLogger(br.mackenzie.hangman.DAO.SessionDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new PersistenceException("Atualização não realizada!");
        }
        catch ( SQLException ex) {
            Logger.getLogger(br.mackenzie.hangman.DAO.SessionDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new PersistenceException("Atualização não realizada!");
        }
    }

    @Override
    public void deletar(Integer id) throws PersistenceException {
        Connection connection = null;
        try {
            connection = ConnectionHangman.getInstance().getConnection();
            String sql = "DELETE FROM HANGMAN_DB.SESSION WHERE IDSESSION = ?";
            PreparedStatement preparedStatement  = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            connection.close();
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(br.mackenzie.hangman.DAO.SessionDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new PersistenceException("Não foi possível excluir o registro!");
        }
        catch ( SQLException ex) {
            Logger.getLogger(br.mackenzie.hangman.DAO.SessionDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new PersistenceException("Não foi possível excluir o registro!");
        }
    }

    @Override
    public List<Session> listarTodos() throws PersistenceException {
        Connection connection = null;
        List<Session> sessions = new ArrayList<Session>();
        try {
            connection = ConnectionHangman.getInstance().getConnection();
            String sql = "SELECT * FROM HANGMAN_DB.SESSION";
            Statement select = connection.createStatement();
            ResultSet result = select.executeQuery(sql);
            
            while(result.next()){
                sessions.add(new Session(result.getInt("IDSESSION"),result.getInt("TIMESESSION"),new PlayerDAO().buscarPorId(result.getInt("IDPLAYER")), new WordDAO().buscarPorId(result.getInt("IDWORD")),result.getInt("SCORE")));
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(br.mackenzie.hangman.DAO.SessionDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new PersistenceException("Não foi possível listar todos!");
        }
        catch ( SQLException ex) {
            Logger.getLogger(br.mackenzie.hangman.DAO.SessionDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new PersistenceException("Não foi possível listar todos!");
        }
        return sessions;
    }

    @Override
    public Session buscarPorId(Integer id) throws PersistenceException {
        Connection connection = null;
        Session session = null;
        try {
            connection = ConnectionHangman.getInstance().getConnection();
            String sql = "SELECT * FROM HANGMAN_DB.SESSION WHERE IDSESSION = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
			ResultSet result = preparedStatement.executeQuery();
            while (result.next()) {
                session = new Session(result.getInt("IDSESSION"),result.getInt("TIMESESSION"),new PlayerDAO().buscarPorId(result.getInt("IDPLAYER")), new WordDAO().buscarPorId(result.getInt("IDWORD")),result.getInt("SCORE"));
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(br.mackenzie.hangman.DAO.SessionDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new PersistenceException("Não foi possível listar todos!");
        }
        catch ( SQLException ex) {
            Logger.getLogger(br.mackenzie.hangman.DAO.SessionDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new PersistenceException("Não foi possível listar todos!");
        }
        return session;
    }

    @Override
    public Session buscarPorNome(String name) throws PersistenceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public Session buscarPorPlayer (Player player) throws PersistenceException{
        Connection connection = null;
        Session session = null;
        try {
            connection = ConnectionHangman.getInstance().getConnection();
            String sql = "SELECT HANGMAN_DB.SESSION.IDSESSION,HANGMAN_DB.SESSION.TIMESESSION, HANGMAN_DB.SESSION.IDWORD HANGMAN_DB.SESSION.IDPLAYER INNER JOIN HANGMAN_DB.PLAYER ON (?) = HANGMAN_DB.SESSION.SESSION.IDPLAYER";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, new PlayerDAO().retornaId(player));
            ResultSet result = preparedStatement.executeQuery();
            
            while(result.next()){
                session = new Session(result.getInt("IDSESSION"),result.getInt("TIMESESSION"),new PlayerDAO().buscarPorId(result.getInt("IDPLAYER")), new WordDAO().buscarPorId(result.getInt("IDWORD")),result.getInt("SCORE"));
            }
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(br.mackenzie.hangman.DAO.SessionDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new PersistenceException("Não foi possível listar todos!");
        }
        catch ( SQLException ex) {
            Logger.getLogger(br.mackenzie.hangman.DAO.SessionDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new PersistenceException("Não foi possível listar todos!");
        }
        return session;
    }
    
    public Session buscarPorWord (Word word) throws PersistenceException{
        Connection connection = null;
        Session session = null;
        try {
            connection = ConnectionHangman.getInstance().getConnection();
            String sql = "SELECT HANGMAN_DB.SESSION.IDSESSION,HANGMAN_DB.SESSION.TIMESESSION, HANGMAN_DB.SESSION.IDWORD HANGMAN_DB.SESSION.IDPLAYER INNER JOIN HANGMAN_DB.WORD ON (?) = HANGMAN_DB.SESSION.SESSION.IDWORD";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, new WordDAO().retornaId(word));
            ResultSet result = preparedStatement.executeQuery();
            
            while(result.next()){
                session = new Session(result.getInt("IDSESSION"),result.getInt("TIMESESSION"),new PlayerDAO().buscarPorId(result.getInt("IDPLAYER")), new WordDAO().buscarPorId(result.getInt("IDWORD")),result.getInt("SCORE"));
            }
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(br.mackenzie.hangman.DAO.SessionDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new PersistenceException("Não foi possível listar todos!");
        }
        catch ( SQLException ex) {
            Logger.getLogger(br.mackenzie.hangman.DAO.SessionDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new PersistenceException("Não foi possível listar todos!");
        }
        return session;
    }
    
}