package com.example.socil;


import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class SplashActivity extends Activity {
	private LinearLayout animado;
	private LinearLayout ocultar;
	private LinearLayout registro;
	private ImageView logo;
	private int sw=0;
	private int c=0; //sw para verificar el registro
	private static String passParaVerificar="";
	private static String passParaVerificar1="";
	private static RedSocial r=new RedSocial();
	ImageView centro;
	private int fotoInt=0;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_splash);

		getActionBar().hide();
		animado=(LinearLayout)findViewById(R.id.mover);
		ocultar=(LinearLayout)findViewById(R.id.IngresoOcultar);
		registro=(LinearLayout)findViewById(R.id.RegistroOcultar);
		logo=(ImageView)findViewById(R.id.imageView1);

centro=(ImageView)findViewById(R.id.image0);
		

		sw=0;

		
		/////////////////////////////foto de perfil///////////////////////////////////
		
		if(r.getCreado().equals("no")){
			llenar();
			r.setCreado("si");
		}
		else{
			Intent i=getIntent();
			r=(RedSocial)i.getSerializableExtra("objeto");
		}
		
		

		/////////////////////////////////////////////////////////////////////////////////////////////


		new Handler().postDelayed(new Runnable() {

			public void run() {

				mostrar();

			}
		}, 1500);

		Toast.makeText(getApplicationContext(), "Admin es un usuario de prueba, tambien puede registrar otros e interactuar", Toast.LENGTH_SHORT).show();

		/// mostrar error del nombre al registrar
		EditText nombre=(EditText)findViewById(R.id.nombreReg);
		nombre.addTextChangedListener(new TextWatcher() {

			TextView nomCorrecto=(TextView)findViewById(R.id.nombreCorrectoText);
			TextView nomIncorrecto=(TextView)findViewById(R.id.nombreIncorrectoText);
			@Override
			public void afterTextChanged(Editable s) {
				String nombreText=s.toString();
				Button reg=(Button)findViewById(R.id.registrar);
				if(r.getU().existeUsuario(nombreText)){
					nomIncorrecto.setVisibility(View.VISIBLE);
					nomCorrecto.setVisibility(View.GONE);
//
//					reg.setEnabled(false);
//					reg.setAlpha((float) 0.5);
//					c=c-1;
				}
				if(!r.getU().existeUsuario(nombreText)){
					nomIncorrecto.setVisibility(View.GONE);
					nomCorrecto.setVisibility(View.VISIBLE);

//					if(nombreText.length()<=1){
//
//						c=c+1;
//						
//					}
//					if(c>=3){
//						reg.setEnabled(true);
//						reg.setAlpha((float) 1);
//					}
				}
				if(nombreText.equals("")){
					nomIncorrecto.setVisibility(View.GONE);
					nomCorrecto.setVisibility(View.GONE);
//					c=c-1;
//					reg.setEnabled(false);
//					reg.setAlpha((float) 0.5);
				}
			}

			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onTextChanged(CharSequence s, int start, int before,
					int count) {
				// TODO Auto-generated method stub

			}
		});


		///// sw del correo

		EditText correo=(EditText)findViewById(R.id.correoReg);
		correo.addTextChangedListener(new TextWatcher() {
			@Override
			public void afterTextChanged(Editable s) {
				String nombreText=s.toString();
				Button reg=(Button)findViewById(R.id.registrar);
				if(nombreText.equals("")){
//					c=c-1;
//					reg.setEnabled(false);
//					reg.setAlpha((float) 0.5);
				}
//				else{
//					if(nombreText.length()<=1){
//
//
//						c=c+1;
//						if(c>=3){
//							reg.setEnabled(true);
//							reg.setAlpha((float) 1);
//						}
//					}
//				}
			}

			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onTextChanged(CharSequence s, int start, int before,
					int count) {
				// TODO Auto-generated method stub

			}
		});


		///////////////mostrar el eeror de las contrase�as


		EditText pass=(EditText)findViewById(R.id.passReg);
		pass.addTextChangedListener(new TextWatcher() {

			TextView passCorrecto=(TextView)findViewById(R.id.passCorrectosText);
			TextView passIncorrecto=(TextView)findViewById(R.id.passIncorrectosText);
			@Override
			public void onTextChanged(CharSequence s, int start, int before, int count) {
			}
			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
			}
			@Override
			public void afterTextChanged(Editable s) {
				passParaVerificar=s.toString();
				Button reg=(Button)findViewById(R.id.registrar);
				String passText1=s.toString();

				if(!passText1.equals(passParaVerificar1)){
					passIncorrecto.setVisibility(View.VISIBLE);
					passCorrecto.setVisibility(View.GONE);
//					if(passParaVerificar1.length()==passParaVerificar.length())
//						c=c-1;
//					reg.setEnabled(false);
//					reg.setAlpha((float) 0.5);
				}
				if(passText1.equals(passParaVerificar1)){
					passIncorrecto.setVisibility(View.GONE);
					passCorrecto.setVisibility(View.VISIBLE);
//					c=c+1;
//					if(c>=3){
//						reg.setEnabled(true);
//						reg.setAlpha((float) 1);
//					}

				}
				if(passParaVerificar1.equals("") && passText1.equals("")){
					passIncorrecto.setVisibility(View.GONE);
					passCorrecto.setVisibility(View.GONE);
//					c=c-1;
//					reg.setEnabled(false);
//					reg.setAlpha((float) 0.5);
				}
			}
		});


		EditText pass1=(EditText)findViewById(R.id.passRepReg);
		pass1.addTextChangedListener(new TextWatcher() {

			TextView passCorrecto=(TextView)findViewById(R.id.passCorrectosText);
			TextView passIncorrecto=(TextView)findViewById(R.id.passIncorrectosText);
			@Override
			public void afterTextChanged(Editable s) {
				passParaVerificar1=s.toString();
				String passText1=s.toString();
				Button reg=(Button)findViewById(R.id.registrar);

				if(!passText1.equals(passParaVerificar)){
					passIncorrecto.setVisibility(View.VISIBLE);
					passCorrecto.setVisibility(View.GONE);
					if(passParaVerificar1.length()==passParaVerificar.length())
						c=c-1;
//					reg.setEnabled(false);
//					reg.setAlpha((float) 0.5);

				}
				if(passText1.equals(passParaVerificar)){
					passIncorrecto.setVisibility(View.GONE);
					passCorrecto.setVisibility(View.VISIBLE);
//					c=c+1;
//					if(c>=3){
//						reg.setEnabled(true);
//						reg.setAlpha((float) 1);
//					}

				}
				if(passParaVerificar.equals("") && passText1.equals("")){
					passIncorrecto.setVisibility(View.GONE);
					passCorrecto.setVisibility(View.GONE);
//					c=c-1;
//					reg.setEnabled(false);
//					reg.setAlpha((float) 0.5);
				}
			}
			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
			}
			@Override
			public void onTextChanged(CharSequence s, int start, int before,
					int count) {
			}
		});




	}

	public void mostrar(){

		Animation animation=AnimationUtils.loadAnimation(this, R.anim.mostrar);

		ocultar.startAnimation(animation);
		ocultar.setVisibility(View.VISIBLE);


	}

	public void ocultar(View v){
		ocultar.setVisibility(View.GONE);
		registro.setVisibility(View.VISIBLE);
		sw=1;
		logo.setVisibility(View.GONE);
	}
	public void entrar(View v){
		EditText nombre=(EditText)findViewById(R.id.nombreIngreso);
		EditText pass=(EditText)findViewById(R.id.passIngreso);
		String nombreText=nombre.getText().toString();
		String passText=pass.getText().toString();

		TextView error=(TextView)findViewById(R.id.DatosIncorrectosText);
		String ingreso=r.getU().ingresar(nombreText, passText);
		if(ingreso.equals("")){

			error.setVisibility(View.VISIBLE);
		}
		else{
			r.setIngreso(true);
			r.setNombre_ingreso(nombreText);
			error.setVisibility(View.GONE);
			Intent i=new Intent(SplashActivity.this, MainActivity.class);
			i.putExtra("objeto", r);
			
			startActivity(i);
			finish();
		}

	}

	public void registrar(View v){
		EditText nombre=(EditText)findViewById(R.id.nombreReg);
		EditText correo=(EditText)findViewById(R.id.correoReg);
		EditText pass=(EditText)findViewById(R.id.passReg);

		String nombreText=nombre.getText().toString();
		String correoText=correo.getText().toString();
		String passText=pass.getText().toString();

				if(nombreText.equals("") || correoText.equals("") || passText.equals("")){
					Toast.makeText(getApplicationContext(), "Llene todos los datos", Toast.LENGTH_SHORT).show();
				}
				else{


		r.getU().addUsuario(nombreText, correoText, passText, fotoInt);

		Toast.makeText(getApplicationContext(), "Registro con Exito", Toast.LENGTH_SHORT).show();

		registro.setVisibility(View.GONE);
		ocultar.setVisibility(View.VISIBLE);
		logo.setVisibility(View.VISIBLE);
		sw=0;
				}

	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event){
		if(keyCode==KeyEvent.KEYCODE_BACK){
			if(sw==1){
				registro.setVisibility(View.GONE);
				ocultar.setVisibility(View.VISIBLE);
				logo.setVisibility(View.VISIBLE);
				sw=0;
			}
			else{
				System.exit(0);
				System.runFinalization();
				
				finish();
			}


			return true;
		}

		return super.onKeyDown(keyCode, event);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.splash, menu);
		return true;
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
	
	
	public void llenar(){

		
		
		
		
		/////////////////////////////Casos de Prueva///////////////////////
		Usuario x=new Usuario("Marcelo Ticona", "marcelo@gmail.com","123");
		Usuario x1=new Usuario("Maria Belen", "mariabelen@gmail.com","123456");
		Usuario x2=new Usuario("admin", "admin@gmail.com","admin");
		x.setFoto(2);
		x1.setFoto(5);
		x2.setFoto(8);

		CSimpleA a=new CSimpleA();
		CSimpleA a2=new CSimpleA();
		CSimpleA a3=new CSimpleA();

		//Adicionar amigos

		
		Amigo am2=new Amigo("Maria Belen", "familia");
		Amigo am3=new Amigo("admin", "amistad");
		
		Amigo am=new Amigo("Marcelo Ticona", "familia");
		Amigo am6=new Amigo("admin", "amistad");
		
		Amigo am4=new Amigo("Maria Belen", "amistad");
		Amigo am5=new Amigo("Marcelo Ticona", "amistad");

		
		
		
		a.adicionar(am2);
		a.adicionar(am3);
		
		a2.adicionar(am);
		a2.adicionar(am6);
		
		a3.adicionar(am4);
		a3.adicionar(am5);

		x.setA(a);
		x1.setA(a2);
		x2.setA(a3);

		//adicionar publicaciones

		Publicacion p=new Publicacion("Marcelo Ticona","hola como estas esta es una publicacion");
		Publicacion p1=new Publicacion("Marcelo Ticona","esta es otra publicacion");
		Publicacion p2=new Publicacion("Marcelo Ticona","esta es una publicacion de grupo");
		p2.addLike("admin");

		Publicacion p3=new Publicacion("Maria Belen","lorem ipsu caso de prueba");
		Publicacion p4=new Publicacion("Maria Belen","proyecto de informatica 131");
		p4.addLike("Marcelo Ticona");

		Publicacion p5=new Publicacion("admin","esta es la primera publicacion de de este usuario");
		Publicacion p6=new Publicacion("admin","Este es la primera publicacion en un grupo de este usuario");
		p6.addLike("Maria Belen");
		Publicacion p7=new Publicacion("admin","Publicacion numero 1 en un grupo");

		PilaP grupoMat115=new PilaP();
		grupoMat115.adicionar(p2);
		grupoMat115.adicionar(p7);
		
		PilaP grupoInf131=new PilaP();
		grupoInf131.adicionar(p6);
		
		
		PilaP pi=new PilaP();
		pi.adicionar(p);
		pi.adicionar(p1);
		//pi.adicionar(p2);


		PilaP pi1=new PilaP();
		pi1.adicionar(p3);
		pi1.adicionar(p4);

		PilaP pi2=new PilaP();
		pi2.adicionar(p5);
		//pi2.adicionar(p6);
		//pi2.adicionar(p7);

		x.setP(pi);
		x1.setP(pi1);
		x2.setP(pi2);

		r.getU().adiprimero(x);
		r.getU().adiprimero(x1);
		r.getU().adiprimero(x2);

		//crear grupos

		CSimpleM m1=new CSimpleM();
		m1.adicionar("admin");
		Grupo g1=new Grupo("inf131", "grupo de la clase inf 131", 5);
		g1.setP(grupoInf131);
		g1.setM(m1);

		CSimpleM m2=new CSimpleM();

		m2.adicionar("Marcelo Ticona");
		m2.adicionar("Maria Belen");
		Grupo g2=new Grupo("mat115", "grupo de la clase mat 115", 4);
		g2.setP(grupoMat115);
		g2.setM(m2);

		r.getG().adiprimero(g1);
		r.getG().adiprimero(g2);

		//mensajes

		Unmensaje w1=new Unmensaje("Marcelo Ticona", "Hola Maria como te encuentras?");
		Unmensaje w2=new Unmensaje("Maria Belen", "hola!! todo bien por aca");
		CSimpleMEN e1=new CSimpleMEN();
		e1.adicionar(w1);
		e1.adicionar(w2);
		MensajeDia r1=new MensajeDia(e1);
		CSimpleMD z1=new CSimpleMD();
		z1.adicionar(r1);
		Mensaje men1=new Mensaje("Marcelo Ticona", "Maria Belen", z1);


		Unmensaje w3=new Unmensaje("Maria Belen", "que tal admin como le va");
		CSimpleMEN e3=new CSimpleMEN();
		e3.adicionar(w3);
		MensajeDia r3=new MensajeDia(e3);
		CSimpleMD z3=new CSimpleMD();
		z3.adicionar(r3);
		Mensaje men3=new Mensaje("Maria Belen", "admin", z3);

		Unmensaje w4=new Unmensaje("admin", "hola marcelo que tal tu dia");
		Unmensaje w5=new Unmensaje("Marcelo Ticona", "Hola! que tal admin como le va");
		Unmensaje w6=new Unmensaje("admin", "hola marcelo que tal tu dia espero que te este yendo muy pero muy bien");
		Unmensaje w7=new Unmensaje("Marcelo Ticona", "Todo bien y tu?");
		Unmensaje w8=new Unmensaje("admin", "Yo igual todo bien");
		Unmensaje w9=new Unmensaje("Marcelo Ticona", "Me alegra");
		Unmensaje w10=new Unmensaje("Marcelo Ticona", ":)");
		CSimpleMEN e4=new CSimpleMEN();
		e4.adicionar(w4);
		e4.adicionar(w5);
		e4.adicionar(w6);
		e4.adicionar(w7);
		e4.adicionar(w8);
		e4.adicionar(w9);
		e4.adicionar(w10);
		MensajeDia r4=new MensajeDia(e4);
		CSimpleMD z4=new CSimpleMD();
		z4.adicionar(r4);
		Mensaje men4=new Mensaje("Marcelo Ticona", "admin", z4);

		r.getM().adiprimero(men1);
		r.getM().adiprimero(men3);
		r.getM().adiprimero(men4);
	}
}
