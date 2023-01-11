package ru.horn.enumtest;
//
//import lombok.AllArgsConstructor;
//import lombok.Getter;
//
//import java.util.Collections;
//import java.util.Set;
//
//@Getter
//@AllArgsConstructor
//public enum TestEnum {
//    GROUP_1(Set.of("Will", "John", "Charles")),
//    GROUP_2(Set.of("Tom", "Robin", "Jack")),
//    GROUP_3(Set.of("Tilly", "Marry", "Janny")),
//    UNKNOWN(Collections.emptySet());
//
//    private final Set<String> persons;
//
//    public static TestEnum of(String name) {
//
//        if (name == null || name.isEmpty()) return UNKNOWN;
//
//        for (TestEnum group : values()) {
//            if (group.name().equalsIgnoreCase(name)) {
//                return group;
//            }
//
//            for (String person : group.persons) {
//                if (person.equalsIgnoreCase(name)) {
//                    return group;
//                }
//            }
//        }
//        return UNKNOWN;
//    }
//}

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Collections;
import java.util.Set;

@Getter
@AllArgsConstructor
public enum TestEnum {
    GROUP_1(Set.of("Sady", "Grimshaw", "Alex")),
    GROUP_2(Set.of("Colm", "Jack", "Frisk")),
    GROUP_3(Set.of("James", "Sans", "Monty")),
    UNKNOWN(Collections.emptySet());

    private final Set<String> peoples;

    public static TestEnum of(String name) {
        if (name == null || name.isEmpty()) return UNKNOWN;

        for (TestEnum group : values()){
            if (group.name().equalsIgnoreCase(name)){
                return group;
            }

            for (String people : group.peoples){
                if (people.equalsIgnoreCase(name)){
                    return group;
                }
            }
        }

        return UNKNOWN;
    }
}