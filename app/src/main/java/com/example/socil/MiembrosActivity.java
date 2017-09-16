package com.example.socil;

import java.util.ArrayList;

import com.example.socil.AgregarActivity.AddAdapter;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class MiembrosActivity extends Activity {
	private static RedSocial r=new RedSocial();
	private ArrayList<Usuario> ArrayAdd;
	AddAdapter adapter;
	String q;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_miembros);
		getActionBar().hide();
		
		
		Intent i=getIntent();
		r=(RedSocial)i.getSerializableExtra("objeto");
		q=(String)i.getSerializableExtra("nombre_grupo");
		
		TextView no=(TextView)findViewById(R.id.nomGrupo);
		no.setText(q);
		
		ArrayAdd =new ArrayList<Usuario>();
		NodoU u=r.getU().getP();
		Grupo g=r.getG().grupoIngreso(q);
		int n=g.getM().nroelem();
		for(int j=1; j<=n; j++) {
			String x=g.getM().eliminar();
			Usuario a=r.getU().userIngreso(x);
			
				ArrayAdd.add(a);
			g.getM().adicionar(x);
			
			
		}
		
		 adapter =new AddAdapter(getApplicationContext(), R.layout.adapter_addamigos, ArrayAdd);
        
        ListView list = (ListView)findViewById(R.id.list_addAmigos);
        list.setAdapter(adapter);
        
        list.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				Usuario x=adapter.getItem(arg2);
				
				Intent i=new Intent(MiembrosActivity.this, PerfilPersonaActivity.class);
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
	
	
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event){
		if(keyCode==KeyEvent.KEYCODE_BACK){
			Intent i=new Intent(MiembrosActivity.this, PerfilGrupoActivity.class);
			i.putExtra("objeto", r);
			i.putExtra("nombre_grupo",q);
			startActivity(i);
				

			finish();
			return true;
		}

		return super.onKeyDown(keyCode, event);
	}

}
