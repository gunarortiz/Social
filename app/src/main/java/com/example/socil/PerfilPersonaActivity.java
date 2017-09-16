package com.example.socil;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class PerfilPersonaActivity extends Activity {
	private static RedSocial r=new RedSocial();
	private ArrayList<Publicacion> ArrayPublicacion =new ArrayList<Publicacion>();
	PublicacionAdapter adapter;
	Usuario x=new Usuario();
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_perfil_persona);
		getActionBar().hide();
		Intent i=getIntent();
		r=(RedSocial)i.getSerializableExtra("objeto");
		String q=(String)i.getSerializableExtra("user");

		x=r.getU().userIngreso(q);

		TextView nombre=(TextView)findViewById(R.id.nombrePerfil);
		nombre.setText(x.getNombre());

		TextView correo=(TextView)findViewById(R.id.correoPerfil);
		correo.setText(x.getCorreo());

		final Button b=(Button)findViewById(R.id.botonAddAmigo1);
		if(!r.getU().esAmigo(r.getNombre_ingreso(), x.getNombre())){
			b.setVisibility(View.VISIBLE);
			b.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View p) {
					
					Toast.makeText(getApplicationContext(), "Ya eres su amigo!", Toast.LENGTH_SHORT).show();
					r.getU().addAmigoA(x.getNombre(), r.getNombre_ingreso(), "amistad");
					b.setVisibility(View.GONE);
//					TextView esAmigo=(TextView)findViewById(R.id.esAmigo);
//					esAmigo.setVisibility(View.VISIBLE);
					
				}
			});
			
		}
		LinearLayout l=(LinearLayout)findViewById(R.id.publi);
		
		
		if(r.getNombre_ingreso().equals(x.getNombre())){
			nombre.setText("Tu: "+x.getNombre());
			b.setVisibility(View.GONE);
			l.setVisibility(View.VISIBLE);
			
			
		}
//		else{
//			TextView esAmigo=(TextView)findViewById(R.id.esAmigo);
//			esAmigo.setVisibility(View.VISIBLE);
//		}

		ImageView fotoSup=(ImageView)findViewById(R.id.fotoPerfil);
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

		actualizar(x);


	}

	public void actualizar(Usuario x){
		ArrayPublicacion.clear();
		int n=x.getP().nroelem();
		PilaP aux=new PilaP();
		for (int j = 1; j <= n; j++) {
			Publicacion p=x.getP().eliminar();

			aux.adicionar(p);
			//if(p.getLugar().equals("p"))
			ArrayPublicacion.add(p);
		}

		x.getP().vaciar(aux);
		//r.getU().userIngreso(r.getNombre_ingreso()).setA(aux);
		adapter =new PublicacionAdapter(getApplicationContext(), R.layout.adapter_publicacion, ArrayPublicacion);

		ListView list = (ListView)findViewById(R.id.list_publicaciones);
		list.setAdapter(adapter);

		Utility.setListViewHeightBasedOnChildren(list);
	}

	public void publi(View v){
		TextView t=(TextView)findViewById(R.id.textoPubli);
		if(t.getText().toString().equals("")){
			Toast.makeText(getApplicationContext(), "Llene todos los campos", Toast.LENGTH_SHORT).show();
		}
		else{
			Usuario y=r.getU().userIngreso(r.getNombre_ingreso());
			Publicacion p=new Publicacion(r.getNombre_ingreso(), t.getText().toString());
			y.getP().adicionar(p);
			actualizar(x);
			t.setText("");
		}
		
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.perfil_persona, menu);
		return true;
	}

	public class PublicacionAdapter extends ArrayAdapter<Publicacion>{

		public PublicacionAdapter(Context context, int resourse, ArrayList<Publicacion> lista){
			super(context, resourse, lista);
		}

		@Override
		public View getView(int i, View c, ViewGroup p){
			View v=LayoutInflater.from(getContext()).inflate(R.layout.adapter_publicacion, p, false);

			ImageView img=(ImageView)v.findViewById(R.id.imgPubli);
			TextView textNombre=(TextView)v.findViewById(R.id.nombrePubli);

			TextView textDescrip=(TextView)v.findViewById(R.id.textoDescripcionPubli);




			img.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub

				}
			});

			final Publicacion us=getItem(i);

			TextView horaPubli=(TextView)v.findViewById(R.id.horaPubli);
			horaPubli.setText(us.getFecha());
			textNombre.setText(us.getDe());
			textDescrip.setText(us.getTexto());

			final Usuario m=r.getU().userIngreso(us.getDe());



			final Button bo=(Button)v.findViewById(R.id.botonLike);



			if(us.getM().getTope()==0){
				bo.setText("Like");
			}
			else
				bo.setText(us.getM().getTope()+" Like");
			int y=0;
			PilaM aux=new PilaM();
			while(!us.getM().esvacia()){
				String x=us.getM().eliminar();
				if(x.equals(r.getNombre_ingreso())){
					y=1;
				}
				aux.adicionar(x);
			}

			us.getM().vaciar(aux);




			if(y==1){
				bo.setBackgroundColor(Color.rgb(255, 157, 100));

			}

			else{
				bo.setBackgroundColor(Color.rgb(255, 115, 33));

			}

			bo.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					ColorDrawable botonColor=(ColorDrawable)bo.getBackground();
					int color=botonColor.getColor();
					if(color==-36063){
						us.getM().adicionar(r.getNombre_ingreso());
						bo.setBackgroundColor(Color.rgb(255, 157, 100));
						bo.setText(us.getM().getTope()+" likes");

					}else{
						PilaM aux=new PilaM();
						while(!us.getM().esvacia()){
							String x=us.getM().eliminar();
							if(x.equals(r.getNombre_ingreso())){

							}
							else{
								aux.adicionar(x);
							}

						}
						us.getM().vaciar(aux);
						if(us.getM().getTope()==0){
							bo.setText("Like");
						}
						else{
							bo.setText(us.getM().getTope()+" likes");
						}


						bo.setBackgroundColor(Color.rgb(255, 115, 33));

					}

				}
			});



			if(m.getFoto()==1){
				img.setImageResource(R.drawable.perfil1);
			}
			if(m.getFoto()==2){
				img.setImageResource(R.drawable.perfil2);
			}
			if(m.getFoto()==3){
				img.setImageResource(R.drawable.perfil3);
			}
			if(m.getFoto()==4){
				img.setImageResource(R.drawable.perfil4);
			}
			if(m.getFoto()==5){
				img.setImageResource(R.drawable.perfil5);
			}
			if(m.getFoto()==5){
				img.setImageResource(R.drawable.perfil6);
			}
			if(m.getFoto()==7){
				img.setImageResource(R.drawable.perfil7);
			}
			if(m.getFoto()==8){
				img.setImageResource(R.drawable.perfil8);
			}
			return v;
		}

	}

	public void add(View v){
		Intent i=new Intent(PerfilPersonaActivity.this, AgregarActivity.class);
		i.putExtra("objeto", r);
		startActivity(i);
		finish();
	}

	public static class Utility{
		public static void setListViewHeightBasedOnChildren(ListView listView){
			ListAdapter listAdapter=listView.getAdapter();
			if(listAdapter==null){
				return;
			}

			int totalHeight=0;

			for(int i=0; i<listAdapter.getCount(); i++){
				View listltem=listAdapter.getView(i, null, listView);
				listltem.measure(0, 0);
				totalHeight+=listltem.getMeasuredHeight();
			}

			ViewGroup.LayoutParams params=listView.getLayoutParams();
			params.height=totalHeight+(listView.getDividerHeight()*(listAdapter.getCount()*(listAdapter.getCount()-1)));
			listView.setLayoutParams(params);

		}

	}


	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event){
		if(keyCode==KeyEvent.KEYCODE_BACK){

			finish();
			Intent i=new Intent(PerfilPersonaActivity.this, MainActivity.class);				
			i.putExtra("objeto", r);
			startActivity(i);
			finish();
			return true;
		}

		return super.onKeyDown(keyCode, event);
	}


}
