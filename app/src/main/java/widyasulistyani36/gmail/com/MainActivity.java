package widyasulistyani36.gmail.com;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity  implements View.OnClickListener {

    //MainActivity mengextends sifat/atribut dari AppCompatActivity lalu mengimplemens OnClickListener
    EditText editWaktu;
    Button tombolPlay, tombolStop;
    //Variabel variabel yang digunakan pada aplikasi ini
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editWaktu = (EditText) findViewById(R.id.et_waktu);
        tombolPlay = (Button) findViewById(R.id.bt_play);
        tombolStop = (Button) findViewById(R.id.bt_stop);
        tombolPlay.setOnClickListener(this);
        tombolStop.setOnClickListener(this);
    }
    @Override
    public void onClick(View v){
        switch (v.getId()){
            case R.id.bt_play:
                callPlay();
                break;

            case R.id.bt_stop:
                callStop();
                break;
        }
    }

    public void callPlay(){
        int detik = Integer.parseInt(editWaktu.getText().toString());

        Intent intent = new Intent(MainActivity.this, MyService.class);

        PendingIntent pendingIntent = PendingIntent.getService(MainActivity.this,0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
        //Untuk memberikan alarm manual menggunakan getSystemService
        if(alarmManager !=null){
            alarmManager.set(AlarmManager.RTC_WAKEUP,System.currentTimeMillis()+(detik*1000),pendingIntent);
            Toast.makeText(getApplicationContext(),"Song Play After"+detik+"second!", Toast.LENGTH_LONG).show();
        }
    }

    public void callStop(){
        stopService(new Intent(MainActivity.this, MyService.class));
    }
}
