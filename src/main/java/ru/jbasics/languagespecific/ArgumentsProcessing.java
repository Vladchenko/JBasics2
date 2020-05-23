/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.jbasics.languagespecific;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * Processing a command line arguments.
 *
 * @author v.yanchenko
 */
public class ArgumentsProcessing {

    // Keeps a couples of "value=key" arguments, like sectors=1024;
    Map<String, String> mapArguments = new HashMap();
    // Keeps a strings of arguments;
    List<String> lstArguments = new ArrayList<String>();

    public ArgumentsProcessing(String[] args) {
        System.out.println("Command line arguments are: ");
        printArguments(args);
        processArgs(args);
        System.out.println("\nProcessed command line arguments are: ");
        printProcessedArguments(mapArguments, lstArguments);
    }

    // Putting a couples of "value=key" to a map and strings to list.
    public void processArgs(String[] args) {
        String[] pair = new String[2];
        pair[0] = new String();
        pair[1] = new String();
        if (args != null) {
            for (String arg : args) {
                if (arg.indexOf('=') == arg.length() - 1) {
                    lstArguments.add(arg);
                    continue;
                }
                pair = arg.split("=");
                if (pair.length > 1) {
                    if (!pair[0].isEmpty()) {
                        mapArguments.put(pair[0], pair[1]);
                    } else {
                        lstArguments.add("=" + pair[1]);
                    }
                } else {
                    lstArguments.add(pair[0]);
                }
//                {
//                    System.out.println("Command line arguments are not present.");
//                }
            }
        }

    }

    public void printProcessedArguments(Map<String, String> map, List list) {
        if (map.size() != 0) {
            System.out.print("Key = Value pairs: ");
            for (Map.Entry<String, String> entrySet : map.entrySet()) {
                System.out.print(entrySet.getKey() + " = " + entrySet.getValue()
                        + ", ");
            }
            System.out.println();
        }
        System.out.print("Values: ");
        if (list.size() != 0) {
            for (Object list1 : list) {
                System.out.print(list1 + ", ");
            }
        }
    }
    
    public void printArguments(String[] arguments) {
        for(String str : arguments) {
            System.out.print(str + " ");
        }
    }
}
