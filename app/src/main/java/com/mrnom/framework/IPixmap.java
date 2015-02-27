/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mrnom.framework;

import com.mrnom.framework.IGraphics.PixmapFormat;

/**
 *
 * @author zbynek
 */
public interface IPixmap
{
    public int getWidth();
    
    public int getHeight();
    
    public PixmapFormat getFormat();
    
    public void dispose();
}
