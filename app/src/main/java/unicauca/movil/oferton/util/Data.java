package unicauca.movil.oferton.util;


import java.util.ArrayList;
import java.util.List;

import unicauca.movil.oferton.models.Novedad;

public class Data {

    private static List<Novedad> novedades;
    public static List<Novedad> getNovedades(){
        if(novedades ==  null){
            novedades =  new ArrayList<>();

            Novedad n1 = new Novedad();
            n1.setNombre("Guayos Nike");
            n1.setAlmacen("Nike");
            n1.setTipo("Deportes");
            n1.setImagen("http://www.sport-style.by/assets/components/phpthumbof/cache/b72e89145b293f5c583fa78512705c2d.c948e6f8e2e597206f400f32718d2435700.jpg");
            n1.setPrecio("150000");
            n1.setVigencia("15 de Julio");
            n1.setDescripcion("Aproveche el gran descuento en guayos nike solo por este mes, no se quede sin ellos, mochila incluida");

            Novedad n2 = new Novedad();
            n2.setNombre("Chevignon Hot Sale");
            n2.setAlmacen("Chevignon");
            n2.setTipo("Ropa");
            n2.setImagen("https://cazaofertas.com.co/wp-content/uploads/2016/04/oferta-25.jpg");
            n2.setPrecio("50000");
            n2.setVigencia("20 de agosto");
            n2.setDescripcion("Descuentos hasta el 60% en todos los almacenes del pais, aproveche el remate de coleccion");

            Novedad n3 = new Novedad();
            n3.setNombre("Sandwich Qbano Especial");
            n3.setAlmacen("Qbano");
            n3.setTipo("Comida");
            n3.setImagen("https://static0.tiendeo.com.co/images/tiendas/7863/catalogos/138779/paginas/mid2/00001.jpg");
            n3.setPrecio("7900");
            n3.setVigencia("30 de Junio");
            n3.setDescripcion("Disfrute de un delicioso sandwich Qbano especial por el como precio de 7900 todos los mates hasta el 31 de julio, reclame bono 2 x 1");

            Novedad n4 = new Novedad();
            n4.setNombre("Lavadora LG 26");
            n4.setAlmacen("Electromillonaria");
            n4.setTipo("Electrodomesticos");
            n4.setImagen("https://electrojaponesa.vteximg.com.br/arquivos/ids/160147/LavadoraLG.jpg");
            n4.setPrecio("929000");
            n4.setVigencia("1 de Julio");
            n4.setDescripcion("Aproveche y lleve una espectacular lavadora, 12 Kg, el decuento solo aplica para compras en linea");

            Novedad n5 = new Novedad();
            n5.setNombre("Promocion Cinemark");
            n5.setAlmacen("Cinemark");
            n5.setTipo("Cine");
            n5.setImagen("http://revistaelcrisol.com/wp-content/uploads/2015/09/unnamed.jpg");
            n5.setPrecio("10000");
            n5.setVigencia("11 de Julio");
            n5.setDescripcion("Disfrute de todos los beneficios que brinda la tarjeta Gold Cinemar, no se quede sin ella, valida en todos los cinemas del pain.");


            novedades.add(n1);
            novedades.add(n2);
            novedades.add(n3);
            novedades.add(n4);
            novedades.add(n5);
        }
        return  novedades;

    }

}
