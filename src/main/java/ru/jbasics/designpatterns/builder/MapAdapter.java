package ru.jbasics.designpatterns.builder;

import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/*

http://javarevisited.blogspot.ru/2016/08/adapter-design-pattern-in-java-example.html

* This class is an adapter which allows to create a Map by providing a two
* dimensional array of keys and values. It extends AbstractMap class so that it
* become a Map and can be passed around where a Map is needed. All other method
* is implemented in AbstractMap except the adapter functionality which is
* implemented in constructor of this class.
*/

class MapAdapter extends AbstractMap {
    private Map map;

    public MapAdapter(Object[][] array) {
        super();
        map = new HashMap();
        for (Object[] mapping : array) {
            map.put(mapping[0], mapping[1]);
        }
    }

    @Override
    public Set entrySet() {
        return map.entrySet();
    }
}
