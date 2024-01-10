package courses.oop.collections;

import courses.oop.Person;
import courses.oop.PersonSex;

import java.util.*;

public class CollectionExample {

    public static void main(String[] args) {
        CollectionExample collectionExample = new CollectionExample();

        int[] numbers = {1, 2, 3, 4};

        numbers[3] = 100;
        for (int i = 0; i <= numbers.length - 1; i++) {
            System.out.print(numbers[i] + " ");
        }

        Person[] people = {new Person("Popescu Ion", "111111111111114", PersonSex.MASCULIN), new Person("Maria Ionescu", "211222567896543", PersonSex.FEMININ)};

        System.out.println();
        System.out.println("Equivalent way to display list values:");
        for (Person person : people)
            System.out.println(person);

        collectionExample.workWithArrays();
        collectionExample.workWithSets();
        collectionExample.workWithHashMap();
    }

    public void workWithArrays() {
        System.out.println("Work with LISTS");
        List list1 = new ArrayList<>();
        list1.add(1);
        list1.add("Ion");
        list1.add(new Person("Popescu Ion", "111111111111114", PersonSex.MASCULIN));

        displayList(list1);
        List<String> names = new ArrayList<>();
        names.add("Ion");
        names.add("Vasile");
        names.add("Maria");
        names.remove("Ion");
        displayList(names);

        System.out.println("Element on first poz:" + names.get(0));
        System.out.println("Name Ion is on list:" + names.contains("Ion"));
        System.out.println("Maria position on list:" + (names.indexOf("Maria") + 1));

        names.set(1, "Marioara");
        displayList(names);
        System.out.println("Add new element with index");
        names.add(1, "Ion");
        names.add("Ion");
        displayList(names);
    }

    public void workWithSets() {
        System.out.println("Work with sets:");
        HashSet<String> setList = new HashSet<>();
        setList.add("Ion");
        setList.add("Ion");
        setList.add("Maria");
        setList.add("Vasile");
        setList.add("Cristiana");

        HashSet<String> copySet = (HashSet<String>) setList.clone();
        System.out.println("Copy set is equal with setList:" + copySet.equals(setList));

        for (String el : setList)
            System.out.println(el);
    }

    public void workWithHashMap() {
        System.out.println("Work with hashmap");
        Map<Integer, Integer> map = new HashMap<>();
        map.put(1, 4);
        map.put(2, 6);
        map.put(3, 4);
        map.put(7, 4);
        map.put(3, 5);

        System.out.println(map.get(3));
        displayHashMap(map);
        map.remove(7);
        displayHashMap(map);

        Map<Integer, List<String>> apartments = new HashMap<>();
        List<String> numeAp1 = new ArrayList<>();
        numeAp1.add("Ion");
        numeAp1.add("Maria");
//        add to map
        apartments.put(1, numeAp1);
        displayHashMapWithList(apartments);
    }

    public void displayList(List list) {
        for (Object ob : list)
            System.out.println(ob);
    }

    public void displayHashMap(Map map) {
        for (Object key : map.keySet())
            System.out.println(key + "->" + map.get(key));
    }

    public void displayHashMapWithList(Map<Integer, List<String>> integerListMap) {
        for (Object key : integerListMap.keySet()) {
            System.out.println(key + "->");
            displayList(integerListMap.get(key));
        }
    }
}
