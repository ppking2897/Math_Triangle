package com.example.biancaen.math_triangle;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

public class Draw extends View {
    private static double a;
    private static double b;
    private static double c;
    //經過比例放大的b邊長

    private static float b_Point_Start_X;
    private static float b_Point_Start_Y;
    private static float b_Point_End_X;
    private static float b_Point_End_Y;

    private static float a_Point_Start_X;
    private static float a_Point_Start_Y;
    private static float a_Point_End_X;
    private static float a_Point_End_Y;

    private static float ac_Point_Start_X;
    private static float ac_Point_Start_Y;
    private static float ac_Point_End_X;
    private static float ac_Point_End_Y;

    private static float bc_Point_Start_X;
    private static float bc_Point_Start_Y;
    private static float bc_Point_End_X;
    private static float bc_Point_End_Y;

    private static float b_TextCenterX;
    private static float b_TextCenterY;
    private static float a_TextCenterX;
    private static float a_TextCenterY;
    private static float c_TextCenterX;
    private static float c_TextCenterY;

    private static int textSize;

    private static double angleDeg_ab;
    private static double angleDeg_ac;
    private static double angleDeg_bc;

    public void setParameter(float b_Point_Start_X ,float b_Point_Start_Y ,
                             float b_Point_End_X , float b_Point_End_Y,
                             float a_Point_Start_X , float a_Point_Start_Y,
                             float a_Point_End_X , float a_Point_End_Y,
                             float ac_Point_Start_X , float ac_Point_Start_Y,
                             float ac_Point_End_X , float ac_Point_End_Y,
                             float bc_Point_Start_X , float bc_Point_Start_Y,
                             float bc_Point_End_X , float bc_Point_End_Y)
    {
        Draw.b_Point_Start_X = b_Point_Start_X;
        Draw.b_Point_Start_Y = b_Point_Start_Y;
        Draw.b_Point_End_X = b_Point_End_X;
        Draw.b_Point_End_Y = b_Point_End_Y;

        Draw.a_Point_Start_X = a_Point_Start_X;
        Draw.a_Point_Start_Y = a_Point_Start_Y;
        Draw.a_Point_End_X = a_Point_End_X;
        Draw.a_Point_End_Y = a_Point_End_Y;

        Draw.ac_Point_Start_X = ac_Point_Start_X;
        Draw.ac_Point_Start_Y = ac_Point_Start_Y;
        Draw.ac_Point_End_X = ac_Point_End_X;
        Draw.ac_Point_End_Y = ac_Point_End_Y;

        Draw.bc_Point_Start_X = bc_Point_Start_X;
        Draw.bc_Point_Start_Y = bc_Point_Start_Y;
        Draw.bc_Point_End_X = bc_Point_End_X;
        Draw.bc_Point_End_Y = bc_Point_End_Y;

        Log.v("ppking" , "b_Point_Start_X00 : " + b_Point_Start_X);
    }

    public void setTextCenter(float b_TextCenterX , float b_TextCenterY,
                              float a_TextCenterX , float a_TextCenterY,
                              float c_TextCenterX , float c_TextCenterY,
                              int textSize)
    {
        Draw.b_TextCenterX = b_TextCenterX;
        Draw.b_TextCenterY = b_TextCenterY;
        Draw.a_TextCenterX = a_TextCenterX;
        Draw.a_TextCenterY = a_TextCenterY;
        Draw.c_TextCenterX = c_TextCenterX;
        Draw.c_TextCenterY = c_TextCenterY;
        Draw.textSize = textSize;
    }

    public void setLine(double a , double b , double c)
    {
        Draw.a = a;
        Draw.b = b;
        Draw.c = c;
    }

    public void setAngle(double angleDeg_ab , double angleDeg_ac , double angleDeg_bc){

        Draw.angleDeg_ab = angleDeg_ab;
        Draw.angleDeg_ac = angleDeg_ac;
        Draw.angleDeg_bc = angleDeg_bc;
    }

    Paint paint = new Paint();
    Paint paintText = new Paint();
    RectF rectF = new RectF();

    public Draw(Context context , AttributeSet attributeSet){
        super(context , attributeSet);
    }

    @Override
    protected void onDraw(Canvas canvas){
        super.onDraw(canvas);
        paint.setColor(Color.BLACK);
        paint.setStrokeWidth(8);
        paint.setTextSize(textSize);

        Log.v("ppking" , "b_Point_Start_X : " + b_Point_Start_X);
        //底部線 b
        canvas.drawLine(b_Point_Start_X , b_Point_Start_Y , b_Point_End_X , b_Point_End_Y  , paint);

        //左邊線 a
        canvas.drawLine(a_Point_Start_X , a_Point_Start_Y , a_Point_End_X , a_Point_End_Y ,paint);

        //右邊線 c
        canvas.drawLine(ac_Point_Start_X , ac_Point_Start_Y, ac_Point_End_X ,ac_Point_End_Y ,paint);
        canvas.drawLine(bc_Point_Start_X , bc_Point_Start_Y, bc_Point_End_X ,bc_Point_End_Y ,paint);

        //角度扇形顯示
        paintText.setStyle(Paint.Style.STROKE);
        paintText.setStrokeWidth(8);

        rectF.set(b_Point_Start_X - (80) , b_Point_Start_Y - (80) , b_Point_Start_X + (80) ,b_Point_Start_Y + (80));
        canvas.drawArc(rectF , 0 , -(float)angleDeg_ab  ,false ,paintText);

        //邊長 角度 字體顯示
        canvas.drawText((int)b + "", b_TextCenterX, b_TextCenterY, paint);
        canvas.drawText((int)a + "", a_TextCenterX, a_TextCenterY, paint);

        //canvas.drawText("邊長C", c_TextCenterX, c_TextCenterY, paint);
        canvas.drawText((int)angleDeg_ab + String.valueOf(((char)176)), b_Point_Start_X - 3*textSize/2 , b_Point_Start_Y + 3*textSize/2 , paint);

    }
}
