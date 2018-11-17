package com.calculadora.calculatorinvest;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Inicial extends AppCompatActivity {

    EditText montante, juros, ano;
    Button calcular;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicial);


        montante = findViewById(R.id.montante);
        juros = findViewById(R.id.juros);
        ano = findViewById(R.id.ano);

        calcular = findViewById(R.id.calcular);


        calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Double montantes = Double.parseDouble(montante.getText().toString());
                Double juro = Double.parseDouble(juros.getText().toString());
                Double valorDeImpostos = 0.00;



                            Double montante = montantes;
                            Double juros = ((juro)/100);
                            Double anos = Double.parseDouble(ano.getText().toString());


                            for(int i = 0;i< anos ; i++){

                                Double resultado = montante * juros;
                               montante = montante + resultado;
                            }
                            if(anos == 1 ){
                                valorDeImpostos = montante * 0.20;
                            }else if(anos > 2){
                                valorDeImpostos = montante * 0.175;
                            }else if(anos > 5 ){
                                valorDeImpostos = montante * 0.15;
                            }

                            Bundle bundle = new Bundle();
                            bundle.putDouble("montante", montante);
                            bundle.putDouble("valorDeImpostos", valorDeImpostos);
                            Intent intent = new Intent(Inicial.this,Resultado.class);
                            intent.putExtras(bundle);
                            startActivity(intent);


            }
        });
    }
}
