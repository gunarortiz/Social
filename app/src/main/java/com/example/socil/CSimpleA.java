package com.example.socil;

import java.io.Serializable;

public class CSimpleA implements Serializable {
	int max=1000;
	Amigo v[]=new Amigo [max];
	int ini, fin;

	CSimpleA ()
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


	void adicionar (Amigo elem)
	{
		if (!esllena ())
		{

			fin = (fin + 1) % max;
			v [fin] = elem;
		}
		else
			System.out.println ("Cola circular llena");
	}


	Amigo eliminar ()
	{
		Amigo elem = new Amigo ();
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
		Amigo elem;
		if (esvacia ())
			System.out.println ("Cola vacia xxx");
		else
		{
			System.out.println ("\n Datos de la Cola ");
			CSimpleA aux = new CSimpleA ();
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
			Amigo elem = new Amigo ();
			elem.leer ();
			adicionar (elem);
		}
	}

	

	void invertir ()
	{
		CSimpleA a = new CSimpleA ();
		CSimpleA b = new CSimpleA ();
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


	void vaciar (CSimpleA a)
	{
		while (!a.esvacia ())
			adicionar (a.eliminar ());

	}
    
    public void verificar(Amigo nue){
    	CSimpleA aux =new CSimpleA();
    	int sw=0;
    	while(!esvacia()){
    		Amigo x=eliminar();
    		if(nue.getNombre_amigo().equals(x.getNombre_amigo()) && nue.getRelacion().equals(x.getRelacion())){
    			System.out.println("\t ### Ya eras su amigo ###");
    			sw=1;
    		}
    		aux.adicionar(x);
    	}
    	vaciar(aux);
    	if(sw==0){
    		adicionar(nue);
    		System.out.println("\t ### Ya eres su amigo ###");
    	}
    	
    }
}
