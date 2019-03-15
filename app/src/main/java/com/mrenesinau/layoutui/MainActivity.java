package com.mrenesinau.layoutui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    EditText etNama;
    Button btnTampilkan, btnKosongkan;
    String aray_ulang[];
    RadioGroup RadioGroup;
    RadioButton RadioButton;
    CheckBox chIndonesia, chInggris, chArab, chMandarin, chSunda, chJawa;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNama=(EditText)findViewById(R.id.etNama);
        RadioGroup=(RadioGroup)findViewById(R.id.rdGroup);

        btnTampilkan=(Button)findViewById(R.id.btnTampilkan);
        btnTampilkan.setOnClickListener(this);

        btnKosongkan=(Button)findViewById(R.id.btnKosongkan);
        btnKosongkan.setOnClickListener(this);
        CheckBoxRekam();

    }

    public void CheckBoxRekam(){
        chIndonesia=(CheckBox)findViewById(R.id.chIndonesia);
        chArab=(CheckBox)findViewById(R.id.chArab);
        chInggris=(CheckBox)findViewById(R.id.chInggris);
        chMandarin=(CheckBox)findViewById(R.id.chMandarin);
        chSunda=(CheckBox)findViewById(R.id.chSunda);
        chJawa=(CheckBox)findViewById(R.id.chJawa);
    }

    public void onItemSelected(AdapterView<?> parent, View v, int position, long id) {
        Spinner s = (Spinner) findViewById(R.id.spinner);
        aray_ulang = new String[7];
        aray_ulang[0]="";
        aray_ulang[1]="Indonesia";
        aray_ulang[2]="Malaysia";
        aray_ulang[3]="Singapura";
        aray_ulang[4]="India";
        aray_ulang[5]="Arab";
        aray_ulang[6]="Cina";
        aray_ulang[7]="Jepang";
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, aray_ulang);
        s.setAdapter(adapter);
        Toast.makeText(getApplicationContext(), s.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
    }


    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.btnTampilkan:
            {
                Spinner s =(Spinner) findViewById(R.id.spinner);
                int selectedld = RadioGroup.getCheckedRadioButtonId();
                RadioButton = (RadioButton) findViewById(selectedld);
                etNama= (EditText) findViewById(R.id.etNama);
                String vnama = etNama.getText().toString();
                String cek="";
                if(chIndonesia.isChecked()){
                    cek+="Indonesia\n";
                }
                if(chInggris.isChecked()){
                    cek+="Inggris\n";
                }
                if(chArab.isChecked()){
                    cek+="Arab\n";
                }
                if(chMandarin.isChecked()){
                    cek+="Mandarin\n";
                }
                if(chJawa.isChecked()){
                    cek+="jawa\n";
                }
                if(chSunda.isChecked()){
                    cek+="Sunda\n";
                }
                Toast.makeText(this, "Nama: "+vnama+"\n" + "Jenis Kelamin: "+RadioButton.getText() +
                        "\n" + "Negara Asal: "+s.getSelectedItem().toString()+"\n"+"Kemampuan Berbahasa : "+cek, Toast.LENGTH_SHORT).show();

            }
            break;
            case R.id.btnKosongkan:
            {
                Intent intent = getIntent();
                finish();
                startActivity(intent);
            }
            break;
            default:
                break;
        }

    }
}
