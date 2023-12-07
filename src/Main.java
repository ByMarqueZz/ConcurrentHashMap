import java.util.concurrent.ConcurrentHashMap;
public class Main {
    public static void main(String[] args) {
        ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();
        map.put("A", 1);
        map.put("B", 2);

        System.out.println("________________________________");
        System.out.println("Mostramos el mapa");
        map.forEach((key, value) -> {
            System.out.println(key + " " + value);
        });

        int getValue = map.getOrDefault("A", 1);
        System.out.println("________________________________");
        System.out.println("Obtenemos el valor de la llave A");
        System.out.println(getValue);

        map.putIfAbsent("C", 3);
        map.replace("B", 2, 20);
        map.replace("B", 12311231, 211);
        map.remove("C", 3);

        System.out.println("________________________________");
        System.out.println("Mostramos el mapa después de las operaciones atómicas");
        map.forEach((key, value) -> {
            System.out.println(key + " " + value);
        });

        int total = map.reduceValues(2, Integer::sum);
        System.out.println("________________________________");
        System.out.println("Total: " + total);

        String result = map.search(2, (key, val) -> val > 10 ? key +" "+ val: null);
        System.out.println("________________________________");
        System.out.println("Resultado: " + result);

        ConcurrentHashMap.KeySetView<String, Boolean> keySet = map.newKeySet();
        keySet.add("D");
        keySet.add("E");

        System.out.println("________________________________");
        System.out.println("Mostramos el keySet");
        keySet.forEach((key) -> {
            System.out.println(key);
        });
    }
}