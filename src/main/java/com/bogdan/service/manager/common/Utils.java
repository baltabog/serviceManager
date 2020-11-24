package com.bogdan.service.manager.common;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public final class Utils {

    private Utils() {
        // do nothing
    }

    public static <K> List<K> iteratorToList (Iterable<K> iterable) {
        return iterable != null
                ? StreamSupport.stream(iterable.spliterator(), false)
                .collect(Collectors.toList())
                : new ArrayList<>();
    }
}
