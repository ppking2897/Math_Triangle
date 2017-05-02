package com.example.biancaen.math_triangle;

import android.util.Log;

class DegRadCount {
    private float b_Point_Start_X;
    private float b_Point_Start_Y;
    private float b_Point_End_X;
    private float b_Point_End_Y;

    private float a_Point_Start_X;
    private float a_Point_Start_Y;
    private float a_Point_End_X;
    private float a_Point_End_Y;

    private float bc_Point_Start_X;
    private float bc_Point_Start_Y;
    private float bc_Point_End_X;
    private float bc_Point_End_Y;

    private float ac_Point_Start_X;
    private float ac_Point_Start_Y;
    private float ac_Point_End_X;
    private float ac_Point_End_Y;

    private float a_TextCenterX;
    private float a_TextCenterY;
    private float b_TextCenterX;
    private float b_TextCenterY;
    private float c_TextCenterX;
    private float c_TextCenterY;

    private int textSize;
    private float viewCenterWidth;
    private float viewCenterHeight;

    private double angleDeg_ab;
    private double angleDeg_ac;
    private double angleDeg_bc;

    private double big_a;
    private double big_b;
    private double big_c;



    DegRadCount(MainActivity mainActivity , int proportion , float viewWidth , float viewHeight,
                double a , double b , double c , double angleDeg_ab , double angleDeg_ac , double angleDeg_bc){

        //各個EditText get出來轉成字串，再去判斷是否為空格，若不是再轉成double

        Log.v("ppking" ,"ppking");

        this.angleDeg_ab = angleDeg_ab;
        this.angleDeg_ac = angleDeg_ac;
        this.angleDeg_bc = angleDeg_bc;

        big_a = a *proportion;
        big_b = b *proportion;
        big_c = c *proportion;

        initial(viewWidth , viewHeight , angleDeg_ab);

        if (angleDeg_ab == 60.0 ){
            proportion = proportion -100;
            big_a = a *proportion;
            big_b = b *proportion;
            big_c = c *proportion;
            initial(viewWidth , viewHeight , angleDeg_ab);
        }else if (angleDeg_ab == 150.0){
            proportion = proportion - 50;
            big_a = a *proportion;
            big_b = b *proportion;
            big_c = c *proportion;
            initial(viewWidth , viewHeight , angleDeg_ab);
        }

        Draw draw = mainActivity.draw;

        draw.setParameter(b_Point_Start_X , b_Point_Start_Y,
                            b_Point_End_X ,b_Point_End_Y,
                            a_Point_Start_X,a_Point_Start_Y,
                            a_Point_End_X,a_Point_End_Y,
                            ac_Point_Start_X,ac_Point_Start_Y,
                            ac_Point_End_X,ac_Point_End_Y,
                            bc_Point_Start_X,bc_Point_Start_Y,
                            bc_Point_End_X,bc_Point_End_Y);

        draw.setTextCenter(b_TextCenterX,b_TextCenterY,
                            a_TextCenterX,a_TextCenterY,
                            c_TextCenterX,c_TextCenterY,
                            textSize);

        draw.setAngle(angleDeg_ab , angleDeg_ac , angleDeg_bc);
        draw.invalidate();
    }

    //依公式 x = cos(弳度)*r半徑
    private double ab_xPoint() {
        double angleRad = (angleDeg_ab / 180) * Math.PI;
        return Math.cos(angleRad) * big_a;
    }
    //y = sin(弳度)*r半徑 (負的是依b邊長為基準相對往上)
    private double ab_yPoint() {
        double angleRad = (angleDeg_ab / 180) * Math.PI;
        return -Math.sin(angleRad) * big_a;
    }

    private double ac_xPoint() {
        double angleRad = ((180-(angleDeg_ab+angleDeg_ac)) / 180) * Math.PI;
        return Math.cos(angleRad) * big_c;
    }

    private double ac_yPoint() {
        double angleRad = ((180-(angleDeg_ab+angleDeg_ac)) / 180) * Math.PI;
        return Math.sin(angleRad) * big_c;
    }

    private double bc_xPoint() {
        double angleRad = (angleDeg_bc / 180) * Math.PI;
        return -Math.cos(angleRad) * big_c;
    }

    private double bc_yPoint() {
        double angleRad = (angleDeg_bc / 180) * Math.PI;
        return -Math.sin(angleRad) * big_c;
    }

    //設定各頂點座標XY以及設定出現字體的座標XY
    private void initial(float viewWidth , float viewHeight , double angleDeg_ab){

        //解析度字體大小
        float textCount = 3;
        textSize = 45;
        float textTotalSize = textCount * textSize;

        viewCenterWidth = viewWidth/2;
        viewCenterHeight = viewHeight*4/5;

        if (angleDeg_ab == 120 ){

            b_Point_Start_X = viewCenterWidth-150;
        }else if (angleDeg_ab == 135){

            b_Point_Start_X = viewCenterWidth-100;
        }else if (angleDeg_ab == 150){

            b_Point_Start_X = viewCenterWidth ;
        }
        else {

            b_Point_Start_X = viewCenterWidth - ((float) big_b / 2);
        }
        b_Point_Start_Y = viewCenterHeight;

        b_Point_End_X = b_Point_Start_X + (float) big_b;
        b_Point_End_Y = b_Point_Start_Y;

        //----依B邊長為基準點，A邊長起始點跟B邊長一樣，再利用角度求出A邊長的末端座標
        a_Point_Start_X = b_Point_Start_X;
        a_Point_Start_Y = b_Point_Start_Y;

        a_Point_End_X = b_Point_Start_X + (float) ab_xPoint();
        a_Point_End_Y = b_Point_Start_Y + (float) ab_yPoint();

        //-----依A邊長為基準點，C邊長起始點為A邊長末端座標
        ac_Point_Start_X = a_Point_End_X;
        ac_Point_Start_Y = a_Point_End_Y;

        ac_Point_End_X = a_Point_End_X + (float) ac_xPoint();
        ac_Point_End_Y = a_Point_End_Y + (float) ac_yPoint();

        //-----
        bc_Point_Start_X = b_Point_End_X;
        bc_Point_Start_Y = b_Point_End_Y;

        bc_Point_End_X = b_Point_End_X + (float) bc_xPoint();
        bc_Point_End_Y = b_Point_End_Y + (float) bc_yPoint();

        //-----各個文字的至中點
        if (angleDeg_ab == 120 || angleDeg_ab == 135) {

            b_TextCenterX = viewCenterWidth+textTotalSize;
        }else if( angleDeg_ab == 150) {

            b_TextCenterX = viewCenterWidth+textTotalSize*2;
        }else {

            b_TextCenterX = viewCenterWidth - (textTotalSize / 2);
        }
        b_TextCenterY = b_Point_Start_Y + textSize * 2;

        if (angleDeg_ab == 120 || angleDeg_ab == 135 || angleDeg_ab == 150) {

            a_TextCenterX = b_Point_Start_X + ((float) ab_xPoint() / 2) - textTotalSize ;
            a_TextCenterY = b_Point_Start_Y - 60;
        }else{

            a_TextCenterX = b_Point_Start_X + ((float) ab_xPoint() / 2) - textTotalSize - 3 * textSize / 2;
            a_TextCenterY = b_Point_Start_Y + ((float) ab_yPoint() / 2);
        }

        c_TextCenterX = a_Point_End_X + ((float) ac_xPoint() / 2) + textSize;
        c_TextCenterY = a_Point_End_Y + ((float) ac_yPoint() / 2);
    }
}
