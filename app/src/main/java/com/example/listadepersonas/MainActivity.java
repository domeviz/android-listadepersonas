package com.example.listadepersonas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView tv1;
    private ListView lv1;

    //Vectores para nombres y edades de las personas
    //La posicion de los nombres corresponde a la posicion de edades
    private String nombres []={"Doménica","Santiago","Samuel","Valeria","Camila","Rocio","Patricio","Sofia","Gerardo"};
    private String edades []={"21","32","41","15","31","44","35","12","27"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv1=(TextView) findViewById(R.id.tv1);
        lv1=(ListView) findViewById(R.id.lv1);

        //Se coloca el vector que queremos que muestre el listview
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,R.layout.list_item_dome,nombres);
        //Muestra el contenido del adapter
        lv1.setAdapter(adapter);

        //Asignamos la funcion para que muestre las edades al dar clic en el item del listview
        //setOnItemClickListener()
        lv1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            //Usamos una clase anonima para mostrar las edades
            //Clase anonima: clase que carece de nombre
            //Llamamos a la clase anonima con new OnI
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //Este metodo asigna las edades con los nombres
                //Generamos el texto que se vera al dar clic
                tv1.setText("La edad de "+lv1.getItemAtPosition(i)+" es "+edades[i]+" años");
            }
        });
    }
}