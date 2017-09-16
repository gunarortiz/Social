package com.example.socil;

import java.util.ArrayList;

import com.example.socil.MainActivity.AmigosAdapter;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.sax.TextElementListener;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;

public class ChatActivity extends Activity {
private static RedSocial r=new RedSocial();
private static String nombre_contacto;
private ArrayList<Unmensaje> ArrayMensajes;
MensajesAdapter adapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_chat);
		getActionBar().hide();
		
		Intent i=getIntent();
		r=(RedSocial)i.getSerializableExtra("objeto");
		nombre_contacto=(String)i.getStringExtra("nombre_contacto");
		TextView nom=(TextView)findViewById(R.id.nombrePrincipalChat);
		nom.setText(nombre_contacto);
		
Usuario x=r.getU().userIngreso(nombre_contacto);
		
		ImageView fotoSup=(ImageView)findViewById(R.id.fotoSuperiorChat);
		if(x.getFoto()==1){
			fotoSup.setImageResource(R.drawable.perfil1);
		}
		if(x.getFoto()==2){
			fotoSup.setImageResource(R.drawable.perfil2);
		}
		if(x.getFoto()==3){
			fotoSup.setImageResource(R.drawable.perfil3);
		}
		if(x.getFoto()==4){
			fotoSup.setImageResource(R.drawable.perfil4);
		}
		if(x.getFoto()==5){
			fotoSup.setImageResource(R.drawable.perfil5);
		}
		if(x.getFoto()==5){
			fotoSup.setImageResource(R.drawable.perfil6);
		}
		if(x.getFoto()==7){
			fotoSup.setImageResource(R.drawable.perfil7);
		}
		if(x.getFoto()==8){
			fotoSup.setImageResource(R.drawable.perfil8);
		}
		
		
		
		if(!r.getM().ultimoMensaje(nombre_contacto, r.getNombre_ingreso()).equals("")){
			ArrayMensajes =new ArrayList<Unmensaje>();
			CSimpleMD aux=r.getM().getMensajesDia(nombre_contacto, r.getNombre_ingreso());
			
			int n=aux.nroelem();
			
			for (int j = 1; j <= n; j++) {
				MensajeDia a=aux.eliminar();
						
				CSimpleMEN xx=a.getMEN();
				
				int n1=xx.nroelem();
				for (int k = 1; k <=n1; k++) {
					Unmensaje x1=xx.eliminar();
					ArrayMensajes.add(x1);
					xx.adicionar(x1);
					
				}
				
				aux.adicionar(a);
			}
			
			
			adapter =new MensajesAdapter(getApplicationContext(), R.layout.adapter_mensajes, ArrayMensajes);
	        
	        ListView list = (ListView)findViewById(R.id.list_mensajes);
	        list.setAdapter(adapter);
		}
		
		
        
       
		
		
		
	}
	
	
	
public static class MensajesAdapter extends ArrayAdapter<Unmensaje>{
    	
    	public MensajesAdapter(Context context, int resourse, ArrayList<Unmensaje> lista){
    		super(context, resourse, lista);
    	}
    	
    	@Override
    	public View getView(int i, View c, ViewGroup p){
    		
    		Unmensaje us=getItem(i);
    		View v = null;
    		if(us.getDe().equals(r.getNombre_ingreso())){
    			v=LayoutInflater.from(getContext()).inflate(R.layout.adapter_mensajesmio, p, false);
    		}
    		else{
    			v=LayoutInflater.from(getContext()).inflate(R.layout.adapter_mensajes, p, false);
    		}
    	
    		
    			LinearLayout dia=(LinearLayout)v.findViewById(R.id.linearDia);

        		TextView diamen=(TextView)v.findViewById(R.id.diaChat);
        		String q=r.getM().esPrimerMensaje(us, nombre_contacto, r.getNombre_ingreso());
        		if(!q.equals("")){
        			dia.setVisibility(View.VISIBLE);
        			diamen.setText(q);
        		}
			
    		
    		
    		
    		TextView textoChat=(TextView)v.findViewById(R.id.textoChat);
    		textoChat.setText(us.getTexto());
    		TextView horaChat=(TextView)v.findViewById(R.id.horaChat);
    		horaChat.setText(us.getHora());
    		
    		
    		
    		
    		return v;
    	}

    }



	public void enviar(View v){
		TextView escribir=(TextView)findViewById(R.id.escribirChat);
		String men=escribir.getText().toString();
		if(!men.equals("")){
			r.getM().addMensaje(r.getNombre_ingreso(),nombre_contacto, men);
			
			
			ArrayMensajes =new ArrayList<Unmensaje>();
			CSimpleMD aux=r.getM().getMensajesDia(nombre_contacto, r.getNombre_ingreso());
			
			int n=aux.nroelem();
			
			for (int j = 1; j <= n; j++) {
				MensajeDia a=aux.eliminar();
						
				CSimpleMEN xx=a.getMEN();
				
				int n1=xx.nroelem();
				for (int k = 1; k <=n1; k++) {
					Unmensaje x1=xx.eliminar();
					ArrayMensajes.add(x1);
					xx.adicionar(x1);
					
				}
				
				aux.adicionar(a);
			}
			
			
			adapter =new MensajesAdapter(getApplicationContext(), R.layout.adapter_mensajes, ArrayMensajes);
	        
	        ListView list = (ListView)findViewById(R.id.list_mensajes);
	        list.setAdapter(adapter);
	        
	        
	        adapter.setNotifyOnChange(true);
			
	        escribir.setText("");
			
		}
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.chat, menu);
		return true;
	}
	
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event){
		if(keyCode==KeyEvent.KEYCODE_BACK){
			Intent i=new Intent(ChatActivity.this, MainActivity.class);
			i.putExtra("objeto", r);
			
			startActivity(i);
				

			finish();
			return true;
		}

		return super.onKeyDown(keyCode, event);
	}


}
