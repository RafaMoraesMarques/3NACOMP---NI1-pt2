package br.com.fecapccp.salario;
import br.com.fecapccp.salario.R;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText editSalario;
    private RadioGroup radioGroup;
    private Button btnCalcular;
    private TextView textResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editSalario = findViewById(R.id.editSalario);
        radioGroup = findViewById(R.id.radioGroup);
        btnCalcular = findViewById(R.id.btnCalcular);
        textResultado = findViewById(R.id.textResultado);

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcularNovoSalario();
            }
        });
    }

    private void calcularNovoSalario() {
        String salarioTexto = editSalario.getText().toString();
        if (salarioTexto.isEmpty()) {
            editSalario.setError("Digite um valor");
            return;
        }

        double salario = Double.parseDouble(salarioTexto);
        double percentual = 0;

        int radioId = radioGroup.getCheckedRadioButtonId();
        if (radioId == R.id.radio40) {
            percentual = 0.40;
        } else if (radioId == R.id.radio45) {
            percentual = 0.45;
        } else if (radioId == R.id.radio50) {
            percentual = 0.50;
        } else {
            return;
        }

        double novoSalario = salario + (salario * percentual);
        textResultado.setText("Novo salário: R$" + String.format("%.2f", novoSalario));
        textResultado.setVisibility(View.VISIBLE);
    }
}
