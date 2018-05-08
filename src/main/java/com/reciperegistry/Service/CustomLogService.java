package com.reciperegistry.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This class is responsible for logging.
 *
 * @author Szatmári Mihály
 */
public class CustomLogService {
    /**
     * This is the slf4j logger of the application.
     */
    private static Logger log = LoggerFactory.getLogger(CustomLogService.class);

    /**
     * Logs the Rest url from a controller.
     *
     * @param restUrl        the Rest url
     * @param controllerName the name of the controller
     */
    public static void
    controllerLog(final String restUrl, final String controllerName) {
        log.info("Called - " + restUrl + " rest from " + controllerName);
    }

    /**
     * Logs the function name url from a service.
     *
     * @param functionName the name of the function
     * @param serviceName  the name of the service
     */
    public static void
    serviceLog(final String functionName, final String serviceName) {
        log.info("Called - " + functionName + " from " + serviceName);
    }

    /**
     * Logs the entity name from the constructor.
     *
     * @param entityName the name of the entity
     */
    public static void
    entityLog(final String entityName) {
        log.info("Called - " + entityName + " entity constructor");
    }

    /**
     * Logs the entity name from the empty constructor.
     *
     * @param entityName         the name of the entity
     * @param isConstructorEmpty the flag which determines that
     *                           is it an empty constructor or not
     */
    public static void
    entityLog(final String entityName, final Boolean isConstructorEmpty) {
        log.info("Called - " + entityName + " (empty) entity constructor");
    }

    /**
     * Logs the model name from the constructor.
     *
     * @param modelName the name of the model
     */
    public static void
    modelLog(final String modelName) {
        log.info("Called - " + modelName + " model constructor");
    }

    /**
     * Logs the model name from the empty constructor.
     *
     * @param modelName          the name of the model
     * @param isConstructorEmpty the flag which determines that
     *                           is it an empty constructor or not
     */
    public static void
    modelLog(final String modelName, final Boolean isConstructorEmpty) {
        log.info("Called - " + modelName + " (empty) model constructor");
    }
}
