package br.mackenzie.hangman.DAO;

import br.mackenzie.hangman.DAO.PlayerDAO;
import br.mackenzie.hangman.model.Admin;
import br.mackenzie.hangman.model.Player;
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

public class AdminDAO implements GenericDAO<Admin>{

    @Override
    public void inserir(Admin admin) throws PersistenceException {
        Connection connection = null;
        try {
            connection = ConnectionHangman.getInstance().getConnection();
            String sql = "INSERT INTO HANGMAN_DB.PLAYER (NICKNAME,PASSWORD,ISADMIN) VALUES (?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, admin.getNickname());
            preparedStatement.setString(2, admin.getPassword());
            preparedStatement.setInt(3, admin instanceof Admin ?1:0);
            preparedStatement.executeUpdate();
            connection.close();
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(br.mackenzie.hangman.DAO.AdminDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new PersistenceException("Inserção não realizada!");
        }
        catch ( SQLException ex) {
            Logger.getLogger(br.mackenzie.hangman.DAO.AdminDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new PersistenceException("Inserção não realizada!");
        }
    }

    @Override
    public void atualizar(Admin admin) throws PersistenceException {
        Connection connection = null;
        try {
            connection = ConnectionHangman.getInstance().getConnection();
            String sql = "UPDATE HANGMAN_DB.PLAYER WHERE NICKNAME = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, admin.getNickname());
            preparedStatement.executeUpdate();
            connection.close();
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(br.mackenzie.hangman.DAO.AdminDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new PersistenceException("Atualização não realizada!");
        }
        catch ( SQLException ex) {
            Logger.getLogger(br.mackenzie.hangman.DAO.AdminDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new PersistenceException("Atualização não realizada!");
        }
    }

    
    public void deletar(Admin admin) throws PersistenceException {
        Connection connection = null;
        try {
            connection = ConnectionHangman.getInstance().getConnection();
            String sql = "DELETE FROM HANGMAN_DB.PLAYER WHERE NICKNAME = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, admin.getNickname());
            preparedStatement.executeUpdate();
            connection.close();
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(br.mackenzie.hangman.DAO.AdminDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new PersistenceException("Não foi possível excluir o registro!");
        }
        catch ( SQLException ex) {
            Logger.getLogger(br.mackenzie.hangman.DAO.AdminDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new PersistenceException("Não foi possível excluir o registro!");
        }
        
    }

    @Override
    public List<Admin> listarTodos() throws PersistenceException {
        Connection connection = null;
        List<Admin> admins = new ArrayList<Admin>();
        try {
            connection = ConnectionHangman.getInstance().getConnection();
            String sql = "SELECT * FROM HANGMAN_DB.PLAYER WHERE ISADMIN = 1";
            Statement select = connection.createStatement();
            ResultSet result = select.executeQuery(sql);
            
            while(result.next()){
                admins.add(new Admin(result.getString("NICKNAME"), result.getString("PASSWORD")));
            }
        }catch (ClassNotFoundException ex) {
            Logger.getLogger(br.mackenzie.hangman.DAO.AdminDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new PersistenceException("Não foi possível listar todos!");
        }
        catch ( SQLException ex) {
            Logger.getLogger(br.mackenzie.hangman.DAO.AdminDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new PersistenceException("Não foi possível listar todos!");
        }
        return admins;
    }

    @Override
    public Admin buscarPorId(Integer id) throws PersistenceException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Admin buscarPorNome(String name) throws PersistenceException {
        Connection connection = null;
        Admin admin = null;
        try {
            connection = ConnectionHangman.getInstance().getConnection();
            String sql = "SELECT * FROM HANGMAN_DB.PLAYER WHERE NICKNAME = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, name);
            ResultSet result = preparedStatement.executeQuery();
            while(result.next()){
                admin = new Admin(result.getString("NICKNAME"),result.getString("PASSWORD"));
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(br.mackenzie.hangman.DAO.AdminDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new PersistenceException("Não foi possível buscar!");
        }
        catch ( SQLException ex) {
            Logger.getLogger(br.mackenzie.hangman.DAO.AdminDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new PersistenceException("Não foi possível buscar!");
        }
        return admin;
    }

    @Override
    public void deletar(Integer id) throws PersistenceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
       
    
}