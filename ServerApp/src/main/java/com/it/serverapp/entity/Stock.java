/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.it.serverapp.entity;

//import jakarta.persistence.Entity;

/**
 *
 * @author Aditya Pathak R
 */
//@Entity
public class Stock {

    private int stockid;
    private String company;
    private double closingprice;
    private String category;
    private double sensexClosingValue;

    public int getStockid() {
        return stockid;
    }

    public void setStockid(int stockid) {
        this.stockid = stockid;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public double getClosingprice() {
        return closingprice;
    }

    public void setClosingprice(double closingprice) {
        this.closingprice = closingprice;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getSensexClosingValue() {
        return sensexClosingValue;
    }

    public void setSensexClosingValue(double sensexClosingValue) {
        this.sensexClosingValue = sensexClosingValue;
    }

}
