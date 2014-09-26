package com.mrnom.framework.impl;

import android.content.res.AssetFileDescriptor;

import com.mrnom.framework.IMusic;

/**
 * Created by zbynek on 9/25/2014.
 */
public class Music implements IMusic
{
    public Music(AssetFileDescriptor assetFileDescriptor) {}

    @Override
    public void play()
    {

    }

    @Override
    public void stop()
    {

    }

    @Override
    public void pause()
    {

    }

    @Override
    public void setLooping(boolean looping)
    {

    }

    @Override
    public void setVolume(float volume)
    {

    }

    @Override
    public boolean isPlaying()
    {
        return false;
    }

    @Override
    public boolean isLooping()
    {
        return false;
    }

    @Override
    public void dispose()
    {

    }
}
