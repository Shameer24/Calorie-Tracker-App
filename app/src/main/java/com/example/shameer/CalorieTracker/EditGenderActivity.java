package com.example.shameer.CalorieTracker;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

public class EditGenderActivity extends AppCompatActivity {

    private Button button;
    private Toolbar toolbar;
    private static String gender="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_name);

       // editName = (EditText) findViewById(R.id.editname);

        button = (Button) findViewById(R.id.okbutton);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Gender");

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fragment = new ProfileFragment();
                getSupportFragmentManager().beginTransaction().replace(R.id.genderfrag, fragment).commit();
            }
        });

    }

    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.radioButton:
                if (checked)
                    gender="Male";
                // Pirates are the best
                break;
            case R.id.radioButton2:
                if (checked)
                    gender="Female";
                // Ninjas rule
                break;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_button_save, menu);
        return super.onCreateOptionsMenu(menu);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        if (id == R.id.button_save) {

            Intent intent = new Intent(this, MainActivity.class);
            intent.putExtra("Type","gender");
            intent.putExtra("Value", gender);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }
}
