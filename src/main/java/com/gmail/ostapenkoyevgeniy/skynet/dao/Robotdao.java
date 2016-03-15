package com.gmail.ostapenkoyevgeniy.skynet.dao;

import android.util.Log;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gmail.ostapenkoyevgeniy.skynet.entity.Robot;
import com.gmail.ostapenkoyevgeniy.skynet.httpclient.HttpClient;
import com.gmail.ostapenkoyevgeniy.skynet.httpclient.HttpClientException;
import com.gmail.ostapenkoyevgeniy.skynet.httpclient.Response;
import com.gmail.ostapenkoyevgeniy.skynet.support.AppConstant;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class RobotDao implements Dao<Robot, Integer> {
    private final String URL_ADD = "http://frontend.test.pleaple.com/api/robots";
    private final String URL_GET_ALL = "http://frontend.test.pleaple.com/api/robots";

    @Override
    public boolean insert(Robot object) throws DaoException {
        Log.d(AppConstant.LOG_TAG_DEBUG, "RobotDao -> insert(Robot) start.");
        String json = ObjectToJson(object);
        HttpClient httpClient = new HttpClient(URL_ADD, HttpClient.METHOD_POST);
        httpClient.setData(json);
        try {
            Response response = httpClient.execute();
            if (response.getResponseCode() != 201) {
                return false;
            }
        } catch (HttpClientException e) {
            Log.e(AppConstant.LOG_TAG_ERROR, e.toString());
        }
        Log.d(AppConstant.LOG_TAG_DEBUG, "RobotDao -> insert(Robot) end.");
        return true;
    }

    @Override
    public int update(Robot object) throws DaoException {
        return 0;
    }

    @Override
    public int delete(Robot object) throws DaoException {
        return 0;
    }

    @Override
    public Robot getByPK(Integer key) throws DaoException {
        return null;
    }

    @Override
    public Robot getByColumn(String column, String value) throws DaoException {
        return null;
    }

    @Override
    public List<Robot> getAll() throws DaoException {
        Log.d(AppConstant.LOG_TAG_DEBUG, "RobotDao -> getAll() start.");
        HttpClient httpClient = new HttpClient(URL_GET_ALL, HttpClient.METHOD_GET);
        try {
            Response response = httpClient.execute();
            Log.d(AppConstant.LOG_TAG_DEBUG, String.valueOf(response.getResponseCode()));
            if (response.getResponseCode() == 200) {
                return JsonToRobots(response.getResponseBody());
            }
        } catch (HttpClientException e) {
            Log.e(AppConstant.LOG_TAG_ERROR, e.toString());
        }
        Log.d(AppConstant.LOG_TAG_DEBUG, "RobotDao -> getAll() end.");
        return null;
    }


    private List<Robot> JsonToRobots(String json) {
        ObjectMapper mapper = new ObjectMapper();
        Robot[] robots = null;
        try {
            mapper.readValue(json, Robot.class);
            robots = mapper.readValue(json, Robot[].class);
            Log.d(AppConstant.LOG_TAG_DEBUG, String.valueOf(robots.length));
        } catch (IOException e) {
            Log.e(AppConstant.LOG_TAG_ERROR, e.toString());
        }

        List<Robot> result = new ArrayList<>();
        for (Robot robot : robots) {
            result.add(robot);
        }
        return result;
    }

    private String ObjectToJson(Robot robot) throws DaoException {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ObjectMapper mapper = new ObjectMapper();
        try {
            mapper.writeValue(outputStream, robot);
        } catch (IOException e) {
            throw new DaoException(e);
        }
        return new String(outputStream.toByteArray());
    }
}
