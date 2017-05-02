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
    private double a;
    private double b;
    private double c;
    //經過比例放大的b邊長

    private float b_Point_Start_X;
    private float b_Point_Start_Y;
    private float b_Point_End_X;
    private float b_Point_End_Y;

    private float a_Point_Start_X;
    private float a_Point_Start_Y;
    private float a_Point_End_X;
    private float a_Point_End_Y;

    private float ac_Point_Start_X;
    private float ac_Point_Start_Y;
    private float ac_Point_End_X;
    private float ac_Point_End_Y;

    private float bc_Point_Start_X;
    private float bc_Point_Start_Y;
    private float bc_Point_End_X;
    private float bc_Point_End_Y;

    private float b_TextCenterX;
    private float b_TextCenterY;
    private float a_TextCenterX;
    private float a_TextCenterY;
    private float c_TextCenterX;
    private float c_TextCenterY;

    private int textSize;

    private double angleDeg_ab;
    private double angleDeg_ac;
    private double angleDeg_bc;

    public void setParameter(float b_Point_Start_X ,float b_Point_Start_Y ,
                             float b_Point_End_X , float b_Point_End_Y,
                             float a_Point_Start_X , float a_Point_Start_Y,
                             float a_Point_End_X , float a_Point_End_Y,
                             float ac_Point_Start_X , float ac_Point_Start_Y,
                             float ac_Point_End_X , float ac_Point_End_Y,
                             float bc_Point_Start_X , float bc_Point_Start_Y,
                             float bc_Point_End_X , float bc_Point_End_Y)
    {
        this.b_Point_Start_X = b_Point_Start_X;
        this.b_Point_Start_Y = b_Point_Start_Y;
        this.b_Point_End_X = b_Point_End_X;
        this.b_Point_End_Y = b_Point_End_Y;

        this.a_Point_Start_X = a_Point_Start_X;
        this.a_Point_Start_Y = a_Point_Start_Y;
        this.a_Point_End_X = a_Point_End_X;
        this.a_Point_End_Y = a_Point_End_Y;

        this.ac_Point_Start_X = ac_Point_Start_X;
        this.ac_Point_Start_Y = ac_Point_Start_Y;
        this.ac_Point_End_X = ac_Point_End_X;
        this.ac_Point_End_Y = ac_Point_End_Y;

        this.bc_Point_Start_X = bc_Point_Start_X;
        this.bc_Point_Start_Y = bc_Point_Start_Y;
        this.bc_Point_End_X = bc_Point_End_X;
        this.bc_Point_End_Y = bc_Point_End_Y;
    }

    public void setTextCenter(float b_TextCenterX , float b_TextCenterY,
                              float a_TextCenterX , float a_TextCenterY,
                              float c_TextCenterX , float c_TextCenterY,
                              int textSize)
    {
        this.b_TextCenterX = b_TextCenterX;
        this.b_TextCenterY = b_TextCenterY;
        this.a_TextCenterX = a_TextCenterX;
        this.a_TextCenterY = a_TextCenterY;
        this.c_TextCenterX = c_TextCenterX;
        this.c_TextCenterY = c_TextCenterY;
        this.textSize = textSize;
    }

    public void setLine(double a , double b , double c)
    {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public void setAngle(double angleDeg_ab , double angleDeg_ac , double angleDeg_bc){

        this.angleDeg_ab = angleDeg_ab;
        this.angleDeg_ac = angleDeg_ac;
        this.angleDeg_bc = angleDeg_bc;
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

        rectF.set(b_Point_Start_X-(100) , b_Point_Start_Y -(100) , b_Point_Start_X+(100) ,b_Point_Start_Y+(100));
        canvas.drawArc(rectF , 0 , -(float)angleDeg_ab  ,false ,paintText);

        //rectF.set(a_Point_End_X-(b_TextCenterX/4) , a_Point_End_Y-(b_TextCenterX/4) , a_Point_End_X+(b_TextCenterX/4) ,a_Point_End_Y+(b_TextCenterX/4));
        //canvas.drawArc(rectF , 180 - ((float)angleDeg_ac + (float)angleDeg_ab) , (float)angleDeg_ac ,false ,paintText);

        //rectF.set(b_Point_End_X-(b_TextCenterX/4) , b_Point_End_Y-(b_TextCenterX/4) , b_Point_End_X+(b_TextCenterX/4) ,b_Point_End_Y+(b_TextCenterX/4));
        //canvas.drawArc(rectF , 180 , (float)angleDeg_bc , false , paintText );

        //邊長 角度 字體顯示
        canvas.drawText((int)b + "公分", b_TextCenterX, b_TextCenterY, paint);
        canvas.drawText((int)a + "公分", a_TextCenterX, a_TextCenterY, paint);
        //canvas.drawText(c + "公分", c_TextCenterX, c_TextCenterY, paint);
        canvas.drawText("邊長C", c_TextCenterX, c_TextCenterY, paint);
        //canvas.drawText("Q : 請問邊長C為多少?" , (getWidth()/2)-(textSize*5), a_Point_End_Y-50 , paint );

        canvas.drawText((int)angleDeg_ab + "度", b_Point_Start_X - 3*textSize/2 , b_Point_Start_Y + 3*textSize/2 , paint);
        //canvas.drawText(angleDeg_ac + "度", a_Point_End_X - textSize , a_Point_End_Y - textSize/2 , paint);
        //canvas.drawText(angleDeg_bc + "度", b_Point_End_X - 3*textSize/2 , b_Point_End_Y + + 3*textSize/2 , paint);
    }
}
