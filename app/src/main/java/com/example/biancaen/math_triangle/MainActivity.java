package com.example.biancaen.math_triangle;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    MyViewPager mainPager;
    private ArrayList<Fragment> views = new ArrayList<>();
    private InitialData initialData;
    private ArrayList<Double> lines = new ArrayList<>();
    private ArrayList<ArrayList<Double>> angles = new ArrayList<>();
    private ArrayList arrayList ;
    private double angleAB;
    private double angleAC;
    private double angleBC;

    private int randomA;
    private int randomB;
    private double lineA;
    private double lineB;
    private double lineC;

    private String ans1;
    private float ans2;
    private float denominator;

    DegRadCount degRadCount;
    Draw draw;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainPager = (MyViewPager) findViewById(R.id.mainPager);
        mainPager.setCurrentItem(0);

        initialData = new InitialData();
        initialData.setAngles(angles);
        initialData.setLines(lines);
        initialPager();
    }

    public void initialPager() {

        Q1 q1 = new Q1();
        Q2 q2 = new Q2();
        Q3 q3 = new Q3();
        views.add(q1);
        views.add(q2);
        views.add(q3);
        mainPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {

            private int position;
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
                }

                return super.getItemPosition(object);
            }
        });


        arrayList = angles.get((int)(Math.random()*6));

        angleAB =(Double) arrayList.get(0);
        angleAC =(Double) arrayList.get(1);
        angleBC =(Double) arrayList.get(2);

        lineA = (Double) arrayList.get(3);
        lineB = (Double) arrayList.get(4);
        lineC = (Double) arrayList.get(5);

        randomA = (int)(Math.random()*10);
        randomB = (int)(Math.random()*10);

    }
    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        draw = (Draw)findViewById(R.id.drawView);
        degRadCount = new DegRadCount(this, 400, draw.getWidth(), draw.getHeight(), lineA, lineB, lineC, angleAB, angleAC, angleBC);
        draw.setLine(lines.get(randomA) , lines.get(randomB) , 1);
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
    public String passAnsToQ2(){
        return ans1;
    }
    public ArrayList<Float> passAnsToQ3(){
        ArrayList<Float> arrayList = new ArrayList<>();
        arrayList.add(ans2);
        arrayList.add(denominator);
        return arrayList;
    }

}
