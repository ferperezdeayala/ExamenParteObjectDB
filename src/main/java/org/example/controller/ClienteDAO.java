package org.example.controller;

import org.example.model.Cliente;
import org.example.util.ObjectDBUtils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class ClienteDAO {

    public static void insertarCliente(Cliente cliente) {
        EntityManagerFactory emf = ObjectDBUtils.getEntityManagerFactory();
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(cliente);
        em.getTransaction().commit();
    }

    public static void getCliente(Long id) {
        EntityManagerFactory emf = ObjectDBUtils.getEntityManagerFactory();
        EntityManager em = emf.createEntityManager();
        Cliente cliente = em.find(Cliente.class, id);
        if (cliente != null) {
            System.out.println(cliente.toString());
        } else {
            System.out.println("Cliente no encontrado.");
        }
    }

    public static void listarMejoresClientes(Long cantidad) {
        EntityManagerFactory emf = ObjectDBUtils.getEntityManagerFactory();
        EntityManager em = emf.createEntityManager();
        TypedQuery<Cliente> query = em.createQuery("SELECT c FROM Cliente c WHERE c.activo = true AND c.totalVentas > :cantidad", Cliente.class);
        query.setParameter("cantidad", cantidad);
        List<Cliente> clientes = query.getResultList();
        if (clientes.isEmpty()) {
            System.out.println("No hay clientes activos con total de ventas mayor a " + cantidad);
        } else {
            clientes.forEach(System.out::println);
        }
    }

    public static void estadisticas() {
        EntityManagerFactory emf = ObjectDBUtils.getEntityManagerFactory();
        EntityManager em = emf.createEntityManager();
        TypedQuery<Long> totalVentasQuery = em.createQuery("SELECT SUM(c.totalVentas) FROM Cliente c", Long.class);
        Long totalVentas = totalVentasQuery.getSingleResult();

        TypedQuery<Double> promedioVentasQuery = em.createQuery("SELECT AVG(c.totalVentas) FROM Cliente c WHERE c.activo = true", Double.class);
        Double promedioVentas = promedioVentasQuery.getSingleResult();

        TypedQuery<Long> clientesInactivosQuery = em.createQuery("SELECT COUNT(c) FROM Cliente c WHERE c.activo = false AND c.totalVentas > 0", Long.class);
        Long clientesInactivos = clientesInactivosQuery.getSingleResult();

        System.out.println("1. Total de ventas entre todos los clientes: " + totalVentas);
        System.out.println("2. Promedio de ventas de los clientes activos: " + promedioVentas);
        System.out.println("3. Cantidad de clientes inactivos que tienen total de ventas mayor a 0: " + clientesInactivos);
    }
}

