package net.antra.restdemo.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogUtiles {
    private static Logger log= LoggerFactory.getLogger(LogUtiles.class);

    public static Logger getLog(){
        return log;
    }
}
