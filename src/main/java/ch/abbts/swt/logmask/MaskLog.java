package ch.abbts.swt.logmask;

import org.apache.logging.log4j.core.LogEvent;
import org.apache.logging.log4j.core.config.plugins.Plugin;
import org.apache.logging.log4j.core.pattern.ConverterKeys;
import org.apache.logging.log4j.core.pattern.LogEventPatternConverter;

@Plugin(name = "logmask", category = "Converter")
@ConverterKeys({"m21"})

public class MaskLog extends LogEventPatternConverter {
  public MaskLog(String[] options) {
    super("m21", "m21");
  }

  public static MaskLog newInstance(final String[] options) {
    return new MaskLog(options);
  }

  @Override
  public void format(LogEvent logEvent, StringBuilder outputMsg) {
    String message = logEvent.getMessage().getFormat();
    String rcc = "\\b(?:\\d{4}[ -]?){3}(?=\\d{4}\\b)";
    outputMsg.append(message.replaceAll(rcc, "XXXX XXXX XXXX XXXX"));
  }
}
