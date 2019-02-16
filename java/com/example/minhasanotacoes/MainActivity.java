package com.example.minhasanotacoes;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {


    private EditText editAnotacao;
    private AnotacaoPreferences preferencias;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editAnotacao = findViewById(R.id.editAnotacao);

        preferencias = new AnotacaoPreferences(getApplicationContext());

        FloatingActionButton fab = findViewById(R.id.fab);

        fab.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {


                //Se for digitado algo será salvo
                String textoRecuperado = editAnotacao.getText().toString();
                if( textoRecuperado.equals("")){

                    Snackbar.make(view, "Preencha a anotação", Snackbar.LENGTH_LONG).show();

                }else{

                    preferencias.salvarAnotacao(textoRecuperado);

                    Snackbar.make(view, "Anotação Salva com Sucesso!!", Snackbar.LENGTH_LONG).show();
                }


            }
        });
        String anotacao = preferencias.recuperarAnotacao();

        if( !anotacao.equals(" ")){
            editAnotacao.setText(anotacao);
        }
    }


}

