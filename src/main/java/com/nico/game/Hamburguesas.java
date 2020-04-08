package com.nico.game;
import entorno.Entorno;

import java.awt.Color;

public class Hamburguesas {
	private double x;
	private double y;
	private int ancho;
	private int alto;

	Hamburguesas (double x, double y)
	{
		this.alto = 10;
		this.ancho = 10;
		this.x = x;
		this.y = y;

	}

    void dibujarHamburguesas(Entorno entorno) {

		entorno.dibujarRectangulo(this.x, this.y, this.ancho, this.alto, 0, Color.RED);
	}
    void moverHamburguesas ()
	{
		this.x--;
	}



	public double getX() {
		return x;
	}

	public int getAncho() {
		return ancho;
	}

	public void setAncho(int ancho) {
		this.ancho = ancho;
	}

	public int getAlto() {
		return alto;
	}

	public void setAlto(int alto) {
		this.alto = alto;
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

}
