# ♟️ Proyecto Ajedrez: JAVAque Mate

## 📖 Descripción

Este documento describe el proyecto a realizar durante la segunda evaluación del módulo de Programación de 1º CFGS DAM. Consiste en desarrollar un **motor simplificado de ajedrez en Java**, trabajando en equipos colaborativos (4-5 personas) y utilizando una metodología ágil (Scrum).

> ⚠️ **IMPORTANTE: Política de Entregas**
> La entrega la realizará el Scrum Master siguiendo escrupulosamente las instrucciones. Toda entrega que no se ciña a las fechas o formato será descalificada, significando el **suspenso automático** de todos los miembros del equipo. No se realizarán excepciones de entregas con retraso bajo ningún concepto.

### 🛠️ Conceptos de Java aplicados
El proyecto servirá para poner en práctica los siguientes conocimientos:
* Herencia y Clases abstractas
* Interfaces y Enumerados (`Enum`)
* Serialización y Persistencia de datos
* Colecciones

---

## 🏗️ Estructura General del Proyecto

El proyecto sigue un patrón arquitectónico estructurado en los siguientes paquetes:

### 📦 1. Paquete `modelo`
Contiene toda la lógica de negocio y las entidades del juego.

#### Colores y Piezas
Se permiten dos colores: **Blancas** y **Negras**. Toda pieza debe almacenar su fila (0-7), columna (0-7) y color. Debe validar que la posición es correcta o lanzar una `IllegalArgumentException`.

| Pieza | Puntos | Símbolo Blanca | Símbolo Negra | Reglas especiales |
| :--- | :---: | :---: | :---: | :--- |
| **Rey** | 100 | ♔ | ♚ | |
| **Reina** | 9 | ♕ | ♛ | |
| **Torre** | 5 | ♖ | ♜ | |
| **Alfil** | 3 | ♗ | ♝ | |
| **Caballo** | 3 | ♘ | ♞ | Implementa interfaz saltadora. |
| **Peón** | 1 | ♙ | ♟ | Mueve distinto a como ataca; puede saltar 2 casillas al inicio. |

*Nota: Todas las piezas deben implementar `equals()`, `hashCode()` y representarse mediante un `toString()` usando los caracteres UTF-8 de la tabla.*

#### Tablero
El tablero es el núcleo del juego. Debe ser **Serializable** y **Clonable**.
* **Almacena:** Lista de piezas blancas, lista de negras y lista de piezas eliminadas.
* **Funciones principales:**
  * Inicializar y vaciar el tablero.
  * Añadir, buscar y mover piezas (enviando a las eliminadas a su respectiva lista si son atacadas).
  * Comprobar si hay piezas bloqueando un camino (excepto para piezas saltadoras).
  * Evaluar si el Rey de un color está en **Jaque**.
  * Calcular la puntuación total de un equipo.
  * Dibujar el tablero en consola usando `░` (casilla blanca) y `▓` (casilla negra).

### 🧰 2. Paquete `utils`
* `Utils.java`: Alberga métodos auxiliares y estáticos.
* **Gestor de Persistencia:** Clase encargada de guardar y cargar el estado de un tablero en el disco duro mediante rutas de archivos.

### 🎮 3. Paquete `controladores`
Controlador central que une el tablero con la vista. 
* Maneja el Tablero, el turno actual y la pieza seleccionada.
* **Bucle principal:** Controla el desarrollo de la partida verificando que los movimientos sean legales, que no dejen al propio Rey en jaque y alternando los turnos.

### 🖥️ 4. Paquete `vista`
Clase encargada exclusivamente de la interacción con el usuario por consola (mostrar menús, pintar el estado de la partida, solicitar coordenadas e imprimir mensajes).

---

## 🔄 Flujo de la Aplicación

### Menú Principal
Al iniciar, se muestra el estado de la partida y se ofrecen estas opciones:
1. Seleccionar pieza
2. Reiniciar tablero
3. Cargar tablero
4. Guardar tablero
5. Salir

### Menú Pieza Seleccionada
Si el usuario selecciona una pieza válida de su color:
1. Mover
2. Cancelar
*(Si se cancela, el movimiento es incorrecto, o se completa con éxito, el flujo devuelve al usuario al menú principal actualizado).*

---

## 🚀 Metodología de Trabajo y Git

Trabajaremos bajo la metodología **Scrum**, gestionando Sprints, *Daily Meetings* y el tablero Kanban mediante **Trello**. El código se gestionará en **GitHub**. El Jefe de equipo actuará como **Scrum Master**.

### 🌿 Ramas del Repositorio
* `main`: Versión estable y protegida. No admite Push directos.
* `develop`: Versión en desarrollo donde se integran los Sprints.
* **Ramas de trabajo:**
  * `feature/<nombre>`: Para nuevas características (ej. `feature/movimiento-peon`).
  * `bugfix/<nombre>`: Para arreglar fallos.
  * `refactor/<nombre>`: Para optimización de código.

### 📝 Flujo de trabajo por tarea
1. **Crear Issue:** En GitHub (ej. `#12 Implementar detección de jaque`).
2. **Crear rama:** Siempre naciendo desde `develop` (nunca desde `main`).
3. **Commits descriptivos:** * `feat: añadir método estaEnJaque en Tablero`
   * `fix: corregir validación de diagonal del alfil`
   * `refactor: extraer lógica a método privado`
4. **Pull Request (PR):** Desde la rama hacia `develop`. Debe vincular la Issue y describir los cambios. El Scrum Master debe aprobarlo.
5. **Fin del Sprint:** Se realiza un merge de `develop` hacia `main`.

---

## 📅 Temporalización

* **Inicio del proyecto:** 27 de febrero de 2026
* **Fecha límite de entrega:** 19 de marzo de 2026
* **Comienzo de exposiciones:** 20 de marzo de 2026

**Sprints planificados:**
* **Sprint 1:** 27/02 - 04/03 *(3 días)*
* **Sprint 2:** 05/03 - 09/03 *(3 días)*
* **Sprint 3:** 10/03 - 12/03 *(3 días)*
* **Sprint 4:** 13/03 - 18/03 *(4 días)*

