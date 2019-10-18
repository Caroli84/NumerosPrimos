package com.example.numerosprimos;

import androidx.appcompat.app.AppCompatActivity;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button boton1;
    private EditText entrada;
    private EditText salida;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);//en el onCreate() es cuando se llama a setCOntentView() para definir el diseño de la interfaz de usuario de ese Activity

        entrada=(EditText)findViewById(R.id.introcampo);//creo variables en java que representen y enlacen los objetos del xml
        salida=(EditText)findViewById(R.id.introcampo2);
        boton1=(Button)findViewById(R.id.boton1);


        boton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                entrada.getText().toString();
                int num=Integer.parseInt(entrada.getText().toString());
                int result=MainActivity.numPrimoSegunPuesto(num);
                salida.setText(String.valueOf(result));

                Toast toast=Toast.makeText(getApplicationContext(),"resultado",Toast.LENGTH_LONG);
                toast.setGravity(Gravity.BOTTOM,0,0);
                toast.show();

                //Toast.makeText(getApplicationContext(),"Aqui tienes tu resultado! "+result,Toast.LENGTH_LONG).show();
            }


        });


        //inicializar();

    }

    public static int numPrimoSegunPuesto(int puesto){
        int num=1;
        int cont=0;
        while(cont!=puesto){
            num++;
            if(esPrimo(num))cont++;
        }
        return num;
    }

    public static boolean esPrimo(int num){
        for (int i = 2; i < num; i++) {
            if(num%i==0)return false;
        }
        return true;
    }
/*
    public void inicializar(){
        boton1=(Button)findViewById(R.id.boton1);//el objeto boton1 = se enlaza con apartado grafico
        boton1.setOnClickListener(this);//escucha si se realiza una accion y entonces si se pulsa que se ejecute onClick()
                                        //dice que se ejecutará cuando se apriete el boton
    }


    @Override
    public void onClick(View v) {
        Context context = getApplicationContext();
        CharSequence text = "Este es tu resultado!";
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
        Toast.makeText(context, text, duration).show();
    }

    */

}
