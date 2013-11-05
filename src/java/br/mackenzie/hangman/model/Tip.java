/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.mackenzie.hangman.model;

/**
 *
 * @author 31281354
 */
public class Tip {
    private String information;
    private Word word;

    public Tip() {
    }

    public Tip(String information,Word word) {
        this.information = information;
        this.word = word;
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    public Word getWord() {
        return word;
    }

    public void setWord(Word word) {
        this.word = word;
    }
    
    
    
}
