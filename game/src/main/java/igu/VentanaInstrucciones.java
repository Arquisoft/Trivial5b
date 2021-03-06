package igu;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.IOException;
import java.net.URISyntaxException;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextPane;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;

public class VentanaInstrucciones extends JDialog {

	private static final long serialVersionUID = 1L;
	private static final JTabbedPane instrucciones = new JTabbedPane();

	public VentanaInstrucciones(JFrame padre) {
		super(padre);
		setVisible(true);
		setLocation(300, 250);
		setSize(500, 500);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setResizable(false);

		// Primera pesta�a
		instrucciones.addTab("Objetivo", null, getPanel1(), null);

		// Segunda pesta�a
		instrucciones.addTab("Categorias", null, getPanel2(), null);

		// Tercera pesta�a
		instrucciones.addTab("Mec�nica", null, getPanel3(), null);

		// Cuarta pesnta�a
		instrucciones.addTab("contacto", null, getPanel4(), null);

		getContentPane().add(instrucciones);

		Image icon = Toolkit.getDefaultToolkit().getImage(
				getClass().getResource("/img/logo.jpg"));
		this.setIconImage(icon);

	}

	private JPanel getPanel1() {
		JPanel panel = new JPanel();
		panel.setLayout(null);
		JTextPane textArea = new JTextPane();
		textArea.setEditable(false);
		textArea.setOpaque(false);
		textArea.setText("Consigue los cuatro ticks de cada categoria. Cada vez que aciertes cuatro preguntas, se te otorgar� un tick de la categoria de la ultima pregunta. S� el primero en conseguir los cuatro ticks y gana este divertido juego.");
		textArea.setBorder(null);
		textArea.setForeground(Color.WHITE);
		setFont(new java.awt.Font("Candara", 1, 18));
		textArea.setBounds(30, 30, 447, 401);
		panel.add(textArea);
		panel.add(getFondo());
		return panel;
	}

	private JPanel getPanel2() {
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setLayout(null);

		JLabel lblCat1 = getLblIcono(1);
		lblCat1.setBounds(30, 30, 90, 90);
		panel.add(lblCat1);
		JTextPane txtCat1 = new JTextPane();
		txtCat1.setBounds(130, 30, 350, 90);
		txtCat1.setText("Historia.\nDemuestra que conoces todos los datos sobre la historia del mundo.");
		txtCat1.setOpaque(false);
		txtCat1.setForeground(Color.WHITE);
		setFont(new java.awt.Font("Candara", 1, 18));
		panel.add(txtCat1);

		JLabel lblCat2 = getLblIcono(2);
		lblCat2.setBounds(30, 130, 90, 90);
		panel.add(lblCat2);
		JTextPane txtCat2 = new JTextPane();
		txtCat2.setBounds(130, 130, 350, 90);
		txtCat2.setText("Geograf�a.\nEn esta categor�a se pondr� aprueba tus conocimientos sobre la geograf�a mundial.");
		txtCat2.setOpaque(false);
		txtCat2.setForeground(Color.WHITE);
		setFont(new java.awt.Font("Candara", 1, 18));
		panel.add(txtCat2);

		JLabel lblCat3 = getLblIcono(3);
		lblCat3.setBounds(30, 230, 90, 90);
		panel.add(lblCat3);
		JTextPane txtCat3 = new JTextPane();
		txtCat3.setBounds(130, 230, 350, 90);
		txtCat3.setText("Ciencia.\nLa ciencia esta en todas partes, �sabes tanto como crees? Demuestralo en esta categoria.");
		txtCat3.setOpaque(false);
		txtCat3.setForeground(Color.WHITE);
		setFont(new java.awt.Font("Candara", 1, 18));
		panel.add(txtCat3);

		JLabel lblCat4 = getLblIcono(4);
		lblCat4.setBounds(30, 330, 90, 90);
		panel.add(lblCat4);
		JTextPane txtCat4 = new JTextPane();
		txtCat4.setBounds(130, 330, 350, 90);
		txtCat4.setText("Actualidad.\nDemuestra que tienes los conocimientos actualizados en la categoria sobre preguntas de actualidad.");
		txtCat4.setOpaque(false);
		txtCat4.setForeground(Color.WHITE);
		setFont(new java.awt.Font("Candara", 1, 18));
		panel.add(txtCat4);

		panel.add(getFondo());
		return panel;
	}

	private JPanel getPanel3() {
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setLayout(null);

		JTextPane mecanica = new JTextPane();
		mecanica.setBounds(30, 30, 350, 300);
		mecanica.setText("Tira el dado y escoge la casilla que mas te guste dependiendo del n�mero que te haya salido.\n\n"
				+ "Acierta la pregunta y continua jugando.\nSi fallas, perder�s el turno.");
		mecanica.setOpaque(false);
		mecanica.setForeground(Color.WHITE);
		setFont(new java.awt.Font("Candara", 1, 18));
		panel.add(mecanica);

		panel.add(getFondo());
		return panel;
	}

	private JPanel getPanel4() {
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setLayout(null);

		JEditorPane contacto = new JEditorPane();
		contacto.setEditorKit(JEditorPane
				.createEditorKitForContentType("text/html"));
		contacto.setEditable(false);
		contacto.setText("<html><font color='white'>Para m�s informaci�n, visite nuestra p�gina:</font>\n\n\t<a href=\"http://arquisoft.github.io/Trivial5b\">www.arquisoft.github.io/Trivial5b</a></html>");
		contacto.addHyperlinkListener(new HyperlinkListener() {
			public void hyperlinkUpdate(HyperlinkEvent e) {
				if (e.getEventType() == HyperlinkEvent.EventType.ACTIVATED) {
					if (Desktop.isDesktopSupported()) {
						try {
							Desktop.getDesktop().browse(e.getURL().toURI());
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (URISyntaxException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				}
			}
		});
		contacto.setBounds(30, 30, 370, 310);
		contacto.setOpaque(false);
		setFont(new java.awt.Font("Candara", 1, 18));
		panel.add(contacto);

		panel.add(getFondo());
		return panel;
	}

	private JLabel getLblIcono(int categoria) {
		JLabel lblIcono = new JLabel();
		lblIcono.setBounds(30, 151, 112, 106);
		lblIcono.setText(null);
		ImageIcon img = new ImageIcon();
		switch (categoria) {
		case 1:
			img = new ImageIcon(getClass().getResource("/img/cat1.jpg"));
			break;
		case 2:
			img = new ImageIcon(getClass().getResource("/img/cat2.jpg"));
			break;
		case 3:
			img = new ImageIcon(getClass().getResource("/img/cat3.jpg"));
			break;
		case 4:
			img = new ImageIcon(getClass().getResource("/img/cat4.jpg"));
			break;
		}
		Icon icono = new ImageIcon(img.getImage().getScaledInstance(
				lblIcono.getWidth(), lblIcono.getHeight(), Image.SCALE_DEFAULT));
		lblIcono.setIcon(icono);
		return lblIcono;
	}

	private JLabel getFondo() {
		JLabel lblFondo = new JLabel();
		lblFondo.setText(null);
		lblFondo.setLocation(0, 0);
		lblFondo.setSize(new Dimension(484, 462));
		ImageIcon img = new ImageIcon(getClass().getResource("/img/f0.jpg"));
		Icon fondo = new ImageIcon(img.getImage().getScaledInstance(
				lblFondo.getWidth(), lblFondo.getHeight(), Image.SCALE_DEFAULT));
		lblFondo.setIcon(fondo);
		return lblFondo;
	}
}
