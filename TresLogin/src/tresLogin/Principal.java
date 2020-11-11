package tresLogin;

import javax.swing.*;


public class Principal {

	public static void main(String[] args) {
		
		Lista Lista = new Lista();
		
		int op = 0;
		String menu = "";
		
		String usuario = "";
		String contra = "";
		int dialogButton = JOptionPane.YES_NO_OPTION;
		int registroFallido = JOptionPane.NO_OPTION;
		int loginFallido = JOptionPane.NO_OPTION;
		
		
		do{
			
			if(registroFallido == JOptionPane.YES_OPTION) {
				
				op = 2;
				
			}else if(loginFallido == JOptionPane.YES_OPTION){
				
				op = 1;
				
			}else {
				
				menu = JOptionPane.showInputDialog("Menu de opciones:"
						+ "\n1. Login"
						+ "\n2. Registro"
						+ "\nSeleccione su opcion deseada:");
				
			}
			
			if(!Numerico(menu)) {
				
				JOptionPane.showMessageDialog(null, "Ingrese un valor con el numero de la opcion deseada");
				
			}else {
				
				op = Integer.parseInt(menu);
				switch(op) {
					case 1:
						usuario = JOptionPane.showInputDialog("Inicio de Sesión"
								+ "\nIngrese su nombre de usuario");
						contra = JOptionPane.showInputDialog("Inicio de Sesion"
								+ "\nIngrese su contraseña");
						
						if(Lista.iniciosesion(usuario, contra)) {
							
							if(Lista.buscarNodo(usuario).uno) {
								
								if(Lista.addatos(usuario)) {
									
									JOptionPane.showMessageDialog(null, "Los datos se agregaron correctamente"
											+ "\nBienvenido " + Lista.buscarNodo(usuario).nombre);
									
								}
								
							}else {
								
								JOptionPane.showMessageDialog(null, "Bienvenido " + Lista.buscarNodo(usuario).nombre);
								
							}
							
							loginFallido = JOptionPane.NO_OPTION;
							
						}else {
							
							loginFallido = JOptionPane.showConfirmDialog (null, "Usuario o contraseña incorrectos\nIntente Nuevamente","Usuario y/o contraseña incorrectos",dialogButton);
							
						}
						
						break;
						
					case 2:
						
						usuario = JOptionPane.showInputDialog("Registro de nuevo usuario"
								+ "\nIngrese nombre de usuario");
						
						if(Lista.validarUsuario(usuario)) {
							
							registroFallido = JOptionPane.showConfirmDialog (null, "El usuario existente \nIntente nuevamente","El usuario ya existe",dialogButton);
							
						}else {
							
							contra = JOptionPane.showInputDialog("Inicio de Sesion"
									+ "\nIngrese la contraseña");
							
							if(Lista.crearUsuario(usuario, contra)) {
								
								JOptionPane.showMessageDialog(null, "Usuario nuevo creado de manera correcta");
								registroFallido = JOptionPane.NO_OPTION;
								
							}
						}
						
						break;
						
						
					case 3:
						Lista.mostrarLista();
						
						break;
						
					default:
						JOptionPane.showMessageDialog(null, "Opción incorrecta, intente nuevamente");
						break;
				}
				
			}
			
		}while(op!=2);
		
	}
	
	public static boolean Numerico(String num) {
		
		try {
			Integer.parseInt(num);
			return true;
		}catch(NumberFormatException ex) {
			return false;
		}
		
	}
	
}
