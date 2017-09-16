package com.example.socil;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;


public class LSNormalM  implements Serializable{
	private NodoM P;

	LSNormalM()
	{
		P=null;
	}
	public NodoM getP() {
		return P;
	}

	public void setP(NodoM p) {
		P = p;
	}
	void adiprimero (Mensaje x)     
	{  NodoM w = new NodoM ();  
	w.setM(x);

	w.setSig(getP());
	setP(w);
	}
	public void leer1(int n)
	{
		for (int i = 1; i <=n; i++) 
		{
			Mensaje x=new Mensaje();
			x.leer();
			adiprimero(x);
		}
	}
	public void mostrar()
	{
		NodoM r=getP();
		while(r!=null)
		{
			r.getM().mostrar();
			r=r.getSig();
		}
	}
	public void addMensaje(String emisor, String receptor, String texto){

		NodoM r=getP();
		int sw=0;
		while(r!=null){
			if(r.getM().getId_1().equals(emisor) && r.getM().getId_2().equals(receptor) || r.getM().getId_2().equals(emisor) && r.getM().getId_1().equals(receptor)){

				r.getM().getMD().addMensaje(fechaActual(), emisor, texto);


				sw=1;
			}
			r=r.getSig();
		}
		if(sw==0){
			Mensaje x=new Mensaje();
			x.setId_1(emisor);
			x.setId_2(receptor);
			x.getMD().addMensaje(fechaActual(), emisor, texto);
			adiprimero(x);
		}

	}
	
	
	

	public String fechaActual(){
		Date ahora=new Date();
		SimpleDateFormat formato=new SimpleDateFormat("dd-MM-yyyy");
		return formato.format(ahora);
	}
	public void verMensajeCon(String dato, String nombre_ingreso) {
		NodoM r=getP();
		while(r!=null)
		{	if(r.getM().getId_1().equals(dato) && r.getM().getId_2().equals(nombre_ingreso) || r.getM().getId_1().equals(nombre_ingreso) && r.getM().getId_2().equals(dato))
			r.getM().mostrar();
		r=r.getSig();
		}

	}

	public String ultimoMensaje(String dato, String nombre_ingreso) {
		NodoM r=getP();
		while(r!=null)
		{	if(r.getM().getId_1().equals(dato) && r.getM().getId_2().equals(nombre_ingreso) || r.getM().getId_1().equals(nombre_ingreso) && r.getM().getId_2().equals(dato))
			{
			CSimpleMD a=r.getM().getMD();
			MensajeDia x=new MensajeDia();
			int n=a.nroelem();
			for (int i = 1; i <= n-1; i++) {
				x=a.eliminar();
				a.adicionar(x);
			}
			x=a.eliminar();

			CSimpleMEN a1=x.getMEN();
			int n1=a1.nroelem();
			Unmensaje x1=new Unmensaje();
			for (int i = 1; i <=n1-1; i++) {
				x1=a1.eliminar();
				a1.adicionar(x1);
			}

			x1=a1.eliminar();

			a1.adicionar(x1);

			a.adicionar(x);
			if(x1.getDe().equals(nombre_ingreso)){
				return "Tu: "+ x1.getTexto();
			}
			else{
				return x1.getTexto();
			}

		}
		r=r.getSig();
		}
		return "";
	}

	public String horaUltimoMensaje(String dato, String nombre_ingreso) {
		NodoM r=getP();
		while(r!=null)
		{	if(r.getM().getId_1().equals(dato) && r.getM().getId_2().equals(nombre_ingreso) || r.getM().getId_1().equals(nombre_ingreso) && r.getM().getId_2().equals(dato))
		{
			CSimpleMD a=r.getM().getMD();
			MensajeDia x=new MensajeDia();
			int n=a.nroelem();
			for (int i = 1; i <= n-1; i++) {
				x=a.eliminar();
				a.adicionar(x);
			}
			x=a.eliminar();

			CSimpleMEN a1=x.getMEN();
			int n1=a1.nroelem();
			Unmensaje x1=new Unmensaje();
			for (int i = 1; i <=n1-1; i++) {
				x1=a1.eliminar();
				a1.adicionar(x1);
			}

			x1=a1.eliminar();

			a1.adicionar(x1);

			a.adicionar(x);

			return x1.getHora();


		}
		r=r.getSig();
		}
		return "";
	}

	public int nroNoVistos(String dato, String nombre_ingreso) {
		NodoM r=getP();
		while(r!=null)
		{	if(r.getM().getId_1().equals(dato) && r.getM().getId_2().equals(nombre_ingreso) || r.getM().getId_1().equals(nombre_ingreso) && r.getM().getId_2().equals(dato))
		{
			int c=0;
			CSimpleMD a=r.getM().getMD();
			CSimpleMD a2=new CSimpleMD();
			int n=a.nroelem();
			for (int i = 1; i <= n; i++) {
				MensajeDia x=a.eliminar();

				CSimpleMEN a1=x.getMEN();
				CSimpleMEN a3= new CSimpleMEN();
				int n1=a1.nroelem();

				for (int j = 1; j <=n1; j++) {
					Unmensaje x1=a1.eliminar();

					if(x1.getVisto().equals("no")  && x1.getDe().equals(dato)){
						c=c+1;
					}

					a3.adicionar(x1);
				}
				a1.vaciar(a3);

				a2.adicionar(x);
			}
			a.vaciar(a2);

			return c;
		}
		r=r.getSig();
		}
		return 0;
	}
	
	
	
	
	public void Vistear(String dato, String nombre_ingreso) {
		NodoM r=getP();
		while(r!=null)
		{	if(r.getM().getId_1().equals(dato) && r.getM().getId_2().equals(nombre_ingreso) || r.getM().getId_1().equals(nombre_ingreso) && r.getM().getId_2().equals(dato))
		{
			int c=0;
			CSimpleMD a=r.getM().getMD();
			CSimpleMD a2=new CSimpleMD();
			int n=a.nroelem();
			for (int i = 1; i <= n; i++) {
				MensajeDia x=a.eliminar();

				CSimpleMEN a1=x.getMEN();
				CSimpleMEN a3= new CSimpleMEN();
				int n1=a1.nroelem();

				for (int j = 1; j <=n1; j++) {
					Unmensaje x1=a1.eliminar();

					if(x1.getVisto().equals("no")  && x1.getDe().equals(dato)){
						x1.setVisto("si");
					}

					a3.adicionar(x1);
				}
				a1.vaciar(a3);

				a2.adicionar(x);
			}
			a.vaciar(a2);

		}
		r=r.getSig();
		}
	}
	
	
	
	

	public CSimpleMD getMensajesDia(String dato, String nombre_ingreso) {
		NodoM r=getP();
		while(r!=null)
		{	if(r.getM().getId_1().equals(dato) && r.getM().getId_2().equals(nombre_ingreso) || r.getM().getId_1().equals(nombre_ingreso) && r.getM().getId_2().equals(dato))
		{
			return r.getM().getMD();
		}
		r=r.getSig();
		}
		return null;
	}

	public String esPrimerMensaje(Unmensaje m, String dato, String nombre_ingreso){
		NodoM r=getP();
		String fecha="";
		while(r!=null)
		{	if(r.getM().getId_1().equals(dato) && r.getM().getId_2().equals(nombre_ingreso) || r.getM().getId_1().equals(nombre_ingreso) && r.getM().getId_2().equals(dato))
			{
			CSimpleMD a=r.getM().getMD();
			
			int e=a.nroelem();
			for (int i =1; i <=e; i++) {
				MensajeDia x=a.eliminar();

				CSimpleMEN u=x.getMEN();


				if(u.primerMensaje().getDe().equals(m.getDe()) && u.primerMensaje().getHora().equals(m.getHora()) && u.primerMensaje().getTexto().equals(m.getTexto()) && u.primerMensaje().getVisto().equals(m.getVisto())){
					fecha= x.getFecha_dia();
				}

				a.adicionar(x);
			}
			

			}

			r=r.getSig();
		}
		return fecha;
	}
	
	
}
