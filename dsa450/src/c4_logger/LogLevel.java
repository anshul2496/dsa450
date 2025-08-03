package c4_logger;

public enum LogLevel {
	DEBUG, INFO, WARN, ERROR, FATAL;

	public boolean isAsSevereAs(LogLevel other) {
		return this.ordinal() >= other.ordinal();
	}
}