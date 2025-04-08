package br.com.fecapccp.pizzaria;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    CheckBox cbCalabresa, cbMarguerita, cbPortuguesa;
    Button btnProximo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cbCalabresa = findViewById(R.id.cbCalabresa);
        cbMarguerita = findViewById(R.id.cbMarguerita);
        cbPortuguesa = findViewById(R.id.cbPortuguesa);
        btnProximo = findViewById(R.id.btnProximo);

        btnProximo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ArrayList<String> saboresSelecionados = new ArrayList<>();

                if (cbCalabresa.isChecked()) saboresSelecionados.add(getString(R.string.calabresa));
                if (cbMarguerita.isChecked()) saboresSelecionados.add(getString(R.string.marguerita));
                if (cbPortuguesa.isChecked()) saboresSelecionados.add(getString(R.string.portuguesa));

                Intent intent = new Intent(MainActivity.this, Pagamento.class);
                intent.putStringArrayListExtra("sabores", saboresSelecionados);
                startActivity(intent);
            }
        });
    }
}
