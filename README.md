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
Nuestro proyecto alberga una clase Main , en la cual se prueban algunos de los métodos más importantes de la estructura que hemos elegido , ConcurrentHashMap.

Esta estructura es ideal cuando varios hilos necesitan acceder y modificar el mapa simultáneamente proporciona operaciones seguras sin necesidad de bloquear todo el mapa , como se puede ver en el siguiente ejemplo
```java
ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();
map.put("A", 1);
map.put("B", 2);
```

Además , permite leer de forma simultánea las diferentes secciones del mapa sin bloquear el acceso a otras partes de la estructura
```java
int value = concurrentMap.getOrDefault("C", 0);
```

Las operaciones atómicas también existen este tipo de estructura , de la mano de los métodos putIfAbsent(), replace() , compute() , computeIfAbsent(), y computeIfPresent(). Estos métodos se ejecutan de manera segura y completa , sin intervención de otros hilos. En este caso 

```java
concurrentMap.putIfAbsent("C", 3);
```
Esta línea de código intenta agregar una entrada al mapa concurrentMap solo si la clave "C" no está presente. Si "C" ya está en el mapa, esta operación no tiene ningún efecto. Si "C" no está en el mapa, se agregará con el valor asociado de 3


```java
concurrentMap.replace("B", 2, 20);
```
Esta línea de código intenta reemplazar el valor asociado con la clave "B" en el mapa concurrentMap. Sin embargo, solo realizará el reemplazo si el valor actual asociado con "B" es igual a 2


El método reduce() permite realizar operaciones de reducción de manera paralela en los valores del mapa. Es útil cuando se trabaja con grandes conjuntos de datos y se busca mejorar el rendimiento a través de la concurrencia.En nuestro caso , se realizará una reducción acumulativa de los valores del mapa usando la operación de suma (Integer::sum), y el valor inicial del acumulador será 2.
```java
int total = concurrentMap.reduceValues(2, Integer::sum);
```

El método search facilita la búsqueda concurrente de una clave y un valor asociado utilizando una función de búsqueda personalizada.
```java
String result = concurrentMap.search(2, (key, val) -> {
    val > 10 ? key : null
});
```

La operación que se está realizando es una búsqueda en el mapa utilizando el valor inicial 2 y una función de búsqueda, la cual devuelve la clave si el valor asociado es mayor que 10; de lo contrario, devuelve null.

El método newKeySet() devuelve un conjunto concurrente respaldado por el mapa, lo que significa que cualquier cambio en el mapa se reflejará automáticamente en el conjunto y viceversa.
```java
ConcurrentHashMap.KeySetView<String, Boolean> keySet = concurrentMap.newKeySet();
```
En nuestro caso de uso utiliza el método anteriormente explicado para obtener una vista concurrente de las claves del mapa.Esa vista proporciona operaciones de conjunto Set en un contexto concurrente, lo que significa que puedes realizar operaciones como add, remove, e iterar sobre las claves de manera segura en un entorno con múltiples hilos de ejecución

Por último , los métodos replace() y remove() permiten reemplazar o eliminar una entrada condicionalmente, basándose en el valor actual asociado con la clave.
```java
concurrentMap.replace("A", 1, 100);
concurrentMap.remove("B", 20);
```

El primer método intenta reemplazar el valor asociado con la clave "A" en el concurrentMap. Sin embargo, solo realizará el reemplazo si el valor actual asociado con "A" es igual a 1. Si el valor actual no es 1, la operación no tendrá éxito y no se realizará ningún cambio en el mapa.

- Si el valor actual es 1, se reemplazará con 100.

El segundo de ellos intenta eliminar la entrada del mapa que tiene la clave "B" y el valor asociado igual a 20. La eliminación solo se realizará si la clave "B" está presente en el mapa y si el valor actual asociado con "B" es igual a 20.

- Si la clave "B" está presente y el valor es 20, la entrada correspondiente se eliminará del mapa.






