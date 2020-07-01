### Examen Mercado Libre
> Este problema consiste en determinar si una secuencia de AND pertenece a un mutante, En donde recibirás como parámetro un array de Strings que representan cada fila de una tabla
de (NxN) con la secuencia del ADN. Las letras de los Strings solo pueden ser: (A,T,C,G), las cuales representa cada base nitrogenada del ADN, Sabrás si un humano es mutante, si encuentras más de una secuencia de cuatro letras
iguales , de forma oblicua, horizontal o vertical

### Aclaratorias
> Este problema puede tener algunas variantes, ya que no se especifican algunos datos como por ejemplo, si solo acepta letras mayusculas, minisculas o numeros, por tanto el criterio tomado seria el siguiente, si la secuencias de cuatro letras pueden ser de la misma letra, en caso de ser la misma letra , se cuentan si estas se interceptan?, En funcion a ello plateo las diferentes limitantes o criterios:
 
 1. La secuencia de cuatro letras iguales no debe ser repetida en las diferentes formas, ejemplo si existe una secuencia AAAA en una fila y esta tambien existe en otra AAAA, se contara como una secuencia, ademas si las mismas se interceptan.
 2. Para ser mutante debe existir al menos 2 secuencias de 4 letras repetidas pero no siendo la misma letra por ejemplo AAAA y CCCC.
 3. Se aceptaran mayusculas y minusculas, teniendo asi que el mismo significado es decir a = A.
 4. Si la secuencia cumple con el puntos anteriores, se debe cumplir que todas las letras de su secuencia de ADN deben ser (A,T,C,G).

### Tecnologías necesarias
`Java 1.8` `Maven` `Spring-Boot` `Reactor` `WebFlux` `MySql` `JPA` `SONARQUBE`
### Instalación del proyecto
1. Clonar el repositorio en tu equipo :
```sh
> cd <folder path>
> git clone https://github.com/siritfelix/XmenMeli
```
2. Abrir el proyecto en tu editor o IDE de preferencia
    * Abrir el archivo application.propeties y modificar los valores de tu servidor de base de datos
    >spring.datasource.username=   
     spring.datasource.password=
    * Arrancar el servidor de MySql
    * Levanta la aplicacion con tu ide o por medio de Maven
    * Por medio postman puedes probar los dos endpoint disponibles, pero puedes abrir la documentacion en swagger, http://localhost:8080/swagger-ui.html
    * Metodo POST 
        > localhost:8080/mutant/
        - Entrada: {"dna" : ["ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"] }
        - Respuesta es OK si es mutante o en caso contrario Forbidden
    * Metodo GET
        > localhost:8080/stats
        - Sin parametros de entrada
        - Devuelve un json con los calculos  { "count_human_dna": 0,"count_mutant_dna": 0, "ratio": 0}

3. En la nube la aplicaciones esta en: https://herokuapp.com/
4. En la evaluacion en sonarqube resulto con mas de 85% de coverage
