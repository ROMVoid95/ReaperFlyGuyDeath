package net.romvoid95.mcdeath.Util;

import java.io.IOException;
import net.minecraft.launchwrapper.Launch;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MCDeathLog {
  private static Logger LOG = LogManager.getFormatterLogger("ReaperFlyGuyDeath");
  
  public static final boolean obf;
  
  static {
    boolean flag = false;
    try {
      flag = (Launch.classLoader.getClassBytes("net.minecraft.world.World") == null);
    } catch (IOException iOException) {}
    obf = flag;
  }
  
  private static void log(Level logLevel, Object object) {
    LOG.log(logLevel, String.valueOf(object));
  }
  
  private static void log(Level logLevel, Object object, Throwable throwable) {
    LOG.log(logLevel, String.valueOf(object), throwable);
  }
  
  public static void log(Object object) {
    if (obf)
      log(Level.INFO, "[DEV]: " + object); 
  }
  
  public void catching(Throwable throwable) {
    LOG.catching(throwable);
  }
  
  public void all(Object object) {
    log(Level.ALL, object);
  }
  
  public void debug(Object object) {
    log(Level.DEBUG, object);
  }
  
  public void error(Object object) {
    log(Level.ERROR, object);
  }
  
  public void fatal(Object object) {
    log(Level.FATAL, object);
  }
  
  public void info(Object object) {
    log(Level.INFO, object);
  }
  
  public void trace(Object object) {
    log(Level.TRACE, object);
  }
  
  public void warn(Object object) {
    log(Level.WARN, object);
  }
  
  public void all(String format, Object... object) {
    log(Level.ALL, String.format(format, object));
  }
  
  public void debug(String format, Object... object) {
    log(Level.DEBUG, String.format(format, object));
  }
  
  public void error(String format, Object... object) {
    log(Level.ERROR, String.format(format, object));
  }
  
  public void fatal(String format, Object... object) {
    log(Level.FATAL, String.format(format, object));
  }
  
  public void info(String format, Object... object) {
    log(Level.INFO, String.format(format, object));
  }
  
  public void trace(String format, Object... object) {
    log(Level.TRACE, String.format(format, object));
  }
  
  public void warn(String format, Object... object) {
    log(Level.WARN, String.format(format, object));
  }
  
  public void throwable_All(String object, Throwable throwable) {
    log(Level.ALL, object, throwable);
  }
  
  public void throwable_Debug(String object, Throwable throwable) {
    log(Level.DEBUG, object, throwable);
  }
  
  public void throwable_Error(String object, Throwable throwable) {
    log(Level.ERROR, object, throwable);
  }
  
  public void throwable_Fatal(String object, Throwable throwable) {
    log(Level.FATAL, object, throwable);
  }
  
  public void throwable_Info(String object, Throwable throwable) {
    log(Level.INFO, object, throwable);
  }
  
  public void throwable_Trace(String object, Throwable throwable) {
    log(Level.TRACE, object, throwable);
  }
  
  public void Throwable_Warn(String object, Throwable throwable) {
    log(Level.WARN, object, throwable);
  }
  
  public void bigAll(String format, Object... data) {
    StackTraceElement[] trace = Thread.currentThread().getStackTrace();
    all("****************************************");
    all("* " + format, data);
    for (int i = 2; i < 8 && i < trace.length; i++) {
      all("*  at %s%s", new Object[] { trace[i].toString(), (i == 7) ? "..." : "" });
    } 
    all("****************************************");
  }
  
  public void bigDebug(String format, Object... data) {
    StackTraceElement[] trace = Thread.currentThread().getStackTrace();
    debug("****************************************");
    debug("* " + format, data);
    for (int i = 2; i < 8 && i < trace.length; i++) {
      debug("*  at %s%s", new Object[] { trace[i].toString(), (i == 7) ? "..." : "" });
    } 
    debug("****************************************");
  }
  
  public void bigError(String format, Object... data) {
    StackTraceElement[] trace = Thread.currentThread().getStackTrace();
    error("****************************************");
    error("* " + format, data);
    for (int i = 2; i < 8 && i < trace.length; i++) {
      error("*  at %s%s", new Object[] { trace[i].toString(), (i == 7) ? "..." : "" });
    } 
    error("****************************************");
  }
  
  public void bigFatal(String format, Object... data) {
    StackTraceElement[] trace = Thread.currentThread().getStackTrace();
    fatal("****************************************");
    fatal("* " + format, data);
    for (int i = 2; i < 8 && i < trace.length; i++) {
      fatal("*  at %s%s", new Object[] { trace[i].toString(), (i == 7) ? "..." : "" });
    } 
    fatal("****************************************");
  }
  
  public void bigInfo(String format, Object... data) {
    StackTraceElement[] trace = Thread.currentThread().getStackTrace();
    info("****************************************");
    info("* " + format, data);
    for (int i = 2; i < 8 && i < trace.length; i++) {
      info("*  at %s%s", new Object[] { trace[i].toString(), (i == 7) ? "..." : "" });
    } 
    info("****************************************");
  }
  
  public void bigTrace(String format, Object... data) {
    StackTraceElement[] trace = Thread.currentThread().getStackTrace();
    trace("****************************************");
    trace("* " + format, data);
    for (int i = 2; i < 8 && i < trace.length; i++) {
      trace("*  at %s%s", new Object[] { trace[i].toString(), (i == 7) ? "..." : "" });
    } 
    trace("****************************************");
  }
  
  public void bigWarn(String format, Object... data) {
    StackTraceElement[] trace = Thread.currentThread().getStackTrace();
    warn("****************************************");
    warn("* " + format, data);
    for (int i = 2; i < 8 && i < trace.length; i++) {
      warn("*  at %s%s", new Object[] { trace[i].toString(), (i == 7) ? "..." : "" });
    } 
    warn("****************************************");
  }
}
