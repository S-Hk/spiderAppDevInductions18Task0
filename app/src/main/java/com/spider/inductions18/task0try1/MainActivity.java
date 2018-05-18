package com.spider.inductions18.task0try1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
//import android.text.Layout;
import android.view.View;
import android.widget.Button;
//import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.spider.inductions18.task0try1.R;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    int rand, currentAmt, targetAmt;
    boolean success=false;

    //View layout;

    TextView target, current;

    View view;



    Button R1, R2, R5, R10, reset_all;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializer();

        randomNumber();

        //Toast.makeText(this.getBaseContext(),"App onCreate Success!!!",Toast.LENGTH_SHORT).show();


        R1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentAmt = currentAmt +1;
                current.setText(String.valueOf(currentAmt));
                checkPayment();
            }
        });

        R2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentAmt = currentAmt +2;
                current.setText(String.valueOf(currentAmt));
                checkPayment();
            }
        });

        R5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentAmt = currentAmt + 5;
                current.setText(String.valueOf(currentAmt));
                checkPayment();
            }
        });

        R10.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentAmt = currentAmt + 10;
                current.setText(String.valueOf(currentAmt));
                checkPayment();
            }
        }));



        reset_all.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetFunction();
            }
        });

    }

    public void initializer(){
        this.target = (TextView) findViewById(R.id.textViewTarget);
        this.current = (TextView) findViewById(R.id.textViewCurrent);

        R1=(Button)findViewById(R.id.buttonR1);
        R2= (Button)findViewById(R.id.buttonR2);
        R5=(Button)findViewById(R.id.buttonR5);
        R10= (Button)findViewById(R.id.buttonR10);

        reset_all = (Button)findViewById(R.id.buttonReset);

        view = (View)findViewById(R.id.screenActivity);

        //view=this.getWindow().getDecorView();
    }

    public void randomNumber(){
        //int rand = ((int) Math.random());
        rand = new Random().nextInt(200);
        targetAmt=rand;
        target.setText(String.valueOf(targetAmt));
    }



    public void resetFunction(){
        currentAmt = 0;
        current.setText(String.valueOf(currentAmt));

        if(success){
            newNumber();
        }
    }

    public void checkPayment(){
        if (currentAmt==targetAmt){
           // findViewById(R.id.)
            setBgGreen();
            Toast.makeText(this.getBaseContext(),"Amount paid successfully.",Toast.LENGTH_SHORT).show();
            Toast.makeText(this.getBaseContext(),"Reset to make another payment",Toast.LENGTH_SHORT).show();
            success=true;
        }
    }

    public void newNumber(){
        success=false;
        randomNumber();
        setBgBlue();
    }



    public void setBgBlue(){
        //this.getWindow().getDecorView().setBackgroundResource(R.color.BackgroundBlue);
        view.setBackgroundResource(R.color.BackgroundBlue);
        R1.setEnabled(true);
        R2.setEnabled(true);
        R5.setEnabled(true);
        R10.setEnabled(true);
    }

    public void setBgGreen(){
        //this.getWindow().getDecorView().setBackgroundResource(R.color.BackgroundGreen);
        view.setBackgroundResource(R.color.BackgroundGreen);
        R1.setEnabled(false);
        R2.setEnabled(false);
        R5.setEnabled(false);
        R10.setEnabled(false);

    }


}
