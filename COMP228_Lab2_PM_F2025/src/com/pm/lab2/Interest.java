package com.pm.lab2;

import java.math.BigDecimal;

public class Interest {

    private BigDecimal principal;
    private BigDecimal rate;
    private BigDecimal time;

    public Interest(double principal, double rate, double time) {

        if (principal <= 0 || rate < 0 || time <= 0) throw new IllegalArgumentException("Values must not be negative or zero");
        if (!String.valueOf(principal).contains(".") || !String.valueOf(rate).contains(".")) throw new IllegalArgumentException("Principal and Rate must be decimal values");

        this.principal = BigDecimal.valueOf(principal);
        this.rate = BigDecimal.valueOf(rate);
        this.time = BigDecimal.valueOf(time);
    }

    public Interest(BigDecimal principal, BigDecimal rate, BigDecimal time) {

        if (principal.compareTo(BigDecimal.ZERO) <= 0 || rate.compareTo(BigDecimal.ZERO) < 0 || time.compareTo(BigDecimal.ZERO) <= 0) throw new IllegalArgumentException("Values must not be negative or zero");
        if (principal.scale() == 0 || rate.scale() == 0) throw new IllegalArgumentException("Principal and Rate must be decimal values");

        this.principal = principal;
        this.rate = rate;
        this.time = time;
    }
    
    public Interest(Double principal, BigDecimal rate, Double time) {

        if (principal <= 0 || rate.compareTo(BigDecimal.ZERO) < 0 || time <= 0) throw new IllegalArgumentException("Values must not be negative or zero");
        if (!String.valueOf(principal).contains(".") || rate.scale() == 0) throw new IllegalArgumentException("Principal and Rate must be decimal values");

        this.principal = BigDecimal.valueOf(principal);
        this.rate = rate;
        this.time = BigDecimal.valueOf(time);
    }

    public double SimpleInterest() {
        double interest = principal.doubleValue() * rate.doubleValue() * time.doubleValue() / 100;
        return Math.round(interest * 100.0) / 100.0;
    }

    public double CompoundInterest() {
        double interest = principal.doubleValue() * (Math.pow((1 + rate.doubleValue() / 100), time.doubleValue()) - 1);
        return Math.round(interest * 100.0) / 100.0;
    }
    
    public int GetTime() {
        return time.intValue();
    }
}
