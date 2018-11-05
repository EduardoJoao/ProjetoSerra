package com.calculadora.calculatorinvest;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import java.text.DecimalFormat;

public class Resultado extends AppCompatActivity {
    // Remove the below line after defining your own ad unit ID.

    TextView valorTotal,valorImposto;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);

        valorTotal = findViewById(R.id.valorTotal);
        valorImposto = findViewById(R.id.valorImposto);
        Double montanteTotal = 0.00;

        Bundle bundle = getIntent().getExtras();
        if(bundle == null){
            montanteTotal = 0.00;
        }else{
            Double montantes = bundle.getDouble("montante");
            Double valorDeImposto = bundle.getDouble("valorDeImpostos");
            DecimalFormat decimal = new DecimalFormat("0.00");
            String resultado = decimal.format(montantes);
            String resultadoImposto =  decimal.format(valorDeImposto);
            valorTotal.setText("R$ "+resultado);
            valorImposto.setText("R$ "+resultadoImposto);
        }

        MobileAds.initialize(this, "ca-app-pub-4251802455999210/2592967698");
        // Load an ad into the AdMob banner view.
        AdView adView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder()
                .setRequestAgent("android_studio:ad_template").build();
        adView.loadAd(adRequest);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_resultado, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
