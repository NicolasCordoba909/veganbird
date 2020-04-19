package com.nico.game ;

import java.awt.Color;
import java.awt.Image;
import java.util.ArrayList;
import java.util.Random;
import entorno.Entorno;
import entorno.Herramientas;
import entorno.InterfaceJuego;

public class Juego extends InterfaceJuego {
	// El objeto Entorno que controla el tiempo y otros
	private Entorno entorno;
	private Personaje Personaje;
	private Obstaculos[] obstaculos;
	private ArrayList<Bala> rayos;
	private boolean termino;
	private Comida[] comida;
	private Random random;
	private int puntos;
	Image fondo;
	private int tiempo;
	private int nivel;

	// Variables y métodos propios de cada grupo
	// ...

	Juego() {
		// Inicializa el objeto entorno//
		this.entorno = new Entorno(this, "Vegan Bird - Grupo Grauberger - Cordoba - Deirmendjian - V0.01", 800, 600);

		// Inicializar lo que haga falta para el juego//
		// ...
		inicializador();

		// Inicia el juego!
		//

		this.entorno.iniciar();
	}

	private void inicializador() {
		this.random = new Random();
		this.termino = false;
		this.Personaje = new Personaje();
		this.puntos = 0;
		this.comida = new Comida[6];
		this.rayos = new ArrayList<Bala>();
		fondo = Herramientas.cargarImagen("fondo.jpg");
		this.tiempo = 0;
		this.nivel = 1;
		//
		// SE CREAN LOS OBSTACULOS Y SE LOS AGREGA A LA LISTA//
		//
		inicializadorObstaculos();
		//
		// SE CREAN LAS HAMBURGUESAS Y SE AGREGAN A UNA LISTA//
		//
		generadorComida();
	}

	private void inicializadorObstaculos() {
		this.obstaculos = new Obstaculos[8];
		this.obstaculos[0] = new Obstaculos(1150, 0, 90, 500);
		this.obstaculos[1] = new Obstaculos(1150, 700, 90, 500);
		this.obstaculos[2] = new Obstaculos(900, 600, 90, 500);
		this.obstaculos[3] = new Obstaculos(900, -100, 90, 500);
		this.obstaculos[4] = new Obstaculos(650, 0, 90, 500);
		this.obstaculos[5] = new Obstaculos(650, 700, 90, 500);
		this.obstaculos[6] = new Obstaculos(400, -100, 90, 500);
		this.obstaculos[7] = new Obstaculos(400, 600, 90, 500);
	}

	private void generadorComida() {
		for (int i = 0; i < this.comida.length; i++) {
			this.comida[i] = new Comida(random);
		}
	}

	/**
	 * Durante el juego, el método tick() será ejecutado en cada instante y por lo
	 * tanto es el método más importante de esta clase. Aquí se debe actualizar el
	 * estado interno del juego para simular el paso del tiempo (ver el enunciado
	 * del TP para mayor detalle).
	 */
	public void tick() {
		// Procesamiento de un instante de tiempo
		// ...

		if (this.termino == false) {
			entorno.dibujarImagen(fondo, 403, 330, 0.0, 1);
			this.Personaje.dibujarFlappy(entorno);
			this.Personaje.caer();
			dibujaBala();
			dibujarComida();
			dibujaObstaculo();
			entorno.cambiarFont("Franklin Gothic Medium", 20, Color.WHITE);
			entorno.escribirTexto("Puntos: " + this.puntos, 680, 50);
			muevePersonaje();
			disparar();
			colisionComidaPersonaje();
			colisionPersonajeObstaculos();
			colisionBalaObstaculo();
			colisionBalaComida();
			this.tiempo++;
			entorno.cambiarFont("Franklin Gothic Medium", 20, Color.WHITE);
			entorno.escribirTexto("Tiempo: " + this.tiempo, 680, 100);
			niveles();
		} else {
			mensajeTermino();

			this.termino = true;
			if (this.termino == true) { // iniciar la partida de nuevo
				if (this.entorno.sePresiono(this.entorno.TECLA_CTRL)) {
					inicializador();
					this.termino = false;
				}
			}
		}
		if (this.termino == false) {
			if (this.entorno.sePresiono(this.entorno.TECLA_SHIFT)) { // Reiniciar durante la partida
				inicializador();
			}
		}
	}

	private void niveles() {
		entorno.cambiarFont("Franklin Gothic Medium", 20, Color.WHITE);
		entorno.escribirTexto("Nivel: " + this.nivel, 680, 150);
		if (this.tiempo >= 1000 && this.tiempo < 1001) {
			for (int i = 0; i < this.comida.length; i++) {
				this.comida[i].setVelocidad(3);
			}
			for (int i = 0; i < this.obstaculos.length; i++) {
				this.obstaculos[i].setVelocidad(3);
			}
			this.nivel++;
		}
		if (this.tiempo >= 1500 && this.tiempo < 1501) {
			for (int i = 0; i < this.comida.length; i++) {
				this.comida[i].setVelocidad(4);
			}
			for (int i = 0; i < this.obstaculos.length; i++) {
				this.obstaculos[i].setVelocidad(4);
			}
			this.nivel++;
		}
		if (this.tiempo >= 2000 && this.tiempo < 2001) {
			for (int i = 0; i < this.comida.length; i++) {
				this.comida[i].setVelocidad(5);
			}
			for (int i = 0; i < this.obstaculos.length; i++) {
				this.obstaculos[i].setVelocidad(5);
			}
			this.nivel++;
		}
		if (this.tiempo >= 2500 && this.tiempo < 2501) {
			for (int i = 0; i < this.comida.length; i++) {
				this.comida[i].setVelocidad(5);
			}
			for (int i = 0; i < this.obstaculos.length; i++) {
				this.obstaculos[i].setVelocidad(5);
			}
			this.nivel++;
		}
	}

	private void mensajeTermino() {
		entorno.cambiarFont("Copperplate Gothic Bold", 45, Color.RED);
		entorno.escribirTexto("GAME OVER", 240, 250);
		entorno.cambiarFont("Copperplate Gothic Bold", 40, Color.RED);
		entorno.escribirTexto("YOU DIE!", 295, 300);
		entorno.cambiarFont("Copperplate Gothic Bold", 20, Color.WHITE);
		entorno.escribirTexto("Puntos Totales: " + this.puntos, 290, 350);
		entorno.cambiarFont("Copperplate Gothic Bold", 18, Color.WHITE);
		entorno.escribirTexto("Presione letra Ctrl para reiniciar", 240, 400);
	}

	private void colisionBalaComida() {
		for (int i = 0; i < this.comida.length; i++) {
			for (int j = 0; j < this.rayos.size(); j++) {
				if (colision(this.rayos.get(j).parametro(), this.comida[i].parametro())) {
					this.rayos.remove(j);
					if (!this.comida[i].esVegetal()) {
						puntos += 3;

						this.comida[i].cambia_A_Vegetal();
					}
				}
			}
		}
	}

	private void colisionBalaObstaculo() {
		for (int i = 0; i < this.obstaculos.length; i++) {
			for (int j = 0; j < this.rayos.size(); j++) {
				if (colision(this.rayos.get(j).parametro(), this.obstaculos[i].parametro())) {
					this.rayos.remove(j);

				}
			}
		}
	}

	private void colisionPersonajeObstaculos() {
		for (int i = 0; i < this.obstaculos.length; i++) {
			if (colision(this.Personaje.parametro(), this.obstaculos[i].parametro()) || this.Personaje.getY() <= 0
					|| this.Personaje.getY() >= 600) {
				this.termino = true;
			}
		}
	}

	private void colisionComidaPersonaje() {
		for (int i = 0; i < this.comida.length; i++) {
			if (colision(this.Personaje.parametro(), this.comida[i].parametro())) {
				if (this.comida[i].esVegetal() == false) {
					this.puntos -= 5;
				} else {
					this.puntos += 5;
				}
				this.comida[i].volverAlPrincipio(this.random);
				this.comida[i].randomY(this.random);
			}
		}
	}

	public boolean colision(Parametros a, Parametros b) {
		if ((a.getX() - a.getAncho() / 2 <= b.getX() + b.getAncho() / 2
				&& a.getX() - a.getAncho() / 2 >= b.getX() - b.getAncho() / 2
				&& a.getY() - a.getAlto() / 2 <= b.getY() + b.getAlto() / 2
				&& a.getY() - a.getAlto() / 2 >= b.getY() - b.getAlto() / 2)
				|| (a.getX() + a.getAncho() / 2 <= b.getX() + b.getAncho() / 2
						&& a.getX() + a.getAncho() / 2 >= b.getX() - b.getAncho() / 2
						&& a.getY() - a.getAlto() / 2 <= b.getY() + b.getAlto() / 2
						&& a.getY() - a.getAlto() / 2 >= b.getY() - b.getAlto() / 2)
				|| (a.getX() - a.getAncho() / 2 <= b.getX() + b.getAncho() / 2
						&& a.getX() - a.getAncho() / 2 >= b.getX() - b.getAncho() / 2
						&& a.getY() + a.getAlto() / 2 <= b.getY() + b.getAlto() / 2
						&& a.getY() + a.getAlto() / 2 >= b.getY() - b.getAlto() / 2)
				|| (a.getX() + a.getAncho() / 2 <= b.getX() + b.getAncho() / 2
						&& a.getX() + a.getAncho() / 2 >= b.getX() - b.getAncho() / 2
						&& a.getY() + a.getAlto() / 2 <= b.getY() + b.getAlto() / 2
						&& a.getY() + a.getAlto() / 2 >= b.getY() - b.getAlto() / 2))

		{
			return true;
		}
		return false;
	}

	private void dibujaObstaculo() {
		for (int i = 0; i < this.obstaculos.length; i++) {
			this.obstaculos[i].dibujarObstaculo(entorno);
			this.obstaculos[i].moverObstaculo();
			if (this.obstaculos[i].getX() + this.obstaculos[i].getAncho()/ 2 <= 0) {
				this.obstaculos[i].setX(1030);
			}
		}
	}

	private void disparar() {
		if (this.entorno.sePresiono(this.entorno.TECLA_ESPACIO)) {
			this.rayos.add(this.Personaje.disparar());

		}
	}

	private void dibujarComida() {
		for (int i = 1; i <= this.comida.length; i++) {
			this.comida[i - 1].moverX();
			for (int j = 0; j < this.obstaculos.length; j++) {
				if (colision(this.comida[i - 1].parametro(), this.obstaculos[j].parametro())) {
					this.comida[i - 1].moverA900();
				}
				if (this.comida[i - 1].getX() <= 0) {
					this.comida[i - 1].volverAlPrincipio(this.random);
					this.comida[i - 1].randomY(this.random);
				}
				this.comida[i - 1].dibujarComida(entorno);
			}
			for (int j = i; j < this.comida.length; j++) {
				if (colision(this.comida[i - 1].parametro(), this.comida[j].parametro())) {
					this.comida[i - 1].moverA900();
				}
				if (this.comida[i - 1].getX() <= 0) {
					this.comida[i - 1].volverAlPrincipio(this.random);
					this.comida[i - 1].randomY(this.random);
				}
				this.comida[i - 1].dibujarComida(entorno);
			}
		}
	}

	private void muevePersonaje() {
		if (entorno.estaPresionada(entorno.TECLA_ARRIBA)) {
			this.Personaje.moverFlappy();
		}
	}

	private void dibujaBala() {
		if (this.rayos.size() != 0) {
			for (int i = 0; i < this.rayos.size(); i++) {
				this.rayos.get(i).avanzar();
				this.rayos.get(i).dibujarBala(entorno);
			}
		}
	}

}
