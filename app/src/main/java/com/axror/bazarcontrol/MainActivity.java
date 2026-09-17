package com.axror.bazarcontrol;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        QarzAlarmReceiver.startAlarmTimer(this);
        Toast.makeText(this, "BazarControl Pro faollashdi! 🔒", Toast.LENGTH_LONG).show();
    }
}
