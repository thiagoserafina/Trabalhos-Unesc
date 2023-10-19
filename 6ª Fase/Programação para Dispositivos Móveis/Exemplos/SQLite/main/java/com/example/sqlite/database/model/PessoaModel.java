package com.example.sqlite.database.model;

public class PessoaModel {
    public static final String
    TABLE_NAME = "tb_pessoa";

    public static final String
    COLUNA_ID = "_id",
    COLUNA_NOME = "nome",
    COLUNA_CPF = "cpf";

    public static final String
            CREATE_TABLE =
            "create table " + TABLE_NAME
                    + "("
                    + COLUNA_ID + " integer primary key autoincrement, "
                    + COLUNA_NOME + " text not null, "
                    + COLUNA_CPF + " text not null"
                    + ");";

    public static final String
            DROP_TABLE = "drop table if exists " + TABLE_NAME + ";";

    private int _id;
    private String nome;
    private String cpf;

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
