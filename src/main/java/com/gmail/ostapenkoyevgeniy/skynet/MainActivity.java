package com.gmail.ostapenkoyevgeniy.skynet;

import android.app.DialogFragment;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.gmail.ostapenkoyevgeniy.skynet.dialog.AddRobotDialog;

public class MainActivity extends AppCompatActivity {
    private DialogFragment dlgAddRobot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dlgAddRobot = new AddRobotDialog();
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.add_robot:
                dlgAddRobot.show(getFragmentManager(), "dlgAddRobot");
                break;
            default:
                break;
        }
    }
}
