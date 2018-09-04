package com.skyapps.akash.calculator;

import android.app.Activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.widget.Button;
import android.widget.EditText;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity  {
    EditText text;
    Button b1, b2, b3, b4, b5, b6, b7, b8, b9, b0, beq, bdot, badd, bsub, bdiv, bmul, bclr,bbck,bbo,bbc,bp,bhist,bl,br;
    String st=new String(),s=new String();
    int   cursor_pos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        text = (EditText) findViewById(R.id.text1);
        bclr = (Button) findViewById(R.id.buttonclr);
        bbck = (Button) findViewById(R.id.buttonback);
        b1 = (Button) findViewById(R.id.button1);
        b2 = (Button) findViewById(R.id.button2);
        b3 = (Button) findViewById(R.id.button3);
        b4 = (Button) findViewById(R.id.button4);
        b5 = (Button) findViewById(R.id.button5);
        b6 = (Button) findViewById(R.id.button6);
        b7 = (Button) findViewById(R.id.button7);
        b8 = (Button) findViewById(R.id.button8);
        b9 = (Button) findViewById(R.id.button9);
        b0 = (Button) findViewById(R.id.button0);
        badd = (Button) findViewById(R.id.buttonplus);
        bsub = (Button) findViewById(R.id.buttonminus);
        bdiv = (Button) findViewById(R.id.buttondivide);
        bmul = (Button) findViewById(R.id.buttonmultiply);
        beq = (Button) findViewById(R.id.buttonequal);
        bdot = (Button) findViewById(R.id.buttondot);
        bbo = (Button) findViewById(R.id.button_brac_open);
        bbc = (Button) findViewById(R.id.button_brac_close);
        bp = (Button) findViewById(R.id.buttonpow);
        bhist= (Button) findViewById(R.id.buttonhist);
        bl= (Button) findViewById(R.id.buttonleft);
        br= (Button) findViewById(R.id.buttonright);
        text.setOnTouchListener(new View.OnTouchListener(){
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                int inType = text.getInputType(); // backup the input type
                text.setInputType(InputType.TYPE_NULL); // disable soft input
                text.onTouchEvent(event); // call native handler
                text.setInputType(inType); // restore input type
                text.setFocusable(true);
                return true; // consume touch even
            }
        });
        b1.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View view) {
                s = s + "1";
                text.setText(s);

            }

        });
        b2.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View view) {
                s = s + "2";
                text.setText(s);
            }

        });
        b3.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View view) {
                s = s + "3";
                text.setText(s);
            }

        });
        b4.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View view) {
                s = s + "4";
                text.setText(s);
            }

        });
        b5.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View view) {
                s = s + "5";
                text.setText(s);
            }

        });
        b6.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View view) {
                s = s + "6";
                text.setText(s);
            }

        });
        b7.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View view) {
                s = s + "7";
                text.setText(s);
            }

        });
        b8.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View view) {
                s = s + "8";
                text.setText(s);
            }

        });
        b9.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View view) {
                s = s + "9";
                text.setText(s);
            }

        });
        b0.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View view) {
                s = s + "0";
                text.setText(s);
            }

        });
        badd.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View view) {
                s = s + "+";
                text.setText(s);
            }

        });
        bsub.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View view) {
                s = s + "-";
                text.setText(s);
            }

        });
        bmul.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View view) {
                s = s + "*";
                text.setText(s);
            }

        });
        bdiv.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View view) {
                s = s + "/";
                text.setText(s);
            }

        });
        bdot.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View view) {
                s = s + ".";
                text.setText(s);
            }

        });
        bclr.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View view) {
                s=new String();
                text.setText(s);
            }

        });
        bbck.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View view) {
                if(s.length()>0)
                s = s.substring(0,s.length()-1);
                text.setText(s);
            }

        });
        beq.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View view) {
                String str=s;
                    s = cal(s);
                text.setText(s);
                str=str+" = "+s+"\n";
                DatabaseHandle db = new DatabaseHandle(getApplicationContext());
                db.insertLabel(str);

            }

        });
        bbc.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View view) {
                s = s+")";
                text.setText(s);

            }

        });
        bbo.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View view) {
                s = s+"(";
                text.setText(s);

            }

        });
        bp.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View view) {
                s = s+"^";
                text.setText(s);

            }

        });
        bhist.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View view) {
               Intent i=new Intent(getApplicationContext(),hist.class);
                startActivity(i);

            }

        });
        bl.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View view) {


            }

        });
        br.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View view) {


            }

        });

    }
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            exitByBackKey();

            //moveTaskToBack(false);

            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    protected void exitByBackKey() {

        AlertDialog alertbox = new AlertDialog.Builder(this)
                .setMessage("Do you want to exit application?")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {

                    // do something when the button is clicked
                    public void onClick(DialogInterface arg0, int arg1) {

                        finish();
                        //close();


                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {

                    // do something when the button is clicked
                    public void onClick(DialogInterface arg0, int arg1) {
                    }
                })
                .show();

    }

    public String cal(String s)
    {
        char o[]={'(','^','/','*','+'};
        double sum=0;String r=new String();
        int ca=0,cs=0;
        if(s.charAt(0)!='+')s="+"+s; s=s+" ";
        int j=0;
        while(j<s.length())
        {
            if(s.charAt(j)=='-'&&s.charAt(j-1)!='+'&&s.charAt(j-1)!='*'&&s.charAt(j-1)!='/'&&s.charAt(j-1)!='^')
            {
                s=s.substring(0,j)+"+"+s.substring(j,s.length());
                j=j+2;
            }
            else if(s.charAt(j)=='('&&s.charAt(j-1)=='-')
            {
                s=s.substring(0,j)+"1*"+s.substring(j,s.length());
                j=j+1;
            }
            else
                j++;
        }
        String e=new String();
        String strg=new String();
        for(int k=0;k<o.length;k++)
        {
            for(int i=0;i<s.length();i++)
            {
                int l=s.length();
                char c=s.charAt(i);
                double t=0;String str=new String();
                if(o[k]==c&&o[k]=='(')
                {
                    int b=s.lastIndexOf(c);int p=0;
                    for(p=b;p<s.length();p++)
                    {
                        if(s.charAt(p)==')')
                            break;
                    }
                    e=s.substring(b+1,p);
                    strg=cal(e);
                    s=s.substring(0,b)+strg+s.substring(p+1,l);
                    i=0;
                }
                if(o[k]==c&&(o[k]=='^'||o[k]=='/'||o[k]=='*'))
                {
                    int a=0;
                    for( a=i-2;a>=0;a--)
                    {
                        if(s.charAt(a)=='+'||s.charAt(a)=='*'||s.charAt(a)=='/'||s.charAt(a)==' ')
                            break;
                    }
                    String v=s.substring(a+1,i);
                    int b=0;
                    for( b=i+2;b>=0;b++)
                    {
                        if(s.charAt(b)=='+'||s.charAt(b)=='*'||s.charAt(b)=='/'||s.charAt(b)==' ')
                            break;
                    }
                    String w=s.substring(i+1,b);
                    double p=Double.parseDouble(v);
                    double q=Double.parseDouble(w);
                    if(c=='^')
                    {
                        t=Math.pow(p,q);
                        str=Double.toString(t);
                        s=s.substring(0,a+1)+str+s.substring(b,l);
                    }
                    if(c=='/')
                    {
                        t=p/q;
                        str=Double.toString(t);
                        s=s.substring(0,a+1)+str+s.substring(b,l);
                    }
                    else if(c=='*')
                    {
                        t=p*q;
                        str=Double.toString(t);
                        s=s.substring(0,a+1)+str+s.substring(b,l);
                    }
                    i=0;c=0;st=st+s;
                }
                if(o[k]==c&&o[k]=='+')
                {
                    int b=0;
                    for( b=i+2;b>=0;b++)
                    {
                        if(s.charAt(b)=='+'||s.charAt(b)==' ')
                            break;
                    }
                    String w=s.substring(i+1,b);
                    double q=Double.parseDouble(w);
                    if(c=='+')
                    {
                        ca++;
                        sum=sum+q;
                    }
                }
            }
        }
        if(ca>0)
        {
            r=Double.toString(sum);
            st=st+r;return r;
        }
        else return s;
    }


}
