package com.example.ca3practice;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
ListView listView;
List<Sensor> list_sensor;
SensorManager sensorManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView=findViewById(R.id.list_view);
        sensorManager=(SensorManager)this.getSystemService(this.SENSOR_SERVICE);
        list_sensor=sensorManager.getSensorList(Sensor.TYPE_ALL);
        List<String>  diplay=new ArrayList<>();
       for(int i=0;i<list_sensor.size();i++){
          diplay.add(list_sensor.get(i).getName());

       }
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,diplay);
       listView.setAdapter(adapter);
       listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
           @Override
           public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               Toast.makeText(MainActivity.this, "selected: "+position, Toast.LENGTH_SHORT).show();
           }
       });

    }
}
