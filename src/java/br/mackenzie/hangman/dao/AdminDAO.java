package br.mackenzie.hangman.dao;

import br.mackenzie.hangman.exception.PersistenceException;
import br.mackenzie.hangman.model.Admin;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class AdminDAO implements GenericDAO<Admin> {

    @Override
    public void inserir(Admin obj) throws PersistenceException {
        Connection connection = null;
        try {
            connection = ConnectionHangman.getInstance().getConnection();
        } catch (ClassNotFoundException | SQLException ex) {
            
        }
    }

    @Override
    public void atualizar(Admin obj) throws PersistenceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deletar(Integer id) throws PersistenceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Admin> listarTodos() throws PersistenceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Admin buscarPorId(Integer id) throws PersistenceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
} 