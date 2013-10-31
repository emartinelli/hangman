/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.mackenzie.hangman.exception;

/**
 *
 * @author 31281354
 */
public class PersistenceException extends Exception{
     public PersistenceException(String msg, Exception exception) { 
        super(msg, exception); 
    } 
      
    public PersistenceException(String msg) { 
        super(msg); 
    } 
      
}
