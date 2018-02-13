package com.tykj.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONException;
import net.sf.json.JSONObject;

public class JsonUtils {
	public static Map toMap(String jsonString) throws JSONException {
        JSONObject jsonObject = JSONObject.fromObject(jsonString);
        Map result = new HashMap();
        Iterator iterator = jsonObject.keys();
        String key = null;
        String value = null;
        while (iterator.hasNext()) {
            key = (String) iterator.next();
            value = jsonObject.getString(key);
            result.put(key, value);
        }
        return result;

    }
	/**
	 * 讲jsonStr 转为List<Map>
	 * */
	public static List<Map> getObjectsByJsonArrayString(String jsonArrayString) throws JSONException, Exception{
		List<Map> objectList =new ArrayList<Map>();
		JSONArray array = new JSONArray();
		array=array.fromObject(jsonArrayString);
		for (int i = 0; i < array.size(); i++) {
			Map hashMap=new HashMap<String,Object>();
			hashMap=toMap(array.getJSONObject(i).toString());
			objectList.add(hashMap);
		}
		return objectList;
	}
}
