package com.bookapi.logs;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.bookapi.report.ExtentFactory;


public class WrappedReportLogger {

	private static final Logger logger = LogManager.getLogger(WrappedReportLogger.class);
	

	public static void trace(String message) {
		logger.trace(message);
		ExtentFactory.getInstance().getExtentTest().info(message);
	}

	public static void debug(String message) {
		logger.debug(message);
		ExtentFactory.getInstance().getExtentTest().info(message);
	}


	public static void info(String message) {
		logger.info(ConsoleColors.GREEN+message+ConsoleColors.RESET);
	}
	
	
	public static void warn(String message) {
		logger.warn(ConsoleColors.YELLOW+message+ConsoleColors.RESET);
		ExtentFactory.getInstance().getExtentTest().warning(message);
	}


	public static void error(String message) {
		logger.error(ConsoleColors.RED_BOLD+message+ConsoleColors.RESET);
		
	}

	public static void fatal(String message) {
		logger.fatal(ConsoleColors.RED_BOLD+message+ConsoleColors.RESET);
		ExtentFactory.getInstance().getExtentTest().fail(message);
	}

}
