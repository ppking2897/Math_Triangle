package com.example.biancaen.math_triangle;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import java.util.ArrayList;


public class Q1 extends Fragment {
    private MainActivity mainActivity;
    private String answer;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.q1 , container, false);

        mainActivity = (MainActivity)getActivity();

        int lineA = (int)mainActivity.lineA_ANS();
        int lineB = (int)mainActivity.lineB_ANS();
        int angleAB =(int)mainActivity.angleAB_ANS();

        answer = "1/2 * " + lineA + " * " + lineB + " * Sin" + angleAB + String.valueOf(((char)176));

        ArrayList<String> question = new ArrayList<>();
        question.add("1/2 * " + lineA + " * " + lineB + " * Cos" + angleAB + String.valueOf(((char)176)));
        question.add("1/2 * " + lineA + " * " + lineB + " * Sin" + angleAB + String.valueOf(((char)176)));
        question.add(lineA + " * " + lineB + " * Cos" + angleAB + String.valueOf(((char)176)));
        question.add(lineA + " * " + lineB + " * Sin" + angleAB + String.valueOf(((char)176)));

        Button buttonA = (Button) view.findViewById(R.id.a);
        Button buttonB = (Button) view.findViewById(R.id.b);
        Button buttonC = (Button) view.findViewById(R.id.c);
        Button buttonD = (Button) view.findViewById(R.id.d);

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

        buttonA.setOnClickListener(new MyOnClickListener());
        buttonB.setOnClickListener(new MyOnClickListener());
        buttonC.setOnClickListener(new MyOnClickListener());
        buttonD.setOnClickListener(new MyOnClickListener());

        return view;
    }

    private class MyOnClickListener implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            Button button = (Button)v;
            if (button.getText().toString().contains(answer)){
                Log.v("ppking" , " findout !!");
                mainActivity.passAns1ToMain(answer);
                mainActivity.mainPager.setCurrentItem(mainActivity.mainPager.getCurrentItem()+1);
//                FragmentManager fragmentManager = getFragmentManager();
//                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//                fragmentTransaction.replace(R.id.mainPager , q2);
//                fragmentTransaction.commit();
                mainActivity.mainPager.getAdapter().notifyDataSetChanged();
            }
        }
    }
}
