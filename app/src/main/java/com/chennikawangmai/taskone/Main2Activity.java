package com.chennikawangmai.taskone;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;



public class Main2Activity extends AppCompatActivity {
    public static int y=0;
   public int g;
   public static int j=0;
   public int h;
   private EditText e1;
   private TextView t4;
   public ConstraintLayout col;
   public static final String SHARED_PREFS = "sharedPreferences";
   public static final String INTS="ints";
   public static final String INTK="intk";
   private TextView t2;
   private TextView t3;
   private TextView t5;
   private Button b2;
   private Button b3;
   private int n4;
   private int f=0;
   public int c=0;


    public void closekeyboard() {
        View c = this.getCurrentFocus();
        if (c != null)
        {int flags;
            InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(c.getWindowToken(),0);
        }
    }



    public boolean isEmpty(EditText etText) {
        if (etText.getText().toString().trim().length() > 0)
            return true;

        return false;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Intent intent=getIntent();
        n4=intent.getIntExtra(com.chennikawangmai.taskone.MainActivity.EXTRA_NUM,0);
        ++n4;
        e1=(EditText)findViewById(R.id.editText);
        b2=(Button)findViewById(R.id.button2);
        t3=(TextView)findViewById(R.id.textView3) ;
        t2=(TextView)findViewById(R.id.textView2) ;
        t4=(TextView)findViewById(R.id.textView);
        t5=(TextView)findViewById(R.id.textView4) ;
        col=(ConstraintLayout)findViewById(R.id.constr);
        t4.setText( "Enter your guess of age of death in the space below(a number less than 100)");
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                closekeyboard();
                col=(ConstraintLayout)findViewById(R.id.constr);
                e1=(EditText)findViewById(R.id.editText);
            boolean b=isEmpty(e1);
                if(b) {
                    int num = Integer.parseInt(e1.getText().toString());
                    int k;
                    if (num > 0 && num < 101) {
                            k = num - n4 + 1;
                        if(c<6) {
                            if (k > 0) {
                                f++;
                                if (k > 30) {
                                    c++;
                                    t3.setText("Your guess is very much higher than the correct age of death,enter your guess again ");
                                    int ha = getResources().getColor(R.color.darkred);
                                    col.setBackgroundColor(ha);
                                } else if (k > 20) {
                                    t3.setText("Your guess is higher than the correct age of death,enter your guess again ");
                                    int ha = getResources().getColor(R.color.red);
                                    col.setBackgroundColor(ha);
                                } else if (k > 10) {
                                    t3.setText("Your guess is more than the correct age of death,enter your guess again ");
                                    int ha = getResources().getColor(R.color.green);
                                    col.setBackgroundColor(ha);
                                } else {
                                    t3.setText("Your guess is more than the correct age ( but very close) ");
                                    int ha = getResources().getColor(R.color.darkgreen);
                                    col.setBackgroundColor(ha);
                                }

                            } else if (k < 0) {
                                c++;
                                k = -k;
                                f++;
                                if (k > 30) {
                                    t3.setText("Your guess is very much less than the correct age of death,enter your guess again ");
                                    int ha = getResources().getColor(R.color.darkred);
                                    col.setBackgroundColor(ha);
                                } else if (k > 20) {
                                    t3.setText("Your guess is  very less than the correct age of death,enter your guess again ");
                                    int ha = getResources().getColor(R.color.red);
                                    col.setBackgroundColor(ha);
                                } else if (k > 10) {
                                    t3.setText("Your guess is less than the correct age of death,enter your guess again ");
                                    int ha = getResources().getColor(R.color.green);
                                    col.setBackgroundColor(ha);
                                } else {
                                    t3.setText("Your guess is less than the correct age (but very close) ");
                                    int ha = getResources().getColor(R.color.darkgreen);
                                    col.setBackgroundColor(ha);
                                }
                            } else {
                                int ha = getResources().getColor(R.color.darkgreen);
                                t3.setTextColor(ha);
                                t2.setTextColor(ha);
                                t3.setText("Your guess is correct! and the number of chances you lost is");
                                t2.setText("" + f);
                                col.setBackgroundColor(Color.YELLOW);
                                f = 0;
                                ++y;
                            }

                        }
                        else
                        {t3.setText("You loose ,you have exceeded your no of chances ,try again.");
                        c=0;
                        j++;
                        }
                    }
                        else {
                            t3.setText("Enter a number less than 100");
                        }

                }
                else
                {t3.setText("Enter a number");}





            }

        });
        b3=findViewById(R.id.button3);
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             savedata();
             loaddata();
             t5.setText("Number of games won: " +g+"   Number of games lost:  "+h );



            }
        });


    }
    public void savedata()
    {
        SharedPreferences sharedPreferences=getSharedPreferences(SHARED_PREFS,MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putInt("intk",y);
        editor.putInt("ints",j);
        editor.apply();

    }
    public void loaddata()
    {
        SharedPreferences sharedPreferences=getSharedPreferences(SHARED_PREFS,MODE_PRIVATE);
        g=sharedPreferences.getInt(INTK,y);
        h=sharedPreferences.getInt(INTS,j);
    }

}
