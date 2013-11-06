package br.mackenzie.hangman.DAO;

import br.mackenzie.hangman.model.Player;
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

public class PlayerDAO implements GenericDAO<Player>{

    @Override
    public void inserir(Player player) throws PersistenceException {
        Connection connection = null;
        try {
            connection = ConnectionHangman.getInstance().getConnection();
            String sql = "INSERT INTO HANGMAN_DB.PLAYER (NICKNAME,PASSWORD,ISADMIN) VALUES (?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, player.getNickname());
            preparedStatement.setString(2, player.getPassword());
            preparedStatement.setInt(3, player.isAdmin()? 1:0);
            preparedStatement.executeUpdate();
            connection.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(br.mackenzie.hangman.DAO.PlayerDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new PersistenceException("Inserção não realizada!");
        }
        catch ( SQLException ex) {
            Logger.getLogger(br.mackenzie.hangman.DAO.PlayerDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new PersistenceException("Inserção não realizada!");
        }
    }

    @Override
    public void atualizar(Player player) throws PersistenceException {
        Connection connection = null;
        try {
            connection = ConnectionHangman.getInstance().getConnection();
            String sql = "UPDATE HANGMAN_DB.PLAYER SET PASSWORD = ? WHERE NICKNAME = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(3, player.getNickname());
            preparedStatement.setString(1, player.getPassword());
            preparedStatement.setInt(2, player instanceof Admin ? 1:0);
            //preparedStatement.setInt(3, player.getCodigo());
            preparedStatement.executeUpdate();
            connection.close();

        }catch (ClassNotFoundException ex) {
            Logger.getLogger(br.mackenzie.hangman.DAO.PlayerDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new PersistenceException("Atualização não realizada!");
        }
        catch ( SQLException ex) {
            Logger.getLogger(br.mackenzie.hangman.DAO.PlayerDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new PersistenceException("Atualização não realizada!");
        }
          
    }

    
    public void deletar(String name) throws PersistenceException {
        Connection connection = null;
        try {
            connection = ConnectionHangman.getInstance().getConnection();
            String sql = "DELETE FROM HANGMAN_DB.PLAYER WHERE NICKNAME = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, name);
            preparedStatement.executeUpdate();
            connection.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(br.mackenzie.hangman.DAO.PlayerDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new PersistenceException("Não foi possível excluir o registro!");
        }
        catch ( SQLException ex) {
            Logger.getLogger(br.mackenzie.hangman.DAO.PlayerDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new PersistenceException("Não foi possível excluir o registro!");
        }
    }

    @Override
    public List<Player> listarTodos() throws PersistenceException {
        Connection connection = null;
        List<Player> players = new ArrayList<Player>();
        try {
            connection = ConnectionHangman.getInstance().getConnection();
            String sql = "SELECT * FROM HANGMAN_DB.PLAYER";
            Statement select = connection.createStatement();
            ResultSet result = select.executeQuery(sql);
            
            while (result.next()){
                players.add(new Player(result.getString("NICKNAME"), result.getString("PASSWORD")));
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(br.mackenzie.hangman.DAO.PlayerDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new PersistenceException("Não foi possível listar todos!");
        }
        catch ( SQLException ex) {
            Logger.getLogger(br.mackenzie.hangman.DAO.PlayerDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new PersistenceException("Não foi possível listar todos!");
        }
        return players;
    }

    @Override
    public Player buscarPorNome(String name) throws PersistenceException {
        Connection connection = null;
        Player player = null;
        try {
            connection = ConnectionHangman.getInstance().getConnection();
            String sql = "SELECT * FROM HANGMAN_DB.PLAYER WHERE NICKNAME = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, name);
            ResultSet result = preparedStatement.executeQuery();
            while(result.next()){
                player = new Player(result.getString("NICKNAME"),result.getString("PASSWORD"));
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(br.mackenzie.hangman.DAO.PlayerDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new PersistenceException("Não foi possível buscar!");
        }
        catch ( SQLException ex) {
            Logger.getLogger(br.mackenzie.hangman.DAO.PlayerDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new PersistenceException("Não foi possível buscar!");
        }
        return player;
    }

    @Override
    public void deletar(Integer id) throws PersistenceException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Player buscarPorId(Integer id) throws PersistenceException {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}