package com.mobile.belajar_mvp_mp3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.mobile.belajar_mvp_mp3.presnter.MainPresentImpl;
import com.mobile.belajar_mvp_mp3.presnter.MainView;

public class MainActivity extends AppCompatActivity implements MainView {
    Button buttonluas,buttonkeli;
    EditText et_alas,et_tinggi,et_panjang,et_lebar;
    TextView tv_hasilluas,tv_hasilkel;
    MainPresentImpl mainPresent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonluas = findViewById(R.id.luas);
        buttonkeli = findViewById(R.id.kelling);
        et_alas = findViewById(R.id.alas);
        et_tinggi = findViewById(R.id.tinggi);
        et_panjang = findViewById(R.id.panjang);
        et_lebar = findViewById(R.id.lebar);
        tv_hasilluas = findViewById(R.id.hasilluas);
        tv_hasilkel = findViewById(R.id.hasilkeliling);
        initPresenter();

        buttonluas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Double alas = Double.valueOf(et_alas.getText().toString());
                Double tinggi = Double.valueOf(et_tinggi.getText().toString());

                mainPresent.luas(alas,tinggi);
            }
        });
        buttonkeli.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Double panjang = Double.valueOf(et_panjang.getText().toString());
                Double lebar = Double.valueOf(et_lebar.getText().toString());

                mainPresent.keliling(panjang,lebar);
            }
        });
    }

    private void initPresenter() {
        mainPresent = new MainPresentImpl(this);
    }

    @Override
    public void hasilluas(Double hasilluas) {
        tv_hasilluas.setText(hasilluas.toString());

    }

    @Override
    public void hasilkel(Double hasilkeliling) {
        tv_hasilkel.setText(hasilkeliling.toString());
    }
}