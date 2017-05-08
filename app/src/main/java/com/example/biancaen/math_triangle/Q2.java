package com.example.biancaen.math_triangle;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;


public class Q2 extends Fragment{

    MainActivity mainActivity;
    String angleSin;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.q2 , container , false);
        TextView textView =(TextView) view.findViewById(R.id.q2TextView);

        mainActivity =(MainActivity) getActivity();

        textView.setText("請問" + mainActivity.passAnsToQ2()+" = ?");

        float lineA = (float)mainActivity.lineA_ANS();
        float lineB = (float)mainActivity.lineB_ANS();
        float angleAB =(float) mainActivity.angleAB_ANS();

        if (angleAB == 30 || angleAB == 150){
            angleSin = "1/2";
        }else if (angleAB == 45 || angleAB == 135){
            angleSin = "√2/2";
        }else if (angleAB == 60 || angleAB == 120){
            angleSin = "√3/2";
        }
        float i = (lineA * lineB)/2;
        mainActivity.passAns2ToMain(i , 2);

        Button buttonA = (Button)view.findViewById(R.id.a_Q2);
        Button buttonB = (Button)view.findViewById(R.id.b_Q2);
        Button buttonC = (Button)view.findViewById(R.id.c_Q2);
        Button buttonD = (Button)view.findViewById(R.id.d_Q2);

        ArrayList<String> question = new ArrayList<>();

        if (i%2==0 || i%2==1){
            int p =(int)i;
            question.add( p + "");
            question.add( p + " X 1/2 ");
            question.add( p + " X √2/2 ");
            question.add( p + " X √3/2 ");
        }else {
            question.add( i + "");
            question.add( i + " X 1/2 ");
            question.add( i + " X √2/2 ");
            question.add( i + " X √3/2 ");
        }




        int number = (int) (Math.random() * question.size());
        buttonA.setText("A. "+question.get(number));
        question.remove(number);

        number = (int) (Math.random() * question.size());
        buttonB.setText("B. "+question.get(number));
        question.remove(number);

        number = (int) (Math.random() * question.size());
        buttonC.setText("C. "+question.get(number));
        question.remove(number);

        number = (int) (Math.random() * question.size());
        buttonD.setText("D. "+question.get(number));

        buttonA.setOnClickListener(new MyClickListener());
        buttonB.setOnClickListener(new MyClickListener());
        buttonC.setOnClickListener(new MyClickListener());
        buttonD.setOnClickListener(new MyClickListener());

        return view;
    }
    private class MyClickListener implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            Button button = (Button)v;
            if (button.getText().toString().contains(angleSin)){
                boolean ansRightorWrong = true;
                mainActivity.passAnsRightToMain(ansRightorWrong);
                mainActivity.mainPager.setCurrentItem(mainActivity.mainPager.getCurrentItem()+1);
                mainActivity.mainPager.getAdapter().notifyDataSetChanged();
            }else{
                boolean ansRightorWrong = false;
                mainActivity.passAnsRightToMain(ansRightorWrong);
                mainActivity.mainPager.setCurrentItem(3);
                mainActivity.mainPager.getAdapter().notifyDataSetChanged();
            }
        }
    }
}
