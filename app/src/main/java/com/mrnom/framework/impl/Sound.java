package com.mrnom.framework.impl;

import android.media.SoundPool;

import com.mrnom.framework.ISound;

/**
 * Created by zbynek on 9/25/2014.
 */
public class Sound implements ISound
{
    int _soundId;
    SoundPool _soundPool;

    public Sound(SoundPool soundPool, int soundId)
    {
        _soundId = soundId;
        _soundPool = soundPool;
    }

    @Override
    public void play(float volume)
    {
        _soundPool.play(_soundId, volume, volume, 0, 0, 1);
    }

    @Override
    public void dispose()
    {
        _soundPool.unload(_soundId);
    }
}
