package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
public class MainActivity extends AppCompatActivity {
    private SeekBar seekBarFood, seekBarService, seekBarAmbiance;
    private Button submitButton;
    private TextView resultTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        seekBarFood = findViewById(R.id.seekBarFood);
        seekBarService = findViewById(R.id.seekBarService);
        seekBarAmbiance = findViewById(R.id.seekBarAmbiance);
        submitButton = findViewById(R.id.submitButton);
        resultTextView = findViewById(R.id.resultTextView);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int ratingFood = seekBarFood.getProgress();
                int ratingService = seekBarService.getProgress();
                int ratingAmbiance = seekBarAmbiance.getProgress();
                float averageRating = (ratingFood + ratingService + ratingAmbiance) / 3.0f;
// Display individual ratings for each aspect
                String result = "Food Rating: " + ratingFood +
                        "\nService Rating: " + ratingService +
                        "\nAmbiance Rating: " + ratingAmbiance +
                        "\nAverage Rating: " + averageRating;
                resultTextView.setText(result);
                Toast.makeText(getApplicationContext(), "Ratings Submitted",
                        Toast.LENGTH_SHORT).show();
            }
        });
    }
}
