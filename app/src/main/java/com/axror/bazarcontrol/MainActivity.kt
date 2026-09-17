package com.axror.bazarcontrol

import android.app.Activity
import android.os.Bundle
import android.widget.Toast

class MainActivity : Activity() {
    override fun onCreate(savedInstanceState) {
        super.onCreate(savedInstanceState)
        QarzAlarmReceiver.startAlarmTimer(this)
        Toast.makeText(this, "BazarControl Pro faollashdi! 🔒", Toast.LENGTH_LONG).show()
    }
}
