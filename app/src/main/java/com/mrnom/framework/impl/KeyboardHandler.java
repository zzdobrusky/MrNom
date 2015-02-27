package com.mrnom.framework.impl;


import android.view.View;
import android.view.View.OnKeyListener;

import com.mrnom.framework.IInput.KeyEvent;
import com.mrnom.framework.Pool;
import com.mrnom.framework.Pool.PoolObjectFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zbynek on 10/15/2014.
 */
public class KeyboardHandler implements OnKeyListener
{
    boolean[] _pressedKeys = new boolean[128];
    Pool<KeyEvent> _keyEventPool;
    List<KeyEvent> _keyEventsBuffer = new ArrayList<KeyEvent>();
    List<KeyEvent> _keyEvents = new ArrayList<KeyEvent>();

    public KeyboardHandler(View view)
    {
        Pool.PoolObjectFactory<KeyEvent> factory = new PoolObjectFactory<KeyEvent>()
        {
            @Override
            public KeyEvent createObject()
            {
                return new KeyEvent();
            }
        };

        _keyEventPool = new Pool<KeyEvent>(factory, 100);
        view.setOnKeyListener(this);
        view.setFocusableInTouchMode(true);
        view.requestFocus();
    }

    @Override
    public boolean onKey(View view, int keyCode, android.view.KeyEvent event)
    {
        if (event.getAction() == android.view.KeyEvent.ACTION_MULTIPLE)
            return false;

        synchronized (this)
        {
            KeyEvent keyEvent = _keyEventPool.newObject();
            keyEvent.keyCode = keyCode;
            keyEvent.keyChar = (char) event.getUnicodeChar();
            if (event.getAction() == android.view.KeyEvent.ACTION_DOWN)
            {
                keyEvent.type = KeyEvent.KEY_DOWN;
                if(keyCode > 0 && keyCode < 127)
                    _pressedKeys[keyCode] = true;
            }
            if (event.getAction() == android.view.KeyEvent.ACTION_UP)
            {
                keyEvent.type = KeyEvent.KEY_UP;
                if(keyCode > 0 && keyCode < 127)
                    _pressedKeys[keyCode] = false;
            }
            _keyEventsBuffer.add(keyEvent);
        }

        return false;
    }
}
