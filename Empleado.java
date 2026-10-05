public class Empleado {
    private String nombre;
    private int id; // 5 digitos

    public Empleado(String nombre, int id) {
        this.nombre = nombre;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void mostrar() {
        System.out.println("   ID: " + id + " | Nombre: " + nombre);
    }
}
