package com.gmail.ostapenkoyevgeniy.skynet;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.gmail.ostapenkoyevgeniy.skynet.adapter.RobotAdapter;
import com.gmail.ostapenkoyevgeniy.skynet.asynctask.GetAllRobotsAsyncTask;
import com.gmail.ostapenkoyevgeniy.skynet.entity.Robot;

import java.util.List;

public class AllRobotActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_robot);

        mRecyclerView = (RecyclerView) findViewById(R.id.rvAllRobots);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        GetAllRobotsAsyncTask getRobots = new GetAllRobotsAsyncTask(this);
        getRobots.execute();
    }

    public void addRobots(List<Robot> robots) {
        mRecyclerView.setAdapter(new RobotAdapter(robots));
    }
}
