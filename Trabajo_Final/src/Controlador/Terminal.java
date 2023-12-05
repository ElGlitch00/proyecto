/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import java.io.File;  // Permite ubicar el archivo dentro de nuestro codigo
import java.io.FileWriter;  // Permite escribir en el archivo
import java.io.IOException;  // Permite manejar excepciones
import java.time.LocalDateTime;   // Permite manejar fechas
import java.time.format.DateTimeFormatter;   // Permite dar formato a las fechas

import javax.swing.JOptionPane;   // Permite mostrar mensajes en pantalla

import Modelo.Pasajero;   // Importa la clase Pasajero del paquete Modelo

/**
 *
 * @author G15br
 */
public class Terminal {
    private Pasajero[] pasajeros = new Pasajero[48]; // objeto como atributo de otro objeto
                                                    // arreglo de objetos
    private String puntoPartida;
    private String destino;
    private String fechaPartida;

    public Pasajero[] getPasajeros() {
        return pasajeros;
    }

    public void setPasajeros(Pasajero[] pasajeros) {
        this.pasajeros = pasajeros;
    }

    public String getPuntoPartida() {
        return puntoPartida;
    }

    public void setPuntoPartida(String puntoPartida) {
        this.puntoPartida = puntoPartida;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getFechaPartida() {
        return fechaPartida;
    }

    public void setFechaPartida(String fechaPartida) {
        this.fechaPartida = fechaPartida;
    }

    //metodos(Funciones y Procedimientos)

    public Pasajero crearPasajero(String nombre, String apellidos, String dni, String asiento, String puntoPartida,
            String destino) {
        if (nombre == null || apellidos == null || dni == null || asiento == null || puntoPartida == null  // verifica que los datos no sean null
                || destino == null) {
            throw new IllegalArgumentException("Los datos del pasajero no pueden ser null");  // lanza una excepcion
        }

        int numeroAsiento = Integer.parseInt(asiento); // verifica que el asiento este dentro de los parametros
        if (numeroAsiento < 0 || numeroAsiento >= pasajeros.length) {
            JOptionPane.showMessageDialog(null,
                    "El número de asiento no es válido. Por favor, ingrese un número entre 0 y "
                            + (pasajeros.length - 1) + ".");
            return null;
        }

        if (pasajeros[numeroAsiento] != null) { // condicional verficia que el asiento no este ocupado
            JOptionPane.showMessageDialog(null, "El asiento ya está ocupado. Por favor, seleccione otro asiento.");
            return null;
        }

        Pasajero nuevoPasajero = new Pasajero(nombre, apellidos, dni, asiento, puntoPartida, destino);
        pasajeros[numeroAsiento] = nuevoPasajero; // asigna el nuevo pasajero al asiento
        return nuevoPasajero;
    }

    public void crearArchivoPasajero(Pasajero nuevoPasajero) {
        if (nuevoPasajero == null) {
            throw new IllegalArgumentException("Pasajero no puede ser null");
        }

        int asiento = Integer.parseInt(nuevoPasajero.getAsiento());
        String pasaje; // boleto
        LocalDateTime now = LocalDateTime.now(); // manejo de fechas
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        do {
            asiento = Integer.parseInt(nuevoPasajero.getAsiento());
            pasaje = String.format("%02d", asiento);
        } while (new File("Trabajo_Final/Pasajes/" + pasaje + ".txt").exists());

        File dir = new File("Trabajo_Final/Pasajes/");
        if (!dir.exists()) {
            dir.mkdirs();
        }

        try (FileWriter writer = new FileWriter(dir + "/" + pasaje + ".txt")) {
            writer.write("Nombre del cliente: " + nuevoPasajero.getNombre() + "\n");
            writer.write("Apellido del cliente: " + nuevoPasajero.getApellidos() + "\n");
            writer.write("DNI del cliente: " + nuevoPasajero.getDni() + "\n");
            writer.write("Punto de partida: " + getPuntoPartida() + "\n");
            writer.write("Destino: " + getDestino() + "\n");
            writer.write("Asiento: " + nuevoPasajero.getAsiento() + "\n");
            writer.write("Precio: " + seleccionarPrecio() + "\n");
            writer.write("Fecha y hora de la venta: " + now.format(formatter) + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean pasajeroExiste(String dni) {
        for (Pasajero pasajero : this.pasajeros) {
            if (pasajero != null && pasajero.getDni().equals(dni)) {
                return true;
            }
        }
        return false;
    }

    public void registrarViaje(String puntoPartida, String destino, String fechaPartida) {
        this.puntoPartida = puntoPartida;
        this.destino = destino;
    }

    public double seleccionarPrecio() {
        double precio = 0.0;

        if (puntoPartida.equals("Lima") && destino.equals("Cañete")) {
            precio = 12.0;
        } else if (puntoPartida.equals("Lima") && destino.equals("Chincha")) {
            precio = 22.0;
        } else if (puntoPartida.equals("Chincha") && destino.equals("Lima")) {
            precio = 25.0;
        } else if (puntoPartida.equals("Cañete") && destino.equals("Chincha")) {
            precio = 15.0;
        } else {
            precio = 30.0;
        }

        return precio;
    }
}
