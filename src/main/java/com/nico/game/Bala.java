package com.nico.game;

import java.awt.Image;

import entorno.Entorno;

public class Bala {
	private double x;
	private double y;
	private int ancho;
	private int alto;
	private Double velocidad;
	Image BolaFuego;
	
	Bala (double x, double y)
	{
		this.x = x;
		this.y = y;
		this.ancho = 10;
		this.alto = 10;
		this.velocidad = 2.3;
		this.BolaFuego = entorno.Herramientas.cargarImagen("BolaFuego.gif");
	}
	
	public void avanzar()
	{
		this.x = this.x + this.velocidad;
	
	}
	
	public void dibujarBala(Entorno entorno)
	{
		entorno.dibujarImagen(BolaFuego,this.x, this.y, 0, 0.10);
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
	
	public Parametros parametro()
	{
		return new Parametros(this.x,this.y, this.ancho,this.alto);
	}
}
