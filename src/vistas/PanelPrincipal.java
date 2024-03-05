package vistas;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;

import controladores.ConnectionManager;
import controladores.ControladorCentro;
import controladores.ControladorMateria;
import controladores.ControladorNivel;
import entidades.CentroEducativo;
import entidades.Materia;
import entidades.Nivel;

import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class PanelPrincipal extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField textFieldId;
	private JTextField textFieldNombre;
	private JTextField textFieldCodigo;
	private JTextField textFieldURL;
	private JTextField textFieldFecha;
	private JComboBox<CentroEducativo> comboBoxCentro;
	private JComboBox<Nivel> comboBoxNivel;
	private JComboBox<Materia> comboBoxMateria;
	JCheckBox chkAdmiteMatricula;
	
	/**
	 * Create the panel.
	 */
	public PanelPrincipal() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblGestionDeMaterias = new JLabel("Gestion de Materias");
		GridBagConstraints gbc_lblGestionDeMaterias = new GridBagConstraints();
		gbc_lblGestionDeMaterias.insets = new Insets(0, 0, 5, 5);
		gbc_lblGestionDeMaterias.gridwidth = 3;
		gbc_lblGestionDeMaterias.gridx = 0;
		gbc_lblGestionDeMaterias.gridy = 0;
		add(lblGestionDeMaterias, gbc_lblGestionDeMaterias);
		
		JLabel lblCentro = new JLabel("Centro: ");
		GridBagConstraints gbc_lblCentro = new GridBagConstraints();
		gbc_lblCentro.anchor = GridBagConstraints.EAST;
		gbc_lblCentro.insets = new Insets(0, 0, 5, 5);
		gbc_lblCentro.gridx = 0;
		gbc_lblCentro.gridy = 1;
		add(lblCentro, gbc_lblCentro);
		
		comboBoxCentro = new JComboBox<CentroEducativo>();
		GridBagConstraints gbc_comboBoxCentro = new GridBagConstraints();
		gbc_comboBoxCentro.insets = new Insets(0, 0, 5, 5);
		gbc_comboBoxCentro.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxCentro.gridx = 1;
		gbc_comboBoxCentro.gridy = 1;
		add(comboBoxCentro, gbc_comboBoxCentro);
		cargarTodosCentros();
		
		JButton btnNiveles = new JButton("Cargar niveles");
		btnNiveles.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cargarTodosNivelesdeCentro();
			}
		});
		GridBagConstraints gbc_btnNiveles = new GridBagConstraints();
		gbc_btnNiveles.insets = new Insets(0, 0, 5, 5);
		gbc_btnNiveles.gridx = 2;
		gbc_btnNiveles.gridy = 1;
		add(btnNiveles, gbc_btnNiveles);
		
		JLabel lblNewLabel = new JLabel("Nivel: ");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 2;
		add(lblNewLabel, gbc_lblNewLabel);
		
		comboBoxNivel = new JComboBox();
		GridBagConstraints gbc_comboBoxNivel = new GridBagConstraints();
		gbc_comboBoxNivel.insets = new Insets(0, 0, 5, 5);
		gbc_comboBoxNivel.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxNivel.gridx = 1;
		gbc_comboBoxNivel.gridy = 2;
		add(comboBoxNivel, gbc_comboBoxNivel);
		
		JButton btnMaterias = new JButton("Cargar materias");
		btnMaterias.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cargarTodosMateriasdeNivel();
			}
		});
		GridBagConstraints gbc_btnMaterias = new GridBagConstraints();
		gbc_btnMaterias.insets = new Insets(0, 0, 5, 5);
		gbc_btnMaterias.gridx = 2;
		gbc_btnMaterias.gridy = 2;
		add(btnMaterias, gbc_btnMaterias);
		
		JLabel lblNewLabel_1 = new JLabel("Materia: ");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 3;
		add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		comboBoxMateria = new JComboBox();
		GridBagConstraints gbc_comboBoxMateria = new GridBagConstraints();
		gbc_comboBoxMateria.insets = new Insets(0, 0, 5, 5);
		gbc_comboBoxMateria.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxMateria.gridx = 1;
		gbc_comboBoxMateria.gridy = 3;
		add(comboBoxMateria, gbc_comboBoxMateria);
		
		JButton btnMateria = new JButton("Ver materia");
		btnMateria.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
					verMateria();
				
				
			}
		});
		GridBagConstraints gbc_btnMateria = new GridBagConstraints();
		gbc_btnMateria.insets = new Insets(0, 0, 5, 5);
		gbc_btnMateria.gridx = 2;
		gbc_btnMateria.gridy = 3;
		add(btnMateria, gbc_btnMateria);
		
		JLabel lblVer = new JLabel("Datos de la materia: ");
		GridBagConstraints gbc_lblVer = new GridBagConstraints();
		gbc_lblVer.insets = new Insets(0, 0, 5, 0);
		gbc_lblVer.gridwidth = 4;
		gbc_lblVer.gridx = 0;
		gbc_lblVer.gridy = 4;
		add(lblVer, gbc_lblVer);
		
		JLabel lblId = new JLabel("Id: ");
		GridBagConstraints gbc_lblId = new GridBagConstraints();
		gbc_lblId.anchor = GridBagConstraints.EAST;
		gbc_lblId.insets = new Insets(0, 0, 5, 5);
		gbc_lblId.gridx = 0;
		gbc_lblId.gridy = 5;
		add(lblId, gbc_lblId);
		
		textFieldId = new JTextField();
		GridBagConstraints gbc_textFieldId = new GridBagConstraints();
		gbc_textFieldId.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldId.gridwidth = 2;
		gbc_textFieldId.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldId.gridx = 1;
		gbc_textFieldId.gridy = 5;
		add(textFieldId, gbc_textFieldId);
		textFieldId.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Nombre: ");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 6;
		add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		textFieldNombre = new JTextField();
		GridBagConstraints gbc_textFieldNombre = new GridBagConstraints();
		gbc_textFieldNombre.gridwidth = 2;
		gbc_textFieldNombre.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldNombre.gridx = 1;
		gbc_textFieldNombre.gridy = 6;
		add(textFieldNombre, gbc_textFieldNombre);
		textFieldNombre.setColumns(10);
		
		JLabel lblCodigo = new JLabel("Codigo: ");
		GridBagConstraints gbc_lblCodigo = new GridBagConstraints();
		gbc_lblCodigo.anchor = GridBagConstraints.EAST;
		gbc_lblCodigo.insets = new Insets(0, 0, 5, 5);
		gbc_lblCodigo.gridx = 0;
		gbc_lblCodigo.gridy = 7;
		add(lblCodigo, gbc_lblCodigo);
		
		textFieldCodigo = new JTextField();
		GridBagConstraints gbc_textFieldCodigo = new GridBagConstraints();
		gbc_textFieldCodigo.gridwidth = 2;
		gbc_textFieldCodigo.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldCodigo.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldCodigo.gridx = 1;
		gbc_textFieldCodigo.gridy = 7;
		add(textFieldCodigo, gbc_textFieldCodigo);
		textFieldCodigo.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("URL Classroom: ");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.anchor = GridBagConstraints.BASELINE_TRAILING;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 0;
		gbc_lblNewLabel_3.gridy = 8;
		add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		textFieldURL = new JTextField();
		GridBagConstraints gbc_textFieldURL = new GridBagConstraints();
		gbc_textFieldURL.gridwidth = 2;
		gbc_textFieldURL.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldURL.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldURL.gridx = 1;
		gbc_textFieldURL.gridy = 8;
		add(textFieldURL, gbc_textFieldURL);
		textFieldURL.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Fecha Inicio");
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_4.fill = GridBagConstraints.VERTICAL;
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4.gridx = 0;
		gbc_lblNewLabel_4.gridy = 9;
		add(lblNewLabel_4, gbc_lblNewLabel_4);
		
		textFieldFecha = new JTextField();
		GridBagConstraints gbc_textFieldFecha = new GridBagConstraints();
		gbc_textFieldFecha.gridwidth = 2;
		gbc_textFieldFecha.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldFecha.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldFecha.gridx = 1;
		gbc_textFieldFecha.gridy = 9;
		add(textFieldFecha, gbc_textFieldFecha);
		textFieldFecha.setColumns(10);
		
		chkAdmiteMatricula = new JCheckBox("");
		chkAdmiteMatricula.setSelected(true);
		GridBagConstraints gbc_chkAdmiteMatricula = new GridBagConstraints();
		gbc_chkAdmiteMatricula.anchor = GridBagConstraints.EAST;
		gbc_chkAdmiteMatricula.insets = new Insets(0, 0, 5, 5);
		gbc_chkAdmiteMatricula.gridx = 0;
		gbc_chkAdmiteMatricula.gridy = 10;
		add(chkAdmiteMatricula, gbc_chkAdmiteMatricula);
		
		JLabel lblNewLabel_5 = new JLabel("Adminte Matricula");
		GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
		gbc_lblNewLabel_5.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_5.gridx = 1;
		gbc_lblNewLabel_5.gridy = 10;
		add(lblNewLabel_5, gbc_lblNewLabel_5);
		
		JButton btnNewButton_3 = new JButton("Guardar");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				guardar();
			}
		});
		GridBagConstraints gbc_btnNewButton_3 = new GridBagConstraints();
		gbc_btnNewButton_3.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton_3.gridx = 1;
		gbc_btnNewButton_3.gridy = 11;
		add(btnNewButton_3, gbc_btnNewButton_3);

	}

	private void cargarTodosCentros() {
		List <CentroEducativo> l = ControladorCentro.getTodos();
		for (CentroEducativo o: l) {
			comboBoxCentro.addItem(o);
		}
	}

	private void cargarTodosNivelesdeCentro() {
		CentroEducativo c =	(CentroEducativo) this.comboBoxCentro.getSelectedItem();

		this.comboBoxNivel.removeAllItems();
		List <Nivel> l = ControladorNivel.getTodos(c.getId());
		for (Nivel o: l) {
			comboBoxNivel.addItem(o);
		}
	}

	private void cargarTodosMateriasdeNivel() {
		Nivel a =(Nivel) this.comboBoxNivel.getSelectedItem();

		this.comboBoxMateria.removeAllItems();
		List <Materia> l = ControladorMateria.getTodos(a.getId());
		for (Materia o: l) {
			comboBoxMateria.addItem(o);
		}
	}
	
	private void guardar() {
        
        try {
            Connection conn =  ConnectionManager.getConexion();
            PreparedStatement ps = conn.prepareStatement(""+ "update materia set nombre=?, codigo=?, urlClassroom=?, admiteMatricula=?, fechaInicio=? where id=?");
            ps.setString(1, textFieldNombre.getText());
            ps.setString(2, textFieldCodigo.getText());
            ps.setString(3, textFieldURL.getText());
            ps.setBoolean(4, chkAdmiteMatricula.isSelected());
            ps.setString(5, textFieldFecha.getText());
            ps.setInt(6, Integer.parseInt(textFieldId.getText()));
            
            ps.execute();
            
            
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
	}
	
	private void verMateria() {
		Materia m = (Materia) comboBoxMateria.getSelectedItem();
		
		textFieldId.setText("" + m.getId());
		textFieldCodigo.setText("" + m.getCodigo());
		textFieldNombre.setText("" + m.getNombre());
		textFieldFecha.setText("" + m.getFechaInicio());
		textFieldURL.setText("" + m.getUrlClassroom());
		if(m.isAdmitematricula()) {
			chkAdmiteMatricula.setSelected(true);
		}else chkAdmiteMatricula.setSelected(false);
		
		}
	private boolean isUrlValida() {
		String url = this.textFieldURL.getText().toUpperCase();
		if (url.startsWith("HTTP") || url.startsWith("HTTPS")) {
			return true;
		}
		return false;
	}
}