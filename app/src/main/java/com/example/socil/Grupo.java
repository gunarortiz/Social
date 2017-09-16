package com.example.socil;

import java.io.Serializable;

public class Grupo implements Serializable {

	private String nombre;
	private String descripcion;
	private int foto;
	private CSimpleM M=new CSimpleM();
	private PilaP P=new PilaP();

	Grupo()
	{
		nombre="";
		descripcion="";
		foto=0;
		
	}
	public PilaP getP() {
		return P;
	}
	public void setP(PilaP p) {
		P = p;
	}

	Grupo(String nom, String des, int fot)
	{
		nombre=nom;
		descripcion=des;
		foto=fot;
		
	}
	public void mostrar()
	{
		System.out.println("nombre: "+nombre);
		System.out.println("descripcion: "+descripcion);
		System.out.println("Foto: "+foto);
		System.out.println("Miembros: ");
		M.mostrar();
		System.out.println("------------------------");
	}
	public void leer()
	{
		System.out.println("intro nombre");
		nombre=Leer.dato();
		System.out.println("intro descripcion");
		descripcion=Leer.dato();
//		System.out.println("intro foto");
//		foto=Leer.dato();
		
	}
	public void addMiembro(String nombre_ingreso){
		
		M.verificar(nombre_ingreso);
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public int getFoto() {
		return foto;
	}
	public void setFoto(int foto) {
		this.foto = foto;
	}
	public CSimpleM getM() {
		return M;
	}
	public void setM(CSimpleM m1) {
		M = m1;
	}
	public void addPublicacion(String nombre,String texto){
		Publicacion x=new Publicacion();
		
		x.setDe(nombre);
		x.setTexto(texto);
		P.adicionar(x);
		
	}
	
}

