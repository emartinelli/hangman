/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.mackenzie.hangman.model;

/**
 *
 * @author 31281354
 */
public class Player {
    private String nickname;
    private String password;
    private boolean admin;

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }
    
    public Player() {
    }

    public Player(String nickname, String password) {
        this.nickname = nickname;
        this.password = password;
        this.admin = false;
    }
    
    public Player (int codigo,String nickname, String password){
        this.nickname = nickname;
        this.password = password;
        this.admin = false;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
}
