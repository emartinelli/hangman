package br.mackenzie.hangman.DAO;


import br.mackenzie.hangman.model.Session;
import br.mackenzie.hangman.exception.PersistenceException;
import br.mackenzie.hangman.model.Admin;
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
            String sql = "INSERT INTO HANGMAN_DB.SESSION (TIME,SCORE,IDPLAYER,IDWORD) VALUES (?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, session.getTime());
            preparedStatement.setInt(2,session.getScore());
            preparedStatement.setInt(2,new PlayerDAO().retornaId(session.getPlayer()));
            preparedStatement.setInt(2,new WordDAO().retornaId(session.getWord()));
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
            String sql = "UPDATE HAGMAN_DB.SESSION WHERE IDSESSION = ?  ";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Session> listarTodos() throws PersistenceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Session buscarPorId(Integer id) throws PersistenceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Session buscarPorNome(String name) throws PersistenceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}