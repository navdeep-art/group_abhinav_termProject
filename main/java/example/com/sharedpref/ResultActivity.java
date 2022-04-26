package example.com.sharedpref;

import android.content.Intent;
import android.os.Bundle;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ResultActivity extends AppCompatActivity {

    Button logout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        //get rating bar object
        RatingBar bar=(RatingBar)findViewById(R.id.ratingBar1);
        bar.setNumStars(5);
        bar.setStepSize(0.5f);
        //get text view
        TextView t=(TextView)findViewById(R.id.textResult);
        //get score
        Bundle b = getIntent().getExtras();
        logout = (Button) findViewById(R.id.logout);
        int score= b.getInt("score");
        //display score
        bar.setRating(score);
        switch (score)
        {
            case 0: t.setText("You scored 0%, keep learning");
                break;
            case 1: t.setText("You have 20%, do hard work");
                break;
            case 2: t.setText("You have 40%, focus on study");
                break;
            case 3: t.setText("You have 60%, Average");
                break;
            case 4:t.setText("You have 80% , focus on study and Good performance");
                break;
            case 5:t.setText("  you have 100%, Excellent Performance");
                break;
            default:t.setText("you are fail");
                break;
        }
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ResultActivity.this, MainActivity.class);
                startActivity(i);
                Toast.makeText(ResultActivity.this, "Quiz Completed! Logout Successfully", Toast.LENGTH_SHORT).show();

            }

        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_result, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            Intent settingsIntent = new Intent(this, QuizActivity.class);
            startActivity(settingsIntent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}