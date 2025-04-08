package br.com.fecapccp.lanchefacil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

import br.com.fecapccp.lanchefacil.Pedido;

public class MainActivity extends AppCompatActivity {
    Button btnIniciarPedido;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnIniciarPedido = findViewById(R.id.btnIniciarPedido);
        btnIniciarPedido.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Pedido.class);
                startActivity(intent);
            }
        });
    }
}
