package com.mrnom.framework.impl;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;

/**
 * Created by zbynek on 9/27/2014.
 */
public class AccelerometerHandler implements SensorEventListener
{
    float _accelX;
    float _accelY;
    float _accelZ;

    public AccelerometerHandler(Context context)
    {
        SensorManager manager = (SensorManager) context.getSystemService(Context.SENSOR_SERVICE);
        if (manager.getSensorList(Sensor.TYPE_ACCELEROMETER).size() != 0)
        {
            Sensor accelerometerSenser = manager.getSensorList(Sensor.TYPE_ACCELEROMETER).get(0);
            manager.registerListener(this, accelerometerSenser, SensorManager.SENSOR_DELAY_GAME);
        }
    }

    public float getAccelX()
    {
        return _accelX;
    }

    public float getAccelY()
    {
        return _accelY;
    }

    public float getAccelZ()
    {
        return _accelZ;
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent)
    {
        _accelX = sensorEvent.values[0];
        _accelY = sensorEvent.values[1];
        _accelZ = sensorEvent.values[2];
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i)
    {
        // nothing to do here
    }
}
