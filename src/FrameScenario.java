package src; 

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrameScenario extends JFrame implements ActionListener {

    private JLabel     etapeLabel;
    private JButton    etapeSuivanteJButton;
    private JButton    etapePrecedenteJButton;

    private JPanel     contentPane;

    private int        etapeActuelle;
    private Controleur ctrl;

    public FrameScenario(int x, int y, int etape, int scenario) {
        
        this.etapeActuelle = etape;
        this.ctrl = new Controleur(scenario);
        this.ctrl.executerEtape(etape);

        // Initialisation de la fenêtre
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setSize(400, 200);
		this.setTitle ("Scénario");
		this.setLocation(x, y);
		this.setLayout(new FlowLayout());

        // Création des composants
        etapeLabel            = new JLabel("Étape " + etapeActuelle, JLabel.CENTER);
        etapeSuivanteJButton   = new JButton("Étape suivante");
        etapePrecedenteJButton = new JButton("Étape précédente");

        // Activation des composants
        this.etapePrecedenteJButton.addActionListener( this );
        this.etapeSuivanteJButton.addActionListener( this );


        // Création du conteneur principal et ajout des composants
        this.contentPane = new JPanel(new BorderLayout());
        this.contentPane.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        this.contentPane.add(etapeLabel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new GridLayout(1, 2, 10, 0));
        buttonPanel.add(etapePrecedenteJButton);
        buttonPanel.add(etapeSuivanteJButton);
        this.contentPane.add(buttonPanel, BorderLayout.SOUTH);

        // Configuration de la JFrame
        setContentPane(this.contentPane);
        pack();
        setVisible(true);
    }

    public int getEtapes() { return this.etapeActuelle; }

	public void actionPerformed(ActionEvent e)
	{
        if(e.getSource() == this.etapePrecedenteJButton)
        {
            this.etapeActuelle--;
            this.ctrl = null;
            this.ctrl = new Controleur(0);
            for(int cpt=1; cpt<=etapeActuelle; cpt++)
            {
                this.ctrl.executerEtape(etapeActuelle);
            }
        }

        if(e.getSource() == this.etapeSuivanteJButton)
		{
            this.etapeActuelle++;
            this.ctrl.executerEtape(etapeActuelle);
        }

        etapeLabel.setText("Étape " + etapeActuelle);
    }
}
