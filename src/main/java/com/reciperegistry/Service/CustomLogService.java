package com.reciperegistry.Service;

import static com.reciperegistry.Main.log;

public class CustomLogService {
    public static void controllerLog(String restUrl, String controllerName) {
        log.info("Called - " + restUrl + " rest from " + controllerName);
    }

    public static void serviceLog(String functionName, String serviceName) {
        log.info("Called - " + functionName + " from " + serviceName);
    }

    public static void entityLog(String entityName) {
        log.info("Called - " + entityName + " entity constructor");
    }

    public static void entityLog(String entityName, Boolean isConstructorEmpty) {
        log.info("Called - " + entityName + " (empty) entity constructor");
    }

    public static void modelLog(String modelName) {
        log.info("Called - " + modelName + " model constructor");
    }
}
