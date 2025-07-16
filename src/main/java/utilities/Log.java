package utilities;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log {

    public static Logger getLogger() {
        String className = Thread.currentThread().getStackTrace()[3].getClassName();
        return LogManager.getLogger(className);
    }

    public static void info(String message) {
        getLogger().info(message);
    }

    public static void warn(String message) {
        getLogger().warn(message);
    }

    public static void error(String message) {
        getLogger().error(message);
    }

    public static void debug(String message) {
        getLogger().debug(message);
    }
}
