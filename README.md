# Proyecto MDW - Back-end - Spring
#### Metodologías de Desarrollo Web (SPRING)
#### [Máster en Ingeniería Web por la U.P.M.](http://miw.etsisi.upm.es)
Master: [![Build Status](https://travis-ci.org/mdw-agiles/pr-mdw-agiles-back.svg?branch=master)](https://travis-ci.org/mdw-agiles)

Develop: [![Build Status](https://travis-ci.org/mdw-agiles/pr-mdw-agiles-back.svg?branch=develop)](https://travis-ci.org/mdw-agiles)    

> URL Heroku: [https://betca-tpv-angular.herokuapp.com](https://betca-tpv-angular.herokuapp.com).  
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

## Objetivos

Con la realización de esta práctica se pretende alcanzar los siguientes objetivos:

   * Poner en práctica los principios de las metodologías de desarrollo web incluidos en los contenidos de la asignatura.

   * Fomentar el trabajo en equipo.

   * Aprender a construir software basándose en un proceso de desarrollo ágil.

   * Poner en práctica los principios de planificación y gestión de proyectos.


## Enunciado de práctica

Una empresa hotelera desea revolucionar el alquiler de habitaciones de
hotel mediante la oferta de habitaciones por horas. Para ello, desea
realizar una aplicación web para la gestión de la disponibilidad y de las
reservas online de las habitaciones. Para alcanzar este objetivo, ha
encomendado a los profesores de Metodologías de Desarrollo Web
verificar el avance del proyecto e interactuar con los equipos de
desarrollo de la ETSISI.

La aplicación deseada permitirá a la empresa dar de alta diversas
cadenas de hoteles. De cada cadena de hoteles, además de su
responsable, se debe conocer el nombre de la misma y el logotipo. Cada
cadena de hotel tendrá un responsable de cadena, que podrá
administrar los hoteles pertenecientes a dicha cadena (darlos de alta,
baja y modificarlos). Una cadena podrá tener uno o más hoteles que
admitan reservas por horas.

De cada hotel, se debe recoger el nombre del hotel, la dirección postal,
el nombre y apellidos del director del hotel y una imagen representativa.
Cada hotel tendrá un responsable de hotel, que será el encargado de
gestionar las habitaciones de dicho hotel. El responsable de hotel será el
encargado de dar de alta las habitaciones disponibles, en la modalidad
de alquiler por horas. Para cada habitación, el sistema debe permitir
establecer la disponibilidad de la misma por fecha y horario. El horario
podrá variar según el día. El gestor de cada hotel, además de poder dar
de alta habitaciones, debe poder eliminar y modificar los datos de las
habitaciones bajo su supervisión.

De cada habitación, se desea conocer el tipo de habitación: individual,
doble, triple o suite. Además, se deben conocer los servicios adicionales
de los que dispone la habitación: televisión, Internet, aire acondicionado,
minibar, jacuzzi, etc. Para cada habitación, se establecerá además el
precio por hora de la misma.

Los clientes, deben poder buscar, a través de Internet, habitaciones por
diferentes criterios: ubicación, nombre de hotel, fecha y franja horaria.
Una vez localizado un hotel que disponga de habitaciones que encajen 
Metodologías de desarrollo web – Práctica obligatoria – Curso 2016/2017
3 en sus características deseadas, el sistema debe permitir al cliente realizar
una reserva de la habitación indicando el número de horas que desea
utilizar la misma.

Al realizar la reserva, si el cliente ya tiene cuenta en la aplicación, el
sistema dejará al cliente hacer login. En caso contrario, el sistema debe
recoger los datos básicos del cliente, incluido su correo electrónico, con
el que se creará una cuenta automáticamente para el cliente, quien
podrá solicitar al sistema “recordar su contraseña”. Una vez que el cliente
esté registrado en el sistema, se recogerán los datos relativos a la reserva,
se calculará el precio de la misma (precio de la habitación por hora
multiplicado por el número de horas reservadas) y se conducirá al cliente
a una pasarela de pago por tarjeta de débito/crédito.
Los clientes deben poder acceder al sistema y modificar tanto sus datos
personales como los datos relativos a sus reservas (cancelación o
modificación de la misma). El sistema no almacenará datos de tarjetas
bancarias.

Cuando se realice la compra, el cliente recibirá una confirmación por
pantalla, así como un correo electrónico de confirmación con un código
de reserva. Adicionalmente, el responsable del hotel recibirá un correo
indicando que se ha realizado una nueva reserva y los datos de la misma.
La habitación debe quedar bloqueada durante esas horas de manera
automática. Así mismo, será necesario dejar un margen adicional de dos
horas después de que quede libre para poder limpiarla y prepararla para
otra reserva.

El gestor del hotel debe poder visualizar las reservas sobre todas sus
habitaciones, y tener un mecanismo para cancelar una reserva
determinada, por causa de fuerza mayor. Si esto sucede, el sistema debe
permitir al gestor incluir un mensaje personalizado para el cliente, quien
recibirá un correo electrónico indicando que la reserva se ha cancelado
y dándole la opción de, a través de la aplicación, acceder a un bono
para la realización de otra reserva equivalente, o bien recuperar su
dinero.

Cuando el cliente acude al hotel, el personal de recepción del hotel (no
necesariamente el gestor) le solicita el código de reserva que el cliente
recibió por correo electrónico. Con este código el personal de recepción
puede confirmar que el cliente ha acudido al hotel, para posteriormente
recibir la liquidación correspondiente, que se ha cobrado previamente el
sistema.

## Ecosistema
`Git` `GitHub` `Travis-CI` `Sonarclud` `Heroku` `mLab` `SCRUM`

### Tarea 1

> * Formar un equipo de trabajo Scrum, con el número de integrantes indicados por el profesor.
> * Escoger un Product Owner (PO) y un Scrum Máster (SM) de entre los integrantes del equipo.
> * El PO será el encargado del Product Backlog, mientras que el SM será el encargado del Sprint Backlog.
> * Redactar todas las historias de usuario derivadas del enunciado base.
> * El PO debe reunirse con el cliente para aclarar todas aquellas dudas que tenga y extraer el valor de negocio de cada historia de usuario, de modo que pueda hacer una priorización adecuada.
> * El equipo debe estimar el coste relativo (pequeño, mediano, grande) de realización de cada historia de usuario ya priorizada por valor de negocio.
> * Una vez que las historias de usuario estén debidamente priorizadas, el equipo debe crear el primer Sprint Planning, dividiendo las historias de usuario en tareas y dándole a su vez un coste relativo a las tareas 1,2,4,8, seleccionando las historias que el equipo sea capaz de realizar en el primer sprint, considerando como medida de referencia 20 unidades de tiempo por miembro del equipo (excluyendo PO y SM).

### Tarea 2

> * Abordar el desarrollo del primer Sprint planificado empleando TDD
> * Detallar la conversación y los criterios de aceptación de las historias consideradas

### Metodología de trabajo
:one: Organización de la **historia** y **tareas** en el proyecto de GitHub mediante **notas**. Elegir la **nota** a implementar, convertirla en **issue#** y configurarla  
:two: Mirar el estado del proyecto [![Build Status](https://travis-ci.org/mdw-agiles/pr-mdw-agiles-back.svg?branch=develop)](https://travis-ci.org/mdw-agiles) en [Travis-CI](https://travis-ci.org/miw-upm/betca-tpv-spring/builds)  
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
    public void method(){}
    //...
    public void method2(){}
}
```
Existe un rol especial que se obtiene cuando se envía el usuario y contraseña por **Basic Auth** y es el rol de **authenticated**, sólo se utiliza para logearse.

![](https://github.com/mdw-agiles/pr-mdw-agiles-back/blob/master/docs/authentication.png)

## Tratamiento de errores
Se realiza un tratamiento de error centralizado.  
![](https://github.com/mdw-agiles/pr-mdw-agiles-back/blob/master/docs/exceptions.png)

## DTOs
Son los objetos de transferencia del API, para recibir los datos (input) y enviar las respuestas (output).

* Los **input** se encargan de las validaciones de entrada mediante las anotaciones.  
* Los **output**. Se deben poder construir a partir de los **documentos**. Añadir la anotación `@JsonInclude(Include.NON_NULL)` para que no se devuelvan null en el Json.

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

Fichero ** \*.yml** 
```yaml
userList:
  - &us0
    mobile: 666666000
    username: u000
    password: p000
    email: u000@gmail.com
    dni: null
    address: C/ TPV, 0, 1A, 28000 Madrid
    roles:
      - ADMIN
      - MANAGER
      - OPERATOR
  - mobile: 666666001
    username: u001
    password: p001
    email: u001@gmail.com
    dni: 66666600L
    address: C/ TPV, 1, 1A, 28000 Madrid
    roles:
      - MANAGER
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
   
### Realizar el envio de la práctica en la plataforma de Moddle   

Una vez terminada la práctica, se subirá el código y la documentación a la plataforma moodle.

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










