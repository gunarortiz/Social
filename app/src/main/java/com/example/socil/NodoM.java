package com.example.socil;

import java.io.Serializable;

public class NodoM implements Serializable {
	private Mensaje M;
	private NodoM sig;
	
	public Mensaje getM() {
		return M;
	}
	public void setM(Mensaje m) {
		M = m;
	}
	public NodoM getSig() {
		return sig;
	}
	public void setSig(NodoM sig) {
		this.sig = sig;
	}
}
