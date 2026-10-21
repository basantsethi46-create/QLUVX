
package com.example.qluvx;

import android.app.Activity;
import android.os.Bundle;
import android.graphics.Color;
import android.view.Gravity;
import android.widget.LinearLayout;
import android.widget.TextView;

public class LiveAudioRoomActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().setStatusBarColor(Color.rgb(12, 12, 16));
        getWindow().setNavigationBarColor(Color.rgb(12, 12, 16));

        LinearLayout root = new LinearLayout(this);
        root.setOrientation(LinearLayout.VERTICAL);
        root.setGravity(Gravity.CENTER);
        root.setPadding(24, 24, 24, 24);
        root.setBackgroundColor(Color.rgb(12, 12, 16));

        TextView title = new TextView(this);
        title.setText("QLUVX VOICE ROOM");
        title.setTextColor(Color.rgb(244, 66, 170));
        title.setTextSize(26);
        title.setGravity(Gravity.CENTER);
        root.addView(title);

        TextView info = new TextView(this);
        info.setText(
            "Voice Room setup\n\n" +
            "Room ID: qluvx-room-1\n\n" +
            "ZEGO authentication and SDK connection\n" +
            "are required to start a real room."
        );
        info.setTextColor(Color.WHITE);
        info.setTextSize(16);
        info.setGravity(Gravity.CENTER);
        info.setPadding(0, 24, 0, 0);
        root.addView(info);

        setContentView(root);
    }
}
