package co.edu.cuc.jberdugo10.tallerclases1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    public static final String FIRST_NAME = "co.edu.cuc.jberdugo10.tallerenclases1.FIRST_NAME";
    public static final String SECOND_NAME = "co.edu.cuc.jberdugo10.tallerenclases1.SECOND_NAME";
    public static final String FIRST_LAST_NAME = "co.edu.cuc.jberdugo10.tallerenclases1.FIRST_LAST_NAME";
    public static final String SECOND_LAST_NAME = "co.edu.cuc.jberdugo10.tallerenclases1.SECOND_LAST_NAME";
    public static final String AGE = "co.edu.cuc.jberdugo10.tallerenclases1.AGE";
    public static final String SEX = "co.edu.cuc.jberdugo10.tallerenclases1.SEX";
    public static final String BLOOD_TYPE = "co.edu.cuc.jberdugo10.tallerenclases1.BLOOD_TYPE";

    private EditText mFirstNameText, mSecondNameText, mFirstLastNameText, mSecondLastNameText, mAgeText;
    private RadioGroup mSexGroup;
    private Spinner mBloodTypeSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mFirstNameText = (EditText) findViewById(R.id.first_name_text);
        mSecondNameText = (EditText) findViewById(R.id.second_name_text);
        mFirstLastNameText = (EditText) findViewById(R.id.first_last_name_text);
        mSecondLastNameText = (EditText) findViewById(R.id.second_last_name_text);
        mAgeText = (EditText) findViewById(R.id.age_text);

        mSexGroup = (RadioGroup) findViewById(R.id.sex_radio_group);

        mBloodTypeSpinner = (Spinner) findViewById(R.id.blood_spinner);

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
        //int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        //if (id == R.id.action_settings) {
        //    return true;
        //}

        return super.onOptionsItemSelected(item);
    }

    public void save(View view) {
        String firstName = mFirstNameText.getText().toString().trim();
        String secondName = mSecondNameText.getText().toString().trim();
        String firstLastName = mFirstLastNameText.getText().toString().trim();
        String secondLastName = mSecondLastNameText.getText().toString().trim();
        String age = mAgeText.getText().toString().trim();

        int selectedSex = mSexGroup.getCheckedRadioButtonId();
        int sex;
        switch (selectedSex) {
            case R.id.male_radio_button:
                sex = R.string.male_text;
                break;
            case R.id.female_radio_button:
                sex = R.string.female_text;
                break;
            default:
                Toast.makeText(this, R.string.message_select_sex, Toast.LENGTH_SHORT).show();
                return;
        }
        String[] bloodTypes = getResources().getStringArray(R.array.blood_types);
        int selectedBloodType = mBloodTypeSpinner.getSelectedItemPosition();
        String bloodType = bloodTypes[selectedBloodType];

        Intent intent = new Intent(getApplicationContext(), SaluteActivity.class)
                .putExtra(FIRST_NAME, firstName)
                .putExtra(SECOND_NAME, secondName)
                .putExtra(FIRST_LAST_NAME, firstLastName)
                .putExtra(SECOND_LAST_NAME, secondLastName)
                .putExtra(AGE, age)
                .putExtra(SEX, sex)
                .putExtra(BLOOD_TYPE, bloodType);

        startActivity(intent);

    }

    public void erase(View view) {
        mFirstNameText.setText("");
        mSecondNameText.setText("");
        mFirstLastNameText.setText("");
        mSecondLastNameText.setText("");
        mAgeText.setText("");
        mSexGroup.setSelected(false);
        mBloodTypeSpinner.setSelection(0, true);
    }

}
