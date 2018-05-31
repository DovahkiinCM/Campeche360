package dev.baluarte.campeche360;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.NumberPicker;
import android.widget.TextView;

import java.util.ArrayList;

public class FiliacionActivity extends AppCompatActivity implements NumberPicker.OnValueChangeListener, View.OnClickListener {


        private TextView tv;
        static Dialog d ;

    ArrayAdapter<CharSequence> adapter;
    ListView listView1;
    protected Button selectReceiversBtn;
    protected CharSequence[] receivers = {
            "Ecoturismo", "Playas", "Zonas arqueológicas", "Cenotes", "Sitios de Fé", "Restaurantes"};
    protected ArrayList<CharSequence> selectedReceivers = new ArrayList<>();

        @Override
        public void onCreate(Bundle savedInstanceState)
        {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_filiacion);
            tv = (TextView) findViewById(R.id.textView1);
            Button b = (Button) findViewById(R.id.button11);
            b.setOnClickListener(new View.OnClickListener()
            {

                @Override
                public void onClick(View v) {
                    showAge();
                }
            });

            selectReceiversBtn = (Button) findViewById(R.id.select_receivers);
            selectReceiversBtn.setOnClickListener((View.OnClickListener) this);


            adapter = new ArrayAdapter<CharSequence>(this,
                    android.R.layout.simple_list_item_multiple_choice, selectedReceivers);

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
        np.setMaxValue(65);
        np.setMinValue(18);
        np.setWrapSelectorWheel(false);
        np.setOnValueChangedListener(this);
        b1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                tv.setText(String.valueOf(np.getValue()));
                d.dismiss();
            }
        });
        b2.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                d.dismiss();             }
        });
        d.show();


    }


    @Override
    public void onClick(View view) {
        switch(view.getId()) {
            case R.id.select_receivers:
                showSelectReceiversDialog();
                break;
            default:
                break;
        }
        }

    protected void onChangeSelectedReceivers() {
        StringBuilder stringBuilder = new StringBuilder();

        for(CharSequence receivers : selectedReceivers)
            stringBuilder.append(receivers + ",");
        adapter.notifyDataSetChanged();
    }

    protected void showSelectReceiversDialog() {
        boolean[] checkedReceivers = new boolean[receivers.length];
        int count = receivers.length;

        for(int i = 0; i < count; i++)
            checkedReceivers[i] = selectedReceivers.contains(receivers[i]);

        DialogInterface.OnMultiChoiceClickListener receiversDialogListener = new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                if(isChecked)
                    selectedReceivers.add(receivers[which]);
                else
                    selectedReceivers.remove(receivers[which]);

                onChangeSelectedReceivers();
            }
        };

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder
                .setTitle("Select Receivers")
                .setMultiChoiceItems(receivers, checkedReceivers, receiversDialogListener)
                .setCancelable(false)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.dismiss();

                    }
                });
        AlertDialog dialog = builder.create();
        dialog.show();
    }
}