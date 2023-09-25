package cl.ejemplo.sensores;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private TextView SalidaSensores;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SalidaSensores = findViewById(R.id.txtSensores);
        SensorManager sensorManager = (SensorManager)
                //GENERA OBJETOS, PARA ACCEDER AL LOS SENSORES//
                getSystemService(SENSOR_SERVICE);
        List<Sensor> listadoSensores = sensorManager.getSensorList(Sensor.TYPE_ALL);//accede a todos los tipos de sensores
        for(Sensor sensor: listadoSensores){
            log(sensor.getName());
        }


    }

    private void log(String sensores) {
        SalidaSensores.append(sensores +"\n");
    }
}