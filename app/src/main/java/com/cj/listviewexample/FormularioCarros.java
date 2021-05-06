package com.cj.listviewexample;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.cj.listviewexample.models.Car;

import java.util.ArrayList;

public class FormularioCarros extends AppCompatActivity implements View.OnClickListener {

    private EditText txtNombre;
    private EditText txtModelo;
    private EditText txtCilindraje;
    private EditText txtValor;
    private EditText txtImagen;
    private Button btnGuardar;
    private Button btnListar;
    private ArrayList<Car> cars = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario_carros);

        txtNombre = findViewById(R.id.txtNombre);
        txtModelo = findViewById(R.id.txtModelo);
        txtCilindraje = findViewById(R.id.txtCilindraje);
        txtValor = findViewById(R.id.txtValor);
        txtImagen = findViewById(R.id.txtImagen);
        btnGuardar = findViewById(R.id.btnGuardar);
        btnListar = findViewById(R.id.btnListar);
        btnGuardar.setOnClickListener(this);
        btnListar.setOnClickListener(this);

        //    LLenado de elementos a la lista
        cars.add(new Car("Chevrolet Camaro", "6.2L", "2021", "185000000", "https://www.chevrolet.com.co/content/dam/chevrolet/south-america/colombia/espanol/index/cars/2018-camaro/04-images/plata-sable-camaro-six-ss-2018.jpg?imwidth=960"));
        cars.add(new Car("Shelby Cobra", "4.2L", "1966", "75000000", "https://hips.hearstapps.com/hmg-prod.s3.amazonaws.com/images/captura-de-pantalla-2019-12-30-a-las-12-01-29-1577703838.png"));
        cars.add(new Car("Ford Mustang GT", "5.0L", "2004", "140000000", "https://hips.hearstapps.com/es.h-cdn.co/cades/contenidos/4825/ford-mustang-gt-r-concept-2.jpg"));
        cars.add(new Car("Dodge Charger SRT", "6.2L", "2021", "140000000", "https://img.autocosmos.com/noticias/fotos/preview/NAZ_ff60239c7b684dc7b80f3d4313986456.jpg"));
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnGuardar:
                agregarCarro();
                break;
            case R.id.btnListar:
                Intent intent = new Intent(this, MainActivity.class);
                Bundle bundle = new Bundle();
                bundle.putParcelableArrayList("cars", cars);
                intent.putExtras(bundle);
                startActivity(intent);
                break;
        }
    }

    private void agregarCarro() {
        String nombre = txtNombre.getText().toString();
        String modelo = txtModelo.getText().toString();
        String cilindraje = txtCilindraje.getText().toString();
        String valor = txtValor.getText().toString();
        String imagen = txtImagen.getText().toString();

        Car car = new Car(nombre, cilindraje, modelo, valor, imagen);
        cars.add(car);
        limpiarCampos();
    }

    private void limpiarCampos() {
        txtNombre.getText().clear();
        txtModelo.getText().clear();
        txtCilindraje.getText().clear();
        txtValor.getText().clear();
        txtImagen.getText().clear();
    }
}

