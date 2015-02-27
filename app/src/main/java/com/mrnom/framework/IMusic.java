/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mrnom.framework;

/**
 *
 * @author zbynek
 */
public interface IMusic
{
    public void play();
    
    public void stop();
    
    public void pause();
    
    public void setLooping(boolean looping);
    
    public void setVolume(float volume);
    
    public boolean isPlaying();
    
    public boolean isLooping();

    public boolean isStopped();
    
    public void dispose();
}
