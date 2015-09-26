package com.sleekcreative.testinginadroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button button = (Button) findViewById(R.id.email_sign_in_button);
        button.setOnClickListener(this);
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_login, menu);
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
        switch(v.getId()){
            case R.id.email_sign_in_button:
                AutoCompleteTextView textView = (AutoCompleteTextView)findViewById(R.id.email);
                String email = textView.getText().toString().trim();

                EditText editText = (EditText)findViewById(R.id.password);
                String password = editText.getText().toString().trim();

                TextView errorTextView = (TextView) findViewById(R.id.error_text);

                if( email.length() == 0 || password.length() == 0 ) {
                    errorTextView.setVisibility(View.VISIBLE);
                }
                else{
                    errorTextView.setVisibility(View.INVISIBLE);
                    Intent i = new Intent(this, MainActivity.class);
                    i.putExtra(MainActivity.EXTRA, email);
                    startActivity(i);
                    finish();
                }

                break;
        }
    }
}
