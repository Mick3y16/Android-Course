package hk.ust.cse.comp107x.timegreetfriend;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Calendar;
import java.util.Date;


public class MainActivity extends Activity implements View.OnClickListener {

    Button greetButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // get a reference to the greetButton on the UI
        greetButton = (Button) findViewById(R.id.greetButton);
        // Set the onClickListener for the greetButton to be this class.
        // This requires that the class implement the View.OnClickListener callback
        // the onClick() method
        greetButton.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {

        // get a reference to the TextView on the UI
        TextView textMessage = (TextView) findViewById(R.id.textMessage);

        //get a reference to the EditText so that we can read in the value typed
        // by the user
        EditText editFriendName = (EditText) findViewById(R.id.editFriendName);

        // get the name of the friend typed in by the user in the EditText field
        String friendName = editFriendName.getText().toString();

        // TODO 1
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int hour = calendar.get(Calendar.HOUR_OF_DAY);

        switch (v.getId()) {
            case R.id.greetButton:

                String greetString = "";

                if ((hour >= 6) && (hour < 12)) {
                    greetString = getString(R.string.goodmorning);
                } else if ((hour >= 12) && (hour < 17)) {
                    greetString = getString(R.string.goodafternoon);
                } else if ((hour >= 17) && (hour < 21)) {
                    greetString = getString(R.string.goodevening);
                } else if ((hour >= 21) || (hour < 6)) {
                    greetString = getString(R.string.goodnight);
                }

                textMessage.setText(greetString + friendName + "!");

                break;
            default:
                break;
        }
    }
}
