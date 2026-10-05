import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static Departamento[] deptos = new Departamento[10];
    static int total = 0;

    public static void main(String[] args) {
        int op;
        do {
            System.out.println("\n1. Registrar departamento\n2. Registrar empleado");
            System.out.println("3. Consultar empleado\n4. Mostrar todo\n5. Salir");
            System.out.print("Opcion: ");
            op = Integer.parseInt(sc.nextLine());

            if (op == 1) {
                System.out.print("Nombre: ");
                String n = sc.nextLine();
                System.out.print("Ubicacion (Matriz/Sucursal): ");
                deptos[total++] = new Departamento(n, sc.nextLine());
            } else if (op == 2) {
                Departamento d = buscar();
                if (d != null) {
                    System.out.print("Nombre completo: ");
                    String n = sc.nextLine();
                    System.out.print("ID (5 digitos): ");
                    int id = Integer.parseInt(sc.nextLine());
                    if (id < 10000 || id > 99999) {
                        System.out.println("El ID debe ser de 5 digitos");
                    } else if (d.buscarEmpleado(id) != null) {
                        System.out.println("Ese ID ya existe");
                    } else if (!d.agregarEmpleado(new Empleado(n, id))) {
                        System.out.println("El departamento ya tiene 5 empleados");
                    }
                }
            } else if (op == 3) {
                Departamento d = buscar(); // primero se filtra por departamento
                if (d != null) {
                    System.out.print("ID del empleado: ");
                    Empleado e = d.buscarEmpleado(Integer.parseInt(sc.nextLine()));
                    if (e == null) {
                        System.out.println("No se encontro");
                    } else {
                        e.mostrar();
                    }
                }
            } else if (op == 4) {
                for (int i = 0; i < total; i++) {
                    deptos[i].mostrar();
                }
            }
        } while (op != 5);
    }

    static Departamento buscar() {
        System.out.print("Departamento: ");
        String n = sc.nextLine();
        for (int i = 0; i < total; i++) {
            if (deptos[i].getNombre().equalsIgnoreCase(n)) {
                return deptos[i];
            }
        }
        System.out.println("Ese departamento no existe");
        return null;
    }
}
