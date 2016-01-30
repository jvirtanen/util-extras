package org.jvirtanen.util;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigException;
import com.typesafe.config.ConfigFactory;
import java.io.File;
import java.io.FileNotFoundException;

/**
 * This class contains utility methods for applications.
 */
public class Applications {

    private Applications() {
    }

    /**
     * Parse a configuration file.
     *
     * @param filename the configuration filename
     * @return the configuration object
     * @throws ConfigException if an I/O error occurs
     * @throws FileNotFoundException if the file is not found
     */
    public static Config config(String filename) throws FileNotFoundException {
        File file = new File(filename);
        if (!file.exists() || !file.isFile())
            throw new FileNotFoundException(filename + ": No such file");

        return ConfigFactory.parseFile(file);
    }

    /**
     * Print an error message to the standard error and terminate.
     *
     * @param message the error message
     */
    public static void error(String message) {
        System.err.println("error: " + message);
        System.exit(1);
    }

    /**
     * Print a throwable's message to the standard error and terminate.
     *
     * @param throwable a throwable
     */
    public static void error(Throwable throwable) {
        error(throwable.getMessage());
    }

    /**
     * Print a throwable's message and stack trace to the standard error and
     * terminate.
     *
     * @param throwable a throwable
     */
    public static void fatal(Throwable throwable) {
        System.err.println("fatal: " + throwable.getMessage());
        System.err.println();
        throwable.printStackTrace(System.err);
        System.err.println();
        System.exit(1);
    }

    /**
     * Print a usage message to the standard error and terminate.
     *
     * @param message the usage message
     */
    public static void usage(String message) {
        System.err.println("Usage: " + message);
        System.exit(2);
    }

}
