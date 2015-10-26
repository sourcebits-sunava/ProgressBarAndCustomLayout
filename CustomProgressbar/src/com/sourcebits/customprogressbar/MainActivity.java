package com.sourcebits.customprogressbar;


import android.app.Activity;
import android.content.Context;
import android.media.AudioManager;
import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

public class MainActivity extends Activity{
	Button b;
    ProgressBar s;
    EditText e;
    int c,a;
    private AudioManager audioManager;
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
		//b = (Button)findViewById(R.id.button1);
        s = (ProgressBar)findViewById(R.id.progressBar1);
        e = (EditText)findViewById(R.id.editView1);

        
        audioManager = (AudioManager)getSystemService(Context.AUDIO_SERVICE);
        a = audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        c = audioManager.getStreamVolume(AudioManager.STREAM_MUSIC);
        
        /*b.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                audioManager.setStreamVolume(AudioManager.STREAM_RING, (int)(Integer.parseInt(e.getText().toString().trim())), 0);
                s.setProgress((int)(Integer.parseInt(e.getText().toString().trim())));
            }
        });*/

        s.setMax(7);
        s.setProgress(c);
        e.setText(""+c);
        
	}
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
	    if ((keyCode == KeyEvent.KEYCODE_VOLUME_DOWN)) 
	    {
	    	if(c!=0)
	    	{
	    		s.setProgress(--c);
		        e.setText(""+c);
	    	}
	    	
	         
	        return true;
	    }
	    else if ((keyCode == KeyEvent.KEYCODE_VOLUME_UP))
	    {
	    	if(c<7)
	    	{
	    		s.setProgress(++c);
		        e.setText(""+c);
		         
	    	}
	    	
	        return true;
	    }
	    else
	        return super.onKeyDown(keyCode, event);
	}

	
}	
