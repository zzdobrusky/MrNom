package com.mrnom.framework.impl;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.AssetManager;
import android.os.Environment;
import android.preference.PreferenceManager;

import com.mrnom.framework.IFileIO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by zbynek on 9/25/2014.
 */
public class FileIO implements IFileIO
{
    Context _context;
    AssetManager _assets;
    String _externalStoragePath;

    public FileIO(Context context)
    {
        _context = context;
        _assets = _context.getAssets();
        _externalStoragePath = Environment.getExternalStorageDirectory().getAbsolutePath()
                + File.separator;
    }

    @Override
    public InputStream readAsset(String fileName) throws IOException
    {
        return _assets.open(fileName);
    }

    @Override
    public InputStream readFile(String fileName) throws IOException
    {
        return new FileInputStream(_externalStoragePath + fileName);
    }

    @Override
    public OutputStream writeFile(String fileName) throws IOException
    {
        return new FileOutputStream(_externalStoragePath + fileName);
    }

    @Override
    public SharedPreferences getPreferences()
    {
        return PreferenceManager.getDefaultSharedPreferences(_context);
    }
}
