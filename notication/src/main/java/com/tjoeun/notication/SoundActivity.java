package com.tjoeun.notication;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class SoundActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sound);

        Button vid = (Button)findViewById(R.id.vib);
        Button syssound = (Button)findViewById(R.id.syssound);
        Button ressound = (Button)findViewById(R.id.ressound);

        vid.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v){
                //진동 객체 생성
                Vibrator vibrator = (Vibrator)getSystemService(VIBRATOR_SERVICE);

                //진동
                vibrator.vibrate(10000);
            }
       });

        syssound.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v){
                //시스템 사운드의 경로 만들기
                Uri noti = RingtoneManager.getDefaultUri(
                        RingtoneManager.TYPE_ALARM);
                // 재생가능한 사운드 만들기
                Ringtone ringtone = RingtoneManager.getRingtone(
                        getApplicationContext(), noti);

                //재생
                ringtone.play();
            }
        });

        ressound.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v){

            MediaPlayer player = MediaPlayer.create(
                    getApplicationContext(),
                    R.raw.buttoneffect);
            player.start();
         }
        });

        Button toast = (Button)findViewById(R.id.toast);
        toast.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v){
                Toast.makeText(getApplicationContext(), "토스트 문자열", Toast.LENGTH_LONG).show();

            }
        });


    }
}
