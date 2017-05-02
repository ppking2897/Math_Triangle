package com.example.biancaen.math_triangle;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.ViewGroup;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    MyViewPager mainPager;
    private ArrayList<Fragment> views = new ArrayList<>();
    private ArrayList<Double> lines = new ArrayList<>();
    private ArrayList<ArrayList<Double>> angles = new ArrayList<>();
    private double angleAB;
    private double angleAC;
    private double angleBC;

    private int randomA;
    private int randomB;
    private int randomAngles;
    private double lineA;
    private double lineB;
    private double lineC;

    private String ans1;
    private float ans2;
    private String ans3;
    private float denominator;

    private float viewWidth;
    private float viewHeight;

    DegRadCount degRadCount;
    Draw draw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainPager = (MyViewPager) findViewById(R.id.mainPager);

        InitialData initialData = new InitialData();
        initialData.setAngles(angles);
        initialData.setLines(lines);
        Q1 q1 = new Q1();
        Q2 q2 = new Q2();
        Q3 q3 = new Q3();
        Q4 q4 = new Q4();
        views.add(q1);
        views.add(q2);
        views.add(q3);
        views.add(q4);
        mainPager.setAdapter(new MyFragmentPagerAdapter(getSupportFragmentManager()));
        mainPager.setCurrentItem(0);
        initialPager();
    }

    public void initialPager() {

        randomA = (int)(Math.random()*10);
        randomB = (int)(Math.random()*10);
        randomAngles = ((int) (Math.random() * 6));

        ArrayList arrayList = angles.get(randomAngles);

        angleAB =(Double) arrayList.get(0);
        angleAC =(Double) arrayList.get(1);
        angleBC =(Double) arrayList.get(2);

        lineA = (Double) arrayList.get(3);
        lineB = (Double) arrayList.get(4);
        lineC = (Double) arrayList.get(5);
    }

    @Override
    public void finish() {
        degRadCount = null;
        super.finish();
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        Log.v("ppking" , "onWindowFocusChanged !!");
        draw = (Draw)findViewById(R.id.drawView);
        viewHeight = draw.getHeight();
        viewWidth = draw.getWidth();
        drawData();
    }

    public double lineA_ANS(){
        lines.get(randomA);
        return lines.get(randomA);
    }
    public double lineB_ANS(){
        return lines.get(randomB);
    }
    public double angleAB_ANS(){
        return angleAB;
    }
    public void passAns1ToMain(String ans1){
        this.ans1 = ans1;
    }
    public void passAns2ToMain(float ans2 , float denominator){
        this.ans2 = ans2;
        this.denominator = denominator;
    }
    public void passAns3ToMain0(String ans3){
        this.ans3 = ans3;
    }
    public String passAnsToQ2(){
        return ans1;
    }
    public ArrayList<Float> passAnsToQ3(){
        ArrayList<Float> arrayList = new ArrayList<>();
        arrayList.add(ans2);
        arrayList.add(denominator);
        return arrayList;
    }
    public String passAnsToQ4(){
        return ans3;
    }

    public void drawData(){
        degRadCount = new DegRadCount(this, 300, viewWidth, viewHeight, lineA, lineB, lineC, angleAB, angleAC, angleBC);
        draw.setLine(lines.get(randomA) , lines.get(randomB) , 1);
    }

    private class MyFragmentPagerAdapter extends FragmentPagerAdapter {
        private int position;

        MyFragmentPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            Log.v("ppking" , "position : " + position);
            this.position = position;
            return views.get(position);
        }

        @Override
        public int getCount() {
            return views.size();
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            return super.instantiateItem(container, position);
        }

        @Override
        public int getItemPosition(Object object) {
            if (position == 2){
                //setTag setTitle
                return POSITION_NONE;
            }else if (position == 3){
                return POSITION_NONE;
            }
            return super.getItemPosition(object);
        }
    }

}
