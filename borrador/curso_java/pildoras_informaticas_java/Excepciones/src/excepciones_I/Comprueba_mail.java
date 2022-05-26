package excepciones_I;

import java.io.EOFException;
import java.util.Iterator;

import javax.swing.*;

public class Comprueba_mail {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String el_mail = JOptionPane.showInputDialog("Introduce mail");

		try {
			examina_mail(el_mail);
		} catch (Exception e) {
			System.out.println("La dirección de email no es correcta");
			e.printStackTrace();
		}

	}

	static void examina_mail(String mail) throws Longitud_mail_erronea {
		int arroba = 0;
		boolean punto = false;
		if (mail.length() <= 3) {
			// Puedes prescindir del mensaje ya que en el try catch ya imprime otro mensaje
			throw new Longitud_mail_erronea("El mail es demasiado corto");
		} else {
			for (int i = 0; i < mail.length(); i++) {
				if (mail.charAt(i) == '@') {
					arroba++;
				}
				if (mail.charAt(i) == '.') {
					punto = true;
				}
			}
			if (arroba == 1 && punto == true) {
				System.out.println("Es correcto");
			} else {
				System.out.println("No es correcto");
			}
		}
	}

}

class Longitud_mail_erronea extends Exception {
	public Longitud_mail_erronea() {
		// Este constructor es por si no quieres mostrar ningun mensaje
	}

	public Longitud_mail_erronea(String msj_error) {
		// Para mostrar un mensaje
		super(msj_error);
	}
}
