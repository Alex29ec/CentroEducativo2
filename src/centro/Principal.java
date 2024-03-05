package centro;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;

import vistas.PanelPrincipal;


public class Principal extends JFrame{
	static Principal instance = null;
	public static Principal getInstance() {
		if(instance == null) {
			instance = new Principal();
		}
		return instance;
	}
	
public Principal() {
		
		super("Gestion de centro educativo");
		this.setBounds(0,0,800,600);
		
		JTabbedPane panelTabbed = new JTabbedPane();
		PanelPrincipal panelPrincipal = new PanelPrincipal();
		panelTabbed.add(panelPrincipal);
		
		
		panelTabbed.setSelectedIndex(0);
		
		this.getContentPane().add(panelTabbed);
		}

	public static void main(String[] args) {
		Principal ventana = new Principal();
		ventana.setVisible(true);
	}
}
