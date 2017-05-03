package com.example.biancaen.math_triangle;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;


public class Q4 extends Fragment {
    private String angleSin;
    Draw draw;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.v("ppking" , " Q4");
        View view = inflater.inflate(R.layout.finalpage , container , false);
        final MainActivity mainActivity = (MainActivity) getActivity();
        TextView title = (TextView)view.findViewById(R.id.finalTitle);
        TextView textView =(TextView) view.findViewById(R.id.finalText);
        Button button = (Button)view.findViewById(R.id.again);


        float angleAB =(float) mainActivity.angleAB_ANS();

        if (angleAB == 30 || angleAB == 150){
            angleSin = "1/2";
        }else if (angleAB == 45 || angleAB == 135){
            angleSin = "√2/2";
        }else if (angleAB == 60 || angleAB == 120){
            angleSin = "√3/2";
        }

        ArrayList arrayList = mainActivity.passAnsToQ3();

        float a = (float)arrayList.get(0);

        if (a%2==0 || a%2==1){
            int p  =(int)a;
            textView.setText(mainActivity.passAnsToQ2() + "\n" + p + "  *  " + angleSin + "\n" + mainActivity.passAnsToQ4());

        }else {
            textView.setText(mainActivity.passAnsToQ2() + "\n" + a + "  *  " + angleSin + "\n" + mainActivity.passAnsToQ4());
        }

        title.setText("邊長C : " + "\n" + " =>" + "\n" + " =>") ;

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainActivity.initialPager();
                mainActivity.drawData();
                mainActivity.mainPager.setCurrentItem(0);
                mainActivity.mainPager.getAdapter().notifyDataSetChanged();
            }
        });

        return view;
    }

}
