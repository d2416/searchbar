package searchbar.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Controller {

	private Connection conexion;
	
	public Controller()
	{
		//Conexion con la base de datos
		String user = "searchbar";
		int password = 2021;
		
		try 
		{
			String url = "jdbc:mysql://localhost:3306/searchbar_db?user=" + user + "&pasword=" + password;
			conexion = DriverManager.getConnection(url);
			
			if (conexion != null) 
				System.out.println("Conexion satisfactoria");

		} 
		catch (SQLException e) 
		{
			System.out.println("Error en la conexion, verifique: usuario, password y base de datos");
			e.printStackTrace();
		}
	}
	
	public void menu()
	{
		int opcion;
		Scanner sc = new Scanner(System.in);
		
		do
		{
			System.out.println(".::MENU::.");
			System.out.println("0. Salir");
			System.out.println("1. Buscar por titulo");
			System.out.println("2. Buscar por director");
			System.out.println("3. Buscar por Actor");
			System.out.println("Selecciona una opcion (0-3): ");
			opcion = sc.nextInt();
			
			switch(opcion)
			{
				case 1:
					buscar("title");
					break;
				case 2:
					buscar("director");
					break;
				case 3:
					buscar("actor");
					break;
				case 0:
					System.out.println("Adiós!");
					break;
				default: 
					System.out.println("Opción invalida!");
					break;
			}
			
		}while(opcion != 0);
	}
	
	public void buscar(String por)
	{
		Statement stm = null;
		ResultSet rs = null;
		String sql = "";
		Scanner sc = new Scanner(System.in);
		
		if(por.equals("title"))
		{
			String title;
			System.out.println("Ingresa titulo: ");
			title = sc.nextLine();
			
			sql = "SELECT * FROM contenidos WHERE title LIKE '%" + title + "%'";
		}
		else if(por.equals("director"))
		{
			String director;
			System.out.println("Ingresa nombre del director: ");
			director = sc.nextLine();
			
			sql = "SELECT * FROM contenidos c, directores d WHERE c.director_id = d.id AND d.name LIKE '%" + director + "%'";
		}
		else //actor
		{
			String actor;
			System.out.println("Ingresa nombre del actor: ");
			actor = sc.nextLine();
			
			sql = "SELECT * FROM contenidos c, actores a, contenidos_has_actors ca WHERE c.id = ca.contenido_id AND ca.actor_id = a.id AND a.name LIKE '%" + actor + "%'";
		}
		
		try 
		{			
			stm = conexion.createStatement();
			rs = stm.executeQuery(sql);
			
			System.out.println("title \t\t duration \t description \t\t type \t date");
			
			while (rs.next()) 
			{
				System.out.print(rs.getString(2) + " \t");
				System.out.print(rs.getString(3) + " \t");
				System.out.print(rs.getString(4) + " \t");
				System.out.print(rs.getString(5) + " \t");
				System.out.print(rs.getString(6) + " ");
				System.out.println("\n");
			}

			stm.close();
			rs.close();
		} 
		catch (SQLException e) 
		{
			System.out.println("Error buscando el contenido");
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args)
	{
		Controller cont = new Controller();
		cont.menu();
	}
	
}