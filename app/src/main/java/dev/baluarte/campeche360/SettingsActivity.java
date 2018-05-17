package dev.baluarte.campeche360;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Switch;

import dev.baluarte.campeche360.R;

public class SettingsActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        initSett();
    }

    private void initSett() {

        LinearLayout lMyInfo = findViewById(R.id.my_info);
        lMyInfo.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {


        switch (view.getId()) {
            case R.id.my_info:
                Intent intent = new Intent(SettingsActivity.this, MyInfoActivity.class);
                startActivity(intent);
                break;
        }

    }
}