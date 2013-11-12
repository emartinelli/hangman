package br.mackenzie.hangman.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 31281354
 */
public class Word {
    private static int gameovers;
    private static int sessions;
    private String realWord;
    private Float errorFrequency; //  = GameOvers/Sessions*100
    List<Tip> tips = new ArrayList<Tip>();

    public List<Tip> getTips() {
        return tips;
    }

    public void setTips(List<Tip> tips) {
        this.tips = tips;
    }
    
    public Tip getRandomTip() {
        Random rand = new Random();
        return tips.get(rand.nextInt(tips.size()));
    }
    
    public void setTip(Tip tip) {
        tips.add(tip);
    }

    public static int getGameovers() {
        return gameovers;
    }

    public static void setGameovers(int gameovers) {
        Word.gameovers = gameovers;
    }

    public static int getSessions() {
        return sessions;
    }

    public static void setSessions(int sessions) {
        Word.sessions = sessions;
    }
    
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
