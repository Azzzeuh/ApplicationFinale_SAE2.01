package application.ihm;

import application.metier.*;
import application.Controleur;

import javax.swing.*;
import java.awt.*;

public class FramePlateau extends JFrame {

	private FrameMenu frameMenu;

	private PanelPlateau panelPlateau;

	private Joueur joueur1;
	private Joueur joueur2;

	public FramePlateau(Controleur ctrl, int x, int y)
	{
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Plateau");
		this.setLocation(x, y);
		this.setSize(1000, 915);
		this.joueur1 = new Joueur();
		this.joueur2 = new Joueur();

		this.frameMenu = new FrameMenu(this.getWidth() + (int) this.getLocation().getX() + 30, (int) this.getLocation().getY(), null, joueur1, joueur2);
		
		this.panelPlateau = new PanelPlateau(ctrl, frameMenu);

		this.frameMenu.setPanelPlateau(panelPlateau);

		this.add(panelPlateau);

		this.setVisible(true);
	}
}
