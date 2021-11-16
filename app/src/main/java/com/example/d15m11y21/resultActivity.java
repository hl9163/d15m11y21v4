package com.example.d15m11y21;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * @author		Harel Leibovich <address @ example.com>
 * @version	1.0 (current version number of program)
 * @since		16/11/2021 (the date of the package the class was added)
 * second | result activity
 */

public class resultActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{
    static String []st1= new String[20];
    static double [] series = new double[20];
    ListView lv;
    TextView indexTv, tv2;
    double jumps,sum,firstNum;
    int mode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        lv = (ListView) findViewById(R.id.list);
        indexTv = (TextView) findViewById(R.id.textViewIndex);
        tv2 = (TextView) findViewById(R.id.info);



        Intent gi = getIntent();
        mode = gi.getIntExtra("mode",-1);
        jumps = gi.getDoubleExtra("sirMove",0);
        firstNum = gi.getDoubleExtra("firstNum",0);
        tv2.setText("X1="+firstNum+", d="+ jumps);


        if (mode == 0){
            ArithmeticSeries(firstNum, jumps);
        }else if (mode == 1){
            GP(firstNum, jumps);
        }

        lv.setOnItemClickListener(this);
        lv.setChoiceMode(ListView.CHOICE_MODE_SINGLE);

        ArrayAdapter <String>adp = new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,st1);
        lv.setAdapter(adp);
    }

    /**
     * Description create a new String and double arrays of Arithmetic series by the first number and the jumps.
     * <p>
     *
     * @param	first Description	first number in the series.
     * @param	d Description	jumps of the series.
     */
    public static void ArithmeticSeries(double first, double d){
        for (int i =0;i<20;i++){
            double n = first+(i)*d;
            series[i] = n;
            st1[i] = String.valueOf(n);
        }
    }

    /**
     * Description create a new String and double arrays of Geometric series by the first number and the jumps.
     * <p>
     *
     * @param	first Description	first number in the series.
     * @param	d Description	jumps of the series.
     */
    public static void GP(double first, double d){
        for (int i =0;i<20;i++){
            double n = first*Math.pow(d,i);
            series[i] = n;
            st1[i] = String.valueOf(n);
        }
    }

    /**
     * make the sum of all numbers from the first place to number in place n .
     * <p>
     *
     * @param	n Description	place in the list.
     * @return	Description			sum of all numbers from the first place to number in place n .
     */
    static double sumOfSeries(int n) {
        double sum = 0;
        for (int i = 0; i < n; i++) {
            sum = sum + series[i];
        }
        return sum;

    }

    /**
     * play all the things that connecting to the list.
     * <p>
     *
     */
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        sum = sumOfSeries(position+1);
        String massage = "place: "+(id+1)+" sum: "+sum;
        indexTv.setText(massage);


    }

    /**
     * return to the first activity.
     * <p>
     *
     */
    public void ret(View view) {
        finish();
    }
}