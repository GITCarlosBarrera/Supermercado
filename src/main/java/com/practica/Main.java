package com.practica;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.practica.Productos.Cereal;
import com.practica.Productos.Detergente;
import com.practica.Productos.Producto;
import com.practica.Productos.Vino;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int index = -1;
        List<Producto> productos = new ArrayList<>();

        // Caso de ejemplo
        generarProductosEjemplo(productos);

        while (index != 3) {
            System.out.println("Seleccione el acceso al supermercado:");
            System.out.println("1. Empleado");
            System.out.println("2. Cliente");
            System.out.println("3. Salir");
            System.out.print("> ");

            try {
                index = scanner.nextInt();
                scanner.nextLine();
            } catch (Exception e) {
                System.out.println("Entrada no válida. Introduzca un número.");    
                scanner.nextLine();
                index = -1;
                continue;
            }

            System.out.println();
            switch (index) {
                case 1:
                    // Acceso de empleado
                    menuEmpleado(scanner, productos);
                    break;
                case 2:
                    // Acceso de cliente
                    menuCliente(scanner, productos);
                    break;
                case 3:
                    System.out.println("Saliendo del supermercado...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
                    break;
            }
        }

        scanner.close();
    }

    // Métodos de empleado
    public static void generarProductosEjemplo(List<Producto> productos) {
        // Detergentes
        Detergente d1 = new Detergente("Ariel", 3.99f);
        Detergente d2 = new Detergente("Colon", 2.99f);
        Detergente d3 = new Detergente("Skip", 4.49f, 5.5f, "Garrafa", 0);
        Detergente d4 = new Detergente("Flota", 2.49f, 1.5f, "Botella", 10.5f);

        // Vinos
        Vino v1 = new Vino("Rioja", 7.99f, "Tinto", 14.5f);
        Vino v2 = new Vino("Ribera", 8.49f, "Tinto", 15);
        Vino v3 = new Vino("Albariño", 6.99f, "Blanco", 11.5f, 1, "Botella de cristal", 15);
        Vino v4 = new Vino("Verdejo", 5.99f, "Blanco", 12.5f, 1.5f, "Tetra brik", 11.5f);

        // Cereales
        Cereal c1 = new Cereal("NaturGreen", 2.99f, "Maiz");
        Cereal c2 = new Cereal("El Granero Integral", 3.49f, "Mijo");
        Cereal c3 = new Cereal("Biográ", 3.99f, "Trigo");
        Cereal c4 = new Cereal("El Granero Integral", 4.29f, "Espelta");

        productos.add(d1);
        productos.add(d2);
        productos.add(d3);
        productos.add(d4);

        productos.add(v1);
        productos.add(v2);
        productos.add(v3);
        productos.add(v4);

        productos.add(c1);
        productos.add(c2);
        productos.add(c3);
        productos.add(c4);
    }

    public static void menuEmpleado(Scanner scanner, List<Producto> productos) {
        int index = -1;

        while (index != 4) {
            System.out.println("Seleccione que desea hacer:");
            System.out.println("1. Añadir un producto");
            System.out.println("2. Eliminar un producto");
            System.out.println("3. Ver productos");
            System.out.println("4. Salir");
            System.out.print("> ");

            try {
                index = scanner.nextInt();
                scanner.nextLine();
            } catch (Exception e) {
                System.out.println("Entrada no válida. Introduzca un número.");    
                scanner.nextLine();
                index = -1;
                continue;
            }

            System.out.println();
            switch (index) {
                case 1:
                    seleccionAnyadirProducto(scanner, productos);
                    System.out.println();
                    break;
                case 2:
                    borrarProducto(scanner, productos);
                    System.out.println();
                    break;
                case 3:
                    int cont = 1;
                    for (Producto p : productos) {
                        System.out.println(cont + ". " + p.toSimpleString());
                        cont++;
                    }
                    break;
                case 4:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
                    break;
            }
        }
    }

    public static void seleccionAnyadirProducto(Scanner scanner, List<Producto> productos) {
        int index = -1;

        System.out.println("Seleccione el tipo de producto para añadir:");
        System.out.println("1. Detergente");
        System.out.println("2. Vino");
        System.out.println("3. Cereal");
        System.out.println("4. Salir");
        System.out.print("> ");
        
        while (index < 1 || index > 4) {
            try {
                index = scanner.nextInt();
                scanner.nextLine();
            } catch (Exception e) {
                System.out.println("Entrada no válida. Introduzca un número.");    
                scanner.nextLine();
                index = -1;
                continue;
            }

            System.out.println();
            switch (index) {
                case 1:
                    productos.add(anyadirDetergente(scanner)); // Añade un nuevo detergente a la lista
                    break;
                case 2:
                    productos.add(anyadirVino(scanner)); // Añade un nuevo vino a la lista
                    break;
                case 3:
                    productos.add(anyadirCereal(scanner)); // Añade un nuevo cereal a la lista
                    break;
                case 4:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
                    break;
            }
        }
    }

    public static Detergente anyadirDetergente(Scanner scanner) {
        String marca = "", tipoEnvase = "";
        float  precio = 0, volumen = 0, descuento = 0;

        while (marca == "" || precio == 0) {
            try {
                System.out.print("Marca: ");
                marca = scanner.nextLine();

                System.out.print("Precio: ");
                precio = scanner.nextFloat();
                scanner.nextLine();
                
                System.out.print("Volumen: ");
                volumen = scanner.nextFloat();
                scanner.nextLine();

                System.out.print("Tipo de envase: ");
                tipoEnvase = scanner.nextLine();

                System.out.print("Descuento (%): ");
                descuento = scanner.nextFloat();
                scanner.nextLine();
            } catch (Exception e) {
                System.out.println("Entrada no válida. Introduzca los valores correctos.");    
                scanner.nextLine();
                marca = "";
                precio = 0;
                continue;
            }
        }

        if (tipoEnvase == "" || volumen <= 0 || descuento <= 0) {
            return new Detergente(marca, precio);
        } else {
            return new Detergente(marca, precio, volumen, tipoEnvase, descuento);
        }
    }

    public static Vino anyadirVino(Scanner scanner) {
        String marca = "", tipoEnvase = "";
        float  precio = 0, volumen = 0, descuento = 0, gradosAlcohol = 0;

        while (marca == "" || precio == 0 || gradosAlcohol == 0) {
            try {
                System.out.print("Marca: ");
                marca = scanner.nextLine();

                System.out.print("Precio: ");
                precio = scanner.nextFloat();
                scanner.nextLine();

                System.out.print("Grados de alcohol: ");
                gradosAlcohol = scanner.nextFloat();
                scanner.nextLine();
                
                System.out.print("Volumen: ");
                volumen = scanner.nextFloat();
                scanner.nextLine();

                System.out.print("Tipo de envase: ");
                tipoEnvase = scanner.nextLine();

                System.out.print("Descuento (%): ");
                descuento = scanner.nextFloat();
                scanner.nextLine();
            } catch (Exception e) {
                System.out.println("Entrada no válida. Introduzca los valores correctos.");    
                scanner.nextLine();
                marca = "";
                precio = 0;
                gradosAlcohol = 0;
                continue;
            }
        }

        if (tipoEnvase == "" || volumen <= 0 || descuento <= 0) {
            return new Vino(marca, precio, tipoEnvase, gradosAlcohol);
        } else {
            return new Vino(marca, precio, marca, gradosAlcohol, volumen, tipoEnvase, descuento);
        }
    }

    public static Cereal anyadirCereal(Scanner scanner) {
        String marca = "", tipoCereal = "";
        float  precio = 0;

        while (marca == "" || precio == 0 || tipoCereal == "") {
            try {
                System.out.print("Marca: ");
                marca = scanner.nextLine();

                System.out.print("Precio: ");
                precio = scanner.nextFloat();
                scanner.nextLine();

                System.out.print("Tipo de cereal: ");
                tipoCereal = scanner.nextLine();
            } catch (Exception e) {
                System.out.println("Entrada no válida. Introduzca los valores correctos.");    
                scanner.nextLine();
                marca = "";
                precio = 0;
                tipoCereal = "";
                continue;
            }
        }

        return new Cereal(marca, precio, tipoCereal);
    }

    public static void borrarProducto(Scanner scanner, List<Producto> productos) {
        int index = -1, cont = 1;

        for (Producto p : productos) {
            System.out.println(cont + ". " + p.toSimpleString());
            cont++;
        }

        while (index < 0 || index > productos.size()) {
            System.out.println("Introduzca el id del producto a eliminar ('0' para salir):");
            System.out.print("> ");

            try {
                index = scanner.nextInt();
                scanner.nextLine();
            } catch (Exception e) {
                System.out.println("Entrada no válida. Introduzca un número.");    
                scanner.nextLine();
                index = -1;
                continue;
            }

            if (index < 0 || index > productos.size()) System.out.println("Opción no válida. Intente nuevamente.");
        }

        if (index > 0) {
            productos.remove(index - 1);
            System.out.println("Producto eliminado.");
        } else {
            System.out.println("Saliendo...");
        }
    }

    // Métodos de cliente
    public static void menuCliente(Scanner scanner, List<Producto> productos) {
        List<Producto> listaCompras = new ArrayList<>();
        int index = -1;

        while (index != 3) {
            System.out.println("Seleccione que desea hacer:");
            System.out.println("1. Comprar productos");
            System.out.println("2. Ver lista de compras");
            System.out.println("3. Salir");
            System.out.print("> ");

            try {
                index = scanner.nextInt();
                scanner.nextLine();
            } catch (Exception e) {
                System.out.println("Entrada no válida. Introduzca un número.");    
                scanner.nextLine();
                index = -1;
                continue;
            }

            System.out.println();
            switch (index) {
                case 1:
                    comprarProductos(scanner, productos, listaCompras);
                    System.out.println();
                    break;
                case 2:
                    verListaCompras(scanner, listaCompras);
                    System.out.println();
                    break;
                case 3:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
                    break;
            }
        }
    }    

    public static void comprarProductos(Scanner scanner, List<Producto> productos, List<Producto> listaCompras) {
        int index = -1, cont = 1;

        for (Producto p : productos) {
            System.out.println(cont + ". " + p.toString() + "\n------------------------");
            cont++;
        }

        while (index < 0 || index > productos.size()) {
            System.out.println("Introduzca el id del producto a comprar ('0' para salir):");
            System.out.print("> ");

            try {
                index = scanner.nextInt();
                scanner.nextLine();
            } catch (Exception e) {
                System.out.println("Entrada no válida. Introduzca un número.");    
                scanner.nextLine();
                index = -1;
                continue;
            }

            if (index < 0 || index > productos.size()) System.out.println("Opción no válida. Intente nuevamente.");
        }

        if (index > 0) {
            listaCompras.add(productos.get(index - 1));
            System.out.println("Producto añadido a la lista de compras.");
        } else {
            System.out.println("Saliendo...");
        }
    }

    public static void verListaCompras(Scanner scanner, List<Producto> listaCompras) {
        int cont = 1;

        if (listaCompras.isEmpty()) {
            System.out.println("No hay productos en la lista de compras.");
            return;
        }

        for (Producto p : listaCompras) {
            System.out.println(cont + ". " + p.toSimpleString());
            cont++;
        }

        System.out.println("Calorias totales: " + calcularCalorias(listaCompras) + " cal");
        System.out.println("Total: " + calcularTotal(listaCompras) + "€");
    }

    public static int calcularCalorias(List<Producto> listaCompras) {
        int caloriasTotales = 0;

        for (Producto p : listaCompras) {
            if (p instanceof Vino) {
                Vino v = (Vino) p;
                caloriasTotales += v.getCalorias();
            } else {
                if (p instanceof Cereal) {
                    Cereal c = (Cereal) p;
                    caloriasTotales += c.getCalorias();
                }
            }
        }

        return caloriasTotales;
    }

    public static float calcularTotal(List<Producto> listaCompras) {
        float total = 0;

        for (Producto p : listaCompras) {
            if (p instanceof Vino) {
                Vino v = (Vino) p;
                total += v.getPrecioDescuento();
            } else {
                if (p instanceof Detergente) {
                    Detergente d = (Detergente) p;
                    total += d.getPrecioDescuento();
                } else {
                    total += p.getPrecio();
                }
            }
        }

        return Math.round(total * 100) / 100.0f;
    }
}