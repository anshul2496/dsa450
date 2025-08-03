package c4_logger.appender;

import c4_logger.LogMessage;

public interface LogAppender {
	void append(LogMessage logMessage);
}
