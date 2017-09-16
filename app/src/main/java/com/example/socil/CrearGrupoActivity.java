package com.example.socil;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class CrearGrupoActivity extends Activity {
	private static RedSocial r=new RedSocial();
	ImageView centro;
	private int fotoInt=0;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_crear_grupo);
		getActionBar().hide();
		Intent i=getIntent();
		r=(RedSocial)i.getSerializableExtra("objeto");
		centro=(ImageView)findViewById(R.id.image0);
	}
	
	public void crear(View v){
		TextView nom=(TextView)findViewById(R.id.nombreGrupo);
		TextView des=(TextView)findViewById(R.id.descripcionGrupo);
		
		if(!nom.getText().toString().equals("") || !des.getText().toString().equals("")){
			Grupo g1=new Grupo(nom.getText().toString(), des.getText().toString(), fotoInt);
			g1.getM().adicionar(r.getNombre_ingreso());
			r.getG().adiprimero(g1);
			
			Intent i=new Intent(CrearGrupoActivity.this, GruposActivity.class);
			
			i.putExtra("objeto", r);
			startActivity(i);
			finish();
			
			Toast.makeText(getApplicationContext(), "Se creo el grupo", Toast.LENGTH_SHORT).show();
		}
		else{

			Toast.makeText(getApplicationContext(), "Llene todos los campos", Toast.LENGTH_SHORT).show();
		}
		
		

	}

	public void img1(View v){
		centro.setImageResource(R.drawable.perfil1);
		fotoInt=1;
	}
	public void img2(View v){
		centro.setImageResource(R.drawable.perfil2);
		fotoInt=2;
	}
	public void img3(View v){
		centro.setImageResource(R.drawable.perfil3);
		fotoInt=3;
	}
	public void img4(View v){
		centro.setImageResource(R.drawable.perfil4);
		fotoInt=4;
	}
	public void img5(View v){
		centro.setImageResource(R.drawable.perfil5);
		fotoInt=5;
	}
	public void img6(View v){
		centro.setImageResource(R.drawable.perfil6);
		fotoInt=6;
	}
	public void img7(View v){
		centro.setImageResource(R.drawable.perfil7);
		fotoInt=7;
	}
	public void img8(View v){
		centro.setImageResource(R.drawable.perfil8);
		fotoInt=8;
	}
	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.crear_grupo, menu);
		return true;
	}

}
