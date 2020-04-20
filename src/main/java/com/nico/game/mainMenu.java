package com.nico.game;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JButton;

import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

import javax.sound.sampled.Clip;
import javax.swing.Icon;
import javax.swing.JOptionPane;
import java.awt.FlowLayout;

public class mainMenu extends JFrame implements ActionListener

// escaner de acciones del mouse

{
	JButton boton1, boton2, fondo, macri; // atributo del jframe(dentro de entorno)
	Cursor cursor;
	Clip musicaMenu;

	// cursor del mouse
	// Creo el constructor

	mainMenu() {
		setTitle("Vegan Bird");
		setBounds(273, 50, 800, 640); // limitar el ancho y alto y posicion inicial de pantalla
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true); // mostrar en pantalla boolean
		Container contentpane = getContentPane(); // elemento que contiene en jpanel
		musicaMenu = entorno.Herramientas.cargarSonido("musicaMenu.wav");
		entorno.Herramientas.play("musicaMenu.wav");

		// puedo agregar botones que hagan otras funciones
		// set rollover cambia tama�os, colores, imagenes

		contentpane.setLayout(new GridLayout(1, 1));

		fondo = new JButton(new ImageIcon("fondoParaJuego.gif"));
		boton1 = new JButton(new ImageIcon("botonjugar.png"));
		boton1.setRolloverIcon(new ImageIcon("botonjugaropaco.png")); // cuando la posicion del mouse esta arriba del
																		// boton, cambia de imagen, para cambiar el
																		// color por ejemplo
		boton2 = new JButton(new ImageIcon("salir.png"));
		boton2.setRolloverIcon(new ImageIcon("saliropaco.png"));
		boton1.setBounds(310, 370, 150, 40); // coordenadas en x e y de los botones
		boton2.setBounds(330, 450, 100, 30);
		boton1.addActionListener(this);
		boton2.addActionListener(this);

		fondo.setBounds(0, 50, 800, 250);
		boton1.setBorderPainted(false);
		boton2.setBorderPainted(false);

		fondo.setBorderPainted(false);
		fondo.setBackground(Color.BLACK); // color fondo del menu

		contentpane.setBackground(Color.BLACK);
		contentpane.add(boton1); // para inicializar los botones
		contentpane.add(boton2);
		contentpane.add(fondo);


	}

	public void actionPerformed(ActionEvent click) { // toma un evento(click) dependiendo de adonde se haga el click
														// inicializa el juego
		if (click.getSource() == boton1) {
			Juego juego = new Juego();
			dispose();
		}
		if (click.getSource() == boton2) {
			dispose();
		}

	}

	@SuppressWarnings("unused")
	public static void main(String[] args) {

		mainMenu v = new mainMenu();

	}

}
