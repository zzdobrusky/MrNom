package com.mrnom.framework.impl;


import android.view.View;
import android.view.View.OnKeyListener;

import com.mrnom.framework.IInput.KeyEvent;
import com.mrnom.framework.Pool;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zbynek on 10/15/2014.
 */
public class KeyboardHandler implements OnKeyListener
{
    boolean[] pressedKeys = new boolean[128];
    Pool<KeyEvent> _keyEventPool;
    List<KeyEvent> _keyEventsBuffer = new ArrayList<KeyEvent>();
    List<KeyEvent> _keyEvents = new ArrayList<KeyEvent>();


    public boolean onKey(View view, int i, KeyEvent keyEvent)
    {
        return false;
    }

    @Override
    public boolean onKey(View view, int i, android.view.KeyEvent keyEvent)
    {
        return false;
    }
}
