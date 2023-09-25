package cl.ejemplo.sensores;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

public class acelerometro extends AppCompatActivity implements SensorEventListener {
    private SensorManager SensorManager;

    private Sensor acelerometro;
    TextView x,y,z;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acelerometro);
        x = findViewById(R.id.ejeX);
        y = findViewById(R.id.ejeY);
        z = findViewById(R.id.ejeZ);
        SensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        acelerometro = SensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
    }
    @Override
    protected void onResume(){
        super.onResume();
        SensorManager.registerListener(this,acelerometro, SensorManager.SENSOR_DELAY_NORMAL);
    }
    @Override
    protected void onPause(){
        super.onPause();
        SensorManager.unregisterListener(this);
    }
    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        float ejex= sensorEvent.values[0];
        x.setText(String.valueOf(ejex));
        float ejey= sensorEvent.values[1];
        y.setText(String.valueOf(ejey));
        float ejez= sensorEvent.values[2];
        z.setText(String.valueOf(ejez));


    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}