package com.bpc.utils;

import com.bpc.model.ScoringRule;

import java.io.FileDescriptor;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: do_th
 * Date: 11/21/11
 * Time: 9:38 AM
 * To change this template use File | Settings | File Templates.
 */
public final class ClassFieldNameUtils {

    public static String[] getFieldNames(String className) {
        List<String> filedNames = null;
        try {
            Class cl = Class.forName(className);
            Field fields[] = cl.getDeclaredFields();
            if (fields != null) {
                int numField = fields.length;
                filedNames = new ArrayList<String>();
                for (int i = 0; i < numField; i++) {
                    if (!(fields[i].getType().getName().equals("java.util.List"))) {
                        filedNames.add(fields[i].getName());
                    }
                }
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        if (filedNames != null) {
            return  filedNames.toArray(new String[filedNames.size()]);
        } else {
            return null;
        }

    }

    public static String[] getFieldNames(Class cl) {
        return getFieldNames(cl.getName());
    }

    public static void main(String agr[]) {
        String fields[] = getFieldNames(ScoringRule.class);
        if (fields != null) {
            for (int i = 0; i < fields.length; i++) {
                System.out.println(fields[i]);
            }
        }
    }
}
