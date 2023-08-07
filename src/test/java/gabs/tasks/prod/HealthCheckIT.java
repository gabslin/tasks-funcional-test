package gabs.tasks.prod;

import java.net.MalformedURLException;
import java.net.URL;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class HealthCheckIT {
	
	@Test
	public void healthCheck( ) throws MalformedURLException {
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setBrowserName("chrome");
		WebDriver driver = null;
		try {
		driver = new RemoteWebDriver(
				new URL("http://193.123.103.197:4444/"), cap);
		driver.navigate().to("http://193.123.103.197:9999/tasks/");
		String version = driver.findElement(By.id("version")).getText();
		Assert.assertTrue(version.startsWith("build"));
		}
		finally {
			driver.quit();
		}
			
	}
}
