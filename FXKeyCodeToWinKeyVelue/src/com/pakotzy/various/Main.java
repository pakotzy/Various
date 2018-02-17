package com.pakotzy.various;

import javafx.scene.input.KeyCode;

import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
	    System.out.println("Start");
	    Set<Integer> code = new HashSet<>();

    	for (int i = 1; i <= 254; i++) {
    		if (i == 7 || i == 10 || i == 11 || i == 14 || i == 15 || i == 26 || (i >= 58 & i <= 65) || i == 94 || (i
				    >= 146 && i <= 159) || i == 184 || i == 185 || (i >= 193 && i <= 218) || i == 224 || i == 225 ||
				    i == 227 || i == 228 || i == 230 || (i >= 232 && i <= 245)) {
    			continue;
		    }
		    code.add(i);
	    }

	    int count = 0;
        for (KeyCode keyCode : KeyCode.values()) {
    		if (code.contains(keyCode.impl_getCode())) {
			    System.out.printf("\t\tmap.put(\"%s\", KeyCode.%s);\n", keyCode.getName().toLowerCase(), keyCode
					    .toString());
			    count++;
		    }
        }
	    System.out.println(count);
	    System.out.println("End");
    }
}
