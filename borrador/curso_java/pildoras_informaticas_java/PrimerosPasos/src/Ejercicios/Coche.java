package Ejercicios;

public class Coche {
	private String marca;
	private String modelo;
	private int motor;

	/**
	 * @param motor
	 */
	public Coche() {

	}

	public Coche(String marca, String modelo, int motor) {
		this.marca = marca;
		this.modelo = modelo;
		this.motor = motor;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public int getMotor() {
		return motor;
	}

	public void setMotor(int motor) {
		this.motor = motor;
	}

	public String toString() {
		return "Marca: " + getMarca() + "\n" + "Modelo: " + getModelo() + "\n" + "Motor: " + getMotor() + "cv";
	}
}
