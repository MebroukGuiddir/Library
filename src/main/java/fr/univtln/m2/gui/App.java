package fr.univtln.m2.gui;

import java.util.Properties;

/**
 * Hello world!
 *
 */
public class App 
{   static final public Properties properties = new Properties();

    static {
        properties.setProperty("pu", "mypu");
    }
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
    }
}
