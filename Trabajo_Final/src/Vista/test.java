package Vista;

import javax.swing.JOptionPane;

import Controlador.Terminal;
import Modelo.Pasajero;

import java.awt.HeadlessException;           // Ocurre cuando se llama al código que depende de un teclado, una pantalla o un mouse en un entorno que no admite un teclado, una pantalla o un mouse.
import java.io.IOException;                  // excepcion de entrada o salida 
import java.io.BufferedReader;               // Sirve para la lectura del variables dentro del texto  haciendo uso del Buffer
import java.io.File;                         // Permite ubicar el archivo dentro de nuestro codigo
import java.io.FileReader;                   // Sirve para la lectura del archivo de texto
import java.time.LocalDateTime;              // Obtener la hora local
import java.time.format.DateTimeFormatter;   // Darle un formato a la hora

/**
 * 
 * @author ElgLITCH
 */
public class test {
    public static void main(String[] args) {

        Terminal terminal = new Terminal();      
        String[] busarray = new String[49];
        for (int i = 0; i < 49; i++) {
            busarray[i] = String.format("%02d", i);
        }

        Pasajero[] pasajeros = new Pasajero[50];

        int opcion;
        String menu = """
                Menu opciones
                1. Registrar pasajero
                2. Verificar boleto
                3. Mostrar asientos
                4. Registrar boleto de texto
                5. Salir
                """;
        do {

            String bus = """
                    #################
                          PRIMER PISO
                    #################
                     [%s] [%s]    [%s] [%s]
                     [%s] [%s]    [%s] [%s]
                     [%s] [%s]    [%s] [%s]
                     [%s] [%s]    [%s] [%s]
                     [%s] [%s]    [%s] [%s]
                    #################
                          SEGUNDO PISO
                    #################
                     [%s] [%s]    [%s] [%s]
                     [%s] [%s]    [%s] [%s]
                     [%s] [%s]    [%s] [%s]
                     [%s] [%s]    [%s] [%s]
                     [%s] [%s]    [%s] [%s]
                     [%s] [%s]    [%s] [%s]
                     [%s] [%s]    [%s] [%s]
                    #################
                         """;
            String busString = String.format(bus, busarray[0], busarray[1], busarray[2], busarray[3],
                    busarray[4],
                    busarray[5], busarray[6], busarray[7], busarray[8], busarray[9], busarray[10],
                    busarray[11], busarray[12], busarray[13], busarray[14], busarray[15], busarray[16],
                    busarray[17], busarray[18], busarray[19], busarray[20], busarray[21], busarray[22],
                    busarray[23], busarray[24], busarray[25], busarray[26], busarray[27], busarray[28],
                    busarray[29], busarray[30], busarray[31], busarray[32], busarray[33], busarray[34],
                    busarray[35], busarray[36], busarray[37], busarray[38], busarray[39], busarray[40],
                    busarray[41], busarray[42], busarray[43], busarray[44], busarray[45], busarray[46],
                    busarray[47], busarray[48]);

            String input = JOptionPane.showInputDialog(menu);
            if (input == null) {
                // El usuario presionó "Cancelar"
                opcion = 5; // Esto es para que te bote del sistema
            } else {
                try {
                    opcion = Integer.parseInt(input);
                } catch (NumberFormatException e) { // error por ingresar letras dentro de opcion
                    // El usuario ingresó letras
                    JOptionPane.showMessageDialog(null, "Entrada inválida. Por favor, ingrese un número.");
                    opcion = 0; // Da opcion a repetir el ingreso de opcion
                }
            }
            switch (opcion) {
                case 1 -> {
                    try {
                        String nombre = JOptionPane.showInputDialog("Ingrese sus nombres");
                        String apellidos = JOptionPane.showInputDialog("Ingrese sus apellidos");

                        String dni;
                        int dniNumero;
                        do {
                            dni = JOptionPane.showInputDialog("Ingrese su DNI");
                            try {
                                dniNumero = Integer.parseInt(dni);
                                if (dni.length() != 8) {
                                    JOptionPane.showMessageDialog(null,
                                            "El DNI es inválido, tiene que tener exactamente 8 dígitos", "Error",
                                            JOptionPane.ERROR_MESSAGE);
                                } else {
                                    break; // Si el DNI es válido, rompe el bucle
                                }
                            } catch (NumberFormatException e) {
                                JOptionPane.showMessageDialog(null, "El DNI debe ser un número", "Error",
                                        JOptionPane.ERROR_MESSAGE);
                            }
                        } while (true);

                        StringBuilder menu_origen = new StringBuilder();
                        menu_origen.append("Seleccione su punto de partida\n")
                                .append("1.Lima\n")
                                .append("2.Cañete\n")
                                .append("3.Chincha\n");
                        String opcion_origen = JOptionPane.showInputDialog(menu_origen.toString());
                        int opcion_partida = Integer.parseInt(opcion_origen);
                        String fechaPartida = JOptionPane.showInputDialog("Ingrese la fecha de partida (dd/MM/yyyy)");
                        switch (opcion_partida) {
                            case 1 -> {
                                JOptionPane.showMessageDialog(null, "Haz seleccionado Lima");
                                terminal.registrarViaje("Lima", null, fechaPartida);
                            }
                            case 2 -> {
                                JOptionPane.showMessageDialog(null, "Haz seleccionado Cañete");
                                terminal.registrarViaje("Cañete", null, fechaPartida);
                            }
                            case 3 -> {
                                JOptionPane.showMessageDialog(null, "Haz seleccionado Chincha");
                                terminal.registrarViaje("Chincha", null, fechaPartida);
                            }
                            default -> {
                                JOptionPane.showMessageDialog(null, "Opcion incorrecta");
                            }
                        }

                        StringBuilder menu_destino = new StringBuilder();
                        menu_destino.append("Seleccione su destino\n")
                                .append("1.Lima\n")
                                .append("2.Cañete\n")
                                .append("3.Chincha\n");
                        String opcion_destino = JOptionPane.showInputDialog(menu_destino.toString());

                        switch (opcion_destino) {
                            case "1" -> {
                                JOptionPane.showMessageDialog(null, "Haz seleccionado Lima como destino");
                                terminal.registrarViaje(terminal.getPuntoPartida(), "Lima", terminal.getFechaPartida());
                            }
                            case "2" -> {
                                JOptionPane.showMessageDialog(null, "Haz seleccionado Cañete como destino");
                                terminal.registrarViaje(terminal.getPuntoPartida(), "Cañete",
                                        terminal.getFechaPartida());
                            }
                            case "3" -> {
                                JOptionPane.showMessageDialog(null, "Haz seleccionado Chincha como destino");
                                terminal.registrarViaje(terminal.getPuntoPartida(), "Chincha",
                                        terminal.getFechaPartida());
                            }
                            default -> {
                                JOptionPane.showMessageDialog(null, "Opcion incorrecta");
                            }
                        }

                        // JOptionPane.showMessageDialog(null, busString); Esto sirve es para mostrar
                        // los buses
                        String asientoInput = JOptionPane.showInputDialog(busString + "\nIngrese el asiento");
                        String puntoPartida = terminal.getPuntoPartida();
                        String destino = terminal.getDestino();

                        Pasajero nuevoPasajero = terminal.crearPasajero(nombre, apellidos, String.valueOf(dniNumero),
                                asientoInput, puntoPartida, destino);

                        if (nuevoPasajero != null) {
                            terminal.crearArchivoPasajero(nuevoPasajero);
                            JOptionPane.showMessageDialog(null, "Asiento reservado con éxito");
                            busarray[Integer.parseInt(asientoInput)] = "XX"; // Marca el asiento como ocupado en
                                                                             // busarray
                        }
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(null, "DNI debe ser un número", "Error",
                                JOptionPane.ERROR_MESSAGE);
                    } catch (HeadlessException e) {
                        JOptionPane.showMessageDialog(null, "Un error a ocurrido: " + e.getMessage(), "Error",
                                JOptionPane.ERROR_MESSAGE);
                    }

                }
                case 2 -> {
                    // Solicitar al usuario que ingrese el número de asiento
                    String asientoInput = JOptionPane
                            .showInputDialog("Ingrese el número de asiento para generar el boleto:");
                    int asiento = -1;
                    if (asientoInput == null) {
                        // El usuario presionó "Cancelar", maneja esto como desees
                        JOptionPane.showMessageDialog(null, "Operación cancelada por el usuario");
                    } else {
                        try {
                            asiento = Integer.parseInt(asientoInput);
                            // Continúa con tu lógica aquí
                        } catch (NumberFormatException e) {
                            JOptionPane.showMessageDialog(null, "Por favor, ingrese un número válido");
                        }
                    }

                    // Validar el número de asiento
                    if (asiento < 0 || asiento >= pasajeros.length || pasajeros[asiento] == null) {
                        JOptionPane.showMessageDialog(null, "Número de asiento inválido o asiento no reservado.");
                    } else {
                        // Acceder al Pasajero en el asiento especificado
                        Pasajero pasajeroAsiento = pasajeros[asiento];

                        StringBuilder boleto = new StringBuilder();
                        boleto.append("Generando boleto...\n")
                                .append("Nombre del cliente: ").append(pasajeroAsiento.getNombre()).append("\n")
                                .append("DNI del cliente: ").append(pasajeroAsiento.getDni()).append("\n")
                                .append("Punto de partida: ").append(terminal.getPuntoPartida()).append("\n")
                                .append("Destino: ").append(terminal.getDestino()).append("\n")
                                .append("Asiento: ").append(pasajeroAsiento.getAsiento()).append("\n")
                                .append("Precio: ").append(terminal.seleccionarPrecio());
                        JOptionPane.showMessageDialog(null, boleto.toString());

                        int respuesta = JOptionPane.showConfirmDialog(null, "Desea continuar?", "Confirmación",
                                JOptionPane.YES_NO_OPTION);
                        if (respuesta == JOptionPane.NO_OPTION) {
                            opcion = 5;
                        }
                    }
                }
                case 3 -> {

                    busString = String.format(bus, (Object[]) busarray);
                    JOptionPane.showMessageDialog(null, busString);
                }
                case 4 -> {
                    try {
                        File folder = new File("pasajes/");
                        File[] listOfFiles = folder.listFiles();
                        StringBuilder fileList = new StringBuilder();

                        if (listOfFiles != null) {
                            for (File file : listOfFiles) {
                                if (file.isFile()) { // se confirma si es un archivo
                                    fileList.append(file.getName()).append("\n");
                                }
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "No hay archivos en el directorio.");
                        }

                        String asiento = JOptionPane.showInputDialog(
                                fileList.toString() + "Ingrese numero de su pasaje:");
                        String fileName = "pasajes/" + asiento + ".txt";
                        String nombre = null;
                        String apellidos = null;
                        String dni = null;
                        String puntoPartida = null;
                        String destino = null;
                        double precio = 0;
                        LocalDateTime fechaVenta = null;
                        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
                            nombre = reader.readLine().split(": ")[1];
                            apellidos = reader.readLine().split(": ")[1];
                            dni = reader.readLine().split(": ")[1];
                            puntoPartida = reader.readLine().split(": ")[1];
                            destino = reader.readLine().split(": ")[1];
                            asiento = reader.readLine().split(": ")[1];
                            precio = Double.parseDouble(reader.readLine().split(": ")[1]);
                            fechaVenta = LocalDateTime.parse(reader.readLine().split(": ")[1],
                                    DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"));
                        } catch (IOException e) {
                            JOptionPane.showMessageDialog(null,
                                    "No se pudo leer el archivo. Verifique el ID de venta.");
                        }

                        boolean pasajeroExiste = false;
                        for (Pasajero pasajero : pasajeros) {
                            if (pasajero != null && pasajero.getDni().equals(dni)) {
                                pasajeroExiste = true;
                                break;
                            }
                        }
                        if (pasajeroExiste) {
                            JOptionPane.showMessageDialog(null, "El pasajero ya existe.");
                        } else {
                            if (terminal.pasajeroExiste(dni)) {
                                JOptionPane.showMessageDialog(null, "El pasajero ya existe.");
                            } else {
                                Pasajero nuevoPasajero = new Pasajero(nombre, apellidos, dni, asiento, puntoPartida,
                                        destino);

                                if (nuevoPasajero != null) {
                                    terminal.registrarViaje(puntoPartida, destino, fechaVenta.toString()); // Registra
                                                                                                           // el
                                                                                                           // viaje
                                    precio = terminal.seleccionarPrecio(); // Selecciona el precio
                                    JOptionPane.showMessageDialog(null,
                                            "Pasajero registrado con éxito.\n" + "fechaVenta: "
                                                    + fechaVenta + "\n" + "precio: " + precio);
                                    busarray[Integer.parseInt(asiento)] = "XX"; // Marca el asiento como ocupado en
                                                                                // busarray
                                    pasajeros[Integer.parseInt(asiento)] = nuevoPasajero; // Añade el pasajero al array
                                                                                          // pasajeros
                                }

                                int respuesta = JOptionPane.showConfirmDialog(null, "Desea continuar?", "Confirmación",
                                        JOptionPane.YES_NO_OPTION);
                                if (respuesta == JOptionPane.NO_OPTION) {
                                    opcion = 5;
                                }
                            }
                        }

                    } catch (NullPointerException e) {
                        JOptionPane.showMessageDialog(null, "Se produjo un error: " + e.getMessage());
                    } finally {
                        // Add your code here if needed
                    }
                }
                case 5 -> {

                    JOptionPane.showMessageDialog(null, "Saliendo del sistema...");
                }
                default -> {
                    JOptionPane.showMessageDialog(null, "Opcion incorrecta");
                }
            }
        } while (opcion != 5);

    }

}
