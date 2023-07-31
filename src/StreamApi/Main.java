package StreamApi;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        List<Producto> productoList = Arrays.asList(
                new Producto("Arroz", 30.5, "Alimentos", 50),
                new Producto("Leche", 20.0, "Alimentos", 0),
                new Producto("Laptop", 1500.0, "Electrónicos", 10),
                new Producto("TV", 800.0, "Electrónicos", 5),
                new Producto("Mesa", 120.0, "Hogar", 15)
                );

        List<Producto> stocksMayores = productoList.stream()
                .filter(pro -> pro.getStock() > 0 && pro.getPrecio() < 50)
                .collect(Collectors.toList());

        System.out.println("LISTA con Stock mayor a 0 y con precio menor a 50");
        System.out.println(stocksMayores.toString());

        List<Producto> listaAlimentos = productoList.stream()
                        .filter(producto -> producto.getCategoria() == "Alimentos")
                                .collect(Collectors.toList());

        System.out.print("El precio total de los productos es: ");
        System.out.println((Double) productoList.stream().mapToDouble(Producto::getPrecio).sum() + "\n");

        System.out.println("LISTA DE NOMBRES DE LA CATEGORIA 'Alimentos' ");
        for (Producto producto: listaAlimentos) {
            System.out.println(producto.getNombre());
        }

        System.out.println("\nLISTA DE PRODUCTOS\n");
        for (Producto producto: productoList) {
            System.out.println(producto.toString() + "\n");
        }

    }

}