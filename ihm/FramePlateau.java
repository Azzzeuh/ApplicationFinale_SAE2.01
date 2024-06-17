package ihm;

import metier.*;
import javax.swing.*;
import java.awt.*;

public class FramePlateau extends JFrame {

	private FrameMenu frameMenu;

	private PanelPlateau panelPlateau;

	public FramePlateau( int x, int y)
	{
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Plateau");
		this.setLocation(x, y);
		this.setSize(1000, 800);

		this.frameMenu = new FrameMenu(this.getWidth() + (int) this.getLocation().getX() + 30, (int) this.getLocation().getY(), null);
		
		this.panelPlateau = new PanelPlateau(frameMenu);

		this.frameMenu.setPanelPlateau(panelPlateau);

		this.add(panelPlateau);

		this.setVisible(true);
	}
}
