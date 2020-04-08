package com.nico.game;

public class Bala {
	private double x;
	private double y;
	private int ancho;
	private int alto;

	Bala ()
	{
		this.x = 100;
		this.y = 300;
		this.ancho = 5;
		this.alto = 5;
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

}
