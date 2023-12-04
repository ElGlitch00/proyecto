package Modelo;

public class Pasajero {
    private String nombre;
    private String apellidos;
    private String dni;
    private String asiento;
    private String puntoPartida;
    private String destino;

    public Pasajero(String nombre, String apellidos, String dni, String asiento, String puntoPartida, String destino) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.dni = dni;
        this.asiento = asiento;
        this.puntoPartida = puntoPartida;
        this.destino = destino;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getAsiento() {
        return asiento;
    }

    public void setAsiento(String asiento) {
        this.asiento = asiento;
    }

    public void setPuntoPartida(String puntoPartida) {
        this.puntoPartida = puntoPartida;
    }

    public String getPuntoPartida() {
        return this.puntoPartida;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getDestino() {
        return this.destino;
    }

    @Override
    public String toString() {
        return "Pasajero{" + "nombre=" + nombre + ", apellidos=" + apellidos + ", dni=" + dni + ", asiento=" + asiento
                + ", puntoPartida=" + puntoPartida + ", destino=" + destino + '}';
    }

    public void setPrecio(double double1) {
    }

    public void setFechaVenta(String fechaVenta) {
    }
}
