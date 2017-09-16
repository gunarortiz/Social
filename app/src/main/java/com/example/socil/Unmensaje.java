package com.example.socil;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Unmensaje implements Serializable{
	private String de;
	private String texto;
	private String hora;
	private String visto;
	
	Unmensaje()
	{
		de="";
		texto="";
		hora="";
		visto="no";
	}
	Unmensaje(String de1, String texto1)
	{
		de=de1;
		texto=texto1;
		hora=horaActual();
		visto="no";
	}
	public void mostrar()
	{
		System.out.println("de: "+de);
		System.out.println("texto: "+texto);
		System.out.println("hora: "+hora);
		System.out.println("visto: "+visto);
		System.out.println("-----------------------------");
	}
	public String getVisto() {
		return visto;
	}
	public void setVisto(String visto) {
		this.visto = visto;
	}
	public void leer()
	{
		System.out.println("intro de:");
		de=Leer.dato();
		System.out.println("intro texto");
		texto=Leer.dato();
		
	}
	public String getDe() {
		return de;
	}
	public void setDe(String de) {
		this.de = de;
	}
	public String getTexto() {
		return texto;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}
	public String getHora() {
		return hora;
	}
	public void setHora() {
		this.hora = horaActual();
	}
	public String horaActual(){
		Date ahora=new Date();
		SimpleDateFormat formato=new SimpleDateFormat("hh:mm");
		return formato.format(ahora);
	}
}
