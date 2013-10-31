package br.mackenzie.hangman.model;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 31281354
 */
public class Word {
    private String realWord;
    private Float errorFrequency; //  = GameOvers/Sessions*100

    public Word() {
    }

    public Word(String realWord, Float errorFrequency) {
        this.realWord = realWord;
        this.errorFrequency = errorFrequency;
    }

    public String getRealWord() {
        return realWord;
    }

    public void setRealWord(String realWord) {
        this.realWord = realWord;
    }

    public Float getErrorFrequency() {
        return errorFrequency;
    }

    public void setErrorFrequency(Float errorFrequency) {
        this.errorFrequency = errorFrequency;
    }
}
