package com.example.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class JsonParser {

    public List<RestaurantModel> parseRestaurants(String json) {
        List<RestaurantModel> list = null;

        try {
            JSONArray jsonArray = new JSONArray(json);

            Type listType = new TypeToken<ArrayList<RestaurantModel>>() {
            }.getType();
            list = new GsonBuilder().create().fromJson(jsonArray.toString(), listType);

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return list;
    }

    public List<MenuItemModel> parseMenu(String json) {
        List<MenuItemModel> list = new ArrayList<>();

        try {
            JSONArray jsonArray = new JSONArray(json);

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONArray items = jsonArray.getJSONObject(i).getJSONArray("menu_items");
                for (int j = 0; j < items.length(); j++) {
                    JSONObject item = items.getJSONObject(j);
                    MenuItemModel menuItemModel = new MenuItemModel();
                    menuItemModel.setName(item.getString("item_name"));
                    menuItemModel.setImage(item.getString("item_image"));
                    list.add(menuItemModel);
                }

            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return list;
    }
}
