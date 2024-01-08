package com.example.alert_dialog;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button exitButton;
    private AlertDialog.Builder alert_Dialog_Builder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        exitButton = findViewById(R.id.exitButton_Id);
        exitButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        alert_Dialog_Builder = new AlertDialog.Builder(MainActivity.this);

        //for setting titel
        alert_Dialog_Builder.setTitle(R.string.titel_text);

        //for setting message
        alert_Dialog_Builder.setMessage(R.string.message_text);

        //for setting Icon
        alert_Dialog_Builder.setIcon(R.drawable.warning);


        alert_Dialog_Builder.setCancelable(false);



        alert_Dialog_Builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });

        alert_Dialog_Builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        alert_Dialog_Builder.setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this,"You have clicked on cancel button",Toast.LENGTH_SHORT).show();
            }
        });

        AlertDialog alertDialog = alert_Dialog_Builder.create();
        alertDialog.show();

    }
}