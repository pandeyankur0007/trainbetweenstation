package com.example.ankur.trainbetweenstation;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    Button findTrainBtn;
    EditText dojEditText;
    String dateandmonth;
    EditText sourceCode;
    EditText destinationCode;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("TrainBetweenStation");

        dojEditText = (EditText) findViewById(R.id.dojEdit);
        findTrainBtn = (Button) findViewById(R.id.btnFindTrain);

        sourceCode = (EditText) findViewById(R.id.search1);
        destinationCode = (EditText) findViewById(R.id.search2);
        dojEditText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //
                DatePickerDialog dialog = new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {

                        String str = dayOfMonth + "-" + (monthOfYear + 1) + "-" + year;
                        dateandmonth = dayOfMonth + "-" + (monthOfYear + 1);
                        dojEditText.setText(str);
                    }
                }, 2016, 7, 20);
                dialog.show();
            }
        });

        findTrainBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String fromCode = sourceCode.getText().toString();
                String toCode = destinationCode.getText().toString();
                Intent intent = new Intent(MainActivity.this, TrainBetweenStationInfo.class);

                intent.putExtra("FromCode", fromCode);
                intent.putExtra("ToCode", toCode);
                intent.putExtra("DOJ", dateandmonth);
                startActivityForResult(intent, 101);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 101) {
            sourceCode.setText("");
            destinationCode.setText("");
            dojEditText.setText("");
        }
    }

}
