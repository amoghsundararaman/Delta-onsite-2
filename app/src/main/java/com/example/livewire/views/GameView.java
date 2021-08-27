package com.example.livewire.views;

import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Build;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

import com.example.livewire.EndGame;
import com.example.livewire.R;
import com.example.livewire.gamepage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class GameView extends View {
    private Rect wire1;
    private Rect wire2;
    private Rect wire3;
    private Rect wire4;
    private Rect wire5;
    private Rect wire6;

    private Rect blue1;
    private Rect blue2;
    private Rect pink1;
    private Rect pink2;
    private Rect green1;
    private Rect green2;


    private Paint color1;
    private Paint color2;
    private Paint color3;

    private float wire1x;
    private float wire2x;
    private float wire3x;
    private float wire4x;
    private float wire5x;
    private float wire6x;

    private int move1;
    private int move2;
    private int move3;
    private int move4;
    private int move5;
    private int move6;

    private int wincon;

    private List<Integer> checklist1 = new ArrayList<>();
    private List<Integer> checklist2 = new ArrayList<>();
    private List<Integer> checklist3 = new ArrayList<>();
    private List<Integer> checklist4 = new ArrayList<>();
    private List<Integer> checklist5 = new ArrayList<>();
    private List<Integer> checklist6 = new ArrayList<>();

    private List<Integer> list = new ArrayList<>();
    private List<List<Integer>> list2 = new ArrayList<List<Integer>>();
    List<List<Integer>> colorlist = new ArrayList<>();
    List<Integer> list3 = new ArrayList<>();
    List<Integer> finlist = new ArrayList<>();
    public int greaterblue,greaterpink,greatergreen;


    private gamepage gp;
    public static Context C;

    public void setActivity(gamepage activity) {

        gp = activity;

    }

    public GameView(Context context) {
        super(context);
        C = context;
        setBackgroundResource(R.drawable.background4);
        list.add(1);
        list.add(1);
        list.add(2);
        list.add(2);
        list.add(3);
        list.add(3);
        Collections.shuffle(list);

        checklist1.add(1);
        checklist1.add(1);
        checklist1.add(2);
        checklist1.add(2);
        checklist1.add(3);
        checklist1.add(3);

        checklist2.add(1);
        checklist2.add(1);
        checklist2.add(3);
        checklist2.add(3);
        checklist2.add(2);
        checklist2.add(2);

        checklist3.add(2);
        checklist3.add(2);
        checklist3.add(1);
        checklist3.add(1);
        checklist3.add(3);
        checklist3.add(3);

        checklist4.add(2);
        checklist4.add(2);
        checklist4.add(3);
        checklist4.add(3);
        checklist4.add(1);
        checklist4.add(1);

        checklist5.add(3);
        checklist5.add(3);
        checklist5.add(1);
        checklist5.add(1);
        checklist5.add(2);
        checklist5.add(2);

        checklist6.add(3);
        checklist6.add(3);
        checklist6.add(2);
        checklist6.add(2);
        checklist6.add(1);
        checklist6.add(1);



        move1 = 0;
        move2 = 0;
        move3 = 0;
        move4 = 0;
        move5 = 0;
        move6 = 0;
        init(null);
    }

    public GameView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public GameView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public GameView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    private void init (@Nullable AttributeSet set) {
        wire1 = new Rect();
        wire2 = new Rect();
        wire3 = new Rect();
        wire4 = new Rect();
        wire5 = new Rect();
        wire6 = new Rect();

        color1 = new Paint();
        color2 = new Paint();
        color3 = new Paint();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        Secregatecolorscheck();

        if (wincon == 1) {
            Intent intent = new Intent(C, EndGame.class);
            C.startActivity(intent);
        }

        if (wire1x == 0f) {
            wire1x = getHeight()/6;
        }
        if (wire2x == 0f) {
            wire2x = 2 * getHeight()/8;
        }
        if (wire3x == 0f) {
            wire3x = 3 * getHeight()/8;
        }
        if (wire4x == 0f) {
            wire4x = 4 * getHeight()/8;
        }
        if (wire5x == 0f) {
            wire5x = 5 * getHeight()/8;
        }
        if (wire6x == 0f) {
            wire6x = 6 * getHeight()/8;
        }

        color1.setColor(0xFFFF10F0);
        color2.setColor(0xFF00FF00);
        color3.setColor(0xFF00FFFF);

        wire1.top = (int) wire1x ;
        wire1.left = 150;
        wire1.bottom = wire1.top + 40;
        wire1.right = wire1.left + (int)(0.72 *getWidth());
        if (list.get(0) == 1) {
            canvas.drawRect(wire1,color1);
        } else if (list.get(0) == 2){
            canvas.drawRect(wire1,color2);
        } else {
            canvas.drawRect(wire1,color3);
        }

        wire2.top = (int) wire2x;
        wire2.left = 150;
        wire2.bottom = wire2.top + 40;
        wire2.right = wire2.left + (int)(0.72 *getWidth());
        if (list.get(1) == 1) {
            canvas.drawRect(wire2,color1);
        } else if (list.get(1) == 2){
            canvas.drawRect(wire2,color2);
        } else {
            canvas.drawRect(wire2,color3);
        }

        wire3.top = (int) wire3x;
        wire3.left = 150;
        wire3.bottom = wire3.top + 40;
        wire3.right = wire3.left + (int)(0.72 *getWidth());
        if (list.get(2) == 1) {
            canvas.drawRect(wire3,color1);
        } else if (list.get(2) == 2){
            canvas.drawRect(wire3,color2);
        } else {
            canvas.drawRect(wire3,color3);
        }

        wire4.top = (int) wire4x;
        wire4.left = 150;
        wire4.bottom = wire4.top + 40;
        wire4.right = wire4.left + (int)(0.72 *getWidth());
        if (list.get(3) == 1) {
            canvas.drawRect(wire4,color1);
        } else if (list.get(3) == 2){
            canvas.drawRect(wire4,color2);
        } else {
            canvas.drawRect(wire4,color3);
        }

        wire5.top = (int) wire5x;
        wire5.left = 150;
        wire5.bottom = wire5.top + 40;
        wire5.right = wire5.left + (int)(0.72 *getWidth());
        if (list.get(4) == 1) {
            canvas.drawRect(wire5,color1);
        } else if (list.get(4) == 2){
            canvas.drawRect(wire5,color2);
        } else {
            canvas.drawRect(wire5,color3);
        }

        wire6.top = (int) wire6x;
        wire6.left = 150;
        wire6.bottom = wire6.top + 40;
        wire6.right = wire6.left + (int)(0.72 *getWidth());
        if (list.get(5) == 1) {
            canvas.drawRect(wire6,color1);
        } else if (list.get(5) == 2){
            canvas.drawRect(wire6,color2);
        } else {
            canvas.drawRect(wire6,color3);
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        boolean value =  super.onTouchEvent(event);
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN: {
                float y = event.getY();
                float x = event.getX();
                if (y>= (wire1.top - 40) && y <= (wire1.bottom + 40)) {
                    move1 = 1;
                }
                else if (y>= (wire2.top - 40) && y <= (wire2.bottom + 40)) {
                    move2 = 1;
                }
                else if (y>= (wire3.top - 40) && y <= (wire3.bottom + 40) ) {
                    move3 = 1;
                }
                else if (y>= (wire4.top - 40) && y <= wire4.bottom + 40 ) {
                    move4 = 1;
                }
                else if (y>=(wire5.top - 40) && y <= (wire5.bottom + 40) ) {
                    move5 = 1;
                }
                else if (y >= (wire6.top - 100) && y <= (wire6.bottom + 100)) {
                    move6 = 1;
                }
                return true;
            }

            case MotionEvent.ACTION_MOVE: {
               if (move1 == 1) {
                   float y = event.getY();
                   double dy1 = y - wire1x;
                   if (dy1 != 0) {
                       if (y < ((getHeight() / 6) - 10)) {
                           y = getHeight() / 6;
                       }
                       if ((y > (6 * (getHeight() / 8)) + 10)) {
                           y = 6 * getHeight() / 8;
                       }
                       wire1x = y;
                       postInvalidate();
                   }
               }
               else if (move2 == 1) {
                    float y = event.getY();
                    double dy1 = y - wire2x;
                    if (dy1 != 0) {
                        if (y < ((getHeight() / 6) - 10)) {
                            y = getHeight() / 6;
                        }
                        if ((y > (6 * (getHeight() / 8)) + 10)) {
                            y = 6 * getHeight() / 8;
                        }
                        wire2x = y;
                        postInvalidate();
                    }
               }
               else if (move3 == 1) {
                    float y = event.getY();
                    double dy1 = y - wire3x;
                    if (dy1 != 0) {
                        if (y < ((getHeight() / 6) - 10)) {
                            y = getHeight() / 6;
                        }
                        if ((y > (6 * (getHeight() / 8)) + 10)) {
                            y = 6 * getHeight() / 8;
                        }
                        wire3x = y;
                        postInvalidate();
                    }
               }
               else if (move4 == 1) {
                    float y = event.getY();
                    double dy1 = y - wire4x;
                    if (dy1 != 0) {
                        if (y < ((getHeight() / 6) - 10)) {
                            y = getHeight() / 6;
                        }
                        if ((y > (6 * (getHeight() / 8)) + 10)) {
                            y = 6 * getHeight() / 8;
                        }
                        wire4x = y;
                        postInvalidate();
                    }
               }
               else if (move5 == 1) {
                    float y = event.getY();
                    double dy1 = y - wire5x;
                    if (dy1 != 0) {
                        if (y < ((getHeight() / 6) - 10)) {
                            y = getHeight() / 6;
                        }
                        if ((y > (6 * (getHeight() / 8)) + 10)) {
                            y = 6 * getHeight() / 8;
                        }
                        wire5x = y;
                        postInvalidate();
                    }
               }
               else if (move6 == 1) {
                    float y = event.getY();
                    double dy1 = y - wire6x;
                    if (dy1 != 0) {
                        if (y < ((getHeight() / 6) - 10)) {
                            y = getHeight() / 6;
                        }
                        if ((y > (6 * (getHeight() / 8)) + 10)) {
                            y = 6 * getHeight() / 8;
                        }
                        wire6x = y;
                        postInvalidate();
                    }
               }
               return true;
            }
            case MotionEvent.ACTION_CANCEL: {


            }
            case MotionEvent.ACTION_UP: {
               /* if(green1.top > green2.top){
                    Intent intent = new Intent(C,MainActivity.class);
                    C.startActivity(intent);
                }*/


                if (move1 == 1) {
                    move1 = 0;
                }
                if (move2 == 1) {
                    move2 = 0;
                }
                if (move3 == 1) {
                    move3 = 0;
                }
                if (move4 == 1) {
                    move4 = 0;
                }
                if (move5 == 1) {
                    move5 = 0;
                }
                if (move6 == 1) {
                    move6 = 0;
                }
            }
        }


        return value;
    }

    private void Win() {
    }


    public void Secregatecolorscheck() {

        int color1index1 = list.indexOf(1);

        int color1index2 = list.subList(color1index1,6).indexOf(1);
        int color2index1 = list.indexOf(2);
        int color2index2 = list.subList(color2index1,6).indexOf(2);
        int color3index1 = list.indexOf(3);
        int color3index2 = list.subList(color3index1,6).indexOf(3);

        if (color1index1 == 0) {
            blue1 = wire1;
        }
        if (color1index1 == 1) {
            blue1 = wire2;
        }
        if (color1index1 == 2) {
            blue1 = wire3;
        }
        if (color1index1 == 3) {
            blue1 = wire4;
        }
        if (color1index1 == 4) {
            blue1 = wire5;
        }
        if (color1index1 == 5) {
            blue1 = wire6;
        }

        if (color1index2 == 0) {
            blue2 = wire1;
        }
        if (color1index2 == 1) {
            blue2 = wire2;
        }
        if (color1index2 == 2) {
            blue2 = wire3;
        }
        if (color1index2 == 3) {
            blue2 = wire4;
        }
        if (color1index2 == 4) {
            blue2 = wire5;
        }
        if (color1index2 == 5) {
            blue2 = wire6;
        }

        if (color2index1 == 0) {
            green1 = wire1;
        }
        if (color2index1 == 1) {
            green1 = wire2;
        }
        if (color2index1 == 2) {
            green1 = wire3;
        }
        if (color2index1 == 3) {
            green1 = wire4;
        }
        if (color2index1 == 4) {
            green1 = wire5;
        }
        if (color2index1 == 5) {
            green1 = wire6;
        }

        if (color2index2 == 0) {
            green2 = wire1;
        }
        if (color2index2 == 1) {
            green2 = wire2;
        }
        if (color2index2 == 2) {
            green2 = wire3;
        }
        if (color2index2 == 3) {
            green2 = wire4;
        }
        if (color2index2 == 4) {
            green2 = wire5;
        }
        if (color2index2 == 5) {
            green2 = wire6;
        }

        if (color3index1 == 0) {
            pink1 = wire1;
        }
        if (color3index1 == 1) {
            pink1 = wire2;
        }
        if (color3index1 == 2) {
            pink1 = wire3;
        }
        if (color3index1 == 3) {
            pink1 = wire4;
        }
        if (color3index1 == 4) {
            pink1 = wire5;
        }
        if (color3index1 == 5) {
            pink1 = wire6;
        }

        if (color3index2 == 0) {
            pink2 = wire1;
        }
        if (color3index2 == 1) {
            pink2 = wire2;
        }
        if (color3index2 == 2) {
            pink2 = wire3;
        }
        if (color3index2 == 3) {
            pink2 = wire4;
        }
        if (color3index2 == 4) {
            pink2 = wire5;
        }
        if (color3index2 == 5) {
            pink2 = wire6;
        }

        list2.clear();

        list3.clear();
        list3.add(1);
        list3.add(blue1.top);
        list2.add(list3);

        list3.clear();
        list3.add(1);
        list3.add(blue2.top);
        list2.add(list3);

        list3.clear();
        list3.add(2);
        list3.add(green1.top);
        list2.add(list3);

        list3.clear();
        list3.add(2);
        list3.add(green2.top);
        list2.add(list3);

        list3.clear();
        list3.add(3);
        list3.add(pink1.top);
        list2.add(list3);

        list3.clear();
        list3.add(3);
        list3.add(pink2.top);
        list2.add(list3);

        Collections.sort(list2, new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
                return Math.max(o1.get(1),o2.get(1));
            }
        });

        for (int i = 0; i < 6; i ++){
            finlist.add(list2.get(i).get(0));
        }

        if (finlist.equals(checklist1)) {
            wincon = 1;

        } else if (finlist.equals(checklist2)) {
            wincon = 1;

        } else if (finlist.equals(checklist3)) {
            wincon = 1;

        } else if (finlist.equals(checklist4)) {
            wincon = 1;

        } else if (finlist.equals(checklist5)) {
            wincon = 1;

        } else if (finlist.equals(checklist6)) {
            wincon = 1;
        }



    }


}
