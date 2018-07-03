import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class jdbcConnection {
	public static void main(String[] args) throws SQLException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Rajiv\\Downloads\\Selenium\\chromedriver.exe");
		//When connecting to the MySQL DB we need to specify user/password/host/port
		String host = "localhost";
		String port = "3306";
		Connection con = DriverManager.getConnection("jdbc:mysql://"+ host + ":" + port + "/demo", "root","Vijar123");
		//create a new statement on the connection
		Statement s = con.createStatement();
		//put our query into a resultant set. It is an array
		ResultSet rs = s.executeQuery("select * from credentials where scenario = 'rewardscard';");
		//Loop through the result set and print the following table values 
		while(rs.next()) {
		WebDriver driver = new ChromeDriver();
		driver.get("http://login.salesforce.com");
		driver.findElement(By.xpath(".//*[@id='username']")).sendKeys(rs.getString("username"));
		driver.findElement(By.xpath(".//*[@id='password']")).sendKeys(rs.getString("password"));
		
		}
		
	}
}
