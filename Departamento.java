public class Departamento {
    private String nombre;
    private String ubicacion; // Matriz o Sucursal
    private Empleado[] empleados = new Empleado[5];
    private int cantidad = 0;

    public Departamento(String nombre, String ubicacion) {
        this.nombre = nombre;
        this.ubicacion = ubicacion;
    }

    public String getNombre() {
        return nombre;
    }

    // false si ya hay 5 empleados
    public boolean agregarEmpleado(Empleado e) {
        if (cantidad == 5) {
            return false;
        }
        empleados[cantidad++] = e;
        return true;
    }

    // null si no lo encuentra
    public Empleado buscarEmpleado(int id) {
        for (int i = 0; i < cantidad; i++) {
            if (empleados[i].getId() == id) {
                return empleados[i];
            }
        }
        return null;
    }

    public void mostrar() {
        System.out.println(nombre + " (" + ubicacion + ") - " + cantidad + "/5 empleados");
        for (int i = 0; i < cantidad; i++) {
            empleados[i].mostrar();
        }
    }
}
