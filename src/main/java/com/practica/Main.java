package com.practica;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.practica.Productos.Cereal;
import com.practica.Productos.Detergente;
import com.practica.Productos.Producto;
import com.practica.Productos.Vino;

/**
 * Clase principal del programa de gestión de supermercado.
 *
 * @author Carlos Barrera Babilon
 * @version 1.1
 */
public class Main {
    
    /**
     * Método principal que inicia la ejecución del programa.
     * Crea una lista de productos, permite al usuario añadir, mostrar o eliminar productos
     * y seleccionar entre acceso de empleado, cliente o salir, mediante un menú por consola.
     *
     * @param args Argumentos de línea de comandos (no utilizados).
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int index = -1;
        List<Producto> productos = new ArrayList<>();

        generarProductosEjemplo(productos); // Caso de prueba

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

    /**
     * Genera varios productos de ejemplo para realizar el caso de prueba.
     * 
     * @param productos Lista de productos disponibles en el supermercado.
     */
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

    // Métodos de empleado

    /**
    * Muestra el menú de opciones para el empleado.
    *
    * @param scanner Scanner para leer la entrada del usuario.
    * @param productos Lista de productos disponibles en el supermercado.
    */
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


    /**
    * Muestra el menú de seleccion de tipo de producto y añade el producto.
    *
    * @param scanner Scanner para leer la entrada del usuario.
    * @param productos Lista de productos disponibles en el supermercado.
    */
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


    /**
     * Solicita al usuario la información necesaria para crear un objeto de tipo Detergente.
     *
     * @param scanner Scanner utilizado para leer la entrada del usuario.
     * @return Un nuevo objeto de tipo Detergente.
     */
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

    /**
     * Solicita al usuario la información necesaria para crear un objeto de tipo Vino.
     *
     * @param scanner Scanner utilizado para leer la entrada del usuario.
     * @return Un nuevo objeto de tipo Vino.
     */
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


    /**
     * Solicita al usuario la información necesaria para crear un objeto de tipo Cereal.
     *
     * @param scanner Scanner utilizado para leer la entrada del usuario.
     * @return Un nuevo objeto de tipo Cereal.
     */
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


    /**
     * Muestra los productos disponibles en la lista con un número identificador
     * y permite al usuario seleccionar uno para eliminarlo.
     *
     * @param scanner Scanner utilizado para leer la entrada del usuario.
     * @param productos Lista de productos disponibles en el supermercado.
     */
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

    /**
     * Muestra el menú de opciones para el cliente.
     *
     * @param scanner Scanner para leer la entrada del usuario.
     * @param productos Lista de productos disponibles en el supermercado.
     */
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

    /**
    * Muestra los productos disponibles en la lista con un número identificador
    * y permite al usuario seleccionar uno para añadirlo a la lista de la compra.
    *
    * @param scanner Scanner para leer la entrada del usuario.
    * @param productos Lista de productos disponibles en el supermercado.
    * @param listaCompras Lista de compra del usuario que contiene los productos comprados.
    */
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

    /**
     * Muestra los productos añadidos a la lista de la compra junto con el precio total
     * aplicando los descuentos y la suma total de calorias que contienen los alimentos.
     * 
     * @param scanner Scanner para leer la entrada del usuario.
     * @param listaCompras Lista de compra del usuario que contiene los productos comprados.
     */
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

    /**
     * Recorre todos los productos de la lista y suma la cantidad de calorias de aquellos que son alimentos.
     * 
     * @param listaCompras Lista de compra del usuario que contiene los productos comprados.
     * @return Total de calorias entre todos los alimentos.
     */
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

    /**
     * Recorre todos los productos de la lista y suma el precio de cada uno con el descuento
     * incluido en caso de tenerlo.
     * 
     * @param listaCompras Lista de compra del usuario que contiene los productos comprados.
     * @return Total del precio de todos los productos.
     */
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