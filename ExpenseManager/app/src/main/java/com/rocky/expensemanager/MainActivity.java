package com.rocky.expensemanager;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    int expenses=0;
    TextView currentExpense;
    int year,month,day;
    String key;
    SharedPreferences s;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Calendar c=Calendar.getInstance();
         year=c.get(Calendar.YEAR);
         month=c.get(Calendar.MONTH);
         day=c.get(Calendar.DAY_OF_MONTH);
        key=day+"/"+month+"/"+year;
        currentExpense=(TextView)findViewById(R.id.current_expense);
         s=getSharedPreferences("Myfile", Context.MODE_PRIVATE);
        expenses=s.getInt(key,0);
        currentExpense.setText("Today's Expenses : "+String.valueOf(expenses));
    }
    public void showDate(View vieew){
        DialogFragment f=new DatePickerFragment();
        f.show(getSupportFragmentManager(),"datefragment");
    }
    public void addExpense(View view){
    DialogFragment f=new addExpenseFragment();
        f.show(getSupportFragmentManager(),"fragment");
    }
    public void value(int n){
        Toast.makeText(this,"you gave value "+n,Toast.LENGTH_LONG).show();
        s=getSharedPreferences("Myfile", Context.MODE_PRIVATE);
        SharedPreferences.Editor e=s.edit();
        int f=s.getInt(key,0)+n;
        e.putInt(key,f);
        e.commit();
        expenses=s.getInt(key,0);
        currentExpense.setText("Today's Expenses "+String.valueOf(expenses));
    }
    public void showExpense(String key){
        s=getSharedPreferences("Myfile", Context.MODE_PRIVATE);
        int n=s.getInt(key,0);
        String s="Total Expense on "+key+" was : "+String.valueOf(n);
        TextView t=(TextView)findViewById(R.id.show_expense);
        t.setText(s);
    }
}
