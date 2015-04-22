package com.adsanjal.sample;


import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class MainActivity extends FragmentActivity {

	static String messages[] = new String[]{
			"AdSanjal is a mobile networking platform that is aimed at helping advertiser promote their business via mobile apps.",
			"The advantage with advertising with mobile apps is that you can get your ads directly visible to the end users.",
			"AdSanjal is a product of Mantra Ideas, a team focused on providing various kinds of web/mobile services to people."
	};
	static String colors[] = new String[]{"#009688", "#03A9F4", "#4CAF50", "#8BC34A", "#FFC107"};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		MyAdapter adapter = new MyAdapter(getSupportFragmentManager());
		ViewPager pager = (ViewPager) findViewById(R.id.pager);
		pager.setAdapter(adapter);
	}
	
	public static class MyAdapter extends FragmentPagerAdapter {

		public MyAdapter(FragmentManager fm) {
			super(fm);
		}

		@Override
		public int getCount() {
			return messages.length;
		}

		@Override
		public Fragment getItem(int position) {
			return ArrayFragment.newInstance(position);
		}
	}
	
	public static class ArrayFragment extends Fragment {
		int mNum;

		static ArrayFragment newInstance(int num) {
			ArrayFragment f = new ArrayFragment();
			Bundle args = new Bundle();
			args.putInt("num", num);
			f.setArguments(args);
			return f;
		}

		@Override
		public void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			mNum = getArguments() != null ? getArguments().getInt("num") : 0;
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
			View vi = inflater.inflate(R.layout.fragment_sample, container, false);
			vi.setBackgroundColor(Color.parseColor(colors[mNum]));
			((TextView)vi.findViewById(R.id.text)).setText(messages[mNum]);
			return vi;
		}
	}
}
