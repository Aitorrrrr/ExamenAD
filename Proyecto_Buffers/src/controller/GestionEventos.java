package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.xml.ws.Service.Mode;

import model.*;
import view.*;

public class GestionEventos {

	private GestionDatos model;
	private LaunchView view;
	private ActionListener actionListener_comparar, actionListener_buscar, actionListener_libro, actionListener_RecuperarLibro, actionListener_RecuperarTodos, actionListener_librosAnyo, actionListener_palabrasLong;

	public GestionEventos(GestionDatos model, LaunchView view) {
		this.model = model;
		this.view = view;
	}

	public void contol() {
		actionListener_comparar = new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				call_compararContenido();
			}
		};
		view.getComparar().addActionListener(actionListener_comparar);

		actionListener_buscar = new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				call_buscarPalabra();
			}
		};
		view.getBuscar().addActionListener(actionListener_buscar);
		
		actionListener_libro = new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				comprobarCamposGuardar();
			}
		};
		view.getBtnGuardarLibro().addActionListener(this.actionListener_libro);
		
		actionListener_RecuperarLibro = new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				comprobarCamposRecuperar();
			}
		};
		view.getBtnRecuperarLibro().addActionListener(this.actionListener_RecuperarLibro);
		
		actionListener_RecuperarTodos = new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				recuperarTodos();
			}
		};
		view.getBtnRecuperarTodos().addActionListener(this.actionListener_RecuperarTodos);
		
		actionListener_librosAnyo = new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				librosPorAnyo();
			}
		};
		view.getBtnLibrosPorAo().addActionListener(this.actionListener_librosAnyo);
		
		actionListener_palabrasLong = new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				palabrasPorLong();
			}
		};
		view.getBtnPalabrasPorLongitud().addActionListener(this.actionListener_palabrasLong);
	}

	private int call_compararContenido() {
		try
		{
			if(model.compararContenido(view.getFichero1().getText(), view.getFichero2().getText()))
			{
				view.getTextArea().setText("¡Los ficheros contienen lo mismo!");
			}
			else
			{
				view.getTextArea().setText("Los ficheros no contienen lo mismo...");
			}
		}
		catch (FileNotFoundException fnfe)
		{
			view.showError("Algún fichero no ha sido encontrado");
		} 
		catch (IOException ioe) 
		{
			view.showError("Algo ha sucedido al cerrar los ficheros");
		}
		// TODO: Gestionar excepciones
		return 1;
	}

	private int call_buscarPalabra() {

		try
		{
			boolean primera=view.getPrimera().isSelected();
			int res=model.buscarPalabra(view.getFichero1().getText(), view.getPalabra().getText(), primera);
			
			if (res==0)
			{
				view.getTextArea().setText("La palabra no se ha encontrado");
			}
			else
			{
				if (primera)
				{
					view.getTextArea().setText("La primera aparición de la palabra esta en la línea "+res);
				}
				else
				{
					view.getTextArea().setText("La última aparición de la plabra esta en la línea "+res);
				}
			}
		}
		catch (IOException ioe)
		{
			view.showError("Vaya, algo ha sucedido con el fichero");
		}
		
		return 1;
	}
	
	private void guardar_libro()
	{
		try
		{
			int id=Integer.parseInt(view.getId().getText());
			String titulo=view.getTitulo().getText();
			String autor=view.getAutor().getText();
			int anyo=Integer.parseInt(view.getAnyo().getText());
			String editor=view.getEditor().getText();
			int pags=Integer.parseInt(view.getPaginas().getText());
			
			Libro l1 = new Libro(id, titulo, autor, anyo, editor, pags);
			
			int res=model.guardarLibro(l1);
			
			if (res==0)
			{
				view.getTextArea().setText("El fichero ya existe");
			}
			else
			{
				view.getTextArea().setText("El fichero ha sido creado con éxito");
			}
		}
		catch (FileNotFoundException fnfe)
		{
			view.showError("Vaya, parece que el fichero no se ha encontrado");
		}
		catch (IOException ioe)
		{
			view.showError("Algo ha ocurrido con el arhivo...Mmm...");
			ioe.printStackTrace();
		}
	}
	
	private void recuperarTodos()
	{
		try 
		{
			ArrayList<Libro> todos = (ArrayList<Libro>) model.recuperarTodos();
			StringBuilder builder=new StringBuilder();
			view.getTextArea().setText("");
			
			for (int i=0; i<todos.size(); i++)
			{
				builder.append(todos.get(i).getTitulo()+" del autor "+todos.get(i).getAutor()+"\n");
			}
			
			view.getTextArea().setText(view.getTextArea().getText()+builder.toString());
		} 
		catch (FileNotFoundException e) 
		{
			view.showError("¡El fichero padre no se ha encontrado!");
		} 
		catch (ClassNotFoundException e) 
		{
			view.showError("La clase libro no existe hehe");
		} 
		catch (IOException e) 
		{
			view.showError("Algun fichero no contenía un libro..");
		}
	}
	
	private void comprobarCamposGuardar()
	{
		if (view.getId().getText()!="" && view.getTitulo().getText()!="" && view.getEditor().getText()!="" && view.getAnyo().getText()!="" && view.getAutor().getText()!="" && view.getPaginas().getText()!="")
		{
			guardar_libro();
		}
		else
		{
			view.showError("Alguno de los campos no ha sido introducido");
		}
	}
	
	private void comprobarCamposRecuperar()
	{
		if (view.getTitulo().getText()!="")
		{
			recuperar_libro();
		}
		else
		{
			view.showError("El campo titulo es el único necesario para la recuperación");
		}
	}
	
	private void recuperar_libro()
	{
		try
		{
			String id=String.valueOf(view.getId().getText());
			
			Libro ej=model.recuperarLibro(id);
			
			if (ej==null)
			{
				view.showError("No se ha encontrado el libro en cuestión");
			}
			else
			{
				view.getTextArea().setText("Su libro ha sido recuperado\nTítulo: "+ej.getTitulo()+"\nAutor: "+ej.getAutor()+"\nEditor: "+ej.getEditor()+"\nAño publicación: "+ej.getAnyo()+"\nPáginas: "+ej.getPaginas());
			}
		}
		catch (FileNotFoundException fnfe)
		{
			view.showError("El fichero no ha sido encontrado");
		}
		catch (IOException ioe)
		{
			view.showError("Algo ha ocurrido con el fichero...Mmm...");
		}
		catch (ClassNotFoundException cnte)
		{
			view.showError("Cuidado, la clase Libro no existe...");
		}
	}
	
	private void librosPorAnyo()
	{
		try 
		{
			int cnt=model.librosPorAnyo(Integer.parseInt(view.getAnyo().getText()));
			
			if (cnt==0)
			{
				view.showError("No se han encontrado libros del año "+view.getAnyo().getText());
			}
			else
			{
				if (cnt==1)
				{
					view.getTextArea().setText("Hay guardado "+cnt+" libro del año "+view.getAnyo().getText());
				}
				else
				{
					view.getTextArea().setText("Hay guardados "+cnt+" libros del año "+view.getAnyo().getText());
				}
				
			}
		} 
		catch (FileNotFoundException e) 
		{
			view.showError("Algún fichero no fue encontrado...Mmm");
		} 
		catch (ClassNotFoundException e) 
		{
			view.showError("Parece que la clase libro no existe");
		} 
		catch (IOException e) 
		{
			view.showError("Algo ha sucedido con los ficheros");
		}
	}
	
	private void palabrasPorLong()
	{
		try 
		{
			ArrayList<String> palabras=model.palabrasPorLong(view.getId().getText(), Integer.parseInt(view.getTextLongitud().getText()));
			
			view.getTextArea().setText("");
			for (String aux: palabras)
			{
				view.getTextArea().setText(view.getTextArea().getText()+aux+"\n");
			}
		} 
		catch (NumberFormatException e) 
		{
			view.showError("No se ha introducido un número entero como longitud...Ejem");
		} 
		catch (IOException e) 
		{
			view.showError("Algo ha sucedido con el fichero, vaya...");
		}
	}
}
