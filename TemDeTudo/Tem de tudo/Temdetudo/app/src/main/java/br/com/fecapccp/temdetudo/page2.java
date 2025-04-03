package br.com.fecapccp.temdetudo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class page2 extends AppCompatActivity {
    private EditText editNome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page2);
        editNome = findViewById(R.id.editNome);
    }

    public void confirmarCadastro(View view) {
        String nome = editNome.getText().toString();

        if (!nome.isEmpty()) {
            Intent intent = new Intent(this, page3.class);
            intent.putExtra("NOME_CLIENTE", nome);
            startActivity(intent);
        } else {
            editNome.setError("Por favor, digite seu nome!");
        }
    }
}
