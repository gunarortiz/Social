package com.example.socil;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
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
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class AgregarActivity extends Activity {
	private static RedSocial r=new RedSocial();
	private ArrayList<Usuario> ArrayAdd;
	AddAdapter adapter;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_agregar);
		getActionBar().hide();
		
		
		Intent i=getIntent();
		r=(RedSocial)i.getSerializableExtra("objeto");
		Usuario x=r.getU().userIngreso(r.getNombre_ingreso());
		
		
		
		
		
		ArrayAdd =new ArrayList<Usuario>();
		NodoU u=r.getU().getP();
		
		while(u!=null) {
			Usuario a=u.getU();
			if(!a.getNombre().equals(r.getNombre_ingreso())){
				ArrayAdd.add(a);
			}
			
			u=u.getSig();
		}
		
		 adapter =new AddAdapter(getApplicationContext(), R.layout.adapter_addamigos, ArrayAdd);
        
        ListView list = (ListView)findViewById(R.id.list_addAmigos);
        list.setAdapter(adapter);
        
        list.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				Usuario x=adapter.getItem(arg2);
				
				Intent i=new Intent(AgregarActivity.this, PerfilPersonaActivity.class);
				i.putExtra("objeto", r);
				i.putExtra("user", x.getNombre());
				startActivity(i);
				
				finish();
			}
		});
		
		
	}
	
	
	
	
public static class AddAdapter extends ArrayAdapter<Usuario>{
    	
    	public AddAdapter(Context context, int resourse, ArrayList<Usuario> lista){
    		super(context, resourse, lista);
    	}
    	
    	@Override
    	public View getView(int i, View c, ViewGroup p){
    		final View v=LayoutInflater.from(getContext()).inflate(R.layout.adapter_addamigos, p, false);
    		
    		ImageView img=(ImageView)v.findViewById(R.id.imgAdd);
    		TextView textNombre=(TextView)v.findViewById(R.id.nombreAdd);
    		
    		
    		
    		
    		final Usuario us=getItem(i);
    		textNombre.setText(us.getNombre());
    		
    		
    		final Button botonAdd=(Button)v.findViewById(R.id.botonAdd);
    		final TextView esAmigo=(TextView)v.findViewById(R.id.esAmigo);
    		if(r.getU().esAmigo(r.getNombre_ingreso(), us.getNombre())){
    			
    			esAmigo.setVisibility(View.VISIBLE);
    			
    		}
    		else{
    			
    			botonAdd.setVisibility(View.VISIBLE);
    			botonAdd.setOnClickListener(new OnClickListener() {
					
					@Override
					public void onClick(View p) {
						// TODO Auto-generated method stub
						
						Toast.makeText(getContext(), "Ya eres su amigo!", Toast.LENGTH_SHORT).show();
						r.getU().addAmigoA(us.getNombre(), r.getNombre_ingreso(), "amistad");
						botonAdd.setVisibility(View.GONE);
						
						esAmigo.setVisibility(View.VISIBLE);
						
					}
				});
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
		getMenuInflater().inflate(R.menu.agregar, menu);
		return true;
	}
	
	
	public void grupos(View v){
		Intent i=new Intent(AgregarActivity.this, AgregarGrupoActivity.class);
		i.putExtra("objeto", r);
		startActivity(i);
	}
	
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event){
		if(keyCode==KeyEvent.KEYCODE_BACK){
			Intent i=new Intent(AgregarActivity.this, MainActivity.class);
			i.putExtra("objeto", r);
			
			startActivity(i);
				

			finish();
			return true;
		}

		return super.onKeyDown(keyCode, event);
	}

}
