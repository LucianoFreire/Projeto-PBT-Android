package com.example.luciano.gamequizz;

/**
 * Created by lucia on 22/03/2017.
 */

import android.icu.text.DecimalFormat;
import android.icu.text.NumberFormat;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;

import java.util.Locale;


public class Tab25 extends Fragment {


    private EditText editTextPBT;
    private  EditText editTextTolerancia;
    private ImageButton btncalcular;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.tab25, container, false);

        if(rootView != null) {

            editTextPBT  = (EditText) rootView.findViewById(R.id.editTextPBT);
            editTextTolerancia = (EditText) rootView.findViewById(R.id.editTextTolerancia);

            btncalcular = (ImageButton) rootView.findViewById(R.id.btncalcular);

            btncalcular.setOnClickListener(new View.OnClickListener() {
                @RequiresApi(api = Build.VERSION_CODES.N)
                @Override
                public void onClick(View v) {

                    String pbt = editTextPBT.getText().toString();
                    String tolerancia = editTextTolerancia.getText().toString();

                    if(pbt.isEmpty() || tolerancia.isEmpty()){
                        android.app.AlertDialog.Builder dialog = new android.app.AlertDialog.Builder(getContext());
                        dialog.setTitle("Aviso!");
                        dialog.setIcon(R.mipmap.ic_alertadefinicao);
                        dialog.setMessage("Campo de Texto em Branco, Entre com os Valores!");
                        dialog.setNeutralButton("OK", null);
                        dialog.show();
                    }
                    else {
                        Double valorpbt = Double.parseDouble(editTextPBT.getText().toString());
                        Double valortolerancia = Double.parseDouble(editTextTolerancia.getText().toString());
                        double resultado = 0;

                        if(btncalcular.isPressed()) {
                            NumberFormat formatador = new DecimalFormat(".#");
                            NumberFormat formatador2 = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
                            resultado = ((valorpbt * valortolerancia) / 100 + valorpbt);
                            formatador2.format(resultado);
                            //formatador.format(resultado);

                            android.app.AlertDialog.Builder dialog = new android.app.AlertDialog.Builder(getContext());
                            //     dialog.setView()
                            dialog.setTitle("LIMITE PBTC!");
                            dialog.setIcon(R.mipmap.ic_alertadefinicao);
                            dialog.setMessage("PBT: "+editTextPBT.getText() +"\nTolerancia (5%) " +"\nLimite Total: " +resultado);
                            dialog.setNeutralButton("OK", null);
                            dialog.show();
                        }
                    }

                }
            });

        }

        return rootView;

    }


}
