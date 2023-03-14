## Challenge Conversor

Este es un challenge para ONE Oracle el cual consiste en crear un conversor de divisas mediante Java.
Como plus, se agrega un conversor de temperaturas y uno de logitudes.

## Estructura de las carpetas

El espacio de trabajo contiene dos una carperta principal(conversor) la cual contiene las clases y los packages que ejecutan el programa.

- `src/com/conversor`: Se encuentra la clase principal donde estan creados los elementos de la ventana, con sus respectivas aplicaciones.
- `src/com/conversor/model`: Se encuentran los packages aplicados para convertir las divisas, longitudes y temperaturas.
<br>

## Aplicacion de Conversor

En primera instancia, iniciamos nuestra aplicacion con un JOpcionPane.ShowInputDialog el cual, dependiendo de lo que elijamos
modificara lo que nuestro JFrame nos muestre a continuacion. <br> <br>
![conversor-principal](https://user-images.githubusercontent.com/95766371/224886144-4f88f7c5-7441-4858-92d4-e9a3b70c0d32.png)
<br> <br>
Cada una de estas opciones estan ligadas a un package el cual contiene formulas determinadas para cada una, las cuales actuaran como
conversores de moneda, longitud y temperatura. <br> <br>
![packages](https://user-images.githubusercontent.com/95766371/224886943-460332ab-9093-4e83-ac0b-b916f42ca175.png)
<br> <br>
Por ej, si seleccionamos la opcion de temperatura, la aplicacion utilizara las formulas escritas en el package para generar las conversiones. <br>
![opcion temperatura](https://user-images.githubusercontent.com/95766371/224887684-c1a649f2-d103-44e8-b53e-4de9fc206d91.png) <br>

![package longitud](https://user-images.githubusercontent.com/95766371/224887699-ee769426-9c18-4c06-ba12-6c1ed757ebc4.png)
