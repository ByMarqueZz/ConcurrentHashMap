#PROYECTO ESTRUCTURAS CONCURRENTES
Componentes: Juán Antonio, Félix, Jose María, Víctor.

Estructura concurrente: ConcurrentHashMap

Descripción de la estructura:

Introducción

Casos de uso

Tabla con los métodos de interés
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

Descripción de los ficheros del proyecto
