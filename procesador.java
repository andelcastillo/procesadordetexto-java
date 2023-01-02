import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.text.*;

public class procesador {

	public static void main(String[] args) {

		
		MenuProcesador_II mimarco=new MenuProcesador_II();
		
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}


class MenuProcesador_II extends JFrame {
	
	public MenuProcesador_II() {
		
		setVisible(true);
		
		setBounds(500,300,550,400);
		
		LaminaProcesador_II milamina=new LaminaProcesador_II();
		
		add(milamina);
	}
}

class LaminaProcesador_II extends JPanel {
	
	public LaminaProcesador_II() {
		
		setLayout(new BorderLayout());
		
		JPanel laminamenu=new JPanel();
		
		JMenuBar mibarra=new JMenuBar();
	
		fuente=new JMenu("Fuente");
		
		estilo=new JMenu("Estilo");
		
		tamaño=new JMenu("Tamaño");
		
		configura_menu("Arial","fuente","Arial",9,10);
		
		configura_menu("Courier","fuente","Courier",9,10);
		
		configura_menu("Verdana","fuente","Verdana",9,10);
		
		//---------------------------
		
		configura_menu("Negrita","estilo","",Font.BOLD,1);
		
		configura_menu("Cursiva","estilo","",Font.ITALIC,1);
		
		//---------------------
		
		configura_menu("12","tamaño","",9,12);
		
		configura_menu("16","tamaño","",9,16);
		
		configura_menu("20","tamaño","",9,20);
		
		configura_menu("24","tamaño","",9,24);
		
		//---------------------
		
		mibarra.add(fuente);
		
		mibarra.add(estilo);
		
		mibarra.add(tamaño);
		
		laminamenu.add(mibarra);
		
		add(laminamenu,BorderLayout.NORTH);
		
		miarea=new JTextPane();
		
		add(miarea, BorderLayout.CENTER);
			
	}
	
	public void configura_menu(String rotulo, String menu, String tipo_letra, int estilos, int tam) {
		
		JMenuItem elem_menu=new JMenuItem(rotulo);
		
		if(menu=="fuente") {
			
			fuente.add(elem_menu);
			
			if(tipo_letra=="Arial") {
				
				elem_menu.addActionListener(new StyledEditorKit.FontFamilyAction("cambia_letra", "Arial"));
			}else if(tipo_letra=="Courier") {
				
				elem_menu.addActionListener(new StyledEditorKit.FontFamilyAction("cambia_letra", "Courier"));
			}else if(tipo_letra=="Verdana") {
				
				elem_menu.addActionListener(new StyledEditorKit.FontFamilyAction("cambia_letra", "Verdana"));
			}
			
		}else if(menu=="estilo") {
			
			estilo.add(elem_menu);
			
			if(estilos==Font.BOLD) {
				
				elem_menu.addActionListener(new StyledEditorKit.BoldAction());
				
			}else if(estilos==Font.ITALIC) {
				
				elem_menu.addActionListener(new StyledEditorKit.ItalicAction());
			}
			
		}else if(menu=="tamaño") {
			
			tamaño.add(elem_menu);
			
			elem_menu.addActionListener(new StyledEditorKit.FontSizeAction("cambia_tamaño", tam));
		}
		
		
	}
	
	JTextPane miarea;
	
	JMenu fuente, estilo, tamaño;
	
	Font letras;

}