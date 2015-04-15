Feature: Historias de usuario para el Trivial5b

  Scenario: Tirar dado
    Given Un dado con seis caras
    When Lanzo el dado
    Then Devuelve un numero aleatorio entre 1 y 6

  Scenario: Anadir jugador
    Given Una lista de jugadores
    When Anado uno o mas
    Then El tamano de la lista se corresponde con el numero de jugadores

  Scenario: Iniciar partida
    Given Ventana de inicio
    When Pulso el bot�n de nueva partida
    Then Aparece la ventana para escoger las opciones del juego

  Scenario: Consultar instrucciones del juego
    Given Ventana de inicio
    When Pulso el bot�n de instrucciones
    Then Aparece la ventana de instrucciones

  Scenario: Elegir opciones de juego
    Given Ventana opciones
    When Selecciono el n�mero de jugadores (m�nimo 1, m�ximo 4)
    And Selecciono la interfaz visual
    Then Aparece la ventana del tablero con tantos quesitos como n�mero de jugadores
    And La interfaz seleccionada

  Scenario: Tirar el dado y mover ficha
    Given El bot�n para lanzar el dado y ventana del tablero
    And El tablero con la ficha a mover
    When Pulso el bot�n del dado
    Then Recibo un valor num�rico aleatorio
    And Se activan en el tablero las casillas a las que nos podemos mover

  Scenario: Visualizar pregunta
    Given La casilla a la que se puede mover el jugador
    When Se selecciona dicha casilla
    Then Aparece la ventana con la pregunta y las posibles respuestas

  Scenario: Responder pregunta
    Given La ventana con la pregunta y las respuestas
    When Se selecciona la respuesta que se cree correcta
    Then Se indica si la respuesta es correcta o incorrecta
    And Se muestra el bot�n para continuar la partida

  Scenario: Respuesta correcta
    Given La ventana con la pregunta y las respuestas
    When La respuesta es correcta
    Then Volvemos al tablero para continuar con nuestro turno

  Scenario: Respuesta incorrecta
    Given La ventana conla pregunta y las respuestas
    When La respuesta es incorrecta
    Then Volvemos al tablero y comienza el turno para el siguiente jugador

