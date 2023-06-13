package net.byalexius.snapi.internal.helper;

import net.byalexius.snapi.internal.common.Constants;

public class LoggingHelper {

    public static void Log(Class clazz, String message, Constants.LogLevel level) {
        switch (level) {
            case ERROR -> System.out.println(Constants.RED + "[" + level.label + "] - " + Constants.RESET + clazz.getName() + " : " + message);
            case WARNING -> System.out.println(Constants.YELLOW + "[" + level.label + "] - " + Constants.RESET + clazz.getName() + " : " + message);
            case INFO -> System.out.println(Constants.GREEN + "[" + level.label + "] - " + Constants.RESET + clazz.getName() + " : " + message);
            case DEBUG -> System.out.println(Constants.CYAN + "[" + level.label + "] - " + Constants.RESET + clazz.getName() + " : " + message);
        }
    }

    public static void LogError(Class clazz, Exception e, Constants.LogLevel level) {
        System.out.println(Constants.RED + "[" + level.label + "] - " + Constants.RESET + clazz.getName() + " : " + e);
    }

}
