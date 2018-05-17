package dev.baluarte.campeche360;

import android.app.Dialog;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.TextView;

public class FiliacionActivity extends AppCompatActivity implements NumberPicker.OnValueChangeListener {


        private TextView tv;
        static Dialog d ;

        @Override
        public void onCreate(Bundle savedInstanceState)
        {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_filiacion);
            tv = (TextView) findViewById(R.id.textView1);
            Button b = (Button) findViewById(R.id.button11);// on click of button display the dialog
            b.setOnClickListener(new View.OnClickListener()
            {

                @Override
                public void onClick(View v) {
                    showAge();
                }
            });
        }
        @Override
        public void onValueChange(NumberPicker picker, int oldVal, int newVal) {

        Log.i("Su edad es",""+newVal);

    }

    public void showAge()
    {

        final Dialog d = new Dialog(FiliacionActivity.this);
        d.setTitle("NumberPicker");
        d.setContentView(R.layout.age_dialog);
        Button b1 = (Button) d.findViewById(R.id.button1);
        Button b2 = (Button) d.findViewById(R.id.button2);
        final NumberPicker np = (NumberPicker) d.findViewById(R.id.numberPicker1);
        np.setMaxValue(65); // max value 100
        np.setMinValue(18);   // min value 0
        np.setWrapSelectorWheel(false);
        np.setOnValueChangedListener(this);
        b1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                tv.setText(String.valueOf(np.getValue())); //set the value to textview
                d.dismiss();
            }
        });
        b2.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                d.dismiss(); // dismiss the dialog
            }
        });
        d.show();


    }

    public void showStay()
    {

        final Dialog d = new Dialog(FiliacionActivity.this);
        d.setTitle("NumberPicker");
        d.setContentView(R.layout.age_dialog);
        Button b1 = (Button) d.findViewById(R.id.button1);
        Button b2 = (Button) d.findViewById(R.id.button2);
        final NumberPicker np = (NumberPicker) d.findViewById(R.id.numberPicker1);
        np.setMaxValue(65); // max value 100
        np.setMinValue(18);   // min value 0
        np.setWrapSelectorWheel(false);
        np.setOnValueChangedListener(this);
        b1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                tv.setText(String.valueOf(np.getValue())); //set the value to textview
                d.dismiss();
            }
        });
        b2.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                d.dismiss(); // dismiss the dialog
            }
        });
        d.show();


    }

}
