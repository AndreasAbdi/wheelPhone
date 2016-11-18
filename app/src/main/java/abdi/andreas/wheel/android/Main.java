package abdi.andreas.wheel.android;

import android.app.Activity;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

import abdi.andreas.wheel.R;

public class Main extends Activity implements SensorEventListener{

    TextView textView;

    SensorManager sensorManager;
    Sensor sensor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wheel);
        textView = (TextView)findViewById(R.id.textView);
        sensorManager = (SensorManager) this.getApplicationContext().getSystemService(SENSOR_SERVICE);
        sensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        sensorManager.registerListener(this, sensor, SensorManager.SENSOR_DELAY_GAME);
    }


    @Override
    public void onSensorChanged(SensorEvent event) {
        int sensorType = event.sensor.getType();
        if(sensorType == Sensor.TYPE_ACCELEROMETER) {
            textView.setText(
                    "Accelerometer: \n" +
                    "x: " + event.values[0] + "\n" +
                    "y: " + event.values[1] + "\n" +
                    "z: " + event.values[2] + "\n"
            );
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
