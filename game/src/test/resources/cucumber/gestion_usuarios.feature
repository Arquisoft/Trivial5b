# language: es
Característica: Gestión de usuarios

Escenario: Crear el primer usuario

    Dada una lista vacía de usuarios
    Cuando creo un usuario de nombre "Pepe" y clave "Pepe12"
    Entonces el número de usuarios es 1

Escenario: Entrar en el sistema
	Dada la siguiente lista de usuarios:
      | nombre | clave   |
      | pepe   | pepe12  |
      | luis   | siul    |
      | mari   | 2mmm2   |
    Cuando introduzco el nombre "luis" y la clave "siul"
    Entonces puedo entrar en el sistema 
    
Escenario: Lista vacia de usuarios
	Dada una lista vacía de usuarios
    Cuando introduzco el nombre "pepe" y la clave "pepe12"
    Entonces no puedo entrar en el sistema

Escenario: Lista vacia de usuarios
	Dada una lista vacía de usuarios
    Cuando creo un usuario de nombre "Pepe" y clave "Pepe12"
    Y busco el usuario "Pepe"
    Entonces lo encuentro
    
Escenario: Intentar entrar con una clave falsa
   Dada la siguiente lista de usuarios:
      | nombre | clave   |
      | pepe   | pepe12  |
      | luis   | siul    |
      | mari   | 2mmm2   |
    Cuando introduzco el nombre "luis" y la clave "pepe12"
    Entonces no me deja entrar en el sistema

Escenario: Lista con dos usuarios
	Dada una lista vacía de usuarios
    Cuando creo un usuario de nombre "Pepe" y clave "Pepe12"
    Y creo otro usuario cualquiera
    Entonces el tamaño de la lista de usuarios es 2
    