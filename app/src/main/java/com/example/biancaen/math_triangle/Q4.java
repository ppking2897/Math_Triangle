package com.example.biancaen.math_triangle;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class Q4 extends Fragment {
    private String angleSin;
    private String angleSin1;
    private static int rightCount;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.finalpage , container , false);
        final MainActivity mainActivity = (MainActivity) getActivity();
        TextView textViewUp = (TextView)view.findViewById(R.id.finalUpText);
        TextView title = (TextView)view.findViewById(R.id.finalTitle);
        TextView textView =(TextView) view.findViewById(R.id.finalText);

        TextView show = (TextView)view.findViewById(R.id.show);
        TextView superLink01 = (TextView)view.findViewById(R.id.superLink01);
        TextView superLink02 = (TextView)view.findViewById(R.id.superLink02);

        Button nextQuestion = (Button)view.findViewById(R.id.nextQuestion);

        nextQuestion.setOnClickListener(new MyClickListener());

        boolean ansRightorWrong = mainActivity.passAnsRightToQ4();

        if (ansRightorWrong){
            textViewUp.setText("恭喜答對!!");
            show.setText("");
            superLink01.setText("");
            superLink02.setText("");
            rightCount = rightCount+1;
            if (rightCount == 6 ){
                textViewUp.setText("恭喜又答對了!!");
            }else if (rightCount == 9){
                textViewUp.setText("恭喜過關!!");
                nextQuestion.setVisibility(View.INVISIBLE);
            }
            Log.v("ppking" , " rightCount : " +rightCount);
            //nextQuestion.setVisibility(View.INVISIBLE);
        }else {
            textViewUp.setText("選擇的答案是錯誤的!!");
            rightCount = 0;
            show.setText("可以參考下列網址:");
            superLink01.setText(Html.fromHtml("<a href=\"https://www.youtube.com/watch?v=cUvc6XyT8z8&feature=youtu.be\">利用Sin計算三角形面積</a>"));
            superLink01.setMovementMethod(LinkMovementMethod.getInstance());

            superLink02.setText(Html.fromHtml("<a href=\"https://www.youtube.com/watch?v=_syV6cDk7Lg&list=\">Area Of A Non-Right Angle Triangle</a>"));
            superLink02.setMovementMethod(LinkMovementMethod.getInstance());

            //nextQuestion.setVisibility(View.VISIBLE);
        }
        float angleAB =(float) mainActivity.angleAB_ANS();
        float lineA = (float)mainActivity.lineA_ANS();
        float lineB = (float)mainActivity.lineB_ANS();

        float finalAns = (lineA * lineB) /4;

        if (angleAB == 30 || angleAB == 150){
            angleSin = "(1/2)";
            angleSin1 = "";
        }else if (angleAB == 45 || angleAB == 135){
            angleSin = "(√2/2)";
            angleSin1 = "√2";
        }else if (angleAB == 60 || angleAB == 120){
            angleSin = "(√3/2)";
            angleSin1 = "√3";
        }

        ArrayList arrayList = mainActivity.passAnsToQ3();

        float a = (float)arrayList.get(0);

        if (a%2==0){
            int p =(int)a;
            int x =(int)finalAns;
            textView.setText(mainActivity.passAnsToQ2() + "\n" + p + "  x  " + angleSin + "\n" + x + angleSin1);

        }else {
            textView.setText(mainActivity.passAnsToQ2() + "\n" + a + "  x  " + angleSin + "\n" + finalAns + angleSin1);
        }

        title.setText("面積為 : " + "\n" + " =>" + "\n" + " =>") ;


        return view;
    }

    private class MyClickListener implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            MainActivity mainActivity = (MainActivity)getActivity();
            mainActivity.finish();
            Intent intent = new Intent(getContext() , MainActivity.class);
            getContext().startActivity(intent);

        }
    }

}
