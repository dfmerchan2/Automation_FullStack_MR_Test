#language: es

Característica: Realizar una operaciones matemáticas en la calculadora de Windows
  Yo como Usuario
  Quiero abrir la calculadora
  Para realizar las operaciones básicas

  Escenario: Operación de "Suma" Exitosa
    Dado que "Diego" abre la aplicación de la calculadora
    Cuando realiza la operación de "suma" con los valores "20" y "5"
    Entonces debería de observar el resultado igual a "25"

  Escenario: Operación de "Resta" Exitosa
    Dado que "Diego" abre la aplicación de la calculadora
    Cuando realiza la operación de "resta" con los valores "10" y "6"
    Entonces debería de observar el resultado igual a "5"

  Escenario: Operación de "Multiplicación" Exitosa
    Dado que "Diego" abre la aplicación de la calculadora
    Cuando realiza la operación de "multiplicación" con los valores "10" y "6"
    Entonces debería de observar el resultado igual a "60"

  Escenario: Operación de "Division" Exitosa
    Dado que "Diego" abre la aplicación de la calculadora
    Cuando realiza la operación de "división" con los valores "100" y "5"
    Entonces debería de observar el resultado igual a "20"