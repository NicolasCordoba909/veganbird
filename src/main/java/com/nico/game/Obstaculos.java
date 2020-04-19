package com.nico.game;

import entorno.Entorno;

import java.awt.Image;

public class Obstaculos {
	private double x;
	private double y;
	private double ancho;
	private double alto;
	private double velocidad;
	Image imagen;

	Obstaculos(double x, double y, double ancho, double alto) {
		this.x = x;
		this.y = y;
		this.ancho = ancho;
		this.alto = alto;
		this.velocidad = 2;
		this.imagen = entorno.Herramientas.cargarImagen("imagen.png");
	}

	public Parametros parametro() {
		return new Parametros(this.x, this.y, this.ancho, this.alto);
	}

	void dibujarObstaculo(Entorno entorno) {

		entorno.dibujarImagen(imagen, this.x, this.y, 0, 1.02);

	}

	void moverObstaculo() {
		this.x -= this.velocidad;
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

	public double getVelocidad() {
		return velocidad;
	}

	public void setVelocidad(double velocidad) {
		this.velocidad = velocidad;
	}

}