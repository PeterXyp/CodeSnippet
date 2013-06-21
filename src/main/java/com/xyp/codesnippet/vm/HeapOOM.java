package com.xyp.codesnippet.vm;

import java.util.ArrayList;
import java.util.List;

/**
 * heap out of memory error
 *
 * @author Peter Xu
 *
 */
public class HeapOOM {

    /**
     * @param args VM args -verbose:gc -Xms20M -Xmx20M -Xmn10M
     * -XX:+HeapDumpOnOutOfMemoryError
     */
    public static void main(String[] args) {
        List<Object> a = new ArrayList<Object>();
        while (true) {
            a.add(new Object());
        }
    }
}
