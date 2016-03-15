package com.gmail.ostapenkoyevgeniy.skynet.asynctask;

import android.content.Context;
import android.util.Log;

import com.gmail.ostapenkoyevgeniy.skynet.AllRobotActivity;
import com.gmail.ostapenkoyevgeniy.skynet.dao.Dao;
import com.gmail.ostapenkoyevgeniy.skynet.dao.DaoException;
import com.gmail.ostapenkoyevgeniy.skynet.dao.RobotDao;
import com.gmail.ostapenkoyevgeniy.skynet.entity.Robot;
import com.gmail.ostapenkoyevgeniy.skynet.support.AppConstant;

import java.util.List;

public class GetAllRobotsAsyncTask extends AbstractAsyncTask<Void, Void, Void> {

    public GetAllRobotsAsyncTask(Context context) {
        super(context);
    }

    @Override
    protected Void doInBackground(Void... voids) {
        Log.d(AppConstant.LOG_TAG_DEBUG, "AddRobotAsyncTask -> doInBackground(Robot...) start.");
        Dao<Robot, Integer> robotDao = new RobotDao();
        List<Robot> robots = null;
        try {
            robots = robotDao.getAll();
            Log.d(AppConstant.LOG_TAG_DEBUG, robots.toString());
         } catch (DaoException e) {
            Log.d(AppConstant.LOG_TAG_ERROR, e.toString());
        }

        AllRobotActivity allRobotActivity = (AllRobotActivity) context;
        allRobotActivity.addRobots(robots);
        Log.d(AppConstant.LOG_TAG_DEBUG, "AddRobotAsyncTask -> doInBackground(Robot...) end.");
        return null;
    }

}
