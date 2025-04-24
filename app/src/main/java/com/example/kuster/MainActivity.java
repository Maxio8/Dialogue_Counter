package com.example.kuster;

import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private int licznik = 0;
    private TextView licznikTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        licznikTextView = findViewById(R.id.licznik);
        Button button = findViewById(R.id.button);

        button.setOnClickListener(v -> showAlertDialog());
    }

    private void showAlertDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Czy na pewno chcesz usunąć dane?");

        builder.setPositiveButton("Tak", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                licznik++;
                updateText();
                Toast.makeText(MainActivity.this, "Dane zostały usunięte", Toast.LENGTH_SHORT).show();
            }
        });

        builder.setNegativeButton("Nie", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "Anulowano", Toast.LENGTH_SHORT).show();
            }
        });

        builder.create().show();
    }

    private void updateText() {
        String tekst;
        if (licznik == 1) {
            tekst = "Dane usunięto: 1 raz";
        } else {
            tekst = "Dane usunięto: " + licznik + " razy";
        }
        licznikTextView.setText(tekst);
    }
}