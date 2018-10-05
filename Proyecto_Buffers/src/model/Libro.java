package model;

import java.io.Serializable;

public class Libro implements Serializable{

	private int id;
	private String titulo;
	private String autor;
	private int anyo;
	private String editor;
	private int paginas;
	
	public Libro(int id, String titulo, String autor, int anyo, String editor, int paginas)
	{
		this.id=id;
		this.titulo=titulo;
		this.autor=autor;
		this.anyo=anyo;
		this.editor=editor;
		this.paginas=paginas;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public int getAnyo() {
		return anyo;
	}

	public void setAnyo(int anyo) {
		this.anyo = anyo;
	}

	public String getEditor() {
		return editor;
	}

	public void setEditor(String editor) {
		this.editor = editor;
	}

	public int getPaginas() {
		return paginas;
	}

	public void setPaginas(int paginas) {
		this.paginas = paginas;
	}
	
	
}
