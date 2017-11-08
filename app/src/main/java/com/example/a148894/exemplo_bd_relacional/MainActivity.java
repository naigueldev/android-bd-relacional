package com.example.a148894.exemplo_bd_relacional;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import java.util.List;

public class MainActivity extends AppCompatActivity {


    private EditText edtAno, edtNome;

    private BDmanager bdManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtAno = (EditText) findViewById(R.id.edtAno);
        edtNome = (EditText) findViewById(R.id.edtNome);

        bdManager = new BDmanager(this);


    }

    public void listar(View view) {
        List<Carro> carros = bdManager.getCars();

        for (Carro carro : carros){
            Log.e("Ex", "----------------------------");
            Log.e("Ex", "" + carro.id);
            Log.e("Ex", "" + carro.nome);
            Log.e("Ex", "" + carro.ano);
            Log.e("Ex", "----------------------------");
        }
    }

    public void inserir(View view) {

        String nome = edtNome.getText().toString();
        String ano = edtAno.getText().toString();

        Carro carro = new Carro();

        carro.nome = nome;
        carro.ano = Integer.parseInt(ano);

        bdManager.insertCar(carro);
        listar(view);
    }
}
