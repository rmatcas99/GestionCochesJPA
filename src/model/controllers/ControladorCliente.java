package model.controllers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.entities.Cliente;
import model.entities.Fabricante;



public class ControladorCliente {
	private static ControladorCliente instance = null;
	private EntityManagerFactory factory = Persistence.createEntityManagerFactory("GestionCochesJPA");

	private SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
	
	/**
	 * 
	 * @return
	 */
	public static ControladorCliente getInstance () {
		if (instance == null) {
			instance = new ControladorCliente();
		}
		return instance;
	}
	/**
	 * 
	 */
	public ControladorCliente() {
	}
	

	/**
	 * 
	 * @return
	 */
	public Cliente findPrimero () {
		Cliente f = null;

		EntityManager em = factory.createEntityManager();
		Query q = em.createNativeQuery("select * from tutorialjavacoches.cliente order by id limit 1",
				Cliente.class);
		f = (Cliente) q.getSingleResult();
		em.close();

		return f;
	}
	

	/**
	 * 
	 * @return
	 */
	public Cliente findUltimo () {
		Cliente c = null;

		EntityManager em = factory.createEntityManager();
		Query q = em.createNativeQuery("select * from tutorialjavacoches.cliente order by id desc limit 1",
				Cliente.class);
		c = (Cliente) q.getSingleResult();
		em.close();

		return c;
	}
	

	/**
	 * 
	 * @return
	 */
	public Cliente findSiguiente (int idActual) {
		Cliente c = null;

		EntityManager em = factory.createEntityManager();
		Query q = em.createNativeQuery("select * from tutorialjavacoches.cliente where id > ? order by id limit 1", Cliente.class);
		q.setParameter(1, idActual);
		c = (Cliente) q.getSingleResult();
		em.close();
		
		return c;
	}
	

	/**
	 * 
	 * @return
	 */
	public Cliente findAnterior (int idActual) {
		Cliente c = null;

		EntityManager em = factory.createEntityManager();
		Query q = em.createNativeQuery("select * from tutorialjavacoches.cliente where id < ? order by id desc limit 1", Cliente.class);
		q.setParameter(1, idActual);
		c = (Cliente) q.getSingleResult();
		em.close();
		
		return c;	
	}
	/**
	 * 
	 * @return
	 */
	public boolean guardar (Cliente f) {
		try {
			EntityManager em = factory.createEntityManager();
			em.getTransaction().begin();
			if (f.getId() == 0) {
				em.persist(f);
			}
			else {
				em.merge(f);
			}
			em.getTransaction().commit();
			em.close();
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	public void borrar(Cliente f) {
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		f = em.merge(f);
		em.remove(f);
		em.getTransaction().commit();
		em.close();
	}

	/**
	 * 
	 * @return
	 */
	public List<Cliente> findAll () {
		EntityManager em = factory.createEntityManager();
		
		Query q = em.createNativeQuery("SELECT * FROM cliente", Cliente.class);
		
		List<Cliente> list = (List<Cliente>) q.getResultList();
		em.close();
		return list;
	}
}
