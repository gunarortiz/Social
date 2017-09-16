package com.example.socil;



import java.io.Serializable;

public class LSNormalU implements Serializable{
	private NodoU P;

	LSNormalU()
	{
		P=null;
	}
	public NodoU getP() {
		return P;
	}

	public void setP(NodoU p) {
		P = p;
	}
	void adiprimero (Usuario x)     
	{  NodoU w = new NodoU ();  
	w.setU(x);

	w.setSig(getP());
	setP(w);
	}
	public void leer1(int n)
	{
		for (int i = 1; i <=n; i++) 
		{
			Usuario x=new Usuario();
			x.leer();
			adiprimero(x);
		}
	}
	public void mostrar()
	{
		NodoU r=getP();
		while(r!=null)
		{
			r.getU().mostrar();
			r=r.getSig();
		}
	}
	public void mostrar1(String nombre_ingreso)
	{
		NodoU r=getP();
		while(r!=null)
		{	if(!r.getU().getNombre().equals(nombre_ingreso))
			{
			r.getU().mostrar1();
			}
		
		r=r.getSig();
		}
	}
	public void addUsuario(String nom, String correo, String pass, int fot){
		Usuario x=new Usuario();
		x.setNombre(nom);
		x.setCorreo(correo);
		x.setPassword(pass);
		x.setFoto(fot);
		adiprimero(x);
	}
	public String ingresar(String nom, String pass){
		String x="";
		NodoU q=getP();
		while(q!=null){
			if(q.getU().getNombre().equals(nom) && q.getU().getPassword().equals(pass)){
				return q.getU().getNombre();
			}
			q=q.getSig();
		}

		return x;
	}

	public void addPublicacionDe(String nombre, String lugar){

		NodoU q=getP();
		while(q!=null){
			if(q.getU().getNombre().equals(nombre)){
				q.getU().addPublicacion(nombre, lugar);
			}
			q=q.getSig();
		}

	}
	public void addAmigoA(String nombreA, String nombreU, String relacion){
		NodoU r=getP();
		while(r!=null)
		{
			if(r.getU().getNombre().equals(nombreU)){
				
				NodoU q=getP();
				while(q!=null){
					if(q.getU().getNombre().equals(nombreA)){
						q.getU().addAmigo(nombreU, relacion);
					}
					q=q.getSig();
				}
				
				r.getU().addAmigo(nombreA, relacion);

			}
			r=r.getSig();
		}

	}
	public void mostrarAmigos(String nombre_ingreso){
		NodoU r=getP();
		while(r!=null)
		{	if(r.getU().getNombre().equals(nombre_ingreso))
			{
				r.getU().getA().mostrar();
			}
		
		r=r.getSig();
		}
	}
	public void verPublicacionesDe(String de){
		NodoU r=getP();
		while(r!=null)
		{	if(r.getU().getNombre().equals(de))
			{
				r.getU().getP().mostrarP();
			}
		
		r=r.getSig();
		}
	}
	public void verPublicacionesDeG(String dato) {
		NodoU r=getP();

	    System.out.println ("\t ## Publicaciones del grupo ## ");
		while(r!=null)
		{		
				r.getU().getP().mostrarG(dato);
		r=r.getSig();
		}
		
	}
	
	public boolean existeUsuario(String usu){
		NodoU r=getP();
		while(r!=null)
		{	if(r.getU().getNombre().equals(usu))
			{
				return true;
			}
		
		r=r.getSig();
		}
		return false;
	}
	public int nroNodos(){
		NodoU r=getP();
		int c=0;
		while(r!=null){
			c=c+1;
			r=r.getSig();
		}
		return c;
	}
	public Usuario userIngreso(String nom){
		NodoU r=getP();
		while(r!=null){
			if(r.getU().getNombre().equals(nom)){
				return r.getU();
			}
			
			r=r.getSig();
		}
		return null;
	}
	
	
	public boolean esAmigo(String nombre_ingreso, String nombre_amigo){
		NodoU r=getP();
		int sw=0;
		while(r!=null)
		{	if(r.getU().getNombre().equals(nombre_ingreso))
			{
				CSimpleA a=r.getU().getA();
				int n=a.nroelem();
				for (int i = 1; i <=n; i++) {
					Amigo q=a.eliminar();
					if(q.getNombre_amigo().equals(nombre_amigo)){
						sw=1;
					}
					a.adicionar(q);
				}
			}
		
		r=r.getSig();
		}
		if(sw==1){
			return true;
		}
		return false;
	}
	
	
	
}
