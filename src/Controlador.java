import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;


public class Controlador
{
	private Arbol tree;
	private View view;
	public Controlador()
	{
		tree= new Arbol();
		view= new View();
		
		view.setResizable(false);
		
		ActionListener oyenteBmagic;
		oyenteBmagic= new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent arg0) {
				eventoMagic(arg0);
				
			}
		}; 
	
		view.getBtnMagic().addActionListener(oyenteBmagic);
	}
	
	private void eventoMagic(ActionEvent arg0)
	{
		try{
		view.getLblArbol().setText(tree.infijaAPostfija(view.getTxtEntrada().getText())); 
		view.getLblResultado().setText(tree.evaluar());
		}catch(Exception e)
		{
			System.out.println(e.getMessage());
			JOptionPane.showMessageDialog(null, "No soy aprueba de TROLLS xD");
		}
	}
}
