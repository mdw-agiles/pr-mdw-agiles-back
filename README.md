# Proyecto TPV - Back-end - Spring
#### Back-end con Tecnologías de Código Abierto (SPRING)
#### [Máster en Ingeniería Web por la U.P.M.](http://miw.etsisi.upm.es)
[![Build Status](https://travis-ci.org/miw-upm/betca-tpv-spring.svg?branch=develop)](https://travis-ci.org/miw-upm/betca-tpv-spring)
![Quality Gate](https://sonarcloud.io/api/project_badges/measure?project=es.upm.miw%3Abetca-tpv-spring&metric=alert_status)
> Proyecto Back-end completo para el uso de la tecnología Spring.  
> Api en acción: [https://betca-tpv-spring.herokuapp.com/api/v0/swagger-ui.html](https://betca-tpv-spring.herokuapp.com/api/v0/swagger-ui.html).  
> Web en acción: [https://betca-tpv-angular.herokuapp.com](https://betca-tpv-angular.herokuapp.com).  
> El Front-end se desarrolla en Angular en el proyecto [betca-tpv-angular](https://github.com/miw-upm/betca-tpv-angular).  
> Ejecución en local:
> * Se debe tener arrancado el motor de MongoDB: `mongodb://localhost:27017/tpv`  
> * Ejecutar el **API** en linea de comando, mediante: `> mvn clean spring-boot:run`  

## Tecnologías necesarias
`Java` `Maven` `Spring` `Mongodb`

### Clonar el proyecto
 Clonar el repositorio en tu equipo, **mediante consola**:
```sh
> cd <folder path>
> git clone https://github.com/miw-upm/betca-tpv-spring
```
Importar el proyecto mediante **IntelliJ IDEA**
1. **Import Project**, y seleccionar la carpeta del proyecto.
1. Marcar **Create Project from external model**, elegir **Maven**.
1. **Next** … **Finish**.

## Presentación
Este proyecto es la práctica de Angular desarrollada de forma colaborativa por todos los alumnos.
Se parte de la versión `core`, ya implementada, y se pretende ampliar con un conjunto de mejoras.  
Un **T**erminal **P**unto de **V**enta es un sistema informático que gestiona el proceso de venta mediante una interfaz accesible para los vendedores o compradores.
Un único sistema informático permite la creación e impresión del recibo ticket o factura de venta —con los detalles de las referencias y precios— de los artículos vendidos, actualiza los cambios en el nivel de existencias de mercancías (STOCK) en la base de datos...

## Ecosistema
`Git` `GitHub` `Travis-CI` `Sonarclud` `Heroku` `mLab`
> Se utilizará un flujo de trabajo ramificado (_**Git Workflow**_).
> Una **historia** por **alumno**, organizada como un **proyecto** de tipo **Automated kanban**.
> Cada **historia** se dividirá en **tareas**, cada **tarea** será una **issue#**, que será el nombre de la **rama**.  
> **Se recomienda aportaciones frecuentes a la rama `develop`** :sweat_smile:

### Metodología de trabajo
:one: Organización de la **historia** y **tareas** en el proyecto de GitHub mediante **notas**. Elegir la **nota** a implementar, convertirla en **issue#** y configurarla  
:two: Mirar el estado del proyecto [![Build Status](https://travis-ci.org/miw-upm/betca-tpv-spring.svg?branch=develop)](https://travis-ci.org/miw-upm/betca-tpv-spring) en [Travis-CI](https://travis-ci.org/miw-upm/betca-tpv-spring/builds)  
:three: Sincronizarse con las ramas remotas, 
```sh
> git fetch --all
```
Y si fuera necesario, actualizar la rama **develop** con la remota **origin/develop**:
```sh
> git checkout develop
> git pull origin develop
```
:four: Si se comienza la tarea, se crea la rama y se activa
```sh
> git checkout -b issue#xx
```
 Y si se continúa, y se necesitara actualizar la rama **issue#** con las nuevas incorporaciones de **develop**:
```sh
> git checkout issue#xx
> git merge -m "Merge develop into issue #xx" develop
```
:five: Programar la tarea o una parte de ella, lanzar **TODOS LOS TESTS** y asegurarse que no hay errores. Finalmente, sincronizarse con las ramas remotas:
 ```sh
> git fetch --all
```
Y si necesitamos actualizarnos, se repite el paso :four:  
:six: Actualizar **develop** con nuestro cambios:
```sh
> git checkout develop
> git merge --no-ff -m "Merge issue #xx into develop" issue#xx
```
:seven: Resolver los conflictos, observar el flujo de ramas, y si todo ha ido bien... subirlo 
```sh
> git push --all
 ```
:eight: Si la tarea continua, volver a activar la **rama issue#xx**:
```sh
> git checkout issue#xx
 ```

 ### Travis-CI
Integración continua con **Travis-CI**. Se despliega para pruebas con el servicio de BD de mongodb y ejecución de los test Unitarios y de Integración
```yaml
services:
  - mongodb
script:
- mvn org.jacoco:jacoco-maven-plugin:prepare-agent verify  #Test en el perfil "dev" y con cobertura
```

### Sonarcloud
En el la cuenta de **Sonarcloud**, en la página `-> My Account -> Security`, se ha generado una **API Key**.   
En la cuenta de **Travis-CI**, dentro del proyecto, en `-> More options -> Settings`, se ha creado una variable de entorno llamada `SONAR` cuyo contenido es la **API key** de **Sonar**.    
Se ha incorporado al fichero de `.travis.yml` el siguiente código:
```yml
# Sonarcloud
- mvn sonar:sonar -Dsonar.organization=miw-upm-github -Dsonar.host.url=https://sonarcloud.io -Dsonar.login=$SONAR
```

### Swagger
Se monta un cliente swagger para atacar al API: http://localhost:8080/api/v0/swagger-ui.html.
Para ello, se ha introducido una fichero de configuración [SwaggerConfig](https://github.com/miw-upm/betca-tpv-spring/blob/master/src/main/java/es/upm/miw/config/SwaggerConfig.java)
```
@Configuration @EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket api() {
		...
    }
```

### Heroku & mLab
Se realiza un despliegue en **Heroku** con bases de datos de MongoDB en **mLab**.  
En la cuenta de **Heroku**, en la página `-> Account settings -> API Key`, se ha obtenido la `API KEY`.  
En la cuenta de **Travis-CI**, dentro del proyecto, en `-> More options -> Settings`, se ha creado una variable de entorno llamada `HEROKU` cuyo contenido es la **API key** de **Heroku**.  
Se incorpora el siguiente código en el fichero `.travis.yml`
```yaml
# Deploy https://betca-tpv-spring.herokuapp.com/api/v0/swagger-ui.html
deploy:
  provider: heroku
  api_key:
    secure: $HEROKU
  on:
    branch: master
```
La conexión entre **Heroku** y **mLab** se realiza automáticamente al añadir el **Add-ons**.

## Arquitectura
![](https://github.com/miw-upm/betca-tpv-spring/blob/develop/docs/tpv-architecture.png)

### Responsabilidades
* `config` Clases de configuración de **Spring**.
* `exceptions`tratamiento de errores, convierte las excepciones lanzadas en respuestas de error HTTP.
* `rest_controllers` Clases que conforman el **API**.
   * Define el path del recurso.
   * Deben organizar la recepción de datos de la petición.
   * Delega en los **dtos** la validación de campos.
   * Delega en **exceptions** las respuestas de errores **HTTP**.
   * Delega en los **bussines_controllers** la ejecución de la petición.
* `bussines_controllers` Clases que procesan la petición.
   * Desarrollan el proceso que conlleva la ejecución de la petición.
   * Construye los **documents** a partir de los **dtos** de entrada.
   * Delega en los **dtos** la construcción de los **dtos** de respuesta a partir de los **documents**.
   * Delega en los **repositories** el acceso básico a las BD.
   * Delega en los **data_services** procesos de acceso avanzado a las BD.
   * Delega en los **business_services** procesos genéricos avanzados de la capa de negocio.
* `busines_services` Clases de servicios de apoyo, como fachada de construcción de PDF, fachada de tratamiento de JWT, encriptación...
* `data_services` Clases de servicios avanzados de BD.
* `repositories` Clases de acceso a BD mediante el patrón DAO.
   * Operaciones CRUD sobre BD.
   * Consultas a BD.
* `documents` Clases con los documentos persistentes en BD y utilidades.

## Autenticación
Se plantean mediante **Basic Auth** para logearse y obtener un **API Key** o **token** de tipo **JSON Web Tokens (JWT)**. Uso del **Bearer APIkEY** para el acceso a los recursos.  
Para obtener el **API Key** se accede al recurso: `POST \users\token`, enviando por **Basic auth** las credenciales, van en la cabecera de la petición.
Para el acceso a los recursos, se envia el **token** mediante **Bearer auth**, tambien en la cabecera de la petición.
> Authorization = Basic "user:pass"<sub>Base64</sub>  
> Authorization = Bearer "token"<sub>Base64</sub>  

Para asegurar los recursos, se plantea una filosofía distribuida, es decir, se establece sobre cada recursos (clase). Para ello, se anotará sobre cada clase los roles permitidos; modificando el rol sobre el método si éste, tuviese un rol diferente.  
```java
@PreAuthorize("hasRole('ADMIN') or hasRole('MANAGER')")
public class Clazz {
    //...
    @PreAuthorize("hasRole('ADMIN')")
    public void method(){...}
    //...
    public void method2(){...}
}
```
Existe un rol especial que se obtiene cuando se envía el usuario y contraseña por **Basic Auth** y es el rol de **authenticated**, sólo se utiliza para logearse.

![](https://github.com/miw-upm/betca-tpv-spring/blob/develop/docs/authentication.png)

## Tratamiento de errores
Se realiza un tratamiento de error centralizado.  
![](https://github.com/miw-upm/betca-tpv-spring/blob/develop/docs/exceptions.png)

## API. Descripción genérica
[Heroku deploy](https://betca-tpv-spring.herokuapp.com/api/v0/swagger-ui.html)

![](https://github.com/miw-upm/betca-tpv-spring/blob/develop/docs/api.png)

## DTOs
Son los objetos de transferencia del API, para recibir los datos (input) y enviar las respuestas (output).

* Los **input** se encargan de las validaciones de entrada mediante las anotaciones.  
* Los **output**. Se deben poder construir a partir de los **documentos**. Añadir la anotación `@JsonInclude(Include.NON_NULL)` para que no se devuelvan null en el Json.

![](https://github.com/miw-upm/betca-tpv-spring/blob/develop/docs/dtos.png)   

## Bases de datos
> Se dispone de un servicio para poblar la BD a partir de un fichero YML `db.yml`; se carga automáticamente al iniciar la aplicación en el perfil **dev**.  
> Existe el recurso `/admins/db` para poder borrar o poblar la BD a partir de un fichero yaml subido.  
> El servicio `DatabaseSeederService` nos permiter recargar el fichero `db.yml`.  
> Se debe intentar no abusar de la recarga del **yaml**, ya que ralentiza la ejecución de los tests.

:exclamation: **Si se crea un nuevo _documento_, se debe añadir el `deleteAll()` asociado al nuevo documento, dentro del método `deleteAllAndInitialize` de la clase `DatabaseSeederService`**

Los pasos a seguir para incluir un nuevo documento en la carga de datos a través del fichero `db.yml`:
1. Rellenar el YML con los datos del nuevo documento.  
1. Incluir en la clase `TpvGraph`, la **lista** del nuevo documento con **getters & setters**.  
1. Incluir en la clase `DatabaseSeederService`, en el médoto `seedDatabase`, el `saveAll` del repositorio del nuevo documento.

![](https://github.com/miw-upm/betca-tpv-spring/blob/develop/docs/database-seeder.png)

Fichero ** \*.yml** como ejemplo...
```yaml
articleList:
  - &ar1
    code: 8400000000017
    reference: ref-a1
    description: descrip-a1
    retailPrice: 20
    stock: 10
    tax: GENERAL
    discontinued: false
    provider: *pr1
#...

tagList:
  - description: tag-1
    articleList:
      - *ar1
      - *ar2
      - *ar3
  - description: tag-2
    articleList:
      - *ar1
      - *ar2
      - *ar5
```

## Persistencia del TPV
![](https://github.com/miw-upm/betca-tpv-spring/blob/develop/docs/documents.png)
![](https://github.com/miw-upm/betca-tpv-spring/blob/develop/docs/repositories.png)

## Generación de Pdf's
![](https://github.com/miw-upm/betca-tpv-spring/blob/develop/docs/pdf.png)

## Perfiles
![](https://github.com/miw-upm/betca-tpv-spring/blob/develop/docs/profiles.png)  
Si una propiedad se define en diferentes ficheros, predomina la definición mas específica.  
A cualquier clase se le puede poner la anotación `@Profile()`, con ello indicamos que sólo se configura en el perfil marcado.  
En el TPV, los **test** siempre se ejecutan en el perfil `dev`, y los `ApiLog` también el el perfil `dev`.  
Por defecto el perfil es `dev`, pero se puede indicar como una propiedad en **application.properties**: `spring.profiles.active=dev`.  
Sólamente en la rama `release-xx` cambiaremos este valor a `prod`
Para ejecutar en un perfil determinado localmente:
```sh
> mvn spring-boot:run
> mvn -Dspring.profiles.active=dev spring-boot:run

> mvn -Dspring.profiles.active=prod spring-boot:run
> java –jar –Dspring.profiles.active=prod release-1.0.0.jar 

``` 

# Metodología de trabajo

## Fase 1. Preparar el IDE
> Se debe utilizar `IntelliJ` & `Web Storm`.  
> Para `IntelliJ`, todo el código debe estar formateado mediante: `-> Code -> Reformat Code`, con los chekbox `[x]Optimize imports` y `[x]Rearrange entries` activados.  
> Para `Web Storm`, todo el código debe estar formateado mediante: `-> Code -> Reformat Code`, con los chekbox `[x]Optimize imports`, `[x]Rearrange entries` y `Cleanup code` activados.  

## Fase 2. Importar los proyectos
* BACK-END (IntelliJ): https://github.com/miw-upm/betca-tpv-spring.
* FROND-END (Web Storm): https://github.com/miw-upm/betca-tpv-angular.

## Fase 3. Determinar y limitar el alcance de la práctica  
1. Determinar el enunciado
   * Elegir un enunciado.
   * Añadir los **Tests de aceptación** y **Notas** aclaratorias.
   * Dentro de cada proyecto en GitHub (uno para Angular y otro para Spring), crear un proyecto `Automated Kanban`, con el título de la práctica.  
   * En la wiki, debera haber dos enlaces a los **project-spring** y **project-angular**  desarrollados.  
1. Desarrollar el **Prototipo de Interfaz (\*.png)**
   * Debemos visualizar las ventanas, indicando desde que otras ventanas iniciamos la acción o desde que menú. Cualquier editor es válido, incluso en papel y subiendo la foto, aquí se ha utilizado el editor de Dibujos de Google. Es una vista aproximada.
   * En este punto ya podemos tener, mas o menos cerrado, el alcance de la práctica a realizar.  
   
### Realizar el envio de la práctica en la plataforma de Moddle: [Miw-Spring-ECP](https://moodle.upm.es/titulaciones/oficiales/mod/assign/view.php?id=952015)   
> Se debe obtener la calificación de `YES` para continuar la siguiente Fase   
---

## Fase 4. Gestionar el desarrollo  
1. Dividir la práctica en tareas mas pequeñas, cada tarea una **Nota**. Cuando se vaya a implementar la nota,
 convertirla en **issue#**. Asignaros la **issue#xx** y asociarle la etiqueta oportuna. Como referencia podríamos tomar entre 5 y 15 tareas.  
Realizar fusiones frecuentes con develop del código estable, y subirlo al remoto. **Siempre vigilar la estabilidad de código**.  
Como ejemplo proponemos la siguiente división:  
   * **Tarea 1 (Front-End)**. Vista en Angular. Crearemos en el proyecto de Angular el HTML y los componentes necesarios para su presentación. No debe tener nada de proceso, sólo nos concentraremos en la vista.
   * **Tarea 2 (Front-End)**. Incluir los servicios de Angular. El servicio no llega a realizar las peticiones al API, sino que devuelve valores predeterminados e imprime por **console.log()** las peticiones al API.
   * **Tarea 3 (Front-End)**. Se realiza los servicios de Angular realizando las peticiones. Como el servido no esta realizado, daran error de API no encontrado.
   * **Tarea 4 (Front-End)**. Refactorizar, reoordenar, simplificar...
   * **Tarea 5 (Back-End)**. La API devuelve valores fijos, con los dtos necesarios e imprime logs con las peticiones.
   * **Tarea 6 (Back-End)**. Se realizan los controladores del API con sus correspondientes Test.
   * **Tarea 7 (Back-End)**. Se programa las querys necesarias, se crean los documentos necesarios con sus repositorios...
   * **Tarea 8 (Back-End)**. Refactorizar, reoordenar, simplificar...   
   * **Tarea 9**. Se realizan las pruebas de aceptación.
   * **Tarea 10**. Se podrían realizar bugs.
   * **Tarea 11**. Refactorizar, reoordenar, simplificar...   
   
## Tareas transversales
* Planificar antes los cambios a realizar, y cuando se tiene claro, actualizar la rama **issue#xx** con **develop** justo antes de empezar. Realizar una **estimación temporal** y **anotarlo en la tarea**.
* Cuando nos sentamos a trabajar, comprobar que la rama **issue#xx** está actualizada respecto a **develop** y hacer un **commit de inicio de tarea**.
* No es recomendable dejar de trabajar sin aportar a develop las mejoras, siempre **sin romper develop**.
* Realizar aportaciones frecuentes a la rama **develop**, del código estable, aunque este a medias. **Ojo** con los ficheros muy susceptibles de colisionar, como por ejemplo **app.module.ts**, **app-routing.module.ts**, **home.component.ts**..., en este caso, modificarlos y subirlos a **develop** con rapidez.
* Vigilar y pensar bien los **comentarios de los commits**, acordarse de añadir la referencia del issue: **#xx**.
* Cuando se termina un **issue#xx**, añadir el **tiempo real** utilizado y cerrarlo.










