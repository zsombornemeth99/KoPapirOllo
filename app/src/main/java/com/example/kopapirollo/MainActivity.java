package com.example.kopapirollo;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private ImageView imageHp1Gep, imageHp2Gep, imageHp3Gep, imageHp1Jatekos, imageHp2Jatekos, imageHp3Jatekos, gepValaszt, JatekosValaszt;
    private ImageButton buttonKo, buttonPapir, buttonOllo;
    private TextView textX;
    private Random r;
    private int dontetlen, jatekosPontjai, gepPontjai;
    private Toast toast;
    private AlertDialog felugroUzenet;
    private AlertDialog.Builder felugroUzenetbuilder;

    private void init() {
        imageHp1Gep = findViewById(R.id.iv_hp1);
        imageHp2Gep = findViewById(R.id.iv_hp2);
        imageHp3Gep = findViewById(R.id.iv_hp3);
        imageHp1Jatekos = findViewById(R.id.iv_hp4);
        imageHp2Jatekos = findViewById(R.id.iv_hp5);
        imageHp3Jatekos = findViewById(R.id.iv_hp6);
        gepValaszt = findViewById(R.id.iv_GepValasztasa);
        JatekosValaszt = findViewById(R.id.iv_JatekosValasztasa);
        buttonKo = findViewById(R.id.ib_ko);
        buttonPapir = findViewById(R.id.ib_papir);
        buttonOllo = findViewById(R.id.ib_ollo);
        textX = findViewById(R.id.tv_X);
        r = new Random();
        dontetlen = 0;
        gepPontjai = 0;
        jatekosPontjai = 0;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        felugroUzenetbuilder = new AlertDialog.Builder(MainActivity.this);
        felugroUzenetbuilder.setMessage("Szeretnél új játékot?")
                .setPositiveButton("Igen", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dontetlen = 0;
                        gepPontjai = 0;
                        jatekosPontjai = 0;
                        imageHp1Gep.setImageResource(R.drawable.heart2);
                        imageHp2Gep.setImageResource(R.drawable.heart2);
                        imageHp3Gep.setImageResource(R.drawable.heart2);
                        imageHp1Jatekos.setImageResource(R.drawable.heart2);
                        imageHp3Jatekos.setImageResource(R.drawable.heart2);
                        imageHp3Jatekos.setImageResource(R.drawable.heart2);
                        textX.setText("Döntetlenek száma: 0");
                    }
                })
                .setNegativeButton("Nem", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                        dialog.cancel();
                    }
                })
                .setTitle("Játék vége")
                .setCancelable(false);
        felugroUzenet = felugroUzenetbuilder.create();


    }
}
