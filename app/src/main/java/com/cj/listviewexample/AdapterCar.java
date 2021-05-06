package com.cj.listviewexample;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.cj.listviewexample.models.Car;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class AdapterCar extends BaseAdapter {

    protected Activity activity;
    protected ArrayList<Car> cars;

    public AdapterCar(Activity activity, ArrayList<Car> cars) {
        this.activity = activity;
        this.cars = cars;
    }

    public void addCar(ArrayList<Car> carsElement) {
        cars.addAll(carsElement);
    }

    @Override
    public int getCount() {
        return cars.size();
    }

    @Override
    public Object getItem(int position) {
        return cars.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.car_item, null);
        }
        Car carElement = cars.get(position);
        TextView nameCar = view.findViewById(R.id.carName);
        TextView valueCar = view.findViewById(R.id.carValue);
        TextView modelCar = view.findViewById(R.id.carModel);
        TextView ccCar = view.findViewById(R.id.carCylinderCapacity);
        ImageView imageCar = view.findViewById(R.id.carImageView);
        nameCar.setText(carElement.getName());
        valueCar.setText("$" + carElement.getValue());
        modelCar.setText("Modelo: " + carElement.getModel());
        ccCar.setText("Motor: " + carElement.getCylinderCapacity());

        Picasso.get()
                .load(carElement.getImage())
                .resize(300, 120)
                .centerCrop()
                .error(R.mipmap.ic_launcher)
                .into(imageCar);

        return view;
    }
}
