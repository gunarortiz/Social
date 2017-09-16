package com.example.socil;

import java.io.Serializable;

public class Mensaje implements Serializable {
	private String id_1;
	private String id_2;
	private CSimpleMD MD;
	
	Mensaje()
	{
		id_1="";
		id_2="";
		MD=new CSimpleMD();
	}
	
	Mensaje(String a, String b, CSimpleMD m)
	{
		id_1=a;
		id_2=b;
		MD=m;
	}
	public void mostrar()
	{
		MD.mostrar();
	}
	public void leer()
	{
		System.out.println("intro id_1");
		id_1=Leer.dato();
		System.out.println("intro id_2");
		id_2=Leer.dato();
		System.out.println("intro N° de CSimpleMD");
		MD.llenar(Leer.datoInt());
	}
	public String getId_1() {
		return id_1;
	}
	public void setId_1(String id_1) {
		this.id_1 = id_1;
	}
	public String getId_2() {
		return id_2;
	}
	public void setId_2(String id_2) {
		this.id_2 = id_2;
	}
	public CSimpleMD getMD() {
		return MD;
	}
	public void setMD(CSimpleMD mD) {
		MD = mD;
	}
	
}

