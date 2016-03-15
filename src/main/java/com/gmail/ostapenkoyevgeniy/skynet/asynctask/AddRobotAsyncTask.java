package com.gmail.ostapenkoyevgeniy.skynet.asynctask;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.gmail.ostapenkoyevgeniy.skynet.dao.Dao;
import com.gmail.ostapenkoyevgeniy.skynet.dao.DaoException;
import com.gmail.ostapenkoyevgeniy.skynet.dao.RobotDao;
import com.gmail.ostapenkoyevgeniy.skynet.entity.Robot;
import com.gmail.ostapenkoyevgeniy.skynet.support.AppConstant;

public class AddRobotAsyncTask extends AbstractAsyncTask<Robot,Void,Void> {
    public AddRobotAsyncTask(Context context) {
        super(context);
    }

    @Override
    protected Void doInBackground(Robot... params) {
        Log.d(AppConstant.LOG_TAG_DEBUG, "AddRobotAsyncTask -> doInBackground(Robot...) start.");
        Dao<Robot, Integer> robotDao = new RobotDao();
        try {
            if (robotDao.insert(params[0])) {
                isSuccessful = true;
            }
        } catch (DaoException e) {
            Log.d(AppConstant.LOG_TAG_ERROR, e.toString());
        }
        Log.d(AppConstant.LOG_TAG_DEBUG, "AddRobotAsyncTask -> doInBackground(Robot...) end.");
        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        Log.d(AppConstant.LOG_TAG_DEBUG, "AddRobotAsyncTask -> onPostExecute(Void) start.");
        if (isSuccessful) {
            Toast.makeText(context, "Робот успешно добавлен!", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(context, "Произошла ошибка, попробуйте позднее!", Toast.LENGTH_LONG).show();
        }
        Log.d(AppConstant.LOG_TAG_DEBUG, "AddRobotAsyncTask -> onPostExecute(Void) end.");
    }
}
