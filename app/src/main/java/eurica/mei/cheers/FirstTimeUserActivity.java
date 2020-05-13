package eurica.mei.cheers;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class FirstTimeUserActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_time_user);

//        Init
        final EditText etUsername = (EditText) findViewById(R.id.etUsername);
        Button btn_next = (Button) findViewById(R.id.btn_next);

        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //stored data in SharedPreferences
                SharedPreferences prefs = getSharedPreferences("UserData", MODE_PRIVATE);
                SharedPreferences.Editor editor = prefs.edit();
                editor.putString("username", etUsername.getText().toString());
                editor.apply();

                //go to main activity
                Intent i = new Intent(FirstTimeUserActivity.this, MainActivity.class);
                startActivity(i);
                finish();
            }
        });

    }
}
