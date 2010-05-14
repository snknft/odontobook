package edu.austral.lab1.odontobook.graphicInterface;

import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;

import edu.austral.lab1.odontobook.model.Doctor;
import edu.austral.lab1.odontobook.model.HibernateUtil;
import edu.austral.lab1.odontobook.model.Paciente;
import edu.austral.lab1.odontobook.model.dao.DoctorDao;
import edu.austral.lab1.odontobook.model.dao.PacienteDao;



public class TabbedPane extends JTabbedPane{
	private JPanel panel;
	private JPanel panel1;
	private JPanel panel2;
	private DoctorDao doctorDao;
	private JList doc;
	private PacienteDao pacienteDao;
	private JList paci;

	public TabbedPane (){
		HibernateUtil.beginTransaction();
		doctorDao =new DoctorDao();
		List doctores=doctorDao.getAll();
		System.out.print(doctores.isEmpty());
		doc=new JList();
		DefaultListModel modeloDeLista = new DefaultListModel();

		if(!doctores.isEmpty()){

			for(int i=0;i<doctores.size();i++){
				modeloDeLista.addElement(((Doctor) doctores.get(i)).getNombre()+" "+((Doctor) doctores.get(i)).getApellido());
			}
		}
		doc.setModel(modeloDeLista);
		JScrollPane scroll=new JScrollPane(doc);
		doc.setSelectedIndex(0);
		this.addTab("Doctores",scroll);
		
				
		pacienteDao =new PacienteDao();
		List pacientes=pacienteDao.getAll();
		System.out.print(doctores.isEmpty());
		paci=new JList();
		DefaultListModel modeloDeListaDePacientes = new DefaultListModel();

		if(!pacientes.isEmpty()){

			for(int i=0;i<pacientes.size();i++){
				modeloDeListaDePacientes.addElement(((Paciente)pacientes.get(i)).getNombre()+" "+((Paciente) pacientes.get(i)).getApellido());
			}
		}
		paci.setModel(modeloDeListaDePacientes);
		JScrollPane scrollDePacientes=new JScrollPane(paci);
		paci.setSelectedIndex(0);
		this.addTab("Pacientes",scrollDePacientes);

		
		
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
	

	public JList getPaci() {
		return paci;
	}










	public void setPaci(JList paci) {
		this.paci = paci;
	}










	public JList getDoc() {
		return doc;
	}

	public void setDoc(JList doc) {
		this.doc = doc;
	}
}

