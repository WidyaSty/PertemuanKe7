package widyasulistyani36.gmail.com;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.support.annotation.Nullable;

public class MyService extends Service {

        MediaPlayer mediaPlayer;

        @Nullable
        @Override
        public IBinder onBind(Intent intent) {
            return null;
        }

        @Override
        public void onCreate() {
            mediaPlayer = MediaPlayer.create(this, R.raw.perfect);
            mediaPlayer.setLooping(true);
            super.onCreate();
        }
        //Mengambil lagu lalu setLooping
        @Override
        public int onStartCommand(Intent intent, int flags, int startId) {
            mediaPlayer.start();
            return START_STICKY;
        }
        //Mulai memainkan musik
        @Override
        public void onDestroy(){
            mediaPlayer.start();
            //Mematikan musik

        }
    }
