package com.example.datepicker;

import android.app.DatePickerDialog;
import android.icu.util.Calendar;

import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    //部品の変数
    EditText showDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //部品の取得
        showDate = (EditText) findViewById(R.id.showDate);

        //EditTextにリスナーをつける
        showDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Calendarインスタンスを取得
                final Calendar date;
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
                    date = Calendar.getInstance();

                    //DatePickerDialogインスタンスを取得
                    DatePickerDialog datePickerDialog = new DatePickerDialog(
                            MainActivity.this,
                            new DatePickerDialog.OnDateSetListener() {
                                @Override
                                public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                                    //setした日付を取得して表示
                                    showDate.setText(String.format("%d / %02d / %02d", year, month+1, dayOfMonth));
                                }
                            },
                            date.get(Calendar.YEAR),
                            date.get(Calendar.MONTH),
                            date.get(Calendar.DATE)
                    );

                    //dialogを表示
                    datePickerDialog.show();
                }



            }
        });

    }
}