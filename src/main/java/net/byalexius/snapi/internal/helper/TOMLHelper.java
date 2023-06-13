package net.byalexius.snapi.internal.helper;

import com.moandjiezana.toml.Toml;
import net.byalexius.snapi.internal.common.Constants;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class TOMLHelper {

    public static Toml readConfig(String configName) {
        Toml config;

        ClassLoader classLoader = TOMLHelper.class.getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream(configName);

        if (inputStream == null) {
            LoggingHelper.Log(TOMLHelper.class, "Couldn't load TOML config " + configName, Constants.LogLevel.WARNING);
            return null;
        }

        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));

        return config = new Toml().read(reader);
    }

}
