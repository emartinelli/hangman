/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.mackenzie.hangman.dao;

import br.mackenzie.hangman.exception.PersistenceException; 
import java.util.List;

/**
 *
 * @author 31281354
 */
public interface GenericDAO<T> {
    void inserir(T obj) throws PersistenceException; 
    void atualizar(T obj) throws PersistenceException; 
    void deletar(Integer id) throws PersistenceException; 
    List<T> listarTodos() throws PersistenceException; 
    T buscarPorId(Integer id) throws PersistenceException; 
}
