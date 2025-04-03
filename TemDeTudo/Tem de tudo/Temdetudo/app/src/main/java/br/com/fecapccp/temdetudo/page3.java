package br.com.fecapccp.temdetudo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class page3 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page3);

        TextView textBemVindo = findViewById(R.id.textBemVindo);
        String nome = getIntent().getStringExtra("NOME_CLIENTE");

        if (nome != null) {
            String mensagem = getString(R.string.welcome_user, nome);
            textBemVindo.setText(mensagem);
        }
    }

    public void voltarInicio(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
