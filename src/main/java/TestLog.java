import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import org.apache.log4j.Logger;


public class TestLog {
	
	WebDriver driver;
	
	@Test
	public void RootLoggerDemo()
	{
		Logger log = Logger.getRootLogger();
		log.trace("Trace message!");
				log.debug("debug message");	
						log.info("info message!");
								log.warn("warn message!");
										log.error("error message!");
												log.fatal("fatal message!");
	}

@Test
public void ManualLoggerDemo()
{
	Logger log = Logger.getLogger("manualLogger");
	log.trace("trace message");
	log.debug("debug message");
	log.info("info message");
	log.warn("warn message");
	log.error("error message");
	log.fatal("fatal message");
	
	
	
}
}
