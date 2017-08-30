package com.example.oliver.tablaseekbarlistview_modificado;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    TextView txtTitulo;
    SeekBar seekBar;
    ListView lvRes;
    ArrayList<String> arrayList;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtTitulo = (TextView) findViewById(R.id.txt_titulo);
        seekBar = (SeekBar) findViewById(R.id.seekbar);
        lvRes = (ListView) findViewById(R.id.lv_res);
        arrayList = new ArrayList<String>();

        adapter= new ArrayAdapter<String>(getApplicationContext(),R.layout.custom,arrayList);
        lvRes.setAdapter(adapter);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                //arrayList.add(i+"");
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                if(!arrayList.isEmpty()){
                    arrayList.clear();
                }
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                obtenerCadena();
            }
        });

        lvRes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Toast.makeText(getApplicationContext(), "Ha pulsado el item"+ adapterView.getItemAtPosition(position).toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }


    public void obtenerCadena(){
        int numero = seekBar.getProgress();
        String resultado = "";
        //realizar un ciclo para la cadena de texto seekBar
        //arrayList.clear();
        for (int i=1;i<=10;i++){
            int result1 = i * numero;
            //resultado = resultado + numero+ " x " + i + " = "+ String.valueOf(result1) + "\n";
            arrayList.add(resultado + numero+ " x " + i + " = "+ String.valueOf(result1) + "\n");
            adapter.notifyDataSetChanged();
        }

    }
}

