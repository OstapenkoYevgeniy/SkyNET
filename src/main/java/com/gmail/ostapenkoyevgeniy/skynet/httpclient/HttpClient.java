package com.gmail.ostapenkoyevgeniy.skynet.httpclient;

import android.util.Log;

import com.gmail.ostapenkoyevgeniy.skynet.support.AppConstant;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpClient {
    public static final String METHOD_GET = "GET";
    public static final String METHOD_POST = "POST";
    private String urlAPI;
    private String method;
    private String data;
    private boolean isExecute = false;

    public HttpClient(String url, String method) {
        this.urlAPI = url;
        this.method = method;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Response execute() throws HttpClientException {
        Log.d(AppConstant.LOG_TAG_DEBUG, "HttpClient -> execute() start.");
        if (!isExecute) {
            switch (method) {
                case METHOD_GET:
                    return executeGet();
                case METHOD_POST:
                    return executePost();
            }
            isExecute = true;
        }
        Log.d(AppConstant.LOG_TAG_DEBUG, "HttpClient -> execute() end.");
        return null;
    }

    private Response executePost() {
        Log.d(AppConstant.LOG_TAG_DEBUG, "HttpClient -> executePost() start.");
        Response response = new Response();
        HttpURLConnection conn;
        URL objUrl;
        try {
            objUrl = new URL(urlAPI);
            conn = (HttpURLConnection) objUrl.openConnection();
            conn.setRequestMethod(method);

            DataOutputStream wr = new DataOutputStream(conn.getOutputStream());
            wr.write(data.getBytes());
            wr.close();

            response.setResponseCode(conn.getResponseCode());
            response.setResponseMessage(conn.getResponseMessage());

            InputStream is = conn.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));

            response.setResponseBody(br.readLine());
            conn.disconnect();
        } catch (Exception e) {
            Log.e(AppConstant.LOG_TAG_ERROR, e.toString());
        }
        Log.d(AppConstant.LOG_TAG_DEBUG, "HttpClient -> executePost() end.");
        return response;
    }

    private Response executeGet() {
        Log.d(AppConstant.LOG_TAG_DEBUG, "HttpClient -> executeGet() start.");
        Response response = new Response();
        HttpURLConnection conn;
        URL objUrl;
        try {
            objUrl = new URL(urlAPI);
            conn = (HttpURLConnection) objUrl.openConnection();
            conn.setRequestMethod(method);

            response.setResponseCode(conn.getResponseCode());
            response.setResponseMessage(conn.getResponseMessage());

            InputStream is = conn.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));

            response.setResponseBody(br.readLine());
            conn.disconnect();
        } catch (Exception e) {
            Log.e(AppConstant.LOG_TAG_ERROR, e.toString());
        }
        Log.d(AppConstant.LOG_TAG_DEBUG, "HttpClient -> executeGet() end.");
        return response;
    }


}
