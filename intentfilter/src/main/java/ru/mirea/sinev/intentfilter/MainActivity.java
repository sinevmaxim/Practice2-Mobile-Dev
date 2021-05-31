package ru.mirea.sinev.intentfilter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        View.OnClickListener openBrowser = v -> {
            Uri address = Uri.parse("https://www.mirea.ru/");
            Intent openLinkIntent = new Intent(Intent.ACTION_VIEW, address);
            if (openLinkIntent.resolveActivity(getPackageManager()) != null) {
                startActivity(openLinkIntent);
            } else {
                Log.d("Intent", "Не получается обработать намерение!");
            }
        };


        View.OnClickListener newApp = v -> {
            Intent shareIntent = new Intent(Intent.ACTION_SEND);
            shareIntent.setType("text/plain");
            shareIntent.putExtra(Intent.EXTRA_SUBJECT, "MIREA");
            shareIntent.putExtra(Intent.EXTRA_TEXT, "СИНЕВ МАКСИМ ИГОРЕВИЧ");
            startActivity(Intent.createChooser(shareIntent, "МОИ ФИО"));
        };

        Button browserBtn = (Button) findViewById(R.id.button);
        Button newAppBtn = (Button) findViewById(R.id.button2);

        browserBtn.setOnClickListener(openBrowser);
        newAppBtn.setOnClickListener(newApp);


    }
}