package com.biconsulting.ryankolbe.utility;

import java.util.UUID;

public class Misc {
    public static String generateId() {
        return UUID.randomUUID().toString();
    }
}
