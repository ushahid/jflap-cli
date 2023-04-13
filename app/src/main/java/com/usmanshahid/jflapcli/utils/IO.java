package com.usmanshahid.jflapcli.utils;

import edu.duke.cs.jflap.file.XMLCodec;
import java.io.Serializable;

import java.io.File;


public final class IO {
    private IO(){}

    public static Serializable loadJflapFile(String filepath){
        File f = new File(filepath);
        // Check if the location is a file
        if (f.isFile()){
            return new XMLCodec().decode(f, null);
        }
        throw new RuntimeException(f.getAbsolutePath() + " does not exist");
    }
}