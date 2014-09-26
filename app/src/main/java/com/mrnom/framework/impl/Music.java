package com.mrnom.framework.impl;

import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;

import com.mrnom.framework.IMusic;

import java.io.IOException;

/**
 * Created by zbynek on 9/25/2014.
 */
public class Music implements IMusic, MediaPlayer.OnCompletionListener
{
    MediaPlayer _mediaPlayer;
    boolean _isPrepared = false;

    public Music(AssetFileDescriptor assetFileDescriptor)
    {
        _mediaPlayer = new MediaPlayer();
        try
        {
            _mediaPlayer.setDataSource(
                    assetFileDescriptor.getFileDescriptor(),
                    assetFileDescriptor.getStartOffset(),
                    assetFileDescriptor.getLength()
            );
            _mediaPlayer.prepare();
            _isPrepared = true;
            _mediaPlayer.setOnCompletionListener(this);
        }
        catch (Exception e)
        {
            throw new RuntimeException("Couldn't load music");
        }
    }

    @Override
    public void play()
    {
        if (_mediaPlayer.isPlaying())
            return;

        try
        {
            synchronized (this)
            {
                if(!_isPrepared)
                    _mediaPlayer.prepare();
                _mediaPlayer.start();
            }
        }
        catch (IllegalStateException e)
        {
            e.printStackTrace();
        }
        catch (IOException ioe)
        {
            ioe.printStackTrace();
        }
    }

    @Override
    public void stop()
    {
        synchronized (this)
        {
            _isPrepared = false;
        }
    }

    @Override
    public void pause()
    {
        if (_mediaPlayer.isPlaying())
            _mediaPlayer.pause();
    }

    @Override
    public void setLooping(boolean looping)
    {
        _mediaPlayer.setLooping(isLooping());
    }

    @Override
    public void setVolume(float volume)
    {
        _mediaPlayer.setVolume(volume, volume);
    }

    @Override
    public boolean isPlaying()
    {
        return _mediaPlayer.isPlaying();
    }

    @Override
    public boolean isLooping()
    {
        return _mediaPlayer.isLooping();
    }

    @Override
    public boolean isStopped()
    {
        return !_isPrepared;
    }

    @Override
    public void dispose()
    {
        if (_mediaPlayer.isPlaying())
            _mediaPlayer.stop();
        _mediaPlayer.release();
    }

    @Override
    public void onCompletion(MediaPlayer mediaPlayer)
    {
        synchronized (this)
        {
            _isPrepared = false;
        }
    }
}
