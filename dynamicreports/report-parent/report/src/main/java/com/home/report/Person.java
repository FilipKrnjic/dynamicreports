/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.home.report;

/**
 *
 * @author Filip
 */
public class Person {
    private String zuname;
    private String grp;
    private int [] zeit;
    private static int n = 0;
    
    public Person (String z, String g) {
        zuname = z;
        grp = g;
        zeit = new int [] {3+n,2+n,5+n,7+n};
        n++;
    }
    
    /**
     * @return the zuname
     */
    public String getZuname() {
        return zuname;
    }

    /**
     * @param zuname the zuname to set
     */
    public void setZuname(String zuname) {
        this.zuname = zuname;
    }

    /**
     * @return the grp
     */
    public String getGrp() {
        return grp;
    }

    /**
     * @param grp the grp to set
     */
    public void setGrp(String grp) {
        this.grp = grp;
    }

    /**
     * @return the zeit
     */
    public int getZeit(int x) {
        return zeit[x];
    }

    /**
     * @param zeit the zeit to set
     */
    public void setZeit(int[] zeit) {
        this.zeit = zeit;
    }
   
}
