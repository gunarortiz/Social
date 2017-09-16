package com.example.socil;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;


public class MensajeDia implements Serializable{
	private String fecha_dia;
	private CSimpleMEN MEN;
	
	MensajeDia()
	{
		fecha_dia=fechaActual();
		MEN=new CSimpleMEN();
	}
	MensajeDia(CSimpleMEN m)
	{
		fecha_dia=fechaActual();
		MEN=m;
	}
	public void mostrar()
	{
		System.out.println("Fecha_dia: "+fecha_dia);
		MEN.mostrar();
		System.out.println("\t --------------");
	}
	public void leer()
	{
		System.out.println("intro Fecha_Dia");
		fecha_dia=Leer.dato();
		System.out.println("intro N° de CSimpleMEN");
		MEN.llenar(Leer.datoInt());
	}
	public String getFecha_dia() {
		return fecha_dia;
	}
	public void setFecha_dia(String fecha_dia) {
		this.fecha_dia = fecha_dia;
	}
	public CSimpleMEN getMEN() {
		return MEN;
	}
	public void setMEN(CSimpleMEN mEN) {
		MEN = mEN;
	}
	public String fechaActual(){
		Date ahora=new Date();
		SimpleDateFormat formato=new SimpleDateFormat("dd-MM-yyyy");
		return formato.format(ahora);
	}
}
