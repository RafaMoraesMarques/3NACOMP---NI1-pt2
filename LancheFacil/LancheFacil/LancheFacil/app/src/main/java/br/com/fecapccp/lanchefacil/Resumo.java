package br.com.fecapccp.lanchefacil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import br.com.fecapccp.lanchefacil.MainActivity;

public class Resumo extends AppCompatActivity {

    TextView txtResumo;
    Button btnNovoPedido;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resumo);

        txtResumo = findViewById(R.id.txtResumo);
        btnNovoPedido = findViewById(R.id.btnNovoPedido);

        Intent intent = getIntent();
        String nome = intent.getStringExtra("nomeCliente");
        String lanche = intent.getStringExtra("lancheEscolhido");

        String mensagem = "Pedido para " + nome + ": " + lanche;
        txtResumo.setText(mensagem);

        btnNovoPedido.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent voltarInicio = new Intent(Resumo.this, MainActivity.class);
                voltarInicio.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); // limpa a pilha de activities
                startActivity(voltarInicio);
            }
        });
    }
}
