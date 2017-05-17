package target.aula.cursoandroid.service;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.StrictMode;
import android.util.Log;
import android.widget.Toast;

import com.google.gson.Gson;

import java.io.IOException;

import target.aula.cursoandroid.Comunicacao;
import target.aula.cursoandroid.telegram.GetUpdates;

/**
 * Created by sala01 on 17/05/2017.
 */

public class AndroidServiceStartOnBoot extends Service {

    private static boolean iniciado = false;

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    public void onCreate() {
        iniciado = true;
        super.onCreate();

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        PendingIntent pendingIntent = PendingIntent.getService(this, 0, new Intent(this, AndroidServiceStartOnBoot.class), 0);
        AlarmManager alarm = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        alarm.setRepeating(AlarmManager.RTC_WAKEUP, System.currentTimeMillis(), 60 * 1000, pendingIntent);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        Log.d("R", "EXEUTANDO AndroidServiceStartOnBoot");
        Toast.makeText(getApplicationContext(), "CHAMA ESTA PORÁ", Toast.LENGTH_LONG).show();
        Comunicacao c = new Comunicacao();

        try {
            String json = c.get("https://api.telegram.org/bot187061445:AAHxm6dXxDpaN4gTwwNDswQyVyv0_EPRKns/getUpdates");

            Log.d("JSON", json);

            GetUpdates getUpdates = new Gson().fromJson(json, GetUpdates.class);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return super.onStartCommand(intent, flags, startId);
    }

    public static boolean isIniciado() {
        return iniciado;
    }
}
