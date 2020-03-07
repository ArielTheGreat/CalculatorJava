package calculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class CrearVentana extends JFrame
{
	private final JPanel panelFinal = new JPanel(new BorderLayout(2, 2));
	private JTextField pantalla = new JTextField();

    private final ArrayList<JButton> controles = new ArrayList<>();
	public CrearVentana()
	{
		super("Calculadora");
		
		crearBotonesYFunciones();
		crearPantalla();
		anadirBordesAlrededor();
		add(panelFinal);
		setSize(400, 500);
		setVisible(true);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		 pantalla.addKeyListener(new KeyAdapter() {
	         public void keyPressed(KeyEvent ke) {
	            if (ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9') {
	            	pantalla.setEditable(true);
	            } else {
	            	pantalla.setEditable(false);
	            }
	         }
	      });
		
		ImageIcon icono = new ImageIcon(".\\src\\calculator\\Materiales\\iconoCalc.png");
		setIconImage(icono.getImage());
	}
	public void anadirBordesAlrededor()
	{
		panelFinal.setBorder(BorderFactory.createEmptyBorder(3, 3, 3, 3));
	}
	public void crearBotonesYFunciones()
	{
		JPanel panelBotones = new JPanel();
		panelBotones.setLayout(new GridLayout(4,4,2,2));
		String[] valores = {"7","8","9","/",
							  "4","5","6","*",
							  "1","2","3","+",
							  ".","0","C","-"};
		for(String valor : valores)
		{
			anadirBoton(panelBotones,valor);
		}
		panelFinal.add(panelBotones,BorderLayout.CENTER);
		botonIgual();
	}
	public void botonIgual()
	{
		JButton botonIgual = new JButton("=");
		botonIgual.setBackground(new Color(0,128,255));
		Font fuenteIgual = new Font("Verdana",Font.BOLD,40);
		botonIgual.setFont(fuenteIgual);
		panelFinal.add(botonIgual,BorderLayout.LINE_END);
		botonIgual.setPreferredSize(new Dimension(80,25));
	}
	public void anadirBoton(Container panelBotones,String valor)
	{
		JButton boton = new JButton(valor);
		configurarBoton(boton);
		panelBotones.add(boton);
	}
	public void crearPantalla()
	{
		Font fuente = new Font("Verdana",Font.BOLD,40);
		pantalla.setFont(fuente);
		pantalla.setHorizontalAlignment(JTextField.RIGHT);
		pantalla.setDocument(new LimitePantalla(13));
		pantalla.setPreferredSize(new Dimension(100,90));
		panelFinal.add(pantalla,BorderLayout.PAGE_START);
		
	}
	public void configurarBoton(JButton z)
	{
		/*z.addActionListener(this);
		z.addKeyListener(this);*/
		controles.add(z);
	}
	
}


