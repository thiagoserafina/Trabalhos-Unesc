package com.example.sqlite.database.dao;

import android.content.ContentValues;
import android.content.Context;

import com.example.sqlite.database.DBOpenHelper;
import com.example.sqlite.database.model.PessoaModel;

public class PessoaDAO extends AbstrataDAO {
    private final String[] colunas = {
            PessoaModel.COLUNA_ID,
            PessoaModel.COLUNA_NOME,
            PessoaModel.COLUNA_CPF
    };

    public PessoaDAO(Context context){
        db_helper = new DBOpenHelper(context);
    }

    public void AbreBanco() {
        Open();
    }

    public long Insert(PessoaModel model) {
        long rowAffect = 0; // Se for maior que 0, é pq o insert funcionou;

            Open();

            ContentValues values = new ContentValues();
            values.put(PessoaModel.COLUNA_ID, model.get_id()); // Não precisa pois é autoincrement
            values.put(PessoaModel.COLUNA_NOME, model.getNome());
            values.put(PessoaModel.COLUNA_CPF, model.getCpf());

            rowAffect = db.insert(PessoaModel.TABLE_NAME, null, values);

            Close();

        return rowAffect;
    }


}
