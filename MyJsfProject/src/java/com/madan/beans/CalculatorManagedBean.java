/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.madan.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Madan
 */
@ManagedBean
@RequestScoped
public class CalculatorManagedBean {

    /**
     * Creates a new instance of CalculatorManagedBean
     */
    private double number1=0;

    private double number2=0;

    private double result=0;

    public CalculatorManagedBean() {
    }

    /**
     * @return the number1
     */
    public double getNumber1() {
        return number1;
    }

    /**
     * @param number1 the number1 to set
     */
    public void setNumber1(double number1) {
        this.number1 = number1;
    }

    /**
     * @return the number2
     */
    public double getNumber2() {
        return number2;
    }

    /**
     * @param number2 the number2 to set
     */
    public void setNumber2(double number2) {
        this.number2 = number2;
    }

    /**
     * @return the result
     */
    public double getResult() {
        return result;
    }

    /**
     * @param result the result to set
     */
    public void setResult(double result) {
        this.result = result;
    }

    public void add() {
        result = number1 + number2;
    }

    public void mul() {
        result = number1 * number2;
    }

    public void div1() {
        result = number1 / number2;
    }

    public void diff() {
        result = number1 - number2;
    }

}
