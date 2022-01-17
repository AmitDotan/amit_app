package com.example.carsapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Bundle b = getIntent().getExtras();
        Car car = (Car) b.getSerializable("car");

        ImageView avatar = findViewById(R.id.avater);
        TextView brand = findViewById(R.id.brand);
        TextView model = findViewById(R.id.model);
        TextView year = findViewById(R.id.year);
        TextView price = findViewById(R.id.price);

        avatar.setImageResource(car.getImage());
        brand.setText(car.getBrand());
        model.setText(car.getModel());
        year.setText(car.getYear());
        price.setText(car.getPrice());
    }
}
