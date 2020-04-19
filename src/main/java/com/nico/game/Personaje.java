package com.nico.game;

import java.awt.Color;
import java.awt.Image;

import entorno.Entorno;

import java.awt.image.*;
import entorno.Herramientas;
import java.awt.image.*;
import entorno.Herramientas;

public class Personaje {
	private double x;
	private double y;
	private double ancho;
	private double alto;
	private int velocidad;
	Image Dragon2;
	
	Personaje() {
		this.x = 100;
		this.y = 300;
		this.alto = 50;
		this.ancho = 55;
		this.velocidad =10;
		this.Dragon2 = entorno.Herramientas.cargarImagen("Dragon2.gif");
		
		
	}
	//METODO PARA DIBUJAR AL PERSONAJE
	void dibujarFlappy(Entorno entorno) {
		entorno.dibujarImagen(Dragon2,this.x, this.y, 0, 0.30);
	}
	// METODO QUE SIRVE PARA QUE EL PERSONAJE SUBA
	void moverFlappy() {
		this.y -= this.velocidad;
	}
	// METODO PARA QUE EL PERSONAJE SIEMPRE ESTE CAYENDO
	void caer() {
		this.y += 2;
	}
	// METODO QUE DEVUELVE UNA BALA
	public Bala disparar()
	{	
		return new Bala(this.x, this.y);
	
	}
	// METODO QUE DEVUELVE LOS PARAMETROS DEL PERSONAJE (X, Y , ALTO Y ANCHO) SE UTILIZA EN UN METODO PARA LAS COLISIONES
	public Parametros parametro()
	{
		return new Parametros (this.x,this.y, this.ancho,this.alto);
	}
	// 
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
