package com.reciperegistry.Service;

import static com.reciperegistry.Main.log;

/**
 * This class is responsible for logging.
 *
 * @author Szatmári Mihály
 */
public class CustomLogService {
    /**
     * Logs the Rest url from a controller.
     *
     * @param restUrl        the Rest url
     * @param controllerName the name of the controller
     */
    public static void controllerLog(String restUrl, String controllerName) {
        log.info("Called - " + restUrl + " rest from " + controllerName);
    }

    /**
     * Logs the function name url from a service.
     *
     * @param functionName the name of the function
     * @param serviceName  the name of the service
     */
    public static void serviceLog(String functionName, String serviceName) {
        log.info("Called - " + functionName + " from " + serviceName);
    }

    /**
     * Logs the entity name from the constructor.
     *
     * @param entityName the name of the entity
     */
    public static void entityLog(String entityName) {
        log.info("Called - " + entityName + " entity constructor");
    }

    /**
     * Logs the entity name from the empty constructor.
     *
     * @param entityName         the name of the entity
     * @param isConstructorEmpty the flag which determines that is it an empty constructor or not
     */
    public static void entityLog(String entityName, Boolean isConstructorEmpty) {
        log.info("Called - " + entityName + " (empty) entity constructor");
    }

    /**
     * Logs the model name from the constructor.
     *
     * @param modelName the name of the model
     */
    public static void modelLog(String modelName) {
        log.info("Called - " + modelName + " model constructor");
    }

    /**
     * Logs the model name from the empty constructor.
     *
     * @param modelName          the name of the model
     * @param isConstructorEmpty the flag which determines that is it an empty constructor or not
     */
    public static void modelLog(String modelName, Boolean isConstructorEmpty) {
        log.info("Called - " + modelName + " (empty) model constructor");
    }
}
