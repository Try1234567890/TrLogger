package me.tr.trlogger;

import me.tr.trlogger.loggers.ConsoleLogger;
import org.junit.jupiter.api.Test;

public class LoggerTest {

    @Test
    public void testLoggers() {
        ConsoleLogger LOGGER = new ConsoleLogger();


        LOGGER.info("MESSAGE");
    }

}
