package com.example.ankur.trainbetweenstation;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by ankur on 8/26/16.
 */
public class ParseJSON {
    public static String[] no;
    public static String[] name;
    public static String[] number;

    public static final String JSON_ARRAY = "train";
    public static final String KEY_NO = "no";
    public static final String KEY_NAME = "name";
    public static final String KEY_NUMBER = "number";

    private JSONArray users = null;

    private String json;

    public ParseJSON(String json) {
        this.json = json;
    }

    protected void parseJSON() {
        JSONObject jsonObject = null;
        try {
            jsonObject = new JSONObject(json);
            String responseCode = jsonObject.getString("response_code");

            users = jsonObject.getJSONArray(JSON_ARRAY);

            no = new String[users.length()];
            name = new String[users.length()];
            number = new String[users.length()];

            for (int i = 0; i < users.length(); i++) {
                JSONObject jo = users.getJSONObject(i);
                no[i] = jo.getString(KEY_NO);
                name[i] = jo.getString(KEY_NAME);
                number[i] = jo.getString(KEY_NUMBER);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }


}
