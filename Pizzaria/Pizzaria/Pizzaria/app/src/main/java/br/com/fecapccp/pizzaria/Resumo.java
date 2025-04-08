package br.com.fecapccp.pizzaria;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

import br.com.fecapccp.pizzaria.MainActivity;

public class Resumo extends AppCompatActivity {

    TextView tvSabores, tvTamanho, tvPagamento, tvValor;
    Button btnVoltar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resumo);

        tvSabores = findViewById(R.id.tvSabores);
        tvTamanho = findViewById(R.id.tvTamanho);
        tvPagamento = findViewById(R.id.tvPagamento);
        tvValor = findViewById(R.id.tvValor);
        btnVoltar = findViewById(R.id.btnVoltar);

        Intent intent = getIntent();
        ArrayList<String> sabores = intent.getStringArrayListExtra("sabores");
        String tamanho = intent.getStringExtra("tamanho");
        String pagamento = intent.getStringExtra("pagamento");
        double valor = intent.getDoubleExtra("valor", 0);

        StringBuilder sb = new StringBuilder();
        sb.append("Sabores: ");
        for (String sabor : sabores) {
            sb.append(sabor).append(" ");
        }

        tvSabores.setText(sb.toString());
        tvTamanho.setText("Tamanho: " + tamanho);
        tvPagamento.setText("Pagamento: " + pagamento);
        tvValor.setText("Total: R$ " + String.format("%.2f", valor));

        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentVoltar = new Intent(Resumo.this, MainActivity.class);
                intentVoltar.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); // limpa a pilha de activities
                startActivity(intentVoltar);
            }
        });
    }
}
