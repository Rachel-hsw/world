package com.rachel.world.data.extra;

import org.json.JSONException;
import org.json.JSONObject;

public class Test {
    public static void main(String[] args) {
        try {
            JSONObject container1 = new JSONObject();
            container1.put("ClassName", "高三一班");
            System.out.println(container1.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
