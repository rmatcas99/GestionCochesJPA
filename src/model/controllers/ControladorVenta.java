package model.controllers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.entities.Fabricante;
import model.entities.Venta;

public class ControladorVenta {

	private static ControladorVenta instance = null;
	private EntityManagerFactory factory = Persistence.createEntityManagerFactory("GestionCochesJPA");

	private SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");

	/**
	 * 
	 * @return
	 */
	public static ControladorVenta getInstance() {
		if (instance == null) {
			instance = new ControladorVenta();
		}

		return instance;
	}

	/**
	 * 
	 */
	public ControladorVenta() {
	}

	/**
	 * 
	 * @return
	 */
	public Venta findPrimero() {

		Venta f = null;

		EntityManager em = factory.createEntityManager();
		Query q = em.createNativeQuery("select * from tutorialjavacoches.venta order by id limit 1", Venta.class);
		f = (Venta) q.getSingleResult();
		em.close();

		return f;
	}

	/**
	 * 
	 * @return
	 */
	public Venta findUltimo() {
		Venta c = null;

		EntityManager em = factory.createEntityManager();
		Query q = em.createNativeQuery("select * from tutorialjavacoches.venta order by id desc limit 1", Venta.class);
		c = (Venta) q.getSingleResult();
		em.close();

		return c;
	}

	/**
	 * 
	 * @return
	 */
	public Venta findSiguiente(int idActual) {
		Venta c = null;

		EntityManager em = factory.createEntityManager();
		Query q = em.createNativeQuery("select * from tutorialjavacoches.venta where id > ? order by id limit 1",
				Venta.class);
		q.setParameter(1, idActual);
		c = (Venta) q.getSingleResult();
		em.close();

		return c;
	}

	/**
	 * 
	 * @return
	 */
	public Venta findAnterior(int idActual) {
		Venta c = null;

		EntityManager em = factory.createEntityManager();
		Query q = em.createNativeQuery("select * from tutorialjavacoches.venta where id < ? order by id desc limit 1",
				Venta.class);
		q.setParameter(1, idActual);
		c = (Venta) q.getSingleResult();
		em.close();

		return c;
	}


	/**
	 * 
	 * @return
	 */
	public boolean guardar (Venta f) {
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
	public void borrar(Venta f) {
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		f = em.merge(f);
		em.remove(f);
		em.getTransaction().commit();
		em.close();
	}

	
}
