package br.com.fecapccp.pizzaria;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

public class Pagamento extends AppCompatActivity {

    RadioGroup grupoTamanho, grupoPagamento;
    RadioButton rbPequena, rbMedia, rbGrande, rbDinheiro, rbCartao;
    Button btnConfirmar;
    ArrayList<String> saboresSelecionados;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagamento);

        grupoTamanho = findViewById(R.id.grupoTamanho);
        grupoPagamento = findViewById(R.id.grupoPagamento);
        rbPequena = findViewById(R.id.rbPequena);
        rbMedia = findViewById(R.id.rbMedia);
        rbGrande = findViewById(R.id.rbGrande);
        rbDinheiro = findViewById(R.id.rbDinheiro);
        rbCartao = findViewById(R.id.rbCartao);
        btnConfirmar = findViewById(R.id.btnConfirmar);

        saboresSelecionados = getIntent().getStringArrayListExtra("sabores");

        btnConfirmar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tamanho = "";
                double valor = 0;

                if (rbPequena.isChecked()) {
                    tamanho = getString(R.string.pequena);
                    valor = 45.0;
                } else if (rbMedia.isChecked()) {
                    tamanho = getString(R.string.media);
                    valor = 55.0;
                } else if (rbGrande.isChecked()) {
                    tamanho = getString(R.string.grande);
                    valor = 65.0;
                }

                String pagamento = "";
                if (rbDinheiro.isChecked()) {
                    pagamento = getString(R.string.dinheiro);
                } else if (rbCartao.isChecked()) {
                    pagamento = getString(R.string.cartao);
                }

                Intent intent = new Intent(Pagamento.this, Resumo.class);
                intent.putStringArrayListExtra("sabores", saboresSelecionados);
                intent.putExtra("tamanho", tamanho);
                intent.putExtra("pagamento", pagamento);
                intent.putExtra("valor", valor);
                startActivity(intent);
            }
        });
    }
}
