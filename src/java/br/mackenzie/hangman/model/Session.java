/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.mackenzie.hangman.model;

/**
 *
 * @author 31281354
 */
public class Session {
    private Integer id;
    private Integer time;
    private Integer score;
    private Player player;
    private Word word;

    public Session() {
    }
    public Session(Integer id, Integer time, Player player, Word word) {
        this.id = id;
        this.time = time;
        this.player = player;
        this.word = word;
    }
    
    public Session(Integer time, Player player, Word word) {
        this.time = time;
        this.player = player;
        this.word = word;
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTime() {
        return time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Word getWord() {
        return word;
    }

    public void setWord(Word word) {
        this.word = word;
    }
    
    
}
