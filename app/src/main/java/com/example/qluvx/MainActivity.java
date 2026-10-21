
package com.example.qluvx;

import android.app.Activity;
import android.os.Bundle;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

    private final int background = Color.rgb(12, 12, 16);
    private final int cardColor = Color.rgb(30, 30, 38);
    private final int accent = Color.rgb(244, 66, 170);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().setStatusBarColor(background);
        getWindow().setNavigationBarColor(background);

        ScrollView scroll = new ScrollView(this);
        scroll.setFillViewport(true);
        scroll.setBackgroundColor(background);

        LinearLayout root = new LinearLayout(this);
        root.setOrientation(LinearLayout.VERTICAL);
        root.setPadding(dp(20), dp(28), dp(20), dp(24));
        scroll.addView(root);

        TextView title = new TextView(this);
        title.setText("QLUVX");
        title.setTextColor(accent);
        title.setTextSize(34);
        title.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
        root.addView(title);

        TextView subtitle = new TextView(this);
        subtitle.setText("CONNECT • CHAT • LIVE");
        subtitle.setTextColor(Color.LTGRAY);
        subtitle.setTextSize(14);
        LinearLayout.LayoutParams sp = params(-1, -2);
        sp.bottomMargin = dp(28);
        root.addView(subtitle, sp);

        TextView welcome = new TextView(this);
        welcome.setText("Welcome to QLUVX");
        welcome.setTextColor(Color.WHITE);
        welcome.setTextSize(24);
        welcome.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
        root.addView(welcome);

        TextView info = new TextView(this);
        info.setText("Meet people. Discover creators. Join live rooms.");
        info.setTextColor(Color.LTGRAY);
        info.setTextSize(14);
        LinearLayout.LayoutParams ip = params(-1, -2);
        ip.topMargin = dp(8);
        ip.bottomMargin = dp(24);
        root.addView(info, ip);

        addCard(root, "LIVE VIDEO",
                "Start or watch a live broadcast",
                "Open Live Video");

        addCard(root, "VOICE ROOM",
                "Talk with people in a voice room",
                "Open Voice Room");

        addCard(root, "DISCOVER",
                "Find creators and popular rooms",
                "Explore");

        addCard(root, "CHAT",
                "Connect with your friends",
                "Open Chat");

        addCard(root, "MY PROFILE",
                "Your account and settings",
                "Open Profile");

        TextView footer = new TextView(this);
        footer.setText("QLUVX");
        footer.setTextColor(Color.GRAY);
        footer.setGravity(Gravity.CENTER);
        footer.setPadding(0, dp(20), 0, dp(10));
        root.addView(footer);

        setContentView(scroll);
    }

    private void addCard(LinearLayout root, String heading,
                         String description, String buttonText) {

        LinearLayout card = new LinearLayout(this);
        card.setOrientation(LinearLayout.VERTICAL);
        card.setPadding(dp(16), dp(16), dp(16), dp(16));

        GradientDrawable shape = new GradientDrawable();
        shape.setColor(cardColor);
        shape.setCornerRadius(dp(16));
        shape.setStroke(dp(1), Color.rgb(65, 55, 70));
        card.setBackground(shape);

        TextView name = new TextView(this);
        name.setText(heading);
        name.setTextColor(Color.WHITE);
        name.setTextSize(18);
        name.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
        card.addView(name);

        TextView desc = new TextView(this);
        desc.setText(description);
        desc.setTextColor(Color.LTGRAY);
        desc.setTextSize(14);

        LinearLayout.LayoutParams dpParams = params(-1, -2);
        dpParams.topMargin = dp(7);
        dpParams.bottomMargin = dp(12);
        card.addView(desc, dpParams);

        Button button = new Button(this);
        button.setText(buttonText);
        button.setAllCaps(false);
        button.setTextColor(Color.WHITE);
        button.setBackgroundTintList(
                android.content.res.ColorStateList.valueOf(accent));

        button.setOnClickListener(v -> {
            String message = heading + " selected. SDK/backend setup is required.";
            Toast.makeText(this, message, Toast.LENGTH_LONG).show();
        });

        card.addView(button);

        LinearLayout.LayoutParams cp = params(-1, -2);
        cp.bottomMargin = dp(14);
        root.addView(card, cp);
    }

    private LinearLayout.LayoutParams params(int width, int height) {
        return new LinearLayout.LayoutParams(width, height);
    }

    private int dp(int value) {
        return (int) (value * getResources()
                .getDisplayMetrics().density + 0.5f);
    }
                         }
