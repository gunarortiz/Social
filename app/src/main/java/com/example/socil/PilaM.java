package com.example.socil;

import java.io.Serializable;

public class PilaM implements Serializable{
	private int max=100;
	private String id_like[]=new String[max];
	private int tope;
	
	public int getMax() {
		return max;
	}
	public void setMax(int max) {
		this.max = max;
	}
	public String[] getId_like() {
		return id_like;
	}
	public void setId_like(String[] id_like) {
		this.id_like = id_like;
	}
	public int getTope() {
		return tope;
	}
	public void setTope(int tope) {
		this.tope = tope;
	}
	
	PilaM()
	{
		tope=0;
	}
	boolean esvacia ()
    {
	if (tope == 0)
	    return (true);
	return (false);
    }


    boolean esllena ()
    {
	if (tope == max)
	    return (true);
	return (false);
    }


    int nroelem ()
    {
	return (tope);
    }


    void adicionar (String elem)
    {
	if (!esllena ())
	{
	    tope++;
	    id_like [tope] = elem;
	}
	else
	    System.out.println ("Pila llena");
    }


    String eliminar ()
    {
    String elem ="";
	if (!esvacia ())
	{
	    elem = id_like [tope];
	    tope--;
	}
	else
	    System.out.println ("\t No tiene Likes");
	return (elem);
    }


    void mostrar ()
    {
    String elem="";
	if (esvacia ())
	    System.out.println ("\t No tiene Likes");
	else
	{
	    PilaM aux = new PilaM ();
	    while (!esvacia ())
	    {
		elem = eliminar ();
		aux.adicionar (elem);
		System.out.println("\t Like de "+elem);;
	    }
	    while (!aux.esvacia ())
	    {
		elem = aux.eliminar ();

		adicionar (elem);
	    }
	}
    }


    void llenar (int n)
    {
	int i;

	for (i = 1 ; i <= n ; i++)
	{
		String l ="";
		System.out.println("like de ");
	    l=Leer.dato();
	    adicionar (l);
	}
    }


    void invertir ()
    {
	PilaM a = new PilaM ();
	PilaM b = new PilaM ();
	while (!esvacia ())
	    a.adicionar (eliminar ());
	while (!a.esvacia ())
	    b.adicionar (a.eliminar ());
	while (!b.esvacia ())
	    adicionar (b.eliminar ());
    }


    void vaciar (PilaM a)
    {
	while (!a.esvacia ())
	    adicionar (a.eliminar());

    }
}
