package com.example.biancaen.math_triangle;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Q3 extends Fragment {
    private MainActivity mainActivity;
    private String angleSin = "";
    private String angleSin2 = "";
    String lastAns;
    String lastAns1;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.q3 , container , false);
        TextView textView =(TextView)view.findViewById(R.id.q3TextView);
        mainActivity = (MainActivity)getActivity();
        float angleAB =(float) mainActivity.angleAB_ANS();

        if (angleAB == 30 || angleAB == 150){
            angleSin = "1/2";
        }else if (angleAB == 45 || angleAB == 135){
            angleSin = "√2/2";
            angleSin2 = "√2";

        }else if (angleAB == 60 || angleAB == 120){
            angleSin = "√3/2";
            angleSin2 = "√3";
        }

        ArrayList arrayList =mainActivity.passAnsToQ3();

        Button buttonA = (Button)view.findViewById(R.id.a_Q3);
        Button buttonB = (Button)view.findViewById(R.id.b_Q3);
        Button buttonC = (Button)view.findViewById(R.id.c_Q3);
        Button buttonD = (Button)view.findViewById(R.id.d_Q3);

        float a = (float)arrayList.get(0);
        float b = (float)arrayList.get(1);

        textView.setText( "請問 " + a + "  *  " + angleSin + " = ?");


        ArrayList<String> question = new ArrayList<>();

        if (angleAB == 30 || angleAB == 150){
            question.add( (a + b)  + "");
            question.add( (a - b)  + "");
            question.add( (a * b)  + "" );
            question.add( (a / b)  + "");
        }else {
            question.add( a + b + angleSin2 + "");
            question.add( Math.abs((a - b)) + angleSin2 + "");
            question.add( a * b + angleSin2 + "" );
            question.add( a / b + angleSin2 + "");
        }

        lastAns = a / b + angleSin2 + "";
        lastAns1 = (a / b)  + "";

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
            if (button.getText().toString().contains(lastAns)){
                mainActivity.passAns3ToMain0(lastAns);

                mainActivity.mainPager.setCurrentItem(mainActivity.mainPager.getCurrentItem()+1);
                mainActivity.mainPager.getAdapter().notifyDataSetChanged();
            }else if (button.getText().toString().contains(lastAns1)){
                mainActivity.passAns3ToMain0(lastAns1);

                mainActivity.mainPager.setCurrentItem(mainActivity.mainPager.getCurrentItem()+1);
                mainActivity.mainPager.getAdapter().notifyDataSetChanged();
            }else {
                Toast.makeText(getContext(),"答案似乎是錯的",Toast.LENGTH_SHORT).show();
            }
        }
    }
}
