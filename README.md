# Proyecto-Ajedrez
#Tablero de ajedrez

#JAVAque Mate
#Descripción
Este documento describe el proyecto a realizar durante la segunda evaluación del módulo de Programación de 1º CFGS DAM. Es un proyecto que se realiza por equipos colaborativos (4-5 personas), empleando el sistema de control de versiones Git y utilizando una metodología ágil. Los sprints se realizarán por semanas y se requerirá el empleo de Trello y Github Issues.

La entrega la realizará el Scrum Master siguiendo escrupulosamente las instrucciones del apartado Entrega.

Toda entrega que no se ciña a las fechas o formato será descalificada significando el suspenso automático de todos los miembros del equipo. No se realizarán excepciones de entregas con retraso sea el motivo que sea.
---
#El proyecto consiste en desarrollar un motor simplificado de ajedrez en Java, aplicando:
Herencia
Clases abstractas
Interfaces
Enum
Serialización
Colecciones
Persistencia
---
#Estructura General
El proyecto debe organizarse en paquetes:
modelo
controladores
vista
utils
---
Paquete Modelo
Colores
Se permiten dos colores: blancas y negras.
Piezas
---
De todas las piezas se debe almacenar:

La fila que ocupan (0-7)
La columna que ocupan (0-7)
---
#El color al que pertenecen
Para crear cualquier pieza, se deben indicar su fila, su columna y su color. Se debe validar que la posición esté entre 0 y 7. Si la posición no está permitida se deberá lanzar una excepción IllegalArgumentException.
---
#Dada una pieza, se debe permitir:

Comprobar si puede mover a una casilla del tablero. Para ello se necesitará información sobre la nueva fila, la nueva columna y el tablero. Se deberá validar:
Movimiento correcto según tipo de pieza
Destino dentro del tablero
No capturar pieza del mismo color
Comprobar que no haya piezas intermedias en caso de no ser pieza saltadora (como el caballo)
Comprobar si puede atacar a una pieza, dada la pieza.
Mover a otra posición. Para ello se necesitará información sobre la nueva fila, la nueva columna y el tablero. Si el movimiento no está permitido, o la pieza que ocupa la casilla es un rey, se deberá lanzar una excepción IllegalArgumentException.
Obtener los puntos de la pieza.
Que sea representada como cadena con el caracter correspondiente de UTF-8:
♔ ♕ ♖ ♗ ♘ ♙
♚ ♛ ♜ ♝ ♞ ♟
equals(), hashCode() y getters necesarios
Piezas concretas
---
#Se deben contemplar las siguientes piezas:
Rey (100 puntos)
Reina (9 puntos)
Torre (5 puntos)
Alfil (3 puntos)
Caballo (3 puntos)
Peon (1 punto)
---
Cada una debe controlar si puede mover, si puede atacar, especificar los puntos que vale y cómo se representa como cadena. En el caso del peón, recordar contemplar que en su posición inicial puede adelantar dos casillas, y que es la única pieza cuyo ataque es distinto de su movimiento.
---
#Piezas saltadoras
Las piezas saltadoras no necesitan comprobar si hay piezas intermedias para mover. La única pieza saltadora presente en el juego es el caballo, pero el juego se debe diseñar de forma que en un futuro se pudieran añadir más piezas saltadoras.
---
#Tablero
El tablero debe ser serializable, para guardarlo, y clonable, por si deseamos hacer copias para evaluar si ciertas jugadas son válidas.
El tablero debe almacenar:
Una lista de piezas blancas en juego.
Una lista de piezas negras en juego.
Una lista de piezas eliminadas (sin importar el color).
Al crear un tablero este se creará con todas las piezas colocadas en su posición inicial.

El tablero deberá permitir:
Vaciar las piezas
Reiniciar el tablero a la posición inicial
Añadir una pieza, dado un color y una posición.
Obtener la pieza que ocupa una posición concreta.
Comprobar si hay piezas entre dos casillas del tablero, dadas la fila y columna de cada casilla.
Mover una pieza, dada una fila inicial, una columna inicial, una fila de destino y una columna de destino. Si el movimiento implica que una pieza ataca a otra, la pieza atacada se elimina de la lista de piezas activas correspondiente (blancas o negras) y se añade a la lista de piezas eliminadas.
Comprobar dado un color si el rey de dicho color está en jaque, es decir, si alguna de las piezas contrarias puede atacarlo.
Obtener dado un color la puntuación total de dicho color, sumando los puntos de las piezas vivas
Al ser representado como cadena, debe dibujar un tablero de 8 filas por 8 columnas:
Las casillas vacías se representan de la siguiente manera:
░ (blanca)
▓ (negra)
Las casillas ocupadas se representan con el caracter UTF-8 de cada pieza.
---
#Paquete utils
Se creará una clase Utils que albergue métodos auxiliares.

Además, deberá crearse otra clase que gestione la persistencia de un tablero, de modo que implemente:
Un método para, dado un tablero y una cadena con una ruta, guardar el tablero con sus piezas en la ruta especificada.
Un método que, dada una ruta, reconstruya el tablero almacenado en dicha ruta y lo devuelva.
Paquete controladores
Se deberá crear un controlador para el tablero. Dicho controlador manejará la siguiente información:
Tablero de la partida
Color del turno actual
Pieza seleccionada por el usuario
Deberá ofrecer la siguiente funcionalidad:
Iniciar la aplicación
Arrancar el menú principal,
Mostrar el estado inicial de la partida
Gestionar el bucle principal hasta salir.
Gestionar el color del turno actual.
Imprimir el estado actual de la partida:
El tablero con las fichas
Si algún rey está en jaque.
Lista de piezas muertas
Puntuación total de blancas
Puntuación total de negras
Seleccionar una pieza, dada una fila y una columna.
Deseleccionar pieza.
Mover la pieza seleccionada a la fila y columna indicadas. Se deberá controlar que:
La pieza se pueda mover a dicha posición
El movimiento no deje en jaque al rey del turno actual
El color del turno cambie si el movimiento es correcto.
Gestionar los menús, y las opciones seleccionadas.
---
#Paquete vista
Se creará una clase que gestione la vista por consola, encargándose de mostrar menús, mensajes, de solicitar datos.
---
#Flujo de la aplicación
Menú principal
Al iniciar, la aplicación mostrará el estado de la partida y ofrecerá un menú con las siguientes opciones:
Seleccionar pieza
Reiniciar tablero
Cargar tablero
Guardar tablero
Salir
Menú pieza seleccionada
Si se selecciona correctamente una pieza se ofrecen dos opciones:
Mover
Cancelar
Si se cancela, se vuelve a imprimir el estado de la partida y el menú principal
Si se indica un movimiento incorrecto, se vuelve a mostrar el menú de la pieza seleccionada
Si el movimiento se realiza correctamente, se vuelve a imprimir el estado de la partida y el menú principal
---
#Metodología de trabajo
La metodología de trabajo estará basada en Scrum. Se trabajará por sprints, usando Trello como plataforma para gestionar las tareas pendientes, en proceso y hechas.
Se utilizará el sistema git de control de versiones, y la forja GitHub.
El jefe de equipo actuará también como Scrum Master, de modo que ademas de supervisar los PR, gestionará las daily meetings y los sprints.
Repositorio
El repositorio contará con las siguientes ramas principales:
Rama main: versión estable
Rama develop: versión en desarrollo, donde se integra el sprint
La configuración será:
Rama main protegida
Pull Request obligatorio
No se puede hacer push directo a main
Ramas
Cada tarea debe tener su propia rama. Ejemplos:
feature/movimiento-peon
feature/jaque
feature/enroque
feature/serializacion
feature/vista-menu
La forma de nombrar ramas será la siguiente:
feature/<nombre> (rama para tareas que consistan en implementar una nueva característica)
bugfix/<nombre> (rama para tareas que consistan en arreglar fallos)
refactor/<nombre> (rama para tareas que consistan en refactorizar código)
Flujo de trabajo por tarea
Al implementar una tarea se deberán llevar a cabo los siguientes pasos:
Paso 1 – Crear Issue en GitHub
Se debe crear una Issue en GitHub para la tarea, con descripción clara y asignada al miembro del equipo correspondiente.
Ejemplo:
#12 Implementar detección de jaque
 El sistema debe detectar si el rey está en jaque tras cada movimiento.
Paso 2 – Crear rama desde develop
La rama para implementar la tarea se creará a partir de develop, nunca desde main
Paso 3 – Commits pequeños y descriptivos
Los mensajes de commit deberán ser pequeños y descriptivos, incluyendo prefijos (feat, fix, refactor) según sea la acción realizada. Ejemplos
feat: añadir método estaEnJaque en Tablero
fix: corregir validación de movimiento diagonal del alfil
refactor: extraer lógica de validación a método privado
Paso 4 – Pull Request hacia develop
Para integrar los cambios, se deberán hacer pull request (PR) desde las ramas a develop, nunca a main. En el PR debe haber:
Descripción
Issue relacionado (#12)
Qué se ha hecho
Qué falta
Cuando el jefe de equipo apruebe el PR se realizará el merge.
Fin del sprint - Merge de develop a main
Cuando termina el sprint se hace merge de develop a main.
Temporalización
Inicio: 27 de febrero de 2026
Fecha límite de entrega: 19 de marzo de 2026
Fecha de comienzo de las exposiciones: 20 de marzo de 2026.
Sprints: 
27/02 - 4/3 (3 días)
5/3 - 9/3 (3 días)
10/3 - 12/3 (3 días)
13/3 - 18/3 (4 días)

