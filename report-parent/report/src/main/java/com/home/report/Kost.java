/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.home.report;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Filip
 */
class Kost {
    
    private String kost;
    private Date dates;
    private int kID;
    
    private List<String> arbeiter = new ArrayList();
    private List<Integer> std = new ArrayList();
    
    private List<String> gerat = new ArrayList();
    private List<Integer> stzs = new ArrayList();
    
    private List<String> mat = new ArrayList();
    private List<Integer> stks = new ArrayList();
    
    private List<String> fracht = new ArrayList();
    private List<Integer> days = new ArrayList();

    private static int count = 0;
    
    public Kost () {
        
    }
    
    public Kost(String kstStr, String str) {
        kID = count + 198;
        kost = "Kostenstelle_" + kstStr;
        dates = new Date();
        
        arbeiter.add("Filip_" + str);
        arbeiter.add("Thomas_" + str);
        arbeiter.add("Robert_" + str);
        
        std.add(5);
        std.add(6);
        std.add(9);
        
        gerat.add("Bagger_" + str);
        gerat.add("Stapler_" + str);
        stzs.add(3);
        stzs.add(8);
        
        mat.add("Wasser:" + str);
        stks.add(2);
   
        fracht.add("LKW_Walter:" + str);
        days.add(23);
        
        count++;
    }
    
    /**
     * @return the kost
     */
    public String getKost() {
        return kost;
    }

    /**
     * @param kost the kost to set
     */
    public void setKost(String kost) {
        this.kost = kost;
    }

    /**
     * @return the dates
     */
    public Date getDates() {
        return dates;
    }

    /**
     * @param dates the dates to set
     */
    public void setDates(Date dates) {
        this.dates = dates;
    }

    /**
     * @return the arbeiter
     */
    public List<String> getArbeiter() {
        return arbeiter;
    }

    /**
     * @param arbeiter the arbeiter to set
     */
    public void setArbeiter(List<String> arbeiter) {
        this.arbeiter = arbeiter;
    }

    /**
     * @return the std
     */
    public List<Integer> getStd() {
        return std;
    }

    /**
     * @param std the std to set
     */
    public void setStd(List<Integer> std) {
        this.std = std;
    }

    /**
     * @return the gerat
     */
    public List<String> getGerat() {
        return gerat;
    }

    /**
     * @param gerat the gerat to set
     */
    public void setGerat(List<String> gerat) {
        this.gerat = gerat;
    }

    /**
     * @return the stzs
     */
    public List<Integer> getStzs() {
        return stzs;
    }

    /**
     * @param stzs the stzs to set
     */
    public void setStzs(List<Integer> stzs) {
        this.stzs = stzs;
    }

    /**
     * @return the mat
     */
    public List<String> getMat() {
        return mat;
    }

    /**
     * @param mat the mat to set
     */
    public void setMat(List<String> mat) {
        this.mat = mat;
    }

    /**
     * @return the stks
     */
    public List<Integer> getStks() {
        return stks;
    }

    /**
     * @param stks the stks to set
     */
    public void setStks(List<Integer> stks) {
        this.stks = stks;
    }

    /**
     * @return the fracht
     */
    public List<String> getFracht() {
        return fracht;
    }

    /**
     * @param fracht the fracht to set
     */
    public void setFracht(List<String> fracht) {
        this.fracht = fracht;
    }

    /**
     * @return the days
     */
    public List<Integer> getDays() {
        return days;
    }

    /**
     * @param days the days to set
     */
    public void setDays(List<Integer> days) {
        this.days = days;
    }

    /**
     * @return the kID
     */
    public int getkID() {
        return kID;
    }

    /**
     * @param kID the kID to set
     */
    public void setkID(int kID) {
        this.kID = kID;
    }
}
