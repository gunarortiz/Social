package com.example.socil;

import java.io.Serializable;

public class NodoU implements Serializable{
	private Usuario U;
	private NodoU sig;
	
	public Usuario getU() {
		return U;
	}
	public void setU(Usuario u) {
		U = u;
	}
	public NodoU getSig() {
		return sig;
	}
	public void setSig(NodoU sig) {
		this.sig = sig;
	}
}
