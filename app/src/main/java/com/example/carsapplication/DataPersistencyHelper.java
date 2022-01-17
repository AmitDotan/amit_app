package com.example.carsapplication;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class DataPersistencyHelper {

    public static Context Context;

    public static void StoreData(List<Car> cars)
    {
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(Context);
        SharedPreferences.Editor editor = sp.edit();
        String json = new Gson().toJson(cars);
        editor.putString("cars", json);
        editor.commit();
    }

    public static List<Car> LoadData()
    {
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(Context);
        String json = sp.getString("cars",null); //TODO change back
        if (json != null)
        {
            Type type = new TypeToken<List<Car>>(){}.getType();
            return new Gson().fromJson(json,type);
        }
        else
        {
            List<Car> cars = new ArrayList<Car>();
            cars.add(new Car(R.drawable.mazda,"Mazda","3 hatchback", "2016", "80,000"));
            cars.add(new Car(R.drawable.kia,"Kia","Picanto", "2019", "60,000"));
            cars.add(new Car(R.drawable.toyota,"Toyota","Rav 4", "2019", "170,000"));
            cars.add(new Car(R.drawable.mazda,"Mazda","3", "2006", "20,000"));
            cars.add(new Car(R.drawable.audi,"Audi","A3", "2010", "35,000"));
            cars.add(new Car(R.drawable.kia,"Kia","Picanto GT Line", "2019", "65,000"));
            cars.add(new Car(R.drawable.mercedes,"Mercedes","A180", "2019", "210,000"));
            cars.add(new Car(R.drawable.audi,"Audi","A1", "2017", "95,000"));
            return cars;
        }
    }
}
