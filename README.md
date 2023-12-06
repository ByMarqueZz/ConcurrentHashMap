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

## Casos de uso
### Acceso Concurrente y Modificación Segura:
El ConcurrentHashMap es ideal cuando varios hilos necesitan acceder y modificar el mapa simultáneamente. 
Proporciona operaciones seguras sin necesidad de bloquear todo el mapa.
```java
ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();
map.put("A", 1);
map.put("B", 2);
```

### Evitar Bloqueos Costosos:
ConcurrentHashMap permite la lectura simultánea de diferentes 
secciones del mapa sin bloquear 
el acceso a otras partes de la estructura
```java
int value = concurrentMap.getOrDefault("C", 0);
```

### Operaciones Atómicas:
Métodos como putIfAbsent, replace, compute, computeIfAbsent, y computeIfPresent son operaciones atómicas, 
lo que significa que se ejecutan de manera segura y completa sin intervención de otros hilos.
```java
concurrentMap.putIfAbsent("C", 3);
concurrentMap.replace("B", 2, 20);
```

### Iteración Concurrente:
El método forEach permite la iteración sobre las entradas del mapa de manera segura en un entorno concurrente,
ya que utiliza mecanismos internos para garantizar la consistencia.
```java
concurrentMap.forEach((key, val) -> System.out.println(key + ": " + val));
```

### Reducción Paralela:
El método reduce permite realizar operaciones de reducción de manera paralela en los valores del mapa. Es útil cuando se trabaja con 
grandes conjuntos de datos y se busca mejorar el rendimiento a través de la concurrencia.
```java
int total = concurrentMap.reduceValues(2, Integer::sum);
```

### Búsqueda Concurrente:
El método search facilita la búsqueda concurrente de una clave y un valor asociado utilizando una función de búsqueda personalizada.
```java
String result = concurrentMap.search(2, (key, val) -> {
    val > 10 ? key : null
});
```

### Manipulación de Conjuntos Concurrentes:
El método newKeySet devuelve un conjunto concurrente respaldado por el mapa, lo que significa que cualquier cambio en el mapa se reflejará automáticamente en el conjunto y viceversa.
```java
ConcurrentHashMap.KeySetView<String, Boolean> keySet = concurrentMap.newKeySet();
```

### Reemplazo Condicional:
Los métodos replace y remove permiten reemplazar o eliminar una entrada condicionalmente, basándose en el valor actual asociado con la clave.
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
