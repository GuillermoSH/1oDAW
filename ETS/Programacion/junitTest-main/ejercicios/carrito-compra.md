<div align="justify">

# Carrito la compra (Javadocs && Testing)

</br>

<div align="center">
  <img src="https://juguettos.com/2836345-large_default/A0077397.jpg" width="400px" />
</div>

</br>

## Introducción

Vamos a implementar un carrito la compra simple basada en la siguiente información.

```
codigo;descripcion;pcompra;pventa;stock
h001;Varilla roscada 0.50m.;7.00;10.00;9
h005;Caja tuercas 16mm.;21.00;25.05;20
h006;Chapa galvanizada;10.50;20.55;3
h007;Barra para cortina 2,00 m.;10.30;22.33;5
h008;Perfil metalico en L longitud 2m.;23.30;32.50;5
h009;Perfil metalico en U longitud 3m.;28.30;52.50;10
h020;Barra acero 16mm. longitud 6m.;35.30;45.40;50
m001;Estantería para pared.;25.30;30.60;5
m002;Tablero pino 1x2m.;10.00;15.00;20
m003;Puerta paso 0.72m.;85.50;110.55;5
m004;Puerta de 0.62m.;70.50;90.50;10
m005;Puerta blindada 0.82m.;205.81;258.33;2
m006;Puerta doble hoja 1.2m.;140.50;192.30;3
```

Cada línea de este fichero representa un producto que se puede agregar al carrito.

También se te entrega un fichero con los productos comprados por un cliente:

```
codigo_prod;cantidad
h001;3
h006;2
h007;1
h020;5
m001;2
m002;1
m005;3
m006;4
h001;1
h006;1
h007;1
m005;1
m006;2
```

El programa permitirá realizar tener una salida similar a la siguiente:
```
-------- ----------------------------------- -------- --------------- --------

Producto Descripción Cantidad Precio Unitario Subtotal

-------- ----------------------------------- -------- --------------- --------

h001 Varilla roscada 0.50m. 4 10,00 40,00

h006 Chapa galvanizada 3 20,55 61,65

h007 Barra para cortina 2,00 m. 2 22,33 44,66

h020 Barra acero 16mm. longitud 6m. 5 45,40 227,00

m001 Estantería para pared. 2 30,60 61,20

m002 Tablero pino 1x2m. 1 15,00 15,00

m005 Puerta blindada 0.82m. 4 258,33 1033,32

m006 Puerta doble hoja 1.2m. 6 192,30 1153,80

-------- ----------------------------------- -------- --------------- --------

Total Carro: 2636,63

-------- ----------------------------------- -------- --------------- --------
```

</div>
