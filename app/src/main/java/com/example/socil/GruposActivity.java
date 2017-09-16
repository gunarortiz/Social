package com.example.socil;

import java.util.ArrayList;

import com.example.socil.MainActivity.AmigosAdapter;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;

public class GruposActivity extends Activity {
	private static RedSocial r=new RedSocial();
	private ArrayList<Grupo> ArrayGrupos;
	GruposAdapter adapter;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_grupos);
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
		
		
		
		
		
		
ArrayGrupos =new ArrayList<Grupo>();
		
		NodoG g=r.getG().getP();
		while(g!=null){
			Grupo a=g.getG();
			int sw=0;
			CSimpleM q=a.getM();
			int n=q.nroelem();
			for (int j = 1; j <=n; j++) {
				String i2=q.eliminar();
				if(i2.equals(r.getNombre_ingreso())){
					sw=1;
				}
				q.adicionar(i2);
			}
			if(sw==1){
				ArrayGrupos.add(a);
			}
			
			g=g.getSig();
		}
		 adapter =new GruposAdapter(getApplicationContext(), R.layout.adapter_grupos, ArrayGrupos);
        
        ListView list = (ListView)findViewById(R.id.list_grupos);
        list.setAdapter(adapter);
        
        
        
        
        list.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				Grupo x=adapter.getItem(arg2);
				
				Intent i=new Intent(GruposActivity.this, PerfilGrupoActivity.class);
				i.putExtra("objeto", r);
				i.putExtra("nombre_grupo", x.getNombre());
				
				startActivity(i);
				finish();
			}
		});
		
		
	}
	
	public void crearGrupo(View v){
		Intent i=new Intent(GruposActivity.this, CrearGrupoActivity.class);
		i.putExtra("objeto", r);

		
		startActivity(i);
		finish();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.grupos, menu);
		return true;
		
	}
	
	
public class GruposAdapter extends ArrayAdapter<Grupo>{
    	
    	public GruposAdapter(Context context, int resourse, ArrayList<Grupo> lista){
    		super(context, resourse, lista);
    	}
    	
    	@Override
    	public View getView(int i, View c, ViewGroup p){
    		View v=LayoutInflater.from(getContext()).inflate(R.layout.adapter_grupos, p, false);
    		
    		ImageView img=(ImageView)v.findViewById(R.id.imgGrupos);
    		TextView textNombre=(TextView)v.findViewById(R.id.nombreGrupo);
    		
    		TextView descripcion=(TextView)v.findViewById(R.id.descripcionGrupo);
    		

    		Grupo us=getItem(i);
    		textNombre.setText(us.getNombre());
    		descripcion.setText(us.getDescripcion());
 
    		
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

public void add(View v){
	Intent i=new Intent(GruposActivity.this, AgregarActivity.class);
	i.putExtra("objeto", r);
	startActivity(i);
	finish();
}

public void mensajes(View v){
	Intent i=new Intent(GruposActivity.this, MainActivity.class);
	i.putExtra("objeto", r);
	startActivity(i);
	finish();
}
public void perfil(View v){
	Intent i=new Intent(GruposActivity.this, PerfilPersonaActivity.class);
	i.putExtra("objeto", r);
	i.putExtra("user", r.getNombre_ingreso());
	startActivity(i);
	finish();
}

}
