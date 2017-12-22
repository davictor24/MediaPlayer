package com.physicalelectronics.mediaplayer;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mediaPlayer = MediaPlayer.create(this, R.raw.mozart);

        Button playButton = (Button) findViewById(R.id.play_button);
        Button stopButton = (Button) findViewById(R.id.stop_button);

        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mediaPlayer == null)
                    mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.mozart);

                if (mediaPlayer.isPlaying()) {
                    mediaPlayer.pause();
                    Toast.makeText(getApplicationContext(), "Song paused", Toast.LENGTH_SHORT).show();
                } else {
                    mediaPlayer.start();
                    Toast.makeText(getApplicationContext(), "Song playing", Toast.LENGTH_SHORT).show();
                }
            }
        });

        stopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mediaPlayer != null) {
                    mediaPlayer.stop();
                    mediaPlayer.release();
                    mediaPlayer = null;
                    Toast.makeText(getApplicationContext(), "Song stopped", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

}
