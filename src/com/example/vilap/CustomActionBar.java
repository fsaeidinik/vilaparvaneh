package com.example.vilap;

import android.support.v7.app.ActionBarActivity;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageButton;

public class CustomActionBar {
	public static void setActionBar(ActionBarActivity activity , OnClickListener drawerButtonListener)
	{
		ViewGroup actionBarLayout = (ViewGroup) activity.getLayoutInflater().inflate(R.layout.custom_actionbar, null);
		
		android.support.v7.app.ActionBar actionBar = activity.getSupportActionBar();
		actionBar.setDisplayShowHomeEnabled(false);
		actionBar.setDisplayShowTitleEnabled(false);
		actionBar.setDisplayShowCustomEnabled(true);
		actionBar.setCustomView(actionBarLayout);
		
		ImageButton drawerButton = (ImageButton) actionBarLayout.findViewById(R.id.actionbar_imagebutton_drawer_layout);
		drawerButton.setOnClickListener(drawerButtonListener);
//		
//		RelativeLayout layout = (RelativeLayout) actionBarLayout.findViewById(R.id.custom_actionbar_relativelayout_main);
		
//		if(android.os.Build.VERSION.SDK_INT < android.os.Build.VERSION_CODES.JELLY_BEAN)
//			layout.setBackgroundDrawable(buildGradient(activity));
//		else
//			layout.setBackground(buildGradient(activity));
	}

}
