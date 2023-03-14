## Challenge Conversor

Este es un challenge para ONE Oracle el cual consiste en crear un conversor de divisas mediante Java.
Como plus, se agrega un conversor de temperaturas y uno de logitudes.

## Estructura de las carpetas

El espacio de trabajo contiene dos una carperta principal(conversor) la cual contiene las clases y los packages que ejecutan el programa.

- `src/com/conversor`: Se encuentra la clase principal donde estan creados los elementos de la ventana, con sus respectivas aplicaciones.
- `src/com/conversor/model`: Se encuentran los packages aplicados para convertir las divisas, longitudes y temperaturas.
<br>

## Aplicacion de Conversor

Para el menu de opciones el cual determinara que convertiremos se utiliza un JOptionPane.ShowInputDialog <br> <br>
![conversor-principal](https://user-images.githubusercontent.com/95766371/224886144-4f88f7c5-7441-4858-92d4-e9a3b70c0d32.png)
<br> <br>
Cada una de estas opciones estan ligadas a un package el cual contiene metodos para cada conversion, los cuales podremos utilizar mediante el nombre de su package. <br> <br>
![packages](https://user-images.githubusercontent.com/95766371/224886943-460332ab-9093-4e83-ac0b-b916f42ca175.png)
<br> <br>

Por ej, si seleccionamos la opcion de temperatura, la aplicacion utilizara las formulas escritas en el package para generar las conversiones. <br>

![metodotemperatura1](https://user-images.githubusercontent.com/95766371/225162098-7933b14c-86ec-4ed9-8bc8-51fe52cb9567.png)
<br> <br>
 ![metodotemperatura2](https://user-images.githubusercontent.com/95766371/225162358-41f5029b-2ed4-4672-bccb-3b07b365e583.png)
<br> <br>
![opcion temperatura](https://user-images.githubusercontent.com/95766371/225162557-a8b6ae09-9924-4556-a96e-048b6df5833d.png)
