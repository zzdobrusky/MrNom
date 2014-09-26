package com.mrnom.framework.impl;

import android.app.Activity;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.media.AudioManager;
import android.media.SoundPool;

import com.mrnom.framework.IAudio;
import com.mrnom.framework.IMusic;
import com.mrnom.framework.ISound;

import java.io.IOException;

/**
 * Created by zbynek on 9/25/2014.
 */
public class Audio implements IAudio
{
    AssetManager _assets;
    SoundPool _soundPool;

    public Audio(Activity activity)
    {
        activity.setVolumeControlStream(AudioManager.STREAM_MUSIC);
        _assets = activity.getAssets();
        _soundPool = new SoundPool(20, AudioManager.STREAM_MUSIC, 0);
    }

    @Override
    public IMusic newMusic(String filename)
    {
        try
        {
            AssetFileDescriptor assetFileDescriptor = _assets.openFd(filename);
            return new Music(assetFileDescriptor);
        }
        catch (IOException ioe)
        {
            throw new RuntimeException("Couldn't load music '" + filename + "'");
        }
    }

    @Override
    public ISound newSound(String filename)
    {
        try
        {
            AssetFileDescriptor assetFileDescriptor = _assets.openFd(filename);
            int soundId = _soundPool.load(assetFileDescriptor, 0);
            return new Sound(_soundPool, soundId);
        }
        catch (IOException ioe)
        {
            throw new RuntimeException("Couldn't load sound '" + filename + "'");
        }
    }
}
