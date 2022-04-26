package example.com.sharedpref;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class DisplayScreen extends AppCompatActivity {
    Button logout, start;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.display_info);
        logout = (Button)findViewById(R.id.logout);
        start = (Button)findViewById(R.id.start);

        SharedPreferences preferences = getSharedPreferences("MYPREFS", MODE_PRIVATE);
        String display = preferences.getString("display", " ");

        TextView displayInfo = (TextView) findViewById(R.id.textViewName);
        displayInfo.setText(display);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(DisplayScreen.this, MainActivity.class);
                startActivity(i);
                Toast.makeText(DisplayScreen.this, "Logout Successfully without attempting Quiz.", Toast.LENGTH_SHORT).show();

            }


        });
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(DisplayScreen.this, QuizActivity.class);
                startActivity(i);

            }
        });



    }
}
