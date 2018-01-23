import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;


public class View extends JFrame {

	private JPanel contentPane;
	private JTextField txtEntrada;
	private JLabel lblResultado;
	private JButton btnMagic;
	private JLabel lblTree;
	private JLabel lblArbol;

	/**
	 * Create the frame.
	 */
	public View() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		txtEntrada = new JTextField();
		txtEntrada.setBounds(10, 11, 414, 20);
		contentPane.add(txtEntrada);
		txtEntrada.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("resultado");
		lblNewLabel.setBounds(10, 42, 65, 14);
		contentPane.add(lblNewLabel);
		
		lblResultado = new JLabel("");
		lblResultado.setBounds(85, 42, 339, 14);
		contentPane.add(lblResultado);
		
		btnMagic = new JButton("MAGIC");
		btnMagic.setFont(new Font("Monotype Corsiva", Font.BOLD | Font.ITALIC, 37));
		btnMagic.setBounds(10, 85, 414, 166);
		contentPane.add(btnMagic);
		
		lblTree = new JLabel("tree");
		lblTree.setBounds(10, 60, 46, 14);
		contentPane.add(lblTree);
		
		lblArbol = new JLabel("");
		lblArbol.setBounds(66, 60, 358, 14);
		contentPane.add(lblArbol);
		
		this.setVisible(true);
	}

	public JLabel getLblTree() {
		return lblTree;
	}

	public void setLblTree(JLabel lblTree) {
		this.lblTree = lblTree;
	}

	public JLabel getLblArbol() {
		return lblArbol;
	}

	public void setLblArbol(JLabel lblArbol) {
		this.lblArbol = lblArbol;
	}

	public JTextField getTxtEntrada() {
		return txtEntrada;
	}

	public void setTxtEntrada(JTextField txtEntrada) {
		this.txtEntrada = txtEntrada;
	}

	public JLabel getLblResultado() {
		return lblResultado;
	}

	public void setLblResultado(JLabel lblResultado) {
		this.lblResultado = lblResultado;
	}

	public JButton getBtnMagic() {
		return btnMagic;
	}

	public void setBtnMagic(JButton btnMagic) {
		this.btnMagic = btnMagic;
	}
	
}
