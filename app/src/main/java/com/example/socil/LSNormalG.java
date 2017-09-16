package com.example.socil;

import java.io.Serializable;

public class LSNormalG implements Serializable{
	private NodoG P;
	
	LSNormalG()
	{
		P=null;
	}
	public NodoG getP() {
		return P;
	}

	public void setP(NodoG p) {
		P = p;
	}
	void adiprimero (Grupo x)     
	{  NodoG w = new NodoG ();  
	   w.setG(x);
	
	   w.setSig(getP());
	   setP(w);
	}
	public void leer1(int n)
	{
		for (int i = 1; i <=n; i++) 
		{
			Grupo x=new Grupo();
			x.leer();
			adiprimero(x);
		}
	}
	public void mostrar()
	{
		NodoG r=getP();
		while(r!=null)
		{
			r.getG().mostrar();
			r=r.getSig();
		}
	}
	public void mostrar1(String nom)
	{
		
		NodoG r=getP();
		while(r!=null)
		{	if(r.getG().getM().existe(nom))
				r.getG().mostrar();
			r=r.getSig();
		}
	}
	public void addGrupo(String nombre_ingreso){
		Grupo x=new Grupo();
		x.leer();
		x.addMiembro(nombre_ingreso);
		adiprimero(x);
	}
	public void addMiembroA(String nombreG, String nombreU){
		NodoG r=getP();
		int sw=0;
		while(r!=null)
		{
			if(r.getG().getNombre().equals(nombreG)){
				r.getG().addMiembro(nombreU);
				sw=1;
			}
			r=r.getSig();
		}
		if(sw==0){
			System.out.println("\t ### Ese grupo no existe ###");
		}
	}
	
	
	public Grupo grupoIngreso(String nom){
		NodoG r=getP();
		while(r!=null){
			if(r.getG().getNombre().equals(nom)){
				return r.getG();
			}
			
			r=r.getSig();
		}
		return null;
	}
	
	
	public void addPublicacionDe(String nombre, String texto,String nombre_grupo){

		NodoG q=getP();
		while(q!=null){
			if(q.getG().getNombre().equals(nombre_grupo)){
				q.getG().addPublicacion(nombre, texto);
			}
			q=q.getSig();
		}

	}
}
