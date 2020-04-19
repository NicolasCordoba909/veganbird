package com.nico.game;

public class Parametros {

	private double x;
	private double y;
	private double ancho;
	private double alto;

	Parametros(double x, double y, double ancho, double alto) {
		this.x = x;
		this.y = y;
		this.alto = alto;
		this.ancho = ancho;
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public double getAncho() {
		return ancho;
	}

	public void setAncho(int ancho) {
		this.ancho = ancho;
	}

	public double getAlto() {
		return alto;
	}

	public void setAlto(int alto) {
		this.alto = alto;
	}
}
