package com.example.socil;

import java.io.Serializable;

public class Usuario implements Serializable{
	
	private String nombre;
	private String correo;
	private String password;
	private int foto;
	private CSimpleA A=new CSimpleA();
	private PilaP P=new PilaP();
	
	Usuario(String nom, String corr, String pass)
	{
		nombre=nom;
		correo=corr;
		password=pass;
		foto=0;
	}
	Usuario()
	{
		nombre="";
		correo="";
		password="";
		foto=0;
	}
	
	public void mostrar()
	{
		System.out.println("Nombre: "+nombre);
		System.out.println("Correo: "+correo);
		System.out.println("Password: "+"jeje XD no lo creo XD alerta de haker");
		System.out.println("Foto: "+foto);
		System.out.println("Amigos:");
		A.mostrar();
		System.out.println("Publicaciones: ");
		P.mostrarP();
	}
	public void mostrar1()
	{
		System.out.println("Nombre: "+nombre);
		
	}
	public void leer()
	{
		System.out.println("intro nombre");
		nombre=Leer.dato();
		System.out.println("intro correo");
		correo=Leer.dato();
		System.out.println("intro password");
		password=Leer.dato();
//		System.out.println("intro direccion foto");
//		foto=Leer.dato();
		
	}
	public void addAmigo(String nombre_amigo, String relacion){
		Amigo x=new Amigo();
		x.setId_amigo(nombre_amigo);
		x.setRelacion(relacion);
		A.verificar(x);
	}
	public void addPublicacion(String nombre, String texto){
		Publicacion x=new Publicacion();
		
		
		x.setDe(nombre);
		x.setTexto(texto);
		P.adicionar(x);
		
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getFoto() {
		return foto;
	}
	public void setFoto(int foto) {
		this.foto = foto;
	}
	public CSimpleA getA() {
		return A;
	}
	public void setA(CSimpleA a) {
		A = a;
	}
	public PilaP getP() {
		return P;
	}
	public void setP(PilaP p) {
		P = p;
	}
}
