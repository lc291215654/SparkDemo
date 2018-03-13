package log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by licheng on 3/12/18.
 */
public class LoggerTest {
    private static final Logger logger = LoggerFactory.getLogger(LoggerTest.class);
    public static void main(String[] args) {
        int status = 0;
        if (status == 0) {
            logger.info("status:{},{}", status,status);
        } else {
            logger.info("status:{}", status);
        }
        logger.info("end!");
    }
}
