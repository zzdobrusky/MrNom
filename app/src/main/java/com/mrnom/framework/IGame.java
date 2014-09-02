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
public interface IGame
{
    public IInput getInput();
    
    public IFileIO getFileIO();
    
    public IGraphics getGraphics();
    
    public IAudio getAudio();
    
    public void setScreen(Screen screen);
    
    public Screen getCurrentScreen();
    
    public Screen getStartScreen();
}
