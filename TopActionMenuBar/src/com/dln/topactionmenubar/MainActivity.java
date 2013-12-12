package com.dln.topactionmenubar;


import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class MainActivity extends Activity {

	private ListView lista; 
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
    public void showAbout() {
        Intent intent = new Intent(this, AboutActivity.class);
        //EditText editText = (EditText) findViewById(R.id.);
        //String message = editText.getText().toString();
        //intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }
    
    public void showSettings() {
        Intent intent = new Intent(this, SettingsActivity.class);
        //EditText editText = (EditText) findViewById(R.id.);
        //String message = editText.getText().toString();
        //intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
        
        
    }
    
    public void showList(){
setContentView(R.layout.listado);

        
        ArrayList<Lista_Categorias> datos = new ArrayList<Lista_Categorias>();  
        
        datos.add(new Lista_Categorias(R.drawable.ic_launcher, "Entretenimiento", "Ofertas en cines, teatros, ópera"));
        datos.add(new Lista_Categorias(R.drawable.ic_launcher, "Comida y bebida", "Ofertas en hostelería y restauración"));
        datos.add(new Lista_Categorias(R.drawable.ic_launcher, "Compras", "Ofertas en calzado, moda, complementos"));
        datos.add(new Lista_Categorias(R.drawable.ic_launcher, "Belleza", "Ofertas en peluquería, belleza, spa"));
        
        
        lista = (ListView) findViewById(R.id.ListView_listado);
        lista.setAdapter(new Lista_adaptador(this, R.layout.entrada, datos){
			@Override
			public void onEntrada(Object entrada, View view) {
		        if (entrada != null) {
		            TextView texto_superior_entrada = (TextView) view.findViewById(R.id.textView_superior); 
		            if (texto_superior_entrada != null) 
		            	texto_superior_entrada.setText(((Lista_Categorias) entrada).get_textoTitulo()); 
		              
		            TextView texto_inferior_entrada = (TextView) view.findViewById(R.id.textView_inferior); 
		            if (texto_inferior_entrada != null)
		            	texto_inferior_entrada.setText(((Lista_Categorias) entrada).get_textoDescripcion()); 
		              
		            ImageView imagen_entrada = (ImageView) view.findViewById(R.id.imageView_imagen); 
		            if (imagen_entrada != null)
		            	imagen_entrada.setImageResource(((Lista_Categorias) entrada).get_idImagen());
		        }
			}
        });
        
        lista.setOnItemClickListener(new OnItemClickListener() { 
			@Override
			public void onItemClick(AdapterView<?> pariente, View view, int posicion, long id) {
				Lista_Categorias elegido = (Lista_Categorias) pariente.getItemAtPosition(posicion); 
                
                CharSequence texto = "Seleccionado: " + elegido.get_textoDescripcion();
                Toast toast = Toast.makeText(MainActivity.this, texto, Toast.LENGTH_LONG);
                toast.show();
				showSub();
			}
        });
		        
    }
   
    public void showSub(){
    
setContentView(R.layout.listado);

        
        ArrayList<Lista_Categorias> datos = new ArrayList<Lista_Categorias>();  
        
        datos.add(new Lista_Categorias(R.drawable.ic_launcher, "Restaurantes", "Ofertas en cines, teatros, ópera"));
        datos.add(new Lista_Categorias(R.drawable.ic_launcher, "Tapeo", "Ofertas en hostelería y restauración"));
        datos.add(new Lista_Categorias(R.drawable.ic_launcher, "Copas", "Ofertas en calzado, moda, complementos"));
        datos.add(new Lista_Categorias(R.drawable.ic_launcher, "Desayunos", "Ofertas en peluquería, belleza, spa"));
        
        
        lista = (ListView) findViewById(R.id.ListView_listado);
        lista.setAdapter(new Lista_adaptador(this, R.layout.entrada, datos){
			@Override
			public void onEntrada(Object entrada, View view) {
		        if (entrada != null) {
		            TextView texto_superior_entrada = (TextView) view.findViewById(R.id.textView_superior); 
		            if (texto_superior_entrada != null) 
		            	texto_superior_entrada.setText(((Lista_Categorias) entrada).get_textoTitulo()); 
		              
		            TextView texto_inferior_entrada = (TextView) view.findViewById(R.id.textView_inferior); 
		            if (texto_inferior_entrada != null)
		            	texto_inferior_entrada.setText(((Lista_Categorias) entrada).get_textoDescripcion()); 
		              
		            ImageView imagen_entrada = (ImageView) view.findViewById(R.id.imageView_imagen); 
		            if (imagen_entrada != null)
		            	imagen_entrada.setImageResource(((Lista_Categorias) entrada).get_idImagen());
		        }
			}
        });

    
    }
   @Override
public boolean onOptionsItemSelected(MenuItem item) {
	// TODO Auto-generated method stub

	switch (item.getItemId()) {
    case R.id.action_maps:
    	showAbout();
        return true;
    case R.id.action_list:
    	showList();
    	return true;
    case R.id.action_messages:
    	showList();
    	return true;
    case R.id.action_settings:
    	showSettings();
    	return true;
    default:
        return super.onOptionsItemSelected(item);
	}
   }
}