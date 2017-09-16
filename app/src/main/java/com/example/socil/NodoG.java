package com.example.socil;

import java.io.Serializable;

public class NodoG implements Serializable {
	private Grupo G;
	private NodoG sig;
	
	public Grupo getG() {
		return G;
	}
	public void setG(Grupo g) {
		G = g;
	}
	public NodoG getSig() {
		return sig;
	}
	public void setSig(NodoG sig) {
		this.sig = sig;
	}
}
