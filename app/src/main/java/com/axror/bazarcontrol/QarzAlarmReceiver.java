package com.axror.bazarcontrol;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.SmsManager;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class QarzAlarmReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm", Locale.getDefault());
        String joriyVaqt = sdf.format(new Date());

        String targetTel = "+998901234567";
        String targetIsm = "Alijon";
        String qarzVaqt = "18:00"; 

        if (joriyVaqt.equals(qarzVaqt)) {
            try {
                String smsMatni = "Hurmatli " + targetIsm + ", qarzni to'lash vaqti keldi. BazarControl Pro.";
                SmsManager smsManager = SmsManager.getDefault();
                smsManager.sendTextMessage(targetTel, null, smsMatni, null, null);
            } catch (Exception e) { 
                e.printStackTrace(); 
            }
        }
    }

    public static void startAlarmTimer(Context context) {
        Intent intent = new Intent(context, QarzAlarmReceiver.class);
        PendingIntent pi = PendingIntent.getBroadcast(context, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT | PendingIntent.FLAG_IMMUTABLE);
        AlarmManager am = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
        if (am != null) {
            am.setRepeating(AlarmManager.RTC_WAKEUP, Calendar.getInstance().getTimeInMillis(), 60000, pi);
        }
    }
}
