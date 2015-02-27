package com.mrnom.framework.impl;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;

/**
 * Created by zbynek on 9/27/2014.
 */
public class CompassHandler implements SensorEventListener
{
    float _yaw;
    float _pitch;
    float _roll;

    public CompassHandler(Context context)
    {
        SensorManager manager = (SensorManager) context.getSystemService(Context.SENSOR_SERVICE);
        if (manager.getSensorList(Sensor.TYPE_ORIENTATION).size() != 0)
        {
            Sensor compassSensor = manager.getSensorList(Sensor.TYPE_ORIENTATION).get(0);
            manager.registerListener(this, compassSensor, SensorManager.SENSOR_DELAY_GAME);
        }
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent)
    {
        _yaw = sensorEvent.values[0];
        _pitch = sensorEvent.values[1];
        _roll = sensorEvent.values[2];
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i)
    {
        // nothing to do here
    }

    public float getYaw()
    {
        return _yaw;
    }

    public float getPitch()
    {
        return _pitch;
    }

    public float getRoll()
    {
        return _roll;
    }
}
