package juego;
import java.awt.Color;
import java.util.Random;

import entorno.Entorno;
public class Vegetal {
	private double x;
	private double y;
	private int ancho;
	private int alto;
	
	Vegetal (double x, double y)
	{
		this.alto = 10;
		this.ancho = 10;
		this.x = x;
		this.y = y;
	
	}
	
    void dibujarVegetal(Entorno entorno) {
		
		entorno.dibujarRectangulo(this.x, this.y, this.ancho, this.alto, 0, Color.YELLOW);
	}
    void moverVegetal ()
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
