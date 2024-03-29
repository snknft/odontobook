package edu.austral.lab1.odontobook.graphicInterface;

import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import edu.austral.lab1.odontobook.controler.OdontogramaAction;


public class MouseListenerGraphic  extends MouseAdapter{

	private JPanel canvas;
	private JFrame frame;
	private JPanel panelDeDientes1;
	private OdontogramaAction odonto;


	public MouseListenerGraphic(DrawTooth canvas, OdontogramaAction odonto){
		this.canvas=canvas;
		this.odonto=odonto;
		this.panelDeDientes1=odonto.getPanelDeDientes1();
	}

	public void mouseClicked(MouseEvent e) {

		
		
		JPanel box=  odonto.getCheckBox();
		JRadioButton button1= (JRadioButton) box.getComponent(0);
		JRadioButton button2= (JRadioButton) box.getComponent(1);
		Color color=null;

		if( button1.isSelected()){
			color=color.RED;
		}else if(button2.isSelected()){
			color=color.BLUE;
		}else{
			color=color.WHITE;
		}

		
		
		JPanel contentPane = panelDeDientes1;	
		for(int z=1;z<64;z++){
			if((z>=16&&z<32)||(z>=48&&z<=64)){
				((JComponent) contentPane.getComponent(z)).setBorder(BorderFactory.createEmptyBorder());
				 contentPane.getComponent(z).setFocusable(false);
			}
		}

		
		
		DrawTooth can=(DrawTooth) canvas;
		int diente= (int) can.getNumeroDeDiente();

if(can.getTratamiento1()==Color.BLACK){

	if(diente<=16){
		((JComponent) contentPane.getComponent(diente+15)).setBorder(BorderFactory.createLineBorder(Color.black));
		contentPane.getComponent(diente+15).setFocusable(true);
		panelDeDientes1.repaint();
	}else{		
		((JComponent) contentPane.getComponent(diente+31)).setBorder(BorderFactory.createLineBorder(Color.black));
		contentPane.getComponent(diente+31).setFocusable(true);
		panelDeDientes1.repaint();}
	
}else{
		


		if(((DrawTooth) canvas).getUno().contains(e.getX(), e.getY())) {

			odonto.paintTooth(diente,color,can.getTratamiento2(),can.getTratamiento3(),can.getTratamiento4(),can.getTratamiento5());

		} else if(((DrawTooth) canvas).getDos().contains(e.getX(), e.getY())) {

			odonto.paintTooth(diente,can.getTratamiento1(),color,can.getTratamiento3(),can.getTratamiento4(),can.getTratamiento5());

		} else if(((DrawTooth) canvas).getTres().contains(e.getX(), e.getY())) {



			odonto.paintTooth(diente,can.getTratamiento1(),can.getTratamiento2(),color,can.getTratamiento4(),can.getTratamiento5());




		} else if(((DrawTooth) canvas).getCuatro().contains(e.getX(), e.getY())) {


			odonto.paintTooth(diente,can.getTratamiento1(),can.getTratamiento2(),can.getTratamiento3(),color,can.getTratamiento5());




		} else if(((DrawTooth) canvas).getCinco().contains(e.getX(), e.getY())) {


			odonto.paintTooth(diente,can.getTratamiento1(),can.getTratamiento2(),can.getTratamiento3(),can.getTratamiento4(),color);


		}else{
			System.out.println("click empty");
		}
		
		

		if(diente<=16){
			((JComponent) contentPane.getComponent(diente+15)).setBorder(BorderFactory.createLineBorder(Color.black));
			contentPane.getComponent(diente+15).setFocusable(true);
			panelDeDientes1.repaint();
		}else{		
			((JComponent) contentPane.getComponent(diente+31)).setBorder(BorderFactory.createLineBorder(Color.black));
			contentPane.getComponent(diente+31).setFocusable(true);
			panelDeDientes1.repaint();}
		
		
}





	}

	

}

