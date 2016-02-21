package Presentation;
import Service.*;
import javax.swing.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.sql.SQLException;
import java.util.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
public class IHM  extends JFrame implements ActionListener{
	 String col_nam[]={"Code cat","Categorie"};
	 String v[][];
	 DefaultTableModel model=new DefaultTableModel(v,col_nam);
	JScrollPane jscrollpane=new JScrollPane();
	JTable Datagrid;
	
 JTextField txt_num=new JTextField(20);
 JTextField txt_nom=new JTextField(20);
 JTextField txt_num_box=new JTextField(20);
	JButton bt_Ajouter=new JButton("Ajouter");
	JButton bt_Supprimer=new JButton("Supprimer");
	JButton bt_Modifier=new JButton("Modifier");
	public static Choice combo=new Choice();
	IHM(){
		super("Mon application");
		add(txt_num);
		txt_num.setBounds(30, 20, 100, 20);
		add(txt_nom);
		txt_nom.setBounds(30, 60, 100, 20);
		
		Service.getDaoCategorie().afficherNumCategorie();
		Service.getDaoCategorie().afficherGrid2(model);
		
		
		combo.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jComboBox1PropertyChange(evt);
            }
        });
		
		combo.addItemListener(new ItemListener(){
       public void itemStateChanged(ItemEvent arg0) {
			 System.out.println(" v "+combo.getSelectedItem());
				txt_num_box.setText(combo.getSelectedItem());
    //			 txt_num_box.setText()
				
			}
			
		});
			
		
        
		add(combo);
		combo.setBounds(150, 60, 100, 20);
		add(bt_Ajouter);
		bt_Ajouter.setBounds(30, 100, 100, 20);
		
		
		add(bt_Supprimer);
		bt_Supprimer.setBounds(30, 140, 100, 20);
		
		
		add(bt_Modifier);
		bt_Modifier.setBounds(30, 180, 100, 20);
		
		
		add(txt_num_box);
		txt_num_box.setBounds(60, 250, 100, 20);
		this.getContentPane().setLayout(null);
		jscrollpane.setBounds(new Rectangle(256, 19, 306, 277));
		this.Datagrid=new JTable(model);
		this.getContentPane().add(jscrollpane,null);
		jscrollpane.getViewport().add(Datagrid,null);
		
		setLayout(null);
		
		setVisible(true);
		setSize(700, 700);
	    setResizable(false);
	    setLayout(null);
	    setLocation(100, 50);
		
		//Les évennements:
		bt_Ajouter.addActionListener(this);
		bt_Supprimer.addActionListener(this);
		bt_Modifier.addActionListener(this);
		
	
	}
	
    private void jComboBox1PropertyChange(java.beans.PropertyChangeEvent evt) {
    	JOptionPane.showMessageDialog(this, combo.getSelectedItem());
    }
    
	public static void main(String[] args) {
		new IHM();
	}
	public void actionPerformed(ActionEvent ev) {
		if(ev.getSource()==bt_Ajouter){
			//Service.ajouterBoutton();
			Service.getDaoCategorie().ajouterCategorie(this, Integer.parseInt(txt_num.getText()), txt_nom.getText());
			Service.getDaoClient().ajouterClient(this, Integer.parseInt(txt_num.getText()), txt_nom.getText(), "sss", 33);
		}
		if(ev.getSource()==bt_Supprimer){
		//	Service.getDaoCategorie().supprimerCategorie(this, Integer.parseInt(txt_num.getText()));
			Service.getDaoClient().supprimerClient(this,Integer.parseInt(txt_num.getText()));
		}
   if(ev.getSource()==bt_Modifier){
		//Service.getDaoCategorie().modifierCategorie(this, Integer.parseInt(txt_num.getText()), txt_nom.getText());
		Service.getDaoClient().modifierClient(this,Integer.parseInt(txt_num.getText()), txt_nom.getText(), "Ici", 33);
		}
   if(ev.getSource()==combo){
	   JOptionPane.showMessageDialog(this, "Toto");
   }
	}}
