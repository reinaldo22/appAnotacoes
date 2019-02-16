package com.example.minhasanotacoes;

import android.content.Context;
import android.content.SharedPreferences;

public class AnotacaoPreferences {


    private Context context;
    private SharedPreferences preferences;
    private final String NOME_ARQUIVO = "anotacao.preferencias";
    private SharedPreferences.Editor editor;
    private final String CHAVE_NOME= "nome";

    public AnotacaoPreferences(Context c) {
        this.context = c;

        preferences = context.getSharedPreferences(NOME_ARQUIVO,0);

        editor = preferences.edit();

    }

    public void salvarAnotacao(String anotacao){
        editor.putString(CHAVE_NOME, anotacao);
        editor.commit();

    }
    public String recuperarAnotacao(){

        String recupera;

        recupera = preferences.getString(CHAVE_NOME,"");


        return recupera;
    }


}

