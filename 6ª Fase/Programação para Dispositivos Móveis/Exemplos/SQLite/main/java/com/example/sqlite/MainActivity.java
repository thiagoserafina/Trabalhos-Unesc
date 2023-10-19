package com.example.sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.sqlite.database.dao.PessoaDAO;
import com.example.sqlite.database.model.PessoaModel;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        PessoaDAO dao = new PessoaDAO(MainActivity.this);
        PessoaModel pessoaModel = new PessoaModel();
        pessoaModel.setNome("Thiago");
        pessoaModel.setNome("123456789");
        dao.Insert(pessoaModel);

        dao.AbreBanco();

    }
}