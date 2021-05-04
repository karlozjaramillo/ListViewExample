package com.cj.listviewexample;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.cj.listviewexample.models.Car;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private ListView lvLista;
    private ArrayList<Car> cars;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Bundle bundle = getIntent().getExtras();
        cars = bundle.getParcelableArrayList("cars");

        lvLista = findViewById(R.id.lvLista);

        AdapterCar adapter = new AdapterCar(this, cars);
        lvLista.setAdapter(adapter);
        lvLista.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(this, "Has pulsado " + cars.get(position).getName(), Toast.LENGTH_SHORT).show();
    }
}