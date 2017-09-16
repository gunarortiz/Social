package com.example.socil;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Publicacion implements Serializable{
	private String de;
	private String texto;
	private String fecha;

	
	private PilaM M;
	
	Publicacion()
	{
		de="";
		texto="";
		fecha="";
		M=new PilaM();
	}
	Publicacion(String de1, String tex)
	{
		de=de1;
		texto=tex;

		fecha=fechaActual();
		
		M=new PilaM();
	}
	public void mostrar()
	{	System.out.println("de: "+de);
		System.out.println("texto: "+texto);
		System.out.println("fecha: "+fecha);
		
		System.out.println("Likes: ");
		M.mostrar();
	}
	public String getDe() {
		return de;
	}
	public void setDe(String de) {
		this.de = de;
	}
	public void leer()
	{
		System.out.println("intro texto: ");
		texto=Leer.dato();
		fecha=fechaActual();
	}
	
	public void addLike(String id_Like){
		M.adicionar(id_Like);
	}
	
	public String getTexto() {
		return texto;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public PilaM getM() {
		return M;
	}
	public void setM(PilaM m) {
		M = m;
	}
	
	public String fechaActual(){
		Date ahora=new Date();
		SimpleDateFormat formato=new SimpleDateFormat("dd-MM-yyyy");
		return formato.format(ahora);
	}
	

}
