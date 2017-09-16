package com.example.socil;

import java.io.Serializable;

public class Amigo implements Serializable {
	private String nombre_amigo;
	private String relacion;
	
	Amigo(String nom, String rela)
	{
		nombre_amigo=nom;
		relacion=rela;
	}
	Amigo()
	{
		nombre_amigo="";
		relacion="";
	}
	public void mostrar()
	{
		System.out.println("nombre_amigo: "+nombre_amigo);
		System.out.println("relacion: "+relacion);
	}
	public void leer()
	{
		System.out.println("intro nombre_amigo");
		nombre_amigo=Leer.dato();
		System.out.println("intro relacion");
		relacion=Leer.dato();
	}
	public String getNombre_amigo() {
		return nombre_amigo;
	}
	public void setId_amigo(String nombre_amigo) {
		this.nombre_amigo = nombre_amigo;
	}
	public String getRelacion() {
		return relacion;
	}
	public void setRelacion(String relacion) {
		this.relacion = relacion;
	}
	
}
