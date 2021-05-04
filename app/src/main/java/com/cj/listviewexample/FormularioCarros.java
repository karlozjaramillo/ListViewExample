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
    private ListView lvLista;
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
        lvLista = findViewById(R.id.lvLista);
        btnGuardar.setOnClickListener(this);
        btnListar.setOnClickListener(this);
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

