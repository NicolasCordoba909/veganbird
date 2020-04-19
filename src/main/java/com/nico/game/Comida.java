package com.nico.game;

import java.awt.Image;
import java.util.Random;
import entorno.Entorno;


public class Comida {
	private double x;
	private double y;
	private int ancho;
	private int alto;
	private boolean esVegetal;
	private double velocidad;

	Image lechuga;
	Image hamburguesa;

	Comida(Random random) {
		this.hamburguesa = entorno.Herramientas.cargarImagen("hamburguesa.gif");
		this.lechuga = entorno.Herramientas.cargarImagen("lechuga.gif");
		generarPosicion(random);
		this.alto = 25;
		this.ancho = 25;
		this.velocidad = 2;
		generarTipo(random);

	}

	public double getVelocidad() {
		return velocidad;
	}

	public void setVelocidad(double velocidad) {
		this.velocidad = velocidad;
	}

	void moverA900() {
		this.x = 900;
	}

	private void generarPosicion(Random random) {
		Personaje personaje = new Personaje();
		this.x = random.nextInt(500) + personaje.getX() + personaje.getAncho() + 200;
		this.y = random.nextInt(400) + 100;
	}

	private void generarTipo(Random random) {
		if (random.nextInt(2) == 1) {
			this.esVegetal = true;
		} else
			this.esVegetal = false;
	}

	public Parametros parametro() {
		return new Parametros(this.x, this.y, this.ancho, this.alto);
	}

	public void moverX() {
		this.x -= this.velocidad;

	}

	public void dibujarComida(Entorno entorno) {
		if (this.esVegetal) {
			entorno.dibujarImagen(lechuga, x, y, 0, 0.10);
		} else
			entorno.dibujarImagen(hamburguesa, x, y, 0, 0.07);
	}

	public void cambia_A_Vegetal() {
		if (this.esVegetal == false) {
			this.esVegetal = true;
		}
	}

	public void volverAlPrincipio(Random random) {
		this.x = 800;
		generarTipo(random);
	}

	public void randomY(Random random) {

		int altura = random.nextInt(400) + 100;
		this.y = altura;

	}

	public void randomX(Random random) {
		double posicion = random.nextInt(600) + (this.x + this.ancho + 150);
		this.x = posicion;
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

	public boolean esVegetal() {
		return this.esVegetal;
	}

	public void setTipo(boolean tipo) {
		this.esVegetal = tipo;
	}

}
