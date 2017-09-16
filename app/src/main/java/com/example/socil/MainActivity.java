package com.example.socil;

import java.util.ArrayList;

import android.R.bool;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
	private static RedSocial r=new RedSocial();
	private ArrayList<Usuario> ArrayAmigos;
	AmigosAdapter adapter;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		getActionBar().hide();
		Intent i=getIntent();
		r=(RedSocial)i.getSerializableExtra("objeto");
		
		
		
		Usuario x=r.getU().userIngreso(r.getNombre_ingreso());
		
		ImageView fotoSup=(ImageView)findViewById(R.id.fotoSuperior);
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
		
		
		ArrayAmigos =new ArrayList<Usuario>();
		
		int n=x.getA().nroelem();
		for (int j = 1; j <= n; j++) {
			Amigo a=x.getA().eliminar();
			
			Usuario y=r.getU().userIngreso(a.getNombre_amigo());
			x.getA().adicionar(a);
			ArrayAmigos.add(y);
		}
		//r.getU().userIngreso(r.getNombre_ingreso()).setA(aux);
		 adapter =new AmigosAdapter(getApplicationContext(), R.layout.adapter_amigos, ArrayAmigos);
        
        ListView list = (ListView)findViewById(R.id.list_amigos);
        list.setAdapter(adapter);
        
        list.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				Usuario x=adapter.getItem(arg2);
				r.getM().Vistear(x.getNombre(), r.getNombre_ingreso());
				Intent i=new Intent(MainActivity.this, ChatActivity.class);
				i.putExtra("objeto", r);
				i.putExtra("nombre_contacto", x.getNombre());
				
				startActivity(i);
				finish();
			}
		});
        
	}

	
public class AmigosAdapter extends ArrayAdapter<Usuario>{
    	
    	public AmigosAdapter(Context context, int resourse, ArrayList<Usuario> lista){
    		super(context, resourse, lista);
    	}
    	
    	@Override
    	public View getView(int i, View c, ViewGroup p){
    		View v=LayoutInflater.from(getContext()).inflate(R.layout.adapter_amigos, p, false);
    		
    		ImageView img=(ImageView)v.findViewById(R.id.imgMensaje);
    		TextView textNombre=(TextView)v.findViewById(R.id.nombreMensaje);
    		
    		TextView textChat=(TextView)v.findViewById(R.id.textoMensaje);
    		final Usuario us=getItem(i);
    		
    		img.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					Intent i=new Intent(MainActivity.this, PerfilPersonaActivity.class);
					i.putExtra("objeto", r);
					i.putExtra("user", us.getNombre());
					startActivity(i);
					finish();
				}
			});
    		
    		
    		textNombre.setText(us.getNombre());
    		if(!r.getM().ultimoMensaje(us.getNombre(), r.getNombre_ingreso()).equals("")){
    			textChat.setText(r.getM().ultimoMensaje(us.getNombre(), r.getNombre_ingreso()));
    			textChat.setTextColor(Color.rgb(80, 80, 80));
    		}
    		
    		TextView horaMen=(TextView)v.findViewById(R.id.horaMensaje);
    		horaMen.setText(r.getM().horaUltimoMensaje(us.getNombre(), r.getNombre_ingreso()));
    		
    		
    		TextView nroVisto=(TextView)v.findViewById(R.id.nroNoVisto);
    		if(r.getM().nroNoVistos(us.getNombre(), r.getNombre_ingreso())!=0){
    			nroVisto.setText(r.getM().nroNoVistos(us.getNombre(), r.getNombre_ingreso())+"");
    			nroVisto.setVisibility(View.VISIBLE);
    		}
    		
    		
    		if(us.getFoto()==1){
    			img.setImageResource(R.drawable.perfil1);
    		}
    		if(us.getFoto()==2){
    			img.setImageResource(R.drawable.perfil2);
    		}
    		if(us.getFoto()==3){
    			img.setImageResource(R.drawable.perfil3);
    		}
    		if(us.getFoto()==4){
    			img.setImageResource(R.drawable.perfil4);
    		}
    		if(us.getFoto()==5){
    			img.setImageResource(R.drawable.perfil5);
    		}
    		if(us.getFoto()==5){
    			img.setImageResource(R.drawable.perfil6);
    		}
    		if(us.getFoto()==7){
    			img.setImageResource(R.drawable.perfil7);
    		}
    		if(us.getFoto()==8){
    			img.setImageResource(R.drawable.perfil8);
    		}
    		return v;
    	}

    }
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	public void per(String q, View v ){
		
		
		
	}
	
	public void add(View v){
		Intent i=new Intent(MainActivity.this, AgregarActivity.class);
		i.putExtra("objeto", r);
		startActivity(i);
		finish();
	}
	
	public void grupos(View v){
		Intent i=new Intent(MainActivity.this, GruposActivity.class);
		i.putExtra("objeto", r);
		startActivity(i);
		finish();
	}
	
	public void perfil(View v){
		Intent i=new Intent(MainActivity.this, PerfilPersonaActivity.class);
		i.putExtra("objeto", r);
		i.putExtra("user", r.getNombre_ingreso());
		startActivity(i);
		finish();
	}
	
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event){
		if(keyCode==KeyEvent.KEYCODE_BACK){
			

					finish();
			
					Intent i=new Intent(MainActivity.this, SplashActivity.class);
					r.setIngreso(false);
					
					r.setNombre_ingreso("");
					i.putExtra("objeto", r);
					startActivity(i);
					
					
					Toast.makeText(getApplicationContext(), "Salio de su cuenta", Toast.LENGTH_SHORT).show();
			finish();



			return true;
		}

		return super.onKeyDown(keyCode, event);
	}

	
	
	
}
