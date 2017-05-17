package target.aula.cursoandroid.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * Created by sala01 on 17/05/2017.
 */

public class BroadcastReceiverOnBootComplete extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equalsIgnoreCase(Intent.ACTION_BOOT_COMPLETED)) {
            if(!AndroidServiceStartOnBoot.isIniciado()) {
                Intent serviceIntent = new Intent(context, AndroidServiceStartOnBoot.class);
                context.startService(serviceIntent);
            }
        }
    }
}
