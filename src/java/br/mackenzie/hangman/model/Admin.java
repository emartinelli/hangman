/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.mackenzie.hangman.model;

/**
 *
 * @author 31281354
 */
public class Admin extends Player{

    public Admin() {
    }

    public Admin(int codigo, String nickname, String password) {
        super(codigo,nickname, password);
        this.setAdmin(true);
    }
    
}
