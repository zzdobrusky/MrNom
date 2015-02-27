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
public abstract class Screen
{
    protected final IGame game;
    
    public Screen(IGame game) 
    {
        this.game = game;
    }
    
    public abstract void update(float deltaTime);
    
    public abstract void present(float deltaTime);
    
    public abstract void pause();
    
    public abstract void resume();
    
    public abstract void dispose();
}
