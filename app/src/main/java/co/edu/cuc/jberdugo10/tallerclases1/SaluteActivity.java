package co.edu.cuc.jberdugo10.tallerclases1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;


public class SaluteActivity extends AppCompatActivity {

    private TextView mFirstNameText, mSecondNameText,mFirstLastNameText, mSecondLastNameText,
            mAgeText, mSexText, mBloodTypeText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_salute);

        mFirstNameText = (TextView) findViewById(R.id.first_name_text);
        mSecondNameText = (TextView) findViewById(R.id.second_name_text);
        mFirstLastNameText = (TextView) findViewById(R.id.first_last_name_text);
        mSecondLastNameText = (TextView) findViewById(R.id.second_last_name_text);
        mAgeText = (TextView) findViewById(R.id.age_text);
        mSexText = (TextView) findViewById(R.id.sex_text);
        mBloodTypeText = (TextView) findViewById(R.id.blood_type_text);

        Intent intent = getIntent();

        String firstName = intent.getStringExtra(MainActivity.FIRST_NAME);
        String secondName = intent.getStringExtra(MainActivity.SECOND_NAME);
        String firstLastName = intent.getStringExtra(MainActivity.FIRST_LAST_NAME);
        String secondLastName = intent.getStringExtra(MainActivity.SECOND_LAST_NAME);
        String age = intent.getStringExtra(MainActivity.AGE);
        int sex = intent.getIntExtra(MainActivity.SEX, 0);
        String bloodType = intent.getStringExtra(MainActivity.BLOOD_TYPE);

        mFirstNameText.setText(firstName);
        mSecondNameText.setText(secondName);
        mFirstLastNameText.setText(firstLastName);
        mSecondLastNameText.setText(secondLastName);
        mAgeText.setText(age);
        mSexText.setText(sex);
        mBloodTypeText.setText(bloodType);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_salute, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        //int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        //if (id == R.id.action_settings) {
        //    return true;
        //}

        return super.onOptionsItemSelected(item);
    }
}
