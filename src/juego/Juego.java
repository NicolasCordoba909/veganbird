package juego;

import entorno.Entorno;
import entorno.InterfaceJuego;

public class Juego extends InterfaceJuego {
	// El objeto Entorno que controla el tiempo y otros
	private Entorno entorno;
	private Personaje Personaje;
	private Obstaculos[] obstaculo;
	private Hamburguesas [] hamburguesas;
	private Vegetal[] vegetal;

	// Variables y métodos propios de cada grupo
	// ...

	Juego() {
		// Inicializa el objeto entorno
		this.entorno = new Entorno(this, "Vegan Bird - Grupo Grauberger - Cordoba - Deirmendjian - V0.01", 800, 600);

		// Inicializar lo que haga falta para el juego
		// ...
		this.Personaje = new Personaje();
		int x = 700;
		int y = 600;
		this.obstaculo= new Obstaculos[5];
		this.obstaculo[0] = new Obstaculos(700, 0, 70, 400);
		this.obstaculo[1] = new Obstaculos(630, 599, 70, 400);
		this.obstaculo[2] = new Obstaculos(560, 0, 70, 400);
		this.obstaculo[3] = new Obstaculos(430, 599, 70, 400);
		this.obstaculo[4] = new Obstaculos(360, 0, 70, 400);
		
		this.hamburguesas = new Hamburguesas [2];
		this.hamburguesas[0] = new Hamburguesas(200, 400);
		this.hamburguesas[1] = new Hamburguesas(100, 400);
		
		this.vegetal = new Vegetal [2];
		this.vegetal[0] = new Vegetal(240, 400);
		this.vegetal[1] = new Vegetal(140, 400);
		
		
		
		// Inicia el juego!
		this.entorno.iniciar();
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
		
		this.Personaje.dibujarFlappy(entorno);
		this.Personaje.caer();

		if (entorno.estaPresionada(entorno.TECLA_ARRIBA)) {
			this.Personaje.moverFlappy();
		}
		for (int i = 0; i< this.obstaculo.length; i++) {
			this.obstaculo[i].dibujarObstaculo(entorno);
			this.obstaculo[i].moverObstaculo();
			if (this.Personaje.chocaConObstaculosArriba(obstaculo[i]) || this.Personaje.getY() <0 || this.Personaje.getY()>600) {
				this.Personaje.pierdeJuego();
			}
		}
		for (int i = 0; i< this.hamburguesas.length; i++) {
			this.hamburguesas[i].dibujarHamburguesas(entorno);
			this.hamburguesas[i].moverHamburguesas();
			if (this.Personaje.comeHamburguesas(hamburguesas[i])) {
				this.Personaje.restaPuntos();
			}
		}
		
		for (int i = 0; i< this.vegetal.length; i++) {
			this.vegetal[i].dibujarVegetal(entorno);
			this.vegetal[i].moverVegetal();
			if (this.Personaje.comeVegetal(vegetal[i])) {
				this.Personaje.sumaPuntos();
			}
		}
		
	}

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		Juego juego = new Juego();
	}
}
