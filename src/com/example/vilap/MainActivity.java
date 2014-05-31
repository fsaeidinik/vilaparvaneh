package com.example.vilap;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.RadioGroup;

public class MainActivity extends BaseActivity {

	VillaListFragment villaListFragment;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		super.setMyActionBar("Main", null);

		villaListFragment = new VillaListFragment();

		FragmentTransaction fragmentTransaction = getSupportFragmentManager()
				.beginTransaction();
		fragmentTransaction.replace(R.id.frame_container, villaListFragment);
		fragmentTransaction.commit();
		final RadioGroup radioGroup = super.getRadioGroup();
		radioGroup.check(R.id.actionbar_image_button_large);
		// radioGroup.setOnClickListener(new OnClickListener() {
		// @Override
		// public void onClick(View arg0) {
		// System.out.println("on click listener");
		// System.err.println("hi");
		// System.err.println(radioGroup.getCheckedRadioButtonId());
		// int radioButtonID = radioGroup.getCheckedRadioButtonId();
		// View radioButton = radioGroup.findViewById(radioButtonID);
		// int idx = radioGroup.indexOfChild(radioButton);
		// System.err.println(idx);
		// }
		// });
		radioGroup
				.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
					@Override
					public void onCheckedChanged(RadioGroup arg0, int arg1) {
						System.err.println("changed");
						if (arg1 == R.id.actionbar_image_button_small) {
							System.err.println("small button");
						} else if (arg1 == R.id.actionbar_image_button_large) {
							System.err.println("large button");
							villaListFragment
									.setAdapterLayout(R.layout.villa_list_item_large);
						} else
							System.err.println("else");
					}
				});

		ImageButton filterButton = (ImageButton) findViewById(R.id.actionbar_button_filter);
		filterButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				startActivity(new Intent(MainActivity.this,
						FilterActivity.class));
			}
		});

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
