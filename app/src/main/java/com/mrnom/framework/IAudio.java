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
public interface IAudio
{
    public IMusic newMusic(String filename);
    
    public ISound newSound(String filename);
}
