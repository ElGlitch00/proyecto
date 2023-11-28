/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package mkx;

import java.util.Scanner;

/**
 *
 * @author LAB-USR-LN6377-B0802
 */
public class MkX {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int opcion;
        //System.out.print("Punto de partida");
        //String partida=entrada.nextLine();
        //System.out.print("Destino");
        //String destino=entrada.nextLine();
        String menu = """
                 Menu opciones
                 1.Igrese sus datos
                 2.Ingrese su punto de partida
                 3.Ingrese su destino
                 4. salir
                 """;
        do {
            System.out.println(menu);
            opcion = entrada.nextInt();
            switch (opcion) {
                case 1 -> {
                    System.out.println("Ingrese su nombre y apellidos");
                    String nombre = entrada.nextLine();
                    System.out.println("Ingrese su DNI");
                    int dni = entrada.nextInt();
                    entrada.nextLine();
                }
                case 2 -> {
                    String menu_partida = """
                 Menu opciones
                 1.Lima
                 2.Cañete               
                 3.Chincha
                 """;
                    System.out.println(menu_partida);
                    int opcion_partida = entrada.nextInt();
                    switch (opcion_partida) {
                        case 1 -> {
                            System.out.println("Haz seleccionado Lima");
                            System.out.println("Haz seleccionado Lima");
                        }
                        case 2 -> {
                            System.out.println("Haz seleccionado Cañete");

                        }
                        case 3 -> {
                            System.out.println("Haz seleccionado Chincha");

                        }
                        default -> {
                            System.out.println("Opcion incorrecta");

                        }

                    }

                }
                case 3 -> {
                    System.out.print("Destino");
                    String destino = entrada.nextLine();
                }
                case 4 -> {
                    System.out.println("salieno del sistema");
                }

            }
        }
        }
}
    