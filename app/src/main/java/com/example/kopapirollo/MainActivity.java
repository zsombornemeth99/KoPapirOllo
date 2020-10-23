package com.example.kopapirollo;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private ImageView imageHp1Gep, imageHp2Gep, imageHp3Gep, imageHp1Jatekos, imageHp2Jatekos, imageHp3Jatekos, gepValaszt, jatekosValaszt;
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
        jatekosValaszt = findViewById(R.id.iv_JatekosValasztasa);
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
                        imageHp2Jatekos.setImageResource(R.drawable.heart2);
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

        buttonKo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jatekosValaszt.setImageResource(R.drawable.rock);
                int gepValasztas = r.nextInt(3);
                if (gepValasztas == 0) {
                    gepValaszt.setImageResource(R.drawable.rock);
                    dontetlen++;
                    textX.setText("Döntetlenek száma: "+dontetlen);
                    Toast.makeText(MainActivity.this,"Döntetlen", Toast.LENGTH_SHORT).show();
                }
                else if(gepValasztas == 1){
                    gepValaszt.setImageResource(R.drawable.paper);
                    gepPontjai++;
                    if (gepPontjai == 3){
                        felugroUzenet.show();
                    }
                    else
                        Toast.makeText(MainActivity.this,"Gép vitte a kört", Toast.LENGTH_SHORT).show();
                    switch (gepPontjai) {
                        case 1:
                            imageHp3Jatekos.setImageResource(R.drawable.heart1);
                            break;
                        case 2:
                            imageHp2Jatekos.setImageResource(R.drawable.heart1);
                            break;
                        case 3:
                            imageHp1Jatekos.setImageResource(R.drawable.heart1);
                            break;
                    }
                }
                else {
                    gepValaszt.setImageResource(R.drawable.scissors);
                    jatekosPontjai++;
                    if(jatekosPontjai == 3){
                        felugroUzenet.show();
                    }
                    else
                        Toast.makeText(MainActivity.this,"Te vitted a kört", Toast.LENGTH_SHORT).show();
                    switch (jatekosPontjai) {
                        case 1:
                            imageHp1Gep.setImageResource(R.drawable.heart1);
                            break;
                        case 2:
                            imageHp2Gep.setImageResource(R.drawable.heart1);
                            break;
                        case 3:
                            imageHp3Gep.setImageResource(R.drawable.heart1);
                            break;
                    }
                }
            }
        });
        buttonPapir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jatekosValaszt.setImageResource(R.drawable.paper);
                int gepValasztas = r.nextInt(3);
                if (gepValasztas == 0) {
                    gepValaszt.setImageResource(R.drawable.rock);
                    jatekosPontjai++;
                    if(jatekosPontjai == 3){
                        felugroUzenet.show();
                    }
                    else
                        Toast.makeText(MainActivity.this,"Te vitted a kört", Toast.LENGTH_SHORT).show();
                    switch (jatekosPontjai) {
                        case 1:
                            imageHp1Gep.setImageResource(R.drawable.heart1);
                            break;
                        case 2:
                            imageHp2Gep.setImageResource(R.drawable.heart1);
                            break;
                        case 3:
                            imageHp3Gep.setImageResource(R.drawable.heart1);
                            break;
                    }
                }
                else if(gepValasztas == 1){
                    gepValaszt.setImageResource(R.drawable.paper);
                    dontetlen++;
                    textX.setText("Döntetlenek száma: "+dontetlen);
                    Toast.makeText(MainActivity.this,"Döntetlen", Toast.LENGTH_SHORT).show();
                }
                else {
                    gepValaszt.setImageResource(R.drawable.scissors);
                    gepPontjai++;
                    if (gepPontjai == 3){
                        felugroUzenet.show();
                    }
                    else
                        Toast.makeText(MainActivity.this,"Gép vitte a kört", Toast.LENGTH_SHORT).show();
                    switch (gepPontjai) {
                        case 1:
                            imageHp3Jatekos.setImageResource(R.drawable.heart1);
                            break;
                        case 2:
                            imageHp2Jatekos.setImageResource(R.drawable.heart1);
                            break;
                        case 3:
                            imageHp1Jatekos.setImageResource(R.drawable.heart1);
                            break;
                    }
                }
            }
        });
        buttonOllo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jatekosValaszt.setImageResource(R.drawable.scissors);
                int gepValasztas = r.nextInt(3);
                if (gepValasztas == 0) {
                    gepValaszt.setImageResource(R.drawable.rock);
                    gepPontjai++;
                    if (gepPontjai == 3){
                        felugroUzenet.show();
                    }
                    else
                        Toast.makeText(MainActivity.this,"Gép vitte a kört", Toast.LENGTH_SHORT).show();
                    switch (gepPontjai) {
                        case 1:
                            imageHp3Jatekos.setImageResource(R.drawable.heart1);
                            break;
                        case 2:
                            imageHp2Jatekos.setImageResource(R.drawable.heart1);
                            break;
                        case 3:
                            imageHp1Jatekos.setImageResource(R.drawable.heart1);
                            break;
                    }
                }
                else if(gepValasztas == 1){
                    gepValaszt.setImageResource(R.drawable.paper);
                    jatekosPontjai++;
                    if(jatekosPontjai == 3){
                        felugroUzenet.show();
                    }
                    else
                        Toast.makeText(MainActivity.this,"Te vitted a kört", Toast.LENGTH_SHORT).show();
                    switch (jatekosPontjai) {
                        case 1:
                            imageHp1Gep.setImageResource(R.drawable.heart1);
                            break;
                        case 2:
                            imageHp2Gep.setImageResource(R.drawable.heart1);
                            break;
                        case 3:
                            imageHp3Gep.setImageResource(R.drawable.heart1);
                            break;
                    }
                }
                else {
                    gepValaszt.setImageResource(R.drawable.scissors);
                    dontetlen++;
                    textX.setText("Döntetlenek száma: "+dontetlen);
                    Toast.makeText(MainActivity.this,"Döntetlen", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
