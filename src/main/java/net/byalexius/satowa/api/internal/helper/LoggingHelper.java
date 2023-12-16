package net.byalexius.satowa.api.internal.helper;

import lombok.experimental.UtilityClass;
import net.byalexius.satowa.api.SatowaAPI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This is the LoggingHelper, it provides a format for System.out.println
 * @author <a href="https://www.github.com/ByAlexius">Alexander Rziha</a>
 */
@UtilityClass
public class LoggingHelper {

    public void debug(String message) {
        Logger logger = LoggerFactory.getLogger(SatowaAPI.class);

        if (!logger.isDebugEnabled())
            return;

        logger.debug(message);
    }

    public void debug(Class clazz, String message) {
        Logger logger = LoggerFactory.getLogger(clazz);

        if (!logger.isDebugEnabled())
            return;

        logger.debug(message);
    }

    public void info(String message) {
        Logger logger = LoggerFactory.getLogger(SatowaAPI.class);

        logger.info(message);
    }

    public void info(Class clazz, String message) {
        Logger logger = LoggerFactory.getLogger(clazz);

        logger.info(message);
    }

    public void error(String message) {
        Logger logger = LoggerFactory.getLogger(SatowaAPI.class);

        logger.error(message);
    }

    public void error(Class clazz, String message) {
        Logger logger = LoggerFactory.getLogger(clazz);

        logger.error(message);
    }

    public void error(Exception exception) {
        Logger logger = LoggerFactory.getLogger(SatowaAPI.class);

        logger.error(exception.toString());
    }

    public void error(Class clazz, Exception exception) {
        Logger logger = LoggerFactory.getLogger(clazz);

        logger.error(exception.toString());
    }
}
