package ru.horn.enumtest;


import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Collections;
import java.util.List;
import java.util.Set;

//@AllArgsConstructor
//public enum TestEnum {
//
//    GROUP_1(Set.of("Jack", "Marry", "Abigale")),
//    GROUP_2(Set.of("Pearson", "Jannet", "Gabriella")),
//    GROUP_3(Set.of("Tom", "Will", "Matis")),
//    UNKNOWN(Collections.emptySet());
//
//    private final Set<String> people;
//
//    public static TestEnum of(String name) {
//        if (name == null || name.isEmpty()) return UNKNOWN;
//
//        for (TestEnum group : values()) {
//            if (group.name().equalsIgnoreCase(name)) {
//                return group;
//            }
//
//            for (String people : group.people) {
//                if (people.equalsIgnoreCase(name)) {
//                    return group;
//                }
//            }
//        }
//        return UNKNOWN;
//    }
//}

@AllArgsConstructor
public enum TestEnum {

    GROUP_1(Set.of("Will", "Thomas", "Venson")),
    GROUP_2(Set.of("Abigale", "Mikr", "Rojer")),
    GROUP_3(Set.of("Tilly", "Jeff", "Clay")),
    UNKNOWN(Collections.emptySet());

    public Set<String> people;

    public static TestEnum of(String name) {
        if (name == null || name.isEmpty()) {
            return UNKNOWN;
        }

        for (TestEnum group : values()) {
            if (group.name().equalsIgnoreCase(name)) {
                return group;
            }
            for (String people : group.people) {
                if (people.equalsIgnoreCase(name)) {
                    return group;
                }
            }
        }
        return UNKNOWN;
    }
}