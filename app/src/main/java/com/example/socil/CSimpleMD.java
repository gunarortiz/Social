package com.example.socil;

import java.io.Serializable;

public class CSimpleMD implements Serializable {
	int max=1000;
	MensajeDia v[]=new MensajeDia [max];
	int ini, fin;

	CSimpleMD ()
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


	void adicionar (MensajeDia elem)
	{
		if (!esllena ())
		{

			fin = (fin + 1) % max;
			v [fin] = elem;
		}
		else
			System.out.println ("Cola circular llena");
	}


	MensajeDia eliminar ()
	{
		MensajeDia elem = new MensajeDia ();
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
		MensajeDia elem;
		if (esvacia ())
			System.out.println ("Cola vacia xxx");
		else
		{
			System.out.println ("\n Datos de la Cola ");
			CSimpleMD aux = new CSimpleMD ();
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
			MensajeDia elem = new MensajeDia ();
			elem.leer ();
			adicionar (elem);
		}
	}

	

	void invertir ()
	{
		CSimpleMD a = new CSimpleMD ();
		CSimpleMD b = new CSimpleMD ();
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


	void vaciar (CSimpleMD a)
	{
		while (!a.esvacia ())
			adicionar (a.eliminar ());

	}
    
    public void addMensaje(String fecha,String emisor, String texto){
    	CSimpleMD aux=new CSimpleMD();
    	int sw=0;
    	while(!esvacia()){
    		MensajeDia x=eliminar();
    		if(x.getFecha_dia().equals(fecha)){
    			Unmensaje y=new Unmensaje();
    			y.setDe(emisor);
    			y.setTexto(texto);
    			y.setHora();
    			x.getMEN().adicionar(y);
    			sw=1;
    		}
    		aux.adicionar(x);
    	}
    	vaciar(aux);
    	if(sw==0)
    	{
    		MensajeDia x1=new MensajeDia();
    		x1.setFecha_dia(fecha);
    		Unmensaje y=new Unmensaje();
			y.setDe(emisor);
			y.setTexto(texto);
			y.setHora();
			x1.getMEN().adicionar(y);
    		adicionar(x1);
    	}
    }
}
