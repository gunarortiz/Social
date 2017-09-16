package com.example.socil;

import java.io.Serializable;

public class CSimpleMEN implements Serializable {
	int max=1000;
	Unmensaje v[]=new Unmensaje [max];
	int ini, fin;

	CSimpleMEN ()
	{
		ini = fin = 0;
	}


	int nroelem ()
	{
		return ((max + fin - ini) % max);
	}


	boolean esvacia ()
	{
		if (nroelem () == 0)
			return (true);
		return (false);
	}


	boolean esllena ()
	{
		if (nroelem () == max - 1)
			return (true);
		return (false);
	}


	void adicionar (Unmensaje elem)
	{
		if (!esllena ())
		{

			fin = (fin + 1) % max;
			v [fin] = elem;
		}
		else
			System.out.println ("Cola circular llena");
	}


	Unmensaje eliminar ()
	{
		Unmensaje elem = new Unmensaje ();
		if (!esvacia ())
		{
			ini = (ini + 1) % max;
			elem = v [ini];
			if (nroelem () == 0)
				ini = fin = 0;
		}
		else
			System.out.println ("Cola circular vacia");
		return (elem);
	}


	void mostrar ()
	{
		Unmensaje elem;
		if (esvacia ())
			System.out.println ("Cola vacia xxx");
		else
		{
			System.out.println ("\n Datos de la Cola ");
			CSimpleMEN aux = new CSimpleMEN ();
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


	void llenar (int n)
	{
		int i;
		for (i = 1 ; i <= n ; i++)
		{
			Unmensaje elem = new Unmensaje ();
			elem.leer ();
			adicionar (elem);
		}
	}

	

	void invertir ()
	{
		CSimpleMEN a = new CSimpleMEN ();
		CSimpleMEN b = new CSimpleMEN ();
		while (!esvacia ())
		{
			while (nroelem () != 1)
				a.adicionar (eliminar ());
			b.adicionar (eliminar ());
			while (!a.esvacia ())
				adicionar (a.eliminar ());
		}
		while (!b.esvacia ())
			adicionar (b.eliminar ());

	}


	void vaciar (CSimpleMEN a)
	{
		while (!a.esvacia ())
			adicionar (a.eliminar ());

	}
    
    
    public Unmensaje primerMensaje(){
    	Unmensaje x=eliminar();
    	CSimpleMEN x2=new CSimpleMEN();
    	x2.adicionar(x);
    	x2.vaciar(this);
    	vaciar(x2);
    	
    	
    	return x;
    }
    
public Unmensaje getME(){
		
		int e=ini+1;
	    Unmensaje elem = v[e];
		return elem;
	}
}
