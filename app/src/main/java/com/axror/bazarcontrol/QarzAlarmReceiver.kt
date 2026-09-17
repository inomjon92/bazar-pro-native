package com.axror.bazarcontrol

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.telephony.SmsManager
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale

class QarzAlarmReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        val sdf = SimpleDateFormat("HH:mm", Locale.getDefault())
        val joriyVaqt = sdf.format(new Date())

        val targetTel = "+998901234567"
        val targetIsm = "Alijon"
        val qarzVaqt = "18:00"

        if (joriyVaqt == qarzVaqt) {
            try {
                val smsMatni = "Hurmatli $targetIsm, qarzni to'lash vaqti keldi. BazarControl Pro."
                val smsManager = SmsManager.getDefault()
                smsManager.sendTextMessage(targetTel, null, smsMatni, null, null)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    companion object {
        fun startAlarmTimer(context: Context) {
            val intent = Intent(context, QarzAlarmReceiver::class.java)
            val pi = PendingIntent.getBroadcast(context, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE)
            val am = context.getSystemService(Context.ALARM_SERVICE) as AlarmManager?
            am?.setRepeating(AlarmManager.RTC_WAKEUP, Calendar.getInstance().timeInMillis, 60000, pi)
        }
    }
}
