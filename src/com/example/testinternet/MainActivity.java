package com.example.testinternet;

import java.net.InetAddress;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_main);
		Button check = (Button) findViewById(R.id.check);
		check.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				new isnetAvailable().execute();
			}
		});
	}

	public class isnetAvailable extends AsyncTask<Void, Void, Void> {
		boolean a;

		@Override
		protected Void doInBackground(Void... params) {
			a = isInternetAvailable();
			return null;
		}

		@Override
		protected void onPostExecute(Void result) {
			// TODO Auto-generated method stub
			super.onPostExecute(result);
			Toast.makeText(getApplicationContext(), "isInternetAvailable " + a, Toast.LENGTH_LONG)
					.show();
		}

	}

	public static boolean isInternetAvailable() {
		try {
			InetAddress ipAddr = InetAddress.getByName("www.google.com"); // You can
																		// replace
																		// it
																		// with
																		// your
																		// name

			if (ipAddr.equals("")) {
				return false;
			} else {
				return true;
			}

		} catch (Exception e) {
			return false;
		}

	}
}
