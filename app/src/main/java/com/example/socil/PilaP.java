package com.example.socil;

import java.io.Serializable;

public class PilaP implements Serializable{
	private int max=100;
	private Publicacion P[]=new Publicacion[max];
	private int tope;
	
	public int getMax() {
		return max;
	}
	public void setMax(int max) {
		this.max = max;
	}
	public Publicacion[] getP() {
		return P;
	}
	public void setP(Publicacion[] p) {
		P = p;
	}
	public int getTope() {
		return tope;
	}
	public void setTope(int tope) {
		this.tope = tope;
	}
	
	PilaP()
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


    void adicionar (Publicacion elem)
    {
	if (!esllena ())
	{
	    tope++;
	    P [tope] = elem;
	}
	else
	    System.out.println ("Pila llena");
    }


    Publicacion eliminar ()
    {
    Publicacion elem = new Publicacion ();
	if (!esvacia ())
	{
	    elem = P [tope];
	    tope--;
	}
	else
	    System.out.println ("Pila vacia");
	return (elem);
    }


    void mostrarP ()
    {
    Publicacion elem;
	if (esvacia ())
	    System.out.println ("\t Aun no tiene publicaciones");
	else
	{
	    System.out.println ("\t ## Publicaciones del perfil ##");
	    PilaP aux = new PilaP ();
	    while (!esvacia ())
	    {
		elem = eliminar ();
		aux.adicionar (elem);
		
			elem.mostrar();
	    }
	    while (!aux.esvacia ())
	    {
		elem = aux.eliminar ();

		adicionar (elem);
	    }
	}
    }

    void mostrarG (String nomG)
    {
    Publicacion elem;
	if (esvacia ())
	    System.out.println ("\t Aun no tiene publicaciones");
	else
	{
	    PilaP aux = new PilaP ();
	    while (!esvacia ())
	    {
		elem = eliminar ();
		aux.adicionar (elem);
		
			elem.mostrar();
			System.out.println("-----------------------");
		
			
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
		Publicacion l = new Publicacion ();
	    l.leer ();
	    adicionar (l);
	}
    }


    void invertir ()
    {
	PilaP a = new PilaP ();
	PilaP b = new PilaP ();
	while (!esvacia ())
	    a.adicionar (eliminar ());
	while (!a.esvacia ())
	    b.adicionar (a.eliminar ());
	while (!b.esvacia ())
	    adicionar (b.eliminar ());
    }


    void vaciar (PilaP a)
    {
	while (!a.esvacia ())
	    adicionar (a.eliminar());

    }
}
