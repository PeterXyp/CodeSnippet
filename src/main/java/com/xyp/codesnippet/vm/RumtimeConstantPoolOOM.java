package com.xyp.codesnippet.vm;

import java.util.ArrayList;
import java.util.List;

/**
 * Rumtime constant pool belongs to method area(also called PermGen Space)
 * String.intern() add a string to the runtime constant pool if not found in it
 *
 * @author Peter Xu
 *
 */
public class RumtimeConstantPoolOOM {

    /**
     * @param args Vm args: -XX:PermSize=10M -XX:MaxPermSize=10M
     */
    public static void main(String[] args) {
        List<String> list;
        list = new ArrayList<>();
        int i = 0;
        while (true) {
            list.add(String.valueOf(i++).intern());
        }
    }
}
