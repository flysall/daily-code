import com.foo.Bar;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class MyApp {
    private static final Logger logger = LogManager.getLogger(MyApp.class);

    public static void main(final String... args) {
        logger.trace("Entering application.");
        logger.info("Now it is ok.");
        Bar bar = new Bar();
        if(!bar.doIt()) 
            logger.error("Didn't do it.");
        logger.trace("Exiting application.");
    }
}

