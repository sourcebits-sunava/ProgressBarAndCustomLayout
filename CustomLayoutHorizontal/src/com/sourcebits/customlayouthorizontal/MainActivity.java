package com.sourcebits.customlayouthorizontal;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.RelativeLayout;

public class MainActivity extends Activity {

	 @Override
	    public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	 
	        // Creating a new RelativeLayout
	        RelativeLayout relativeLayout = new RelativeLayout(this);
	 
	        // Defining the RelativeLayout layout parameters with Fill_Parent
	        RelativeLayout.LayoutParams relativeLayoutParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.FILL_PARENT, RelativeLayout.LayoutParams.FILL_PARENT);
	 
	        
	        
	        /* Creating a new Left Button
	        Button button1 = new Button(this);
	        button1.setText("Button1");
	 
	        // Creating a new Left Button with Margin
	        Button button2 = new Button(this);
	        button2.setText("Button2");
	 
	        // Creating a new Center Button
	        Button button3 = new Button(this);
	        button3.setText("Button3");
	 
	        // Creating a new Bottom Button
	        Button button4 = new Button(this);
	        button4.setText("Button4");
	 
	        // Add a Layout to the Buttons
	        AddButtonLayout(button1, RelativeLayout.ALIGN_PARENT_LEFT);
	        AddButtonLayout(button3, RelativeLayout.CENTER_IN_PARENT);
	        AddButtonLayout(button4, RelativeLayout.ALIGN_PARENT_BOTTOM);
	 
	        // Add a Layout to the Button with Margin
	        LayoutAddButton(button2, RelativeLayout.ALIGN_PARENT_LEFT, 30, 80, 0, 0);
	 
	        // Add the Buttons to the View
	        relativeLayout.addView(button1);
	        relativeLayout.addView(button3);
	        relativeLayout.addView(button4);
	        relativeLayout.addView(button2);*/
	        
	        
	        
	        
	        Display display = getWindowManager().getDefaultDisplay(); 
	        int width = display.getWidth();
	        int height = display.getHeight();
	        Log.i("ht", Integer.toString(height));
	        int currentHeight = 0;
	        boolean top = false;
	        
	        Button button;
	        /*Button button = new Button(this);
        	button.setId(0);
	        button.setText("Button"+0);
	        RelativeLayout.LayoutParams buttonLayoutParameters = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
	   	 
	        // Add Margin to the LayoutParameters
	        buttonLayoutParameters.setMargins(0, 0, 0, 0);
	 
	        // Add Rule to Layout
	        
	        buttonLayoutParameters.addRule(RelativeLayout.CENTER_HORIZONTAL);
	 
	        // Setting the parameters on the Button
	        button.setLayoutParams(buttonLayoutParameters);
	        relativeLayout.addView(button);*/
	        
	        int i =1;
	        int topIndex = i;
	        int rightIndex = -1;
	        
	        for(;i<=50;++i)
	        {
	        	button = new Button(this);
	        	button.setId(i);
		        button.setText("Button"+i);
		        
		        
		        if(currentHeight >= height)
		        {
		        	top = true;	
		        	rightIndex = topIndex;
		        	LayoutAddButton(button, RelativeLayout.RIGHT_OF,0,0,0,0,topIndex,top,rightIndex);
		        	relativeLayout.addView(button);	
		        	topIndex = i;
		        	currentHeight = button.getMeasuredHeight();
		        	top =false;
		        	
		        	continue;
		        }
		        
		        if(rightIndex>0)
		        	++rightIndex;
	        	
		        LayoutAddButton(button, RelativeLayout.BELOW,0,0,0,0,i-1,top,rightIndex);
		        
		        relativeLayout.addView(button);	
		        currentHeight = currentHeight + button.getMeasuredHeight() + 8;
		        Log.i("cht", Integer.toString(currentHeight));
	        }
	        
	 
	        // Setting the RelativeLayout as our content view
	        setContentView(relativeLayout, relativeLayoutParams);
	    }
	 
	    private void LayoutAddButton(Button button, int align, int marginLeft, int marginTop, int marginRight, int marginBottom,int index,boolean top,int rightOf) {
	        // Defining the layout parameters of the Button
	        RelativeLayout.LayoutParams buttonLayoutParameters = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
	        
	        // Add Margin to the LayoutParameters
	        buttonLayoutParameters.setMargins(marginLeft, marginTop, marginRight, marginBottom);
	        	 
	        // Add Rule to Layout
	        if(top && rightOf<0)
	        {
	        	buttonLayoutParameters.addRule(align,index);
	        	
	        }
	        else if(top || rightOf>0)
	        {
	        	buttonLayoutParameters.addRule(align,index);
	        	buttonLayoutParameters.addRule(RelativeLayout.RIGHT_OF,rightOf);
	        }
	        else
	        {
		        buttonLayoutParameters.addRule(align,index);
		        
		 
	        }
	        
	        // Setting the parameters on the Button
	        button.setLayoutParams(buttonLayoutParameters);
	        
	        button.measure(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
	        int currentHeight= button.getMeasuredHeight();
	        Log.i("cht   xxx", Integer.toString(currentHeight));
	    }
	 
	    @Override
	    public boolean onCreateOptionsMenu(Menu menu) {
	    	// Inflate the menu; this adds items to the action bar if it is present.
	    	getMenuInflater().inflate(R.menu.main, menu);
	    	return true;
	    }

	    @Override
	    public boolean onOptionsItemSelected(MenuItem item) {
	    	// Handle action bar item clicks here. The action bar will
	    	// automatically handle clicks on the Home/Up button, so long
	    	// as you specify a parent activity in AndroidManifest.xml.
	    	int id = item.getItemId();
	    	if (id == R.id.action_settings) {
	    		return true;
	   	}
		return super.onOptionsItemSelected(item);
	}
}
