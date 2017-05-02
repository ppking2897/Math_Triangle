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

public class Q4 extends Fragment {
    private MainActivity mainActivity;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.q4 , container , false);
        TextView textView =(TextView)view.findViewById(R.id.q4TextView);
        mainActivity = (MainActivity)getActivity();

        textView.setText("恭喜!!正確答案為:" + "\n" + mainActivity.passAnsToQ40() + "\n" + "請問是否還要再來一題?");

        Button buttonA = (Button)view.findViewById(R.id.a_Q4);

        buttonA.setText("是");

        buttonA.setOnClickListener(new MyClickListener());

        return view;
    }

    private class MyClickListener implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            Button button = (Button)v;
            if (button.getText().equals("是")) {
                Log.v("ppking", "是");

                mainActivity.onWindowFocusChanged(true);
                mainActivity.drawData();
                mainActivity.mainPager.setCurrentItem(0);
            }
        }
    }
}
