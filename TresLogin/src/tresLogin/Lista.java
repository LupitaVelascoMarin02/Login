package tresLogin;

import javax.swing.*;

public class Lista {
	
	Nodo uno;
	Nodo fin;
	
	public Lista() {
		
		uno = null;
		fin = null;
		
	}
	public boolean crearUsuario(String usuario, String contra) {
		
		Nodo nodoNuevo = new Nodo();
		
		nodoNuevo.usuario = usuario;
		
		nodoNuevo.contra = contra;
		
		nodoNuevo.edad = 0;
		
		nodoNuevo.nombre = null;
		
		nodoNuevo.uno = true;
		
		boolean reg = false;
		
		if(validarUsuario(usuario) == true) {
			
			reg = false;
			
		}else {
			
			if(uno==null) {
				
				uno = nodoNuevo;
				uno.siguiente = null;
				fin = uno;
				
			}else {
				
				fin.siguiente = nodoNuevo;
				nodoNuevo.siguiente = null;
				fin = nodoNuevo;
				
			}
			
			reg = true;
			
		}
		
		return reg;
		
	}
	
	public Nodo buscarNodo(String usuario) {
		
		Nodo ac = new Nodo();
		ac = uno;
		Nodo info = new Nodo();
		boolean busca = false;
		while(ac!=null && busca==false) {
			
			if(ac.usuario.equals(usuario)) {
				
				info = ac;
				busca = true;
				
			}else {
				
				info = null;
				busca = false;
				
			}
			
			ac = ac.siguiente;
			
		}
		
		return info;
		
	}
	
	public boolean iniciosesion(String usuario,String contra) {
		
		Nodo ac = new Nodo();
		ac = uno;
		boolean vali = false;
		while(ac!=null && vali == false) {
			
			if(ac.usuario.equals(usuario) && ac.contra.equals(contra)) {
				
				vali = true;
				
			}else {
				
				vali = false;
				
			}
			
			ac = ac.siguiente;
			
		}
		
		return vali;
		
	}
	

	
	public boolean addatos(String usuario) {
		String nombre = "";
		String edad = "";
		Nodo ac = buscarNodo(usuario);
		JOptionPane.showMessageDialog(null, "Este es su primer login, por seguridad debe ingresar la siguiente informacion personal, no debe ingresar campos vacios");
		boolean add = false;
		boolean edaD = false;
		while (add == false) {
			
			nombre = JOptionPane.showInputDialog("Ingrese el nombre del usuario");
		
			if(nombre.length() != 0) {
				
				while(!edaD) {
					
					edad = JOptionPane.showInputDialog("Ingresa la edad del usuario");
					
					if(edad.length() != 0) {
						
						if(esNumerico(edad)) {
							
							ac.nombre = nombre;
							ac.edad = Integer.parseInt(edad);
							ac.uno = false;
							add = true;
							edaD = true;
							
						}else {
							
							JOptionPane.showMessageDialog(null, "Ingrese la edad que sea valida y correcta");
							
						}
						
					}else {
						
						JOptionPane.showMessageDialog(null, "Ingrese Edad");
						
					}
				}
				
			}else{
				
				JOptionPane.showMessageDialog(null, "Ingrese Nombre");
				
			}
			
		}
		
		return add;
		
	}
	
	private boolean esNumerico(String numero) {
		
		try {
			Integer.parseInt(numero);
			return true;
		}catch(NumberFormatException ex) {
			return false;
		}
	}
	
	public void mostrarLista() {
		Nodo ac = new Nodo();
		ac = uno;
		while(ac != null) {
			
			System.out.println(ac.usuario + ", " + ac.contra + ", " + ac.uno  + ", " + ac.nombre+ ", " + ac.edad);
			ac = ac.siguiente;
			
		}
	}
	public boolean validarUsuario(String usuario) {
		Nodo ac = new Nodo();
		ac = uno;
		boolean enco = false;
		while(ac!=null && enco == false) {
			
			if(ac.usuario.equals(usuario)) {
				
				enco = true;
				
			}else {
				
				enco = false;
				
			}
			
			ac = ac.siguiente;
			
		}
		
		return enco;
		
	}
}

