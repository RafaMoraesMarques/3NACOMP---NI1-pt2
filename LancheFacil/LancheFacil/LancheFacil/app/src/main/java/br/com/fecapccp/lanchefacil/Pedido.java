package br.com.fecapccp.lanchefacil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Pedido extends AppCompatActivity {

    private EditText edtNome;
    private RadioGroup grupoLanches;
    private Button btnConfirmar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pedido);

        edtNome = findViewById(R.id.edtNome);
        grupoLanches = findViewById(R.id.radioGroupLanches);
        btnConfirmar = findViewById(R.id.btnConfirmar);

        btnConfirmar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String nome = edtNome.getText().toString();
                int idSelecionado = grupoLanches.getCheckedRadioButtonId();

                if (nome.isEmpty() || idSelecionado == -1) {
                    return;
                }

                RadioButton rbSelecionado = findViewById(idSelecionado);
                String lancheEscolhido = rbSelecionado.getText().toString();

                Intent intent = new Intent(Pedido.this, Resumo.class);
                intent.putExtra("nomeCliente", nome);
                intent.putExtra("lancheEscolhido", lancheEscolhido);
                startActivity(intent);
            }
        });
    }
}
