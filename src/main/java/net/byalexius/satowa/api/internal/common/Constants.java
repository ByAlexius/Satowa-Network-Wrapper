package net.byalexius.satowa.api.internal.common;

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
        public final String label;

        LogLevel(String label) {
            this.label = label;
        }
    }
}
