package net.byalexius.snapi.internal.common;

/**
 * These are the constant variables used throughout the project
 * @author <a href="https://www.github.com/ByAlexius">Alexander Rziha</a>
 */
public class Constants {

    public enum Platform {
        DISCORD("discord"),
        MINECRAFT("minecraft");
        public String label;

        Platform(String label) {
            this.label = label;
        }
    }

    public enum LogLevel {
        ERROR("ERROR"),
        WARNING("WARNING"),
        INFO("INFO"),
        DEBUG("DEBUG");
        public String label;

        LogLevel(String label) {
            this.label = label;
        }
    }

    public static final String RESET = "\033[0m";  // Text Reset

    public static final String BLACK = "\033[0;30m";   // BLACK
    public static final String RED = "\033[0;31m";     // RED
    public static final String GREEN = "\033[0;32m";   // GREEN
    public static final String YELLOW = "\033[0;33m";  // YELLOW
    public static final String BLUE = "\033[0;34m";    // BLUE
    public static final String PURPLE = "\033[0;35m";  // PURPLE
    public static final String CYAN = "\033[0;36m";    // CYAN
    public static final String WHITE = "\033[0;37m";   // WHITE
}
