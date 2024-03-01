### Escuela Colombiana de Ingeniería

### Ciclo de Vida de Desarrollo de Software

### Desarrollo Dirigido por Pruebas + DIP + DI

Para este taller se va a trabajar sobre el juego del ahorcado.

El sistema actual de puntuación del juego comienza en 100 puntos y va
descontando 10 puntos cada vez que se propone una letra incorrecta.

Algunos usuarios han propuesto diferentes esquemas para realizar la
puntuación, los cuales se describen a continuación:

* OriginalScore:
    * Es el esquema actual, se inicia con 100 puntos.
    * No se bonifican las letras correctas.
    * Se penaliza con 10 puntos con cada letra incorrecta.
    * El puntaje minimo es 0.

* BonusScore:
    * El juego inicia en 0 puntos.
    * Se bonifica con 10 puntos cada letra correcta.
    * Se penaliza con 5 puntos cada letra incorrecta.
    * El puntaje mínimo es 0

* PowerBonusScore:
    * El juego inicia en 0 puntos.
    * La $i-ésima$ letra correcta se bonifica con $5^i$.
    * Se penaliza con 8 puntos cada letra incorrecta.
    * El puntaje mínimo es 0
    * Si con las reglas anteriores sobrepasa 500 puntos, el puntaje es
        500.

Lo anterior, se traduce en el siguiente modelo, donde se aplica el
principio de inversión de dependencias:

![imagen](img/model.png)

### Parte I

1. Haga un fork del proyecto (no lo descargue directamente!).

2. A partir del código existente, implemente sólo los cascarones del
   modelo antes indicado.

4. Haga la especificación de los métodos calculateScore (de las tres
   variantes de GameScore), a partir de las especificaciones
   generales dadas anteriormente. Recuerde tener en cuenta: @pre,
   @pos, @param, @throws.

![image2][2]
![image3][3]
![image4][4]

5. Haga commit de lo realizado hasta ahora. Desde la terminal:

    ```sh		
    git add .			
    git commit -m "especificación métodos"
    ```
![image6][6]

6. Actualice el archivo `pom.xml` e incluya las dependencias para la ultima versión de JUnit.

![image5][5]

7. Teniendo en cuenta dichas especificaciones, en la clase donde se
   implementarán las pruebas (GameScoreTest), en los
   comentarios iniciales, especifique las clases de equivalencia para
   las tres variantes de GameScore, e identifique
   condiciones de frontera.

![image7][7]
![image8][8]
![image8][9]

8. Para cada clase de equivalencia y condición de frontera, implemente
   una prueba utilizando JUnit.

![image10][10]
![image11][11]
![image12][12]

9. Haga commit de lo realizado hasta ahora. Desde la terminal:

    ```sh		
    git add .			
    git commit -m "implementación pruebas"
    ```
    
![image13][13]

10. Realice la implementación de los 'cascarones' realizados anteriormente.
   Asegúrese que todas las pruebas unitarias creadas en los puntos anteriores
   se ejecutan satisfactoriamente.

![image14][14]
![image15][15]
![image16][16]

11. Al finalizar haga un nuevo commit:

    ```sh		
    git add .			
    git commit -m "implementación del modelo"
    ```

12. Para sincronizar el avance en el respositorio y NO PERDER el trabajo, use
    el comando de GIT para enviar los cambios:

    ```sh
    git push origin main
    ```


### Parte II

Actualmente se utiliza el patrón FactoryMethod
que desacopla la creación de los objetos para diseñar un juego
de ahorcado (revisar setup.factoryMethod, el
constructor de la clase GUI y HangmanFactoryMethod).

1. Utilizando el HangmanFactoryMethod (MétodoFabrica) incluya el
   OriginalScore a la configuración.

* Mediante la configuración de la Inyección de
  Dependencias se pueda cambiar el comportamiento del mismo, por
  ejemplo:
    * Utilizar el esquema OriginalScore.
    * Utilizar el esquema BonusScore.
    * Utilizar el idioma francés.
    * Utilizar el diccionario francés.
    * etc...
  
[1]: https://github.com/MiltonGutierrez/LAB04-CVDS/blob/main/resources/1.png
[2]: https://github.com/MiltonGutierrez/LAB04-CVDS/blob/main/resources/2.png
[3]: https://github.com/MiltonGutierrez/LAB04-CVDS/blob/main/resources/3.png
[4]: https://github.com/MiltonGutierrez/LAB04-CVDS/blob/main/resources/4.png
[5]: https://github.com/MiltonGutierrez/LAB04-CVDS/blob/main/resources/5.png
[6]: https://github.com/MiltonGutierrez/LAB04-CVDS/blob/main/resources/metodos.png
[7]: https://github.com/MiltonGutierrez/LAB04-CVDS/blob/main/resources/OriginalScore%20Test.PNG
[8]: https://github.com/MiltonGutierrez/LAB04-CVDS/blob/main/resources/BonusScore%20Test.PNG
[9]: https://github.com/MiltonGutierrez/LAB04-CVDS/blob/main/resources/PowerScore%20Test.PNG
[10]: https://github.com/MiltonGutierrez/LAB04-CVDS/blob/main/resources/Pruebas%20Original.PNG
[11]: https://github.com/MiltonGutierrez/LAB04-CVDS/blob/main/resources/Pruebas%20Bonus.PNG
[12]: https://github.com/MiltonGutierrez/LAB04-CVDS/blob/main/resources/Pruebas%20PB.PNG
[13]: https://github.com/MiltonGutierrez/LAB04-CVDS/blob/main/resources/implemetacion%20pruebas.png
[14]: https://github.com/MiltonGutierrez/LAB04-CVDS/blob/main/resources/PowerI.PNG
[15]: https://github.com/MiltonGutierrez/LAB04-CVDS/blob/main/resources/OriginalI.PNG
[16]: https://github.com/MiltonGutierrez/LAB04-CVDS/blob/main/resources/BonusI.PNG
