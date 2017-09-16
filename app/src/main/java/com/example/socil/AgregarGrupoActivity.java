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

public class AgregarGrupoActivity extends Activity {
	private static RedSocial r=new RedSocial();
	private ArrayList<Grupo> ArrayAdd;
	AddAdapter adapter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_agregar_grupo);
		
getActionBar().hide();
		
		
		Intent i=getIntent();
		r=(RedSocial)i.getSerializableExtra("objeto");

		
		
		ArrayAdd =new ArrayList<Grupo>();
		NodoG u=r.getG().getP();
		
		while(u!=null) {
			Grupo a=u.getG();
			
			ArrayAdd.add(a);
			
			
			u=u.getSig();
		}
		
		 adapter =new AddAdapter(getApplicationContext(), R.layout.adapter_addgrupos, ArrayAdd);
        
        ListView list = (ListView)findViewById(R.id.list_addAmigos);
        list.setAdapter(adapter);
        
        list.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				Toast.makeText(getApplicationContext(), "Para ver las publicaciones primero unete y ve a grupos", Toast.LENGTH_SHORT).show();
				
			}
		});
		
		
	}
	
	
	
	
public static class AddAdapter extends ArrayAdapter<Grupo>{
    	
    	public AddAdapter(Context context, int resourse, ArrayList<Grupo> lista){
    		super(context, resourse, lista);
    	}
    	
    	@Override
    	public View getView(int i, View c, ViewGroup p){
    		final View v=LayoutInflater.from(getContext()).inflate(R.layout.adapter_addgrupos, p, false);
    		
    		ImageView img=(ImageView)v.findViewById(R.id.imgAdd);
    		TextView textNombre=(TextView)v.findViewById(R.id.nombreAdd);
    		TextView textDescri=(TextView)v.findViewById(R.id.textoDescripcionAddGrupos);
    		
    		
    		
    		
    		
    		final Grupo us=getItem(i);
    		textNombre.setText(us.getNombre());
    		textDescri.setText(us.getDescripcion());
    		
    		
    		int sw=0;
    		
    		
    		final Button botonAdd=(Button)v.findViewById(R.id.botonAdd);
    		TextView esAmigo=(TextView)v.findViewById(R.id.esAmigo);
    		
    		CSimpleM q=us.getM();
			int n=q.nroelem();
			for (int j = 1; j <=n; j++) {
				String x=q.eliminar();
				if(x.equals(r.getNombre_ingreso())){
					sw=1;
				}
				q.adicionar(x);
			}
			if(sw==1){
				esAmigo.setVisibility(View.VISIBLE);
			}
    		else{
    			
    			botonAdd.setVisibility(View.VISIBLE);
    			botonAdd.setOnClickListener(new OnClickListener() {
					
					@Override
					public void onClick(View p) {
						// TODO Auto-generated method stub
						
						Toast.makeText(getContext(), "Ya eres miembro!", Toast.LENGTH_SHORT).show();
						r.getG().addMiembroA(us.getNombre(), r.getNombre_ingreso());
						botonAdd.setVisibility(View.GONE);
						TextView esAmigo=(TextView)v.findViewById(R.id.esAmigo);
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
		getMenuInflater().inflate(R.menu.agregar_grupo, menu);
		return true;
	}
	
	public void personas(View v){
		Intent i=new Intent(AgregarGrupoActivity.this, AgregarActivity.class);
		i.putExtra("objeto", r);
		startActivity(i);
		finish();
	}
	
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event){
		if(keyCode==KeyEvent.KEYCODE_BACK){
			Intent i=new Intent(AgregarGrupoActivity.this, MainActivity.class);
			i.putExtra("objeto", r);
			
			startActivity(i);
				

			finish();
			return true;
		}

		return super.onKeyDown(keyCode, event);
	}

}