package com.example.socil;

import java.io.Serializable;

public class RedSocial  implements Serializable{
	private String nombre_ingreso;
	private String creado="no";
	public String getCreado() {
		return creado;
	}

	public void setCreado(String creado) {
		this.creado = creado;
	}
	private boolean ingreso=false;
	public boolean getIngreso() {
		return ingreso;
	}

	public void setIngreso(boolean ingreso) {
		this.ingreso = ingreso;
	}
	private LSNormalU u=new LSNormalU();
	private LSNormalG g=new LSNormalG();	
	private LSNormalM m=new LSNormalM();
	
	RedSocial(){
		nombre_ingreso="";
	}

	public String getNombre_ingreso() {
		return nombre_ingreso;
	}

	public void setNombre_ingreso(String nombre_ingreso) {
		this.nombre_ingreso = nombre_ingreso;
	}

	public LSNormalU getU() {
		return u;
	}

	public void setU(LSNormalU u) {
		this.u = u;
	}

	public LSNormalG getG() {
		return g;
	}

	public void setG(LSNormalG g) {
		this.g = g;
	}

	public LSNormalM getM() {
		return m;
	}

	public void setM(LSNormalM m) {
		this.m = m;
	}
	
	public void addUsuario(Usuario x){
		u.adiprimero(x);
	}
	public void addGrupo(Grupo x){
		g.adiprimero(x);
	}
	public void addMensaje(Mensaje x){
		m.adiprimero(x);
	}
	
	
}
