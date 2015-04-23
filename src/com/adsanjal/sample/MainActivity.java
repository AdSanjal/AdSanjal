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
			"Got advertisers looking to put ads on your app?"
			+ "\n\nAdSanjal can help you manage ads and get detailed analytics "
			+ "on impressions and clicks, which later can be shown to advertisers."
			+ "\n\n\nNext screen >>>",
			"Are you looking to place ads on nepali apps?\n\nAdSanjal can help you "
			+ "run campaigns and get detail analytics about the reach from ads "
			+ "and their effectiveness.\n\nPay as you grow with\nhttps://AdSanajal.com"
	};
	static String colors[] = new String[]{"#009688", "#f47a5c"/*, "#795548", "#FFC107", "#03A9F4", "#4CAF50", "#8BC34A"*/};
	
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
