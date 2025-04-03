package com.example.sistemadecompras;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    CheckBox arroz, leite, carne, feijao, refrigerante;
    Button btnCalcular;
    TextView txtTotal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inicializando os componentes
        arroz = findViewById(R.id.chkArroz);
        leite = findViewById(R.id.chkLeite);
        carne = findViewById(R.id.chkCarne);
        feijao = findViewById(R.id.chkFeijao);
        refrigerante = findViewById(R.id.chkRefrigerante);
        btnCalcular = findViewById(R.id.btnCalcular);
        txtTotal = findViewById(R.id.txtTotal);

        txtTotal.setText("Total da compra: R$0.00");

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calcularTotal();
            }
        });
    }

    private void calcularTotal() {
        double total = 0;

        if (arroz.isChecked()) total += Double.parseDouble(getString(R.string.preco_arroz));
        if (leite.isChecked()) total += Double.parseDouble(getString(R.string.preco_leite));
        if (carne.isChecked()) total += Double.parseDouble(getString(R.string.preco_carne));
        if (feijao.isChecked()) total += Double.parseDouble(getString(R.string.preco_feijao));
        if (refrigerante.isChecked()) total += Double.parseDouble(getString(R.string.preco_refrigerante));

        txtTotal.setText(getString(R.string.total_compra, total));
    }

}
