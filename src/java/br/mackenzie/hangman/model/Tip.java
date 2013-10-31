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

    public Tip() {
    }

    public Tip(String information) {
        this.information = information;
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }
}
