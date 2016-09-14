package course.labs.activitylab;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

public class ActivityOne extends Activity {

		// string for logcat documentation
		private final static String TAG = "Lab-ActivityOne";

		// lifecycle counts
		// Create 7 counter variables, each corresponding to a different one of the lifecycle
		// callback methods.
		// You will need to increment these variables' values when their corresponding lifecycle
		// methods get called.

		private int createCtr = 0;
		private int startCtr = 0;
		private int resumeCtr = 0;
		private int pauseCtr = 0;
		private int stopCtr = 0;
		private int restartCtr = 0;
		private int destroyCtr = 0;
		
		@Override
		protected void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			setContentView(R.layout.activity_one);
			TextView view;
			// Do we have saved state?
			if (savedInstanceState != null){
				createCtr = savedInstanceState.getInt("Create count");
				view = (TextView)findViewById(R.id.create);
				view.setText(getString(R.string.onCreate) + " " + createCtr);

				startCtr = savedInstanceState.getInt("Start count");
				view = (TextView)findViewById(R.id.start);
				view.setText(getString(R.string.onStart) + " " + startCtr);

				resumeCtr = savedInstanceState.getInt("Resume count");
				view = (TextView)findViewById(R.id.resume);
				view.setText(getString(R.string.onResume) + " " + resumeCtr);

				pauseCtr = savedInstanceState.getInt("Pause count");
				view = (TextView)findViewById(R.id.pause);
				view.setText(getString(R.string.onPause) + " " + pauseCtr);

				stopCtr = savedInstanceState.getInt("Stop count");
				view = (TextView)findViewById(R.id.stop);
				view.setText(getString(R.string.onStop) + " " + stopCtr);

				restartCtr = savedInstanceState.getInt("Restart count");
				view = (TextView)findViewById(R.id.restart);
				view.setText(getString(R.string.onRestart) + " " + restartCtr);

				destroyCtr = savedInstanceState.getInt("Destroy count");
				view = (TextView)findViewById(R.id.destroy);
				view.setText(getString(R.string.onDestroy) + " " + destroyCtr);

			}

			SharedPreferences prefs = getPreferences(MODE_PRIVATE);

			view = (TextView)findViewById(R.id.create);
            createCtr = prefs.getInt("Create count", 0);
			view.setText(getString(R.string.onCreate) + " " + createCtr);

			view = (TextView)findViewById(R.id.start);
            startCtr = prefs.getInt("Start count", 0);
			view.setText(getString(R.string.onStart) + " " + startCtr);

			view = (TextView)findViewById(R.id.resume);
            resumeCtr = prefs.getInt("Resume count", 0);
			view.setText(getString(R.string.onResume) + " " + resumeCtr);

			view = (TextView)findViewById(R.id.pause);
            pauseCtr = prefs.getInt("Pause count", 0);
			view.setText(getString(R.string.onPause) + " " + pauseCtr);

			view = (TextView)findViewById(R.id.stop);
            stopCtr = prefs.getInt("Stop count", 0);
			view.setText(getString(R.string.onStop) + " " + stopCtr);

			view = (TextView)findViewById(R.id.restart);
            restartCtr = prefs.getInt("Restart count", 0);
			view.setText(getString(R.string.onRestart) + " " + restartCtr);

			view = (TextView)findViewById(R.id.destroy);
            destroyCtr = prefs.getInt("Destroy count", 0);
			view.setText(getString(R.string.onDestroy) + " " + destroyCtr);


			//Log cat print out
			Log.i(TAG, "onCreate called");

			//update the appropriate count variable
			//update the view
			createCtr++;
			TextView create = (TextView)findViewById(R.id.create);
			create.setText(getString(R.string.onCreate) + " " + createCtr);
		}

		@Override
		public boolean onCreateOptionsMenu(Menu menu) {
			// Inflate the menu; this adds items to the action bar if it is present.
			getMenuInflater().inflate(R.menu.activity_one, menu);
			return true;
		}
		
		// lifecycle callback overrides
		
		@Override
		public void onStart(){
			super.onStart();
			
			//Log cat print out
			Log.i(TAG, "onStart called");

			//update the appropriate count variable
			//update the view
			startCtr++;
			TextView start = (TextView)findViewById(R.id.start);
			start.setText(getString(R.string.onStart) + " " + startCtr);
		}

	    // TODO: implement 5 missing lifecycle callback methods
		@Override
		public void onResume(){
			super.onResume();

			//Log cat print out
			Log.i(TAG, "onResume called");

			//update the appropriate count variable
			//update the view
			resumeCtr++;
			TextView resume = (TextView)findViewById(R.id.resume);
			resume.setText(getString(R.string.onResume) + " " + resumeCtr);
		}

		@Override
		public void onPause(){
			super.onPause();

			//Log cat print out
			Log.i(TAG, "onPause called");

			//update the appropriate count variable
			//update the view
			pauseCtr++;
			TextView pause = (TextView)findViewById(R.id.pause);
			pause.setText(getString(R.string.onPause) + " " + pauseCtr);
		}

		@Override
		public void onStop(){
			super.onStop();

			//Log cat print out
			Log.i(TAG, "onStop called");

			//update the appropriate count variable
			//update the view
			stopCtr++;
			TextView stop = (TextView)findViewById(R.id.stop);
			stop.setText(getString(R.string.onStop) + " " + stopCtr);

			SharedPreferences prefs = getPreferences(MODE_PRIVATE);
			SharedPreferences.Editor editor= prefs.edit();
			editor.putInt("Create count", createCtr);
			editor.putInt("Start count", startCtr);
			editor.putInt("Resume count", resumeCtr);
			editor.putInt("Pause count", pauseCtr);
			editor.putInt("Stop count", stopCtr);
			editor.putInt("Restart count", restartCtr);
			editor.putInt("Destroy count", destroyCtr);
			editor.commit();

		}

		@Override
		public void onRestart(){
			super.onRestart();

			//Log cat print out
			Log.i(TAG, "onRestart called");

			//update the appropriate count variable
			//update the view
			restartCtr++;
			TextView restart = (TextView)findViewById(R.id.restart);
			restart.setText(getString(R.string.onRestart)+ " " + restartCtr);
		}

		@Override
		public void onDestroy(){
			super.onDestroy();

			//Log cat print out
			Log.i(TAG, "onDestroy called");

			//update the appropriate count variable
			//update the view
			destroyCtr++;
			TextView destroy = (TextView)findViewById(R.id.destroy);
			destroy.setText(getString(R.string.onDestroy) + " " + destroyCtr);
	}

		@Override
		public void onSaveInstanceState(Bundle savedInstanceState){
			// save state information with a collection of key-value pairs
			// save all  count variables
			super.onSaveInstanceState(savedInstanceState);
			savedInstanceState.putInt("Create count", createCtr);
			savedInstanceState.putInt("Start count", startCtr);
			savedInstanceState.putInt("Resume count", resumeCtr);
			savedInstanceState.putInt("Pause count", pauseCtr);
			savedInstanceState.putInt("Stop count", stopCtr);
			savedInstanceState.putInt("Restart count", restartCtr);
			savedInstanceState.putInt("Destroy count", destroyCtr);
		}
		
		public void launchActivityTwo(View view) {
			// This function launches Activity Two. 
			// Hint: use Context’s startActivity() method.
			Intent intent = new Intent(ActivityOne.this, ActivityTwo.class);
			ActivityOne.this.startActivity(intent);

		}
		

}
