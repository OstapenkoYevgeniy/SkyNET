package com.gmail.ostapenkoyevgeniy.skynet;

import android.app.DialogFragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.gmail.ostapenkoyevgeniy.skynet.dialog.AddRobotDialog;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.add_robot:
                DialogFragment dlgAddRobot;
                dlgAddRobot = new AddRobotDialog();
                dlgAddRobot.show(getFragmentManager(), "dlgAddRobot");
                break;
            case R.id.get_robots:
                Intent intent = new Intent(MainActivity.this, AllRobotActivity.class);
                startActivity(intent);
            default:
                break;
        }
    }
}
