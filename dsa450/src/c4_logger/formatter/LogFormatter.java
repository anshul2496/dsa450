package c4_logger.formatter;

import c4_logger.LogMessage;

public interface LogFormatter {
	String format(LogMessage message);
}
