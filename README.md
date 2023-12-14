# PROYECTO ESTRUCTURAS CONCURRENTES

### Componentes: 
Juán Antonio Márquez, Félix, Jose María, Víctor.

### Estructura concurrente: 
ConcurrentHashMap

### Descripción de la estructura: 
ConcurrentHashMap es una estructura de 
datos en Java diseñada para soportar operaciones concurrentes sin necesidad 
de utilizar bloqueos explícitos, como los que se usarían en un HashMap convencional.

## Introducción
ConcurrentHashMap. En el constante flujo de la evolución tecnológica, donde la
paralelización y la concurrencia se han vuelto la norma más que la excepción,
entender cómo gestionar eficientemente datos compartidos entre múltiples hilos se
vuelve imperativo.
### Orígenes de ConcurrentHashMap:
La historia de ConcurrentHashMap se remonta a la necesidad crítica de abordar los
desafíos de la concurrencia en aplicaciones Java. Esta estructura de datos se
introdujo por primera vez en Java 5 como parte del paquete java.util.concurrent. Su
creación fue una respuesta a las limitaciones observadas en otras
implementaciones de Map en entornos multi-hilo, como HashMap, que no estaban
diseñadas para manejar de manera segura operaciones concurrentes sin una
sincronización externa.

La motivación detrás de ConcurrentHashMap radica en proporcionar una solución
eficiente y segura para escenarios donde múltiples hilos intentan acceder y
modificar simultáneamente una estructura de datos compartida. Surge como una
mejora significativa sobre Hashtable y otros mecanismos de sincronización,
minimizando el bloqueo generalizado y permitiendo un rendimiento más escalable
en entornos con alta concurrencia.
### Características Clave:
Lo que distingue a ConcurrentHashMap es su capacidad para admitir múltiples
operaciones de lectura concurrentes sin bloqueo, al tiempo que proporciona un
mecanismo seguro y eficiente para operaciones de escritura. Logra esto mediante el
uso de segmentos internos y técnicas avanzadas de gestión de bloqueo,
permitiendo que múltiples hilos realicen operaciones simultáneamente en diferentes
segmentos de la estructura, reduciendo así la necesidad de bloquear la estructura
completa.
### Implementación y Funcionamiento:
A medida que profundizamos en nuestra exposición, exploraremos la
implementación interna de ConcurrentHashMap, analizando cómo se gestionan las
colisiones, cómo se distribuyen las claves y cómo se garantiza la coherencia en
operaciones concurrentes.
### Escenarios de Uso Práctico:

Además, abordaremos los escenarios de uso práctico donde ConcurrentHashMap
brilla con luz propia. Desde aplicaciones de alto rendimiento en sistemas
distribuidos hasta su papel fundamental en la gestión de caches, entenderemos
cómo esta estructura de datos se ha convertido en una herramienta esencial en el kit
de desarrollo de aplicaciones concurrentes en Java.

En resumen, lo que exploraremos hoy es más que una estructura de datos; es un
componente clave en la arquitectura de software moderna que nos permite navegar
por el desafiante terreno de la concurrencia con confianza y eficiencia. ¡Sin más
demora, sumerjámonos en el fascinante mundo de ConcurrentHashMap y
descubramos cómo transforma la complejidad de la concurrencia en una elegante
solución para desarrolladores Java!

## Casos de uso
### Acceso Concurrente y Modificación Segura:
```java
ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();
map.put("A", 1);
map.put("B", 2);
```

### Evitar Bloqueos Costosos:
```java
int value = concurrentMap.getOrDefault("C", 0);
```

### Operaciones Atómicas:
```java
concurrentMap.putIfAbsent("C", 3);
concurrentMap.replace("B", 2, 20);
```

### Iteración Concurrente:
```java
concurrentMap.forEach((key, val) -> System.out.println(key + ": " + val));
```

### Reducción Paralela:
```java
int total = concurrentMap.reduceValues(2, Integer::sum);
```

### Búsqueda Concurrente:
```java
String result = concurrentMap.search(2, (key, val) -> {
    val > 10 ? key : null
});
```

### Manipulación de Conjuntos Concurrentes:
```java
ConcurrentHashMap.KeySetView<String, Boolean> keySet = concurrentMap.newKeySet();
```

### Reemplazo Condicional:
```java
concurrentMap.replace("A", 1, 100);
concurrentMap.remove("B", 20);
```

## Tabla con los métodos de interés
<table>
    <tr>
        <th>Método</th>
        <th>Definición</th>
    </tr>
    <tr>
        <td><code>putIfAbsent(K key, V value)</code></td>
        <td>Añade una entrada al mapa si la clave no está presente.</td>
    </tr>
    <tr>
        <td><code>compute(K key, BiFunction<? super K, ? super V, ? extends V> remappingFunction)</code></td>
        <td>Realiza una transformación atómica en el valor asociado con la clave.</td>
    </tr>
    <tr>
        <td><code>merge(K key, V value, BiFunction<? super V, ? super V, ? extends V> remappingFunction)</code></td>
        <td>Combina el valor dado con el valor existente asociado con la clave.</td>
    </tr>
    <tr>
        <td><code>forEach(ConcurrentHashMap.BiConsumer<? super K, ? super V> action)</code></td>
        <td>Ejecuta la acción proporcionada en cada entrada del mapa.</td>
    </tr>
    <tr>
        <td><code>newKeySet()</code></td>
        <td>Devuelve un conjunto concurrente respaldado por el mapa, reflejando cambios en el mapa.</td>
    </tr>
    <tr>
        <td><code>replace(K key, V oldValue, V newValue)</code></td>
        <td>Reemplaza el valor asociado con la clave si el valor existente coincide con el valor especificado.</td>
    </tr>
    <tr>
        <td><code>replace(K key, V value)</code></td>
        <td>Reemplaza el valor asociado con la clave especificada. Operación atómica.</td>
    </tr>
    <tr>
        <td><code>replaceAll(BiFunction<? super K, ? super V, ? extends V> function)</code></td>
        <td>Reemplaza cada valor en el mapa con el resultado de aplicar la función proporcionada.</td>
    </tr>
    <tr>
        <td><code>remove(Object key, Object value)</code></td>
        <td>Elimina la entrada con la clave dada solo si está actualmente mapeada al valor especificado.</td>
    </tr>
    <tr>
        <td><code>search(K key, BiFunction<? super K, ? super V, ? extends U> searchFunction)</code></td>
        <td>Busca una clave y un valor asociado en el mapa utilizando la función de búsqueda proporcionada.</td>
    </tr>
    <tr>
        <td><code>reduce(int parallelismThreshold, BiFunction<? super K, ? super V, ? extends U> transformer, BiFunction<? super U, ? super U, ? extends U> reducer)</code></td>
        <td>Realiza una reducción paralela en los valores del mapa utilizando funciones de transformación y reducción.</td>
    </tr>
    <tr>
        <td><code>computeIfAbsent(K key, Function<? super K, ? extends V> mappingFunction)</code></td>
        <td>Si la clave no está presente, realiza una llamada a la función de mapeo y coloca el resultado en el mapa.</td>
    </tr>
    <tr>
        <td><code>computeIfPresent(K key, BiFunction<? super K, ? super V, ? extends V> remappingFunction)</code></td>
        <td>Si la clave está presente, realiza una llamada a la función de remapeo y actualiza el valor en el mapa.</td>
    </tr>
</table>

## Descripción de los ficheros del proyecto
## Concert

La clase Concert representa un concierto y se encarga de gestionar la reserva de entradas para los clientes. Ahora , veremos en detalle cada una de las partes de esta clase

__Atributo availableTickets__: Objeto de tipo ConcurrentHashMap, la clave del mapa es un entero (ID del ticket) y el valor es un objeto de tipo Ticket.

__Constructor Concert__: Este constructor crea un nuevo concierto con un número específico de entradas . Se inicializa el ConcurrentHashMap y se llenan las entradas en un bucle for utilizando un ID de ticket como clave y un nuevo objeto Ticket como valor.

__Método reservedTicket__: Este método permite a un cliente reservar un ticket para el concierto. Primero, se obtiene una vista de las claves del mapa utilizando keySet(). Luego, se utiliza stream() para procesar las claves de manera funcional. Se filtran los tickets no reservados, se encuentra el primero disponible usando findFirst(), y se actualiza su estado a reservado asignando al cliente actual (customer) y marcando el ticket como reservado. Si no hay tickets disponibles, se imprime un mensaje indicando que no hay tickets disponibles para ese cliente.

__Método showTickets()__: Muestra una representación visual de los tickets disponibles y sus estados (reservado o no). Itera sobre el ConcurrentHashMap y, para cada ticket, imprime su ID, estado de reserva y, si está reservado, el cliente que lo reservó.

Concert posibilita la gestión de tickets de un concierto, permitiendo la reserva de tickets por parte de los clientes y mostrando el estado actual de los tickets.


## Customer

Esta clase Customer extiende la clase Thread, lo que conlleva que cada objeto Customer puede ejecutar su propia secuencia de instrucciones de manera independiente en un hilo separado. Está diseñada para representar a un cliente que quiere reservar un ticket para un concierto. Entrando más en detalle:

__Atributo name__: Nombre del cliente.

__Atributo concert__: Referencia al objeto Concert, que representa el concierto al que el cliente desea asistir.

__Constructor__:Recibe el nombre del cliente y una referencia al objeto Concert, además de inicializar los atributos name y concert.

__Método run()__:Método invocado cuando se inicia un nuevo hilo para un objeto Customer.Llama al método reservedTicket() del objeto Concert al que el cliente está asociado. Esto simula que el cliente está intentando reservar un ticket para el concierto.

__Método toString()__:Devuelve el nombre del cliente.

La clase Customer simboliza un cliente que puede ejecutar su lógica de reserva de tickets en un hilo separado. Al llamar al método run(), el cliente intenta reservar un ticket para el concierto al que está asociado, utilizando el método reservedTicket() del objeto Concert. La idea es simular la concurrencia de múltiples clientes intentando reservar tickets para el concierto al mismo tiempo.



## Ticket

Por último, esta clase representa un boleto para el concierto.

Atributos

__id__: Identificador único del boleto.

__reserved__: Objeto de tipo AtomicBoolean, que proporciona operaciones atómicas para la variable booleana reserved. Nos es útil para evitar problemas de concurrencia.

__customer__: Referencia al objeto Customer que reservó el boleto. Puede ser null si el boleto no está reservado.


__Constructor Ticket__: Inicializa el identificador y crea un nuevo AtomicBoolean con valor inicial false para el estado de reserva del boleto. Además, inicializa el cliente como null.


__Método getId()__: Devuelve el identificador del boleto.

__Método isReserved()__: Devuelve true si el boleto está reservado y false en caso contrario.


__Método setReserved__:Establece el estado de reserva del boleto

__Método getCustomer()__:Devuelve el objeto Customer asociado con el boleto. Puede devolver null si el boleto no está reservado.

__Método setCustomer__:Asigna el objeto Customer que ha reservado el boleto. Este método se llama cuando un cliente reserva un ticket.


Para concluir esta última clase  , se puede resumir en la representación de la información asociada a un boleto, incluyendo su identificador, estado de reserva y el cliente que lo ha reservado. La utilización de AtomicBoolean para gestionar la reserva garantiza una manipulación segura y atómica del estado de reserva,  lo cual es relevante en el contexto del sistema de conciertos que involucra la concurrencia de múltiples clientes.



## Main

La clase Main tiene un solo objetivo , el cual es simular el funcionamiento del programa , creando un concierto con 10 tickets disponibles , según se aprecia en la creación de dicho objeto; a continuación , se crea una colección de clientes , que van a comprar el ticket cuando se ejecuta el método start() , para que más tarde se coordinen todos los hilos mediante el método join() , y finalmente se muestre el estado de los tickets