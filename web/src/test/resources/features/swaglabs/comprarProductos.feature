# language: es

Característica: Comprar productos en la pagina SauceDemo
  Como usuario de la plataforma
  Quiero seleccionar diferentes productos
  Para realizar la compra

  Antecedentes:
    Dado 'juan' ingresa a la pagian de SauceDemo
    Cuando ingresa usuario 'standard_user' y clave 'secret_sauce'

  Escenario: Realizar seleccion y compra de diferentes productos
    Cuando realiza el filtro por 'Price (low to high)' para adiciona los productos al carrito de compras
      | producto                 |
      | Sauce Labs Bike Light    |
      | Sauce Labs Fleece Jacket |
      | Sauce Labs Onesie        |
    Y observa los productos agragdos al carrito de compras
    Entonces ingresa su informacion personal
    Y observa la factura para finalizar el pedido
