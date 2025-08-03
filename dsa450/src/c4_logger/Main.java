package c4_logger;

/*
 * https://github.com/ashishps1/awesome-low-level-design/blob/main/solutions/java/src/loggingframework/README.md
 */
public class Main {
	public static void main(String[] args) {
		Logger logger = LogManager.getLogger();

		// Logging with default configuration
		// Should log debug and above log levels
		logger.info("This is an information message");
		logger.warn("This is a warning message");
		logger.error("This is an error message");

		// Changing log level
		logger.setMinLevel(LogLevel.WARN);

		// Should only log warn and above
		logger.debug("This is a debug message");
		logger.info("This is an information message");
		logger.warn("This is a warning message");

		logger.shutdown();
	}
}
