package org.example;

import org.example.controller.ClienteDAO;
import org.example.model.Cliente;

public class Main {
    public static void main(String[] args) {
        /*
        Cliente cliente1 = new Cliente();
        cliente1.setNombre("Alberto Pérez");
        cliente1.setTotalVentas(1500L);
        cliente1.setActivo(true);
        ClienteDAO.insertarCliente(cliente1);

        Cliente cliente2 = new Cliente();
        cliente2.setNombre("María Rodríguez");
        cliente2.setTotalVentas(3000L);
        cliente2.setActivo(false);
        ClienteDAO.insertarCliente(cliente2);

        Cliente cliente3 = new Cliente();
        cliente3.setNombre("Carlos Gómez");
        cliente3.setTotalVentas(500L);
        cliente3.setActivo(true);
        ClienteDAO.insertarCliente(cliente3);

        Cliente cliente4 = new Cliente();
        cliente4.setNombre("Ana Martínez");
        cliente4.setTotalVentas(2500L);
        cliente4.setActivo(true);
        ClienteDAO.insertarCliente(cliente4);

        Cliente cliente5 = new Cliente();
        cliente5.setNombre("Luisa García");
        cliente5.setTotalVentas(1200L);
        cliente5.setActivo(false);
        ClienteDAO.insertarCliente(cliente5);
        */


        // Probar otros métodos
        //ClienteDAO.getCliente(cliente1.getId());
        //ClienteDAO.listarMejoresClientes(0L);
        ClienteDAO.estadisticas();
    }
}