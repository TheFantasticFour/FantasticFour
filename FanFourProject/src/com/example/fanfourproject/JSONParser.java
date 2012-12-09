package com.example.fanfourproject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONException;
import org.json.JSONObject;

import android.util.Log;

public class JSONParser {

	static InputStream is = null;
	static JSONObject jObj = null;
	static String json = "";

	// constructor
	public JSONParser() {

	}

	// function get json from url
	// by making HTTP POST or GET mehtod
	public JSONObject makeHttpRequest(String url, String method,
			List<NameValuePair> params) {
		//System.out.println("url: " + url);
		//System.out.println("method: " + method);
		//System.out.println("params: " + params);

		// Making HTTP request
		try {
			
			// check for request method
			if(method == "POST"){
				// request method is POST
				// defaultHttpClient
				DefaultHttpClient httpClient = new DefaultHttpClient();
					//System.out.println("httpClient: " + httpClient);
				HttpPost httpPost = new HttpPost(url);
					//System.out.println("httpPost: " + httpPost);
				httpPost.setEntity(new UrlEncodedFormEntity(params));
					//System.out.println("httpPost: " + httpPost);

				HttpResponse httpResponse = httpClient.execute(httpPost);
					//System.out.println("httpResponse: " + httpResponse);
					//System.out.println(httpResponse.getEntity().getContentLength());
				HttpEntity httpEntity = httpResponse.getEntity();
					//System.out.println("httpEntity: " + httpEntity);
				is = httpEntity.getContent();
				
			}else if(method == "GET"){
				// request method is GET
				DefaultHttpClient httpClient = new DefaultHttpClient();
				String paramString = URLEncodedUtils.format(params, "utf-8");
				url += "?" + paramString;
				HttpGet httpGet = new HttpGet(url);

				HttpResponse httpResponse = httpClient.execute(httpGet);
				HttpEntity httpEntity = httpResponse.getEntity();
				is = httpEntity.getContent();
			}			
			

		} catch (UnsupportedEncodingException e) {
			System.out.println("HERE:E1");
			e.printStackTrace();
			System.out.println("HERE:E2");
		} catch (ClientProtocolException e) {
			System.out.println("HERE:F1");
			e.printStackTrace();
			System.out.println("HERE:F2");
		} catch (IOException e) {
			System.out.println("HERE:G1");
			e.printStackTrace();
			System.out.println("HERE:G2");
		} catch(Exception e){
			System.out.println("HERE:Z1");
			e.printStackTrace();
			System.out.println("HERE:Z2");
		}

		try {
			//System.out.println("is: " + is);
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					is, "iso-8859-1"), 8);
			//System.out.println("reader: " + reader);
			StringBuilder sb = new StringBuilder();
			String line = null;
			//System.out.println("reader.readLine(): " + reader.readLine());
			while ((line = reader.readLine()) != null) {
				sb.append(line + "\n");
			}
			is.close();
			json = sb.toString();
			//System.out.println("json: " + json);
		} catch (Exception e) {
			System.out.println("HERE:H1");
			Log.e("Buffer Error", "Error converting result " + e.toString());
			System.out.println("HERE:H2");
		}

		// try parse the string to a JSON object
		try {
			jObj = new JSONObject(json);
		} catch (JSONException e) {
			System.out.println("HERE:I1");
			Log.e("JSON Parser", "Error parsing data " + e.toString());
			System.out.println("HERE:I2");
		}

		// return JSON String
		return jObj;

	}
}