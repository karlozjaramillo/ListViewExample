package com.cj.listviewexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.cj.listviewexample.models.Car;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private ListView lvLista;
//    private String[] names = {"Eduardo", "Felipe", "Edison"};
    private ArrayList<Car> cars = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvLista = findViewById(R.id.lvLista);
//        ArrayAdapter<String> adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, names);
//        Car car = new Car("Ford Mustang", "2500", "2021","140000000", null);
        cars.add(new Car("Ford Mustang", "2500", "2021","140000000", null));
        cars.add(new Car("Camaro", "2500", "2020","120000000", null));
        cars.add(new Car("Shelby Cobra", "2500", "1966","70000000", null));

        AdapterCar adapter = new AdapterCar(this, cars);
        lvLista.setAdapter(adapter);
        lvLista.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//        Toast.makeText(this, "Ha pulsado el elemento " + position, Toast.LENGTH_SHORT).show();
        Toast.makeText(this, "Has pulsado " + cars.get(position).getName(), Toast.LENGTH_SHORT).show();
    }
}