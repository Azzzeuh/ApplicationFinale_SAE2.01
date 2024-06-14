package ihm;

import metier.*;
import javax.swing.*;
import java.awt.*;

public class FramePlateau extends JFrame {

	FrameMenu frameMenu;

	public FramePlateau( int x, int y )
	{
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setTitle("Plateau");
		this.setLocation(x, y);
		this.setSize(1000, 800);

		frameMenu    = new FrameMenu(this.getWidth() + (int) this.getLocation().getX() + 30, (int) this.getLocation().getY());

		this.setVisible(true);
	}
}
