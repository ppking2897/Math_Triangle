package com.example.biancaen.math_triangle;

import java.util.ArrayList;

class InitialData {

    private ArrayList<Double> lines = new ArrayList<>();
    private ArrayList<Double> angle30 = new ArrayList<>();
    private ArrayList<Double> angle45 = new ArrayList<>();
    private ArrayList<Double> angle60 = new ArrayList<>();
    private ArrayList<Double> angle120 = new ArrayList<>();
    private ArrayList<Double> angle135 = new ArrayList<>();
    private ArrayList<Double> angle150 = new ArrayList<>();
    private ArrayList<ArrayList<Double>> angles = new ArrayList<>();

    void setAngles(ArrayList<ArrayList<Double>> angles) {
        this.angles = angles;

        setAngle30(angle30);
        setAngle45(angle45);
        setAngle60(angle60);
        setAngle120(angle120);
        setAngle135(angle135);
        setAngle150(angle150);

        angles.add(angle30);
        angles.add(angle45);
        angles.add(angle60);
        angles.add(angle120);
        angles.add(angle135);
        angles.add(angle150);
    }

    private void setAngle30(ArrayList<Double> angle30) {
        this.angle30 = angle30;
        angle30.add(30.0);
        angle30.add(60.0);
        angle30.add(90.0);
        angle30.add(2.0);
        angle30.add(1.732);
        angle30.add(1.0);
    }

    private void setAngle45(ArrayList<Double> angle45) {
        this.angle45 = angle45;
        angle45.add(45.0);
        angle45.add(90.0);
        angle45.add(45.0);
        angle45.add(1.0);
        angle45.add(1.414);
        angle45.add(1.0);
    }

    private void setAngle60(ArrayList<Double> angle60) {
        this.angle60 = angle60;
        angle60.add(60.0);
        angle60.add(30.0);
        angle60.add(90.0);
        angle60.add(2.0);
        angle60.add(1.0);
        angle60.add(1.732);
    }

    private void setAngle120(ArrayList<Double> angle120) {
        this.angle120 = angle120;
        angle120.add(120.0);
        angle120.add(30.0);
        angle120.add(30.0);
        angle120.add(1.5);
        angle120.add(1.5);
        angle120.add(2.598);
    }

    private void setAngle135(ArrayList<Double> angle135) {
        this.angle135 = angle135;
        angle135.add(135.0);
        angle135.add(22.5);
        angle135.add(22.5);
        angle135.add(1.5);
        angle135.add(1.5);
        angle135.add(2.598);
    }

    private void setAngle150(ArrayList<Double> angle150) {
        this.angle150 = angle150;
        angle150.add(150.0);
        angle150.add(15.0);
        angle150.add(15.0);
        angle150.add(1.5);
        angle150.add(1.5);
        angle150.add(2.598);
    }

    public void setLines(ArrayList<Double> lines) {
        this.lines = lines;
        lines.add(1.0);
        lines.add(2.0);
        lines.add(3.0);
        lines.add(4.0);
        lines.add(5.0);
        lines.add(6.0);
        lines.add(7.0);
        lines.add(8.0);
        lines.add(9.0);
        lines.add(10.0);
    }
}
