package com.nico.game;

import entorno.Entorno;

import java.awt.Color;

public class Personaje {
	private double x;
	private double y;
	private double ancho;
	private double alto;

	Personaje() {
		this.x = 100;
		this.y = 300;
		this.alto = 15;
		this.ancho = 15;
	}

	void dibujarFlappy(Entorno entorno) {
		entorno.dibujarRectangulo(x, y, ancho, alto, 0, Color.cyan);
	}

	void moverFlappy() {
		this.y -= 10;
	}

	void caer() {
		this.y += 2;
	}

	public boolean chocaConObstaculosArriba(Obstaculos obstaculo)
	{
		if ( this.y <= obstaculo.getY() + obstaculo.getAlto()/2 &&
				this.y >= obstaculo.getY() - obstaculo.getAlto() /2
				&& this.x <= obstaculo.getX() + obstaculo.getAncho()/2 && this.x >= obstaculo.getX() - obstaculo.getAncho()/2)
		{
			return true;
		}
		return false;
	}

	public boolean comeHamburguesas(Hamburguesas hamburguesas)
	{
		if ( this.y <= hamburguesas.getY() + hamburguesas.getAlto()/2 &&
				this.y >= hamburguesas.getY() - hamburguesas.getAlto() /2
				&& this.x <= hamburguesas.getX() + hamburguesas.getAncho()/2 && this.x >= hamburguesas.getX() - hamburguesas.getAncho()/2)
		{
			return true;
		}
		return false;
	}

	public boolean comeVegetal(Vegetal vegetal)
	{
		if ( this.y <= vegetal.getY() + vegetal.getAlto()/2 &&
				this.y >= vegetal.getY() - vegetal.getAlto() /2
				&& this.x <= vegetal.getX() + vegetal.getAncho()/2 && this.x >= vegetal.getX() - vegetal.getAncho()/2)
		{
			return true;
		}
		return false;
	}

	void pierdeJuego (){
		this.alto = 0;
		this.ancho = 0;
	}

	void restaPuntos (){
	}

	void sumaPuntos () {

	}

	public double getX() {
		return x;
	}

	public double getAncho() {
		return ancho;
	}

	public double getAlto() {
		return alto;
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
