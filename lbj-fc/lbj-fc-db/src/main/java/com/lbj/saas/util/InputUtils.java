package com.lbj.saas.util;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * @Description 输入处理工具
 * @Author libaojie
 * @create 2021/6/10 14:53
 */

public class InputUtils {

    /**
     * 转String
     * @param inputStream
     * @return
     */
    public static String toString(InputStream inputStream) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        StringBuilder sb = new StringBuilder();
        String line = null;
        try {
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return new String(sb);
    }

    /**
     * 转json
     * @param inputStream
     * @return
     */
    public static JsonObject toJson(InputStream inputStream){
        Gson gson = new Gson();
        JsonObject jsonObject = gson.fromJson(new InputStreamReader(inputStream), JsonObject.class);
        return jsonObject;
//        context.getLogger().info(jsonObject.get("headers").toString());
    }
    //        Type type = new TypeToken<Map<String, String>>() {}.getType();
//        Map<String, String> map2 = new Gson().fromJson(new String(sb), type);
}
