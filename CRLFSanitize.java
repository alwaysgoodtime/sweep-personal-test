package org.secidea.controller;

public class CRLFSanitize {
    public static String sanitize(String input) {
        return input.replaceAll("\r\n", "");
    }
}
