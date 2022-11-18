/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sets;

/**
 *
 * @author jacob
 */
import java.util.*;
import java.util.Map.Entry;

public class TestMap {

    public static void main(String[] args) {
        // Create a HashMap
        Map<String, Integer> hashMap = new HashMap<>();
        hashMap.put("Smith", 30);
        hashMap.put("Anderson", 31);
        hashMap.put("Lewis", 29);
        hashMap.put("Cook", 29);

        System.out.println("Display entries in HashMap");
        System.out.println(hashMap + "\n");

        // Create a TreeMap from the preceding HashMap
        Map<String, Integer> treeMap = new TreeMap<>(hashMap);
        System.out.println("Display entries in ascending order of key");
        System.out.println(treeMap);

        // Create a LinkedHashMap
        Map<String, Integer> linkedHashMap
                = new LinkedHashMap<>(16, 0.75f, true);
        linkedHashMap.put("Smith", 30);
        linkedHashMap.put("Anderson", 31);
        linkedHashMap.put("Lewis", 29);
        linkedHashMap.put("Cook", 29);

        // Display the age for Lewis
        System.out.println("\nThe age for " + "Lewis is "
                + linkedHashMap.get("Lewis"));

        System.out.println("Display entries in LinkedHashMap");
        System.out.println(linkedHashMap);

        // Display each entry with name and age
        System.out.print("\nNames and ages are ");
        treeMap.forEach(
                (name, age) -> System.out.print(name + ": " + age + " "));

        Set<Entry<String, Integer>> entrySet = linkedHashMap.entrySet();
        Set<String> keySet = linkedHashMap.keySet();
        Collection<Integer> valuesCollection = linkedHashMap.values();

        System.out.println("\n------------------------------------------------------------------------");
        System.out.println(entrySet);
        System.out.println(keySet);
        System.out.println(valuesCollection);

        Iterator<Entry<String, Integer>> it = entrySet.iterator();

        while (it.hasNext()) {
            it.next().setValue(1000);
        }
        System.out.println(linkedHashMap);
    }
}
