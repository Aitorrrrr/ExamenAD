package view;

import java.awt.Dimension;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.BorderLayout;

public class LaunchView extends JFrame {

	private JButton comparar,buscar;
	private JTextArea textArea;
	private JTextField fichero1,fichero2,palabra;
	private JLabel label_f1,label_f2,label_pal;
	private JCheckBox primera;
	private JButton btnGuardarLibro;
	
	private JPanel panel;
	private JPanel panel_1;
	private JTextField id;
	private JTextField autor;
	private JTextField titulo;
	private JLabel lblNewLabel_2;
	private JTextField anyo;
	private JTextField editor;
	private JTextField paginas;
	private JButton btnRecuperarLibro;
	private JButton btnRecuperarTodos;
	private JButton btnLibrosPorAo;
	private JButton btnPalabrasPorLongitud;
	private JTextField textLongitud;

	public LaunchView() {
		
		setBounds(200,200,1000,450);
		setTitle("Proyecto Buffers");	
		panel = new JPanel();
		
		comparar = new JButton("Comparar contenido");
		comparar.setPreferredSize(new Dimension(150, 26));
		buscar = new JButton("Buscar palabra");
		buscar.setPreferredSize(new Dimension(150, 26));
					
		fichero1 = new JTextField("",10);
		fichero2 = new JTextField("",10);
		palabra = new JTextField("",10);
		
		label_f1 = new JLabel("Fichero 1:");
		label_f2 = new JLabel("Fichero 2:");
		label_pal = new JLabel("Palabra:");
		
		primera = new JCheckBox("Primera aparición");

		textArea = new JTextArea(20, 80);
		textArea.setBounds(50,50,50,50);
		textArea.setEditable(false);		
		
		panel.add(comparar);
		panel.add(buscar);
		panel.add(label_f1);
		panel.add(fichero1);
		panel.add(label_f2);
		panel.add(fichero2);
		panel.add(label_pal);
		panel.add(palabra);
		panel.add(primera);
		panel.add(textArea);
		
        // Añadimos el JPanel al JFrame
        this.getContentPane().add(panel, BorderLayout.SOUTH);
        
        panel_1 = new JPanel();
        panel.add(panel_1);
        
        id = new JTextField();
        id.setColumns(10);
        
        autor = new JTextField();
        autor.setColumns(10);
        
        titulo = new JTextField();
        titulo.setColumns(10);
        
        JLabel lblNewLabel = new JLabel("Id: ");
        
        JLabel lblNewLabel_1 = new JLabel("T\u00EDtulo:");
        
        lblNewLabel_2 = new JLabel("Autor:");
        
        anyo = new JTextField();
        anyo.setColumns(10);
        
        editor = new JTextField();
        editor.setColumns(10);
        
        JLabel lblAo = new JLabel("A\u00F1o:");
        
        JLabel lblEditor = new JLabel("Editor:");
        
        paginas = new JTextField();
        paginas.setColumns(10);
        
        JLabel lblNewLabel_3 = new JLabel("P\u00E1ginas:");
        
        btnGuardarLibro = new JButton("Guardar libro");
        
        btnRecuperarLibro = new JButton("Recuperar libro");
        
       btnRecuperarTodos = new JButton("Recuperar todos");
        
        btnLibrosPorAo = new JButton("Libros por a\u00F1o");
        
        btnPalabrasPorLongitud = new JButton("Palabras por longitud");
        
        textLongitud = new JTextField();
        textLongitud.setColumns(10);
        
        JLabel lblLng = new JLabel("Lng:");
        GroupLayout gl_panel_1 = new GroupLayout(panel_1);
        gl_panel_1.setHorizontalGroup(
        	gl_panel_1.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_panel_1.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
        				.addComponent(lblNewLabel_2)
        				.addComponent(lblNewLabel_1)
        				.addComponent(lblNewLabel)
        				.addComponent(lblAo)
        				.addComponent(lblEditor)
        				.addComponent(lblNewLabel_3))
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
        				.addGroup(gl_panel_1.createSequentialGroup()
        					.addComponent(id, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        					.addGap(18)
        					.addComponent(btnGuardarLibro))
        				.addGroup(gl_panel_1.createSequentialGroup()
        					.addComponent(titulo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        					.addGap(18)
        					.addComponent(btnRecuperarLibro))
        				.addGroup(gl_panel_1.createSequentialGroup()
        					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
        						.addComponent(autor, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        						.addComponent(anyo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        						.addComponent(editor, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        						.addComponent(paginas, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        					.addGap(18)
        					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
        						.addComponent(btnLibrosPorAo)
        						.addComponent(btnRecuperarTodos)
        						.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
        							.addGroup(gl_panel_1.createSequentialGroup()
        								.addComponent(lblLng)
        								.addGap(18)
        								.addComponent(textLongitud, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        							.addComponent(btnPalabrasPorLongitud)))))
        			.addGap(18))
        );
        gl_panel_1.setVerticalGroup(
        	gl_panel_1.createParallelGroup(Alignment.TRAILING)
        		.addGroup(gl_panel_1.createSequentialGroup()
        			.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
        				.addComponent(id, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        				.addComponent(lblNewLabel)
        				.addComponent(btnGuardarLibro))
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
        				.addComponent(titulo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        				.addComponent(lblNewLabel_1)
        				.addComponent(btnRecuperarLibro))
        			.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
        				.addGroup(gl_panel_1.createSequentialGroup()
        					.addGap(18)
        					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
        						.addComponent(autor, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        						.addComponent(lblNewLabel_2))
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
        						.addComponent(anyo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        						.addComponent(lblAo))
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
        						.addComponent(editor, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        						.addComponent(lblEditor))
        					.addPreferredGap(ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
        					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
        						.addComponent(paginas, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        						.addComponent(lblNewLabel_3)))
        				.addGroup(gl_panel_1.createSequentialGroup()
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addComponent(btnRecuperarTodos)
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addComponent(btnLibrosPorAo)
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addComponent(btnPalabrasPorLongitud)
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
        						.addComponent(textLongitud, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        						.addComponent(lblLng))
        					.addContainerGap())))
        );
        panel_1.setLayout(gl_panel_1);
		
	}	
	
	public JCheckBox getPrimera() {
		return primera;
	}

	public void setPrimera(JCheckBox primera) {
		this.primera = primera;
	}
	
	public JButton getComparar() {
		return comparar;
	}

	public void setComparar(JButton comparar) {
		this.comparar = comparar;
	}
	
	public JButton getBtnRecuperarLibro() {
		return btnRecuperarLibro;
	}

	public void setBtnRecuperarLibro(JButton btnRecuperarLibro) {
		this.btnRecuperarLibro = btnRecuperarLibro;
	}

	public JButton getBuscar() {
		return buscar;
	}

	public void setBuscar(JButton buscar) {
		this.buscar = buscar;
	}

	public JTextArea getTextArea() {
		return textArea;
	}

	public JButton getBtnRecuperarTodos() {
		return btnRecuperarTodos;
	}

	public JButton getBtnLibrosPorAo() {
		return btnLibrosPorAo;
	}

	public JTextField getTextLongitud() {
		return textLongitud;
	}

	public void setTextLongitud(JTextField textLongitud) {
		this.textLongitud = textLongitud;
	}

	public void setBtnLibrosPorAo(JButton btnLibrosPorAo) {
		this.btnLibrosPorAo = btnLibrosPorAo;
	}

	public void setBtnRecuperarTodos(JButton btnRecuperarTodos) {
		this.btnRecuperarTodos = btnRecuperarTodos;
	}

	public void setTextArea(JTextArea textArea) {
		this.textArea = textArea;
	}
			
	public JButton getBtnPalabrasPorLongitud() {
		return btnPalabrasPorLongitud;
	}

	public void setBtnPalabrasPorLongitud(JButton btnPalabrasPorLongitud) {
		this.btnPalabrasPorLongitud = btnPalabrasPorLongitud;
	}

	public JTextField getFichero1() {
		return fichero1;
	}

	public void setFichero1(JTextField fichero1) {
		this.fichero1 = fichero1;
	}

	public JTextField getFichero2() {
		return fichero2;
	}

	public void setFichero2(JTextField fichero2) {
		this.fichero2 = fichero2;
	}
	
	public JTextField getPalabra() {
		return palabra;
	}

	public void setPalabra(JTextField palabra) {
		this.palabra = palabra;
	}
	
	public JButton getBtnGuardarLibro() {
		return btnGuardarLibro;
	}

	public void setBtnGuardarLibro(JButton btnGuardarLibro) {
		this.btnGuardarLibro = btnGuardarLibro;
	}

	public JTextField getId() {
		return id;
	}

	public void setId(JTextField id) {
		this.id = id;
	}

	public JTextField getAutor() {
		return autor;
	}

	public void setAutor(JTextField autor) {
		this.autor = autor;
	}

	public JTextField getTitulo() {
		return titulo;
	}

	public void setTitulo(JTextField titulo) {
		this.titulo = titulo;
	}

	public JTextField getAnyo() {
		return anyo;
	}

	public void setAnyo(JTextField anyo) {
		this.anyo = anyo;
	}

	public JTextField getEditor() {
		return editor;
	}

	public void setEditor(JTextField editor) {
		this.editor = editor;
	}

	public JTextField getPaginas() {
		return paginas;
	}

	public void setPaginas(JTextField paginas) {
		this.paginas = paginas;
	}

	public void showError(String m){
		JOptionPane.showMessageDialog(this.panel,
			    m,
			    "Error",
			    JOptionPane.ERROR_MESSAGE);
	}
}
