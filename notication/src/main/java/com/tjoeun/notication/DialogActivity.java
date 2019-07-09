package com.tjoeun.notication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class DialogActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);

        TextView txt = (TextView)findViewById(R.id.txt);
        for(int i=1; i<=10; i=i+1){
            try{
                Thread.sleep(3000);
                txt.setText(i + "");
            }catch(Exception e){}

        }

        Button basicdialog = (Button)findViewById(R.id.basic);
        basicdialog.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v){
                //대화상자 생성
                Dialog dlg = new Dialog(DialogActivity.this);
                //대화상자에 출력할 뷰 생성
                TextView txt = new TextView(DialogActivity.this);
                txt.setText("대화상자에 출력할 뷰를 직접 생성");
                //대화 상자에 출력할 뷰를 설정
                dlg.setContentView(txt);
                //대화상자 출력
                dlg.show();
            }
        });

        Button alert = (Button)findViewById(R.id.alert);
        alert.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v){
                //메소드의 수행 결과를 가지고 다음 메소드를 바로 호출
                new AlertDialog.Builder(DialogActivity.this)
                        .setTitle("알림 대화상자")
                        .setMessage("대화상자에 출력하는 메시지")
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .setPositiveButton("확인", null)
                        .setNegativeButton("취소", null)
                        .show();

                //액티비티를 닫는 메소드 호출
                //finish(); --> show밑에 있으면 실행과 동시에 수행되서 버튼을 누르자마자 종료

                Toast.makeText(DialogActivity.this, "토스트 출력", Toast.LENGTH_LONG)
                        .show();
            }
        });
    }
}
