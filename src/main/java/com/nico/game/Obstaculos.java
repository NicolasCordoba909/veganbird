package com.nico.game;

import entorno.Entorno;

import java.awt.Color;
import java.awt.image.*;
import java.util.Random;

public class Obstaculos {
	private double x;
	private double y;
	private double ancho;
	private double alto;

	Obstaculos(double x, double y, double ancho, double alto) {
		this.x = x;
		this.y = y;
		this.ancho = ancho;
		this.alto = alto;
	}

	void dibujarObstaculo(Entorno entorno) {

		entorno.dibujarRectangulo(this.x, this.y, this.ancho, this.alto, 0, Color.GREEN);
	}
	void moverObstaculo ()
	{
		this.x--;
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

	public void setAncho(double ancho) {
		this.ancho = ancho;
	}

	public double getAlto() {
		return alto;
	}

	public void setAlto(double alto) {
		this.alto = alto;
	}

}
