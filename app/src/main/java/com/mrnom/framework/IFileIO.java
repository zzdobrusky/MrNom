/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mrnom.framework;

import java.io.*;

/**
 *
 * @author zbynek
 */
public interface IFileIO
{
    public InputStream readAsset(String fileName) throws IOException;
    
    public InputStream readFile(String fileName) throws IOException;
    
    public OutputStream writeFile(String fileName) throws IOException;
}
