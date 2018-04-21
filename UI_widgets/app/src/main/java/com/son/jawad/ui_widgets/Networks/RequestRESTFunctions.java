package com.son.jawad.ui_widgets.Networks;

import android.graphics.Bitmap;
import android.util.Log;
import android.util.Pair;

import com.google.gson.Gson;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Types;
import java.util.List;

/**
 * Created by Adhamkh on 2017-09-02.
 */

public class RequestRESTFunctions<T> {

    private Class<T> t;


    public RequestRESTFunctions(Class<T> tClass) {
        t = tClass;
    }


    public UrlResponse<T> GetRequest(String url, int timeout, List<Pair<String, String>> Properties) {
        HttpURLConnection c = null;
        UrlResponse<T> urlResponse;
        try {
            URL u = new URL(url);
            c = (HttpURLConnection) u.openConnection();
            c.setInstanceFollowRedirects(false);
            c.setRequestMethod("GET");
            c.setRequestProperty("charset", "utf-8");
            c.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            if (Properties != null) {
                for (Pair<String, String> pair : Properties) {
                    c.setRequestProperty(pair.first, pair.second);
                }
            }
            c.setUseCaches(false);
            c.setAllowUserInteraction(false);
            c.setConnectTimeout(timeout);
            c.setReadTimeout(timeout);
            c.connect();

            int status = c.getResponseCode();
            switch (status) {
                case 200:
                case 201:
                    BufferedReader br = new BufferedReader(new InputStreamReader(c.getInputStream(), "UTF-8"));
                    StringBuilder sb = new StringBuilder();
                    String line;
                    while ((line = br.readLine()) != null) {
                        sb.append(line + "\n");
                    }
                    br.close();
                    try {
                        String s = sb.toString();
                        return new UrlResponse<T>(parseResult(s, t), new ResponseMessage(ResponseState.RESPONSE_SUCCESS));
                    } catch (Exception e) {
                        urlResponse = new UrlResponse<T>(null, new ResponseMessage(ResponseState.RESPONSE_PARSEERROR));
                    }
                case 500:
                case 400:
                    urlResponse = new UrlResponse<T>(null, new ResponseMessage(ResponseState.RESPONSE_SERVERERROR));
                default:
                    urlResponse = new UrlResponse<T>(null, new ResponseMessage(ResponseState.RESPONSE_SERVERERROR));
            }
        } catch (MalformedURLException ex) {
            urlResponse = new UrlResponse<T>(null, new ResponseMessage(ResponseState.RESPONSE_ERRORCONNECTION));
        } catch (IOException ex) {
            urlResponse = new UrlResponse<T>(null, new ResponseMessage(ResponseState.RESPONSE_ERRORCONNECTION));
        } catch (Exception ex) {
            urlResponse = new UrlResponse<T>(null, new ResponseMessage(ResponseState.RESPONSE_ERRORCONNECTION));
        } finally {
            if (c != null) {
                try {
                    c.disconnect();

                } catch (Exception ex) {
                    urlResponse = new UrlResponse<T>(null, new ResponseMessage(ResponseState.RESPONSE_ERRORCONNECTION));
                }
            }
        }
        return urlResponse;
    }

    public UrlResponse<T> PostRequest(String url, Object postobject, List<Pair<String, String>> Properties, int timeout) {
        return PostRequest(url, SerializeObject(postobject), Properties, timeout);
    }

    public UrlResponse<T> PostRequest(String url, String jObject, List<Pair<String, String>> Properties, int timeout) {
        HttpURLConnection c = null;

        try {
            URL u = new URL(url);
            c = (HttpURLConnection) u.openConnection();
            c.setConnectTimeout(timeout);
            c.setReadTimeout(timeout);
            c.setRequestMethod("POST");
            c.setRequestProperty("charset", "utf-8");
            if (Properties != null) {
                for (Pair<String, String> pair : Properties) {
                    c.setRequestProperty(pair.first, pair.second);
                }
            }
            c.setRequestProperty("Content-Type", "application/json");
            DataOutputStream localDataOutputStream = new DataOutputStream(c.getOutputStream());
            localDataOutputStream.writeBytes(jObject);
            localDataOutputStream.flush();
            localDataOutputStream.close();

            //c.connect();
            int status = c.getResponseCode();
            switch (status) {
                case 200:
                case 201:
                    BufferedReader br = new BufferedReader(new InputStreamReader(c.getInputStream(), "UTF-8"));
                    StringBuilder sb = new StringBuilder();
                    String line;
                    while ((line = br.readLine()) != null) {
                        sb.append(line + "\n");
                    }
                    br.close();
                    try {
                        return new UrlResponse<T>(parseResult(sb.toString(), t), new ResponseMessage(ResponseState.RESPONSE_SUCCESS));
                    } catch (Exception e) {
                        return new UrlResponse<T>(null, new ResponseMessage(ResponseState.RESPONSE_PARSEERROR));
                    }
                case 400:
                case 500:
                    BufferedReader br1 = new BufferedReader(new InputStreamReader(c.getErrorStream(), "UTF-8"));
                    StringBuilder sb1 = new StringBuilder();
                    String line1;
                    while ((line1 = br1.readLine()) != null) {
                        sb1.append(line1 + "\n");
                    }
                    br1.close();
                    return new UrlResponse<T>(null, new ResponseMessage(br1.toString(), ResponseState.RESPONSE_SERVERERROR));
            }
        } catch (MalformedURLException ex) {
            return new UrlResponse<T>(null, new ResponseMessage(ex.getMessage(), ResponseState.RESPONSE_ERRORCONNECTION));
        } catch (IOException ex) {
            return new UrlResponse<T>(null, new ResponseMessage(ex.getMessage(), ResponseState.RESPONSE_ERRORCONNECTION));
        } catch (Exception ex) {
            return new UrlResponse<T>(null, new ResponseMessage(ex.getMessage(), ResponseState.RESPONSE_ERRORCONNECTION));
        } finally {
            if (c != null) {
                try {
                    c.disconnect();
                } catch (Exception ex) {
                    return new UrlResponse<T>(null, new ResponseMessage(ex.getMessage(), ResponseState.RESPONSE_ERRORCONNECTION));
                }
            }
        }
        return new UrlResponse<T>(null, new ResponseMessage(ResponseState.RESPONSE_ERRORCONNECTION));
    }

    public UrlResponse<T> UploadImage(String upLoadServerUri, Bitmap bitmap) {
        //HttpURLConnection conn = null;
        DataOutputStream dos = null;
        String lineEnd = "\r\n";
        String twoHyphens = "--";
        String boundary = "*****";
        int bytesRead, bytesAvailable, bufferSize;
        byte[] buffer;
        int maxBufferSize = 1024 * 1024;
        String attachmentName = "bitmap";
        String attachmentFileName = "bitmap.bmp";
        String crlf = "\r\n";

        try {
            HttpURLConnection httpUrlConnection = null;
            URL url = new URL(upLoadServerUri);
            httpUrlConnection = (HttpURLConnection) url.openConnection();
            httpUrlConnection.setUseCaches(false);
            httpUrlConnection.setDoOutput(true);

            httpUrlConnection.setRequestMethod("POST");
            httpUrlConnection.setRequestProperty("Connection", "Keep-Alive");
            httpUrlConnection.setRequestProperty("User-Agent", "Android Multipart HTTP Client 1.0");
            httpUrlConnection.setRequestProperty("Cache-Control", "no-cache");
            httpUrlConnection.setRequestProperty(
                    "Content-Type", "multipart/form-data;boundary=" + boundary);


            DataOutputStream request = new DataOutputStream(
                    httpUrlConnection.getOutputStream());
            request.writeBytes(twoHyphens + boundary + crlf);
            request.writeBytes("Content-Disposition: form-data; name=\"" + attachmentName + "\";filename=\"" +
                    attachmentFileName + "\"" + lineEnd);
            request.writeBytes("Content-Type: image/png" + lineEnd);
            request.writeBytes("Content-Transfer-Encoding: binary" + lineEnd);
            request.writeBytes(lineEnd);

            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.PNG, 0 /*ignored for PNG*/, bos);
            byte[] pixels = bos.toByteArray();
            request.write(pixels);
            request.writeBytes(lineEnd);
            request.writeBytes(twoHyphens + boundary + twoHyphens + lineEnd);

            InputStream responseStream = new
                    BufferedInputStream(httpUrlConnection.getInputStream());

            BufferedReader responseStreamReader =
                    new BufferedReader(new InputStreamReader(responseStream));

            String line = "";
            StringBuilder stringBuilder = new StringBuilder();

            while ((line = responseStreamReader.readLine()) != null) {
                stringBuilder.append(line).append("\n");
            }
            responseStreamReader.close();

            String response = stringBuilder.toString();
            request.flush();
            request.close();

            responseStream.close();
            httpUrlConnection.disconnect();
            return new UrlResponse<T>(parseResult(response,t), new ResponseMessage(ResponseState.RESPONSE_SUCCESS));
        } catch (Exception ex) {


        } finally {

        }
        return new UrlResponse<T>(null, new ResponseMessage(ResponseState.RESPONSE_ERRORCONNECTION));
    }

    public T parseResult(String gsonstring, Class<T> tp) {
        Gson gson = new Gson();
        String classname = tp.getName();
        return gson.fromJson(gsonstring, tp);
    }

    public String SerializeObject(Object postobject) {
        return new Gson().toJson(postobject);
    }

}
