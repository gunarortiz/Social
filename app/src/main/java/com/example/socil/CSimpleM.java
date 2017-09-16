package com.example.socil;

import java.io.Serializable;

public class CSimpleM implements Serializable {
	int max=1000;
	String v[]=new String [max];
	int ini, fin;

	CSimpleM ()
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


	void adicionar (String elem)
	{
		if (!esllena ())
		{

			fin = (fin + 1) % max;
			v [fin] = elem;
		}
		else
			System.out.println ("Cola circular llena");
	}


	String eliminar ()
	{
		String elem ="";
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
		String elem;
		if (esvacia ())
			System.out.println ("Cola vacia xxx");
		else
		{
			System.out.println ("\n Datos de la Cola ");
			CSimpleM aux = new CSimpleM ();
			while (!esvacia ())
			{
				elem = eliminar ();
				aux.adicionar (elem);
				System.out.println(elem);
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
			
			adicionar (Leer.dato());
		}
	}

	

	void invertir ()
	{
		CSimpleM a = new CSimpleM ();
		CSimpleM b = new CSimpleM ();
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


	void vaciar (CSimpleM a)
	{
		while (!a.esvacia ())
			adicionar (a.eliminar ());

	}

	public boolean existe(String nom) {
		String elem="";
		int sw=0;
		if (esvacia ())
		{
			
		}
		else
		{
		    CSimpleM aux = new CSimpleM ();
		    while (!esvacia ())
		    {
			elem = eliminar ();
			aux.adicionar (elem);
			if(elem.equals(nom))
				sw=1;
		    }
		    vaciar(aux);
		}
		if(sw==1)
			return true;
		return false;
	}
	
	public void verificar(String nombre_ingreso){
    	CSimpleM aux =new CSimpleM();
    	int sw=0;
    	while(!esvacia()){
    		String x=eliminar();
    		if(nombre_ingreso.equals(x)){
    			System.out.println("\t ### Ya eras miembro de ese grupo ###");
    			sw=1;
    		}
    		aux.adicionar(x);
    	}
    	vaciar(aux);
    	if(sw==0){
    		adicionar(nombre_ingreso);
    		System.out.println("\t ### Ya eres miembro de ese grupo ###");
    	}
    	
    }
}
