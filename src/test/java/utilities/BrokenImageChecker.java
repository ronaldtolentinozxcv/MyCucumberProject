package utilities;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BrokenImageChecker {
	
	WebDriver driver;
	
	public BrokenImageChecker(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void verifyAllImages()
	{
		List<WebElement> imgList=driver.findElements(By.xpath("//img"));
		System.out.println("Total images found: "+imgList.size());
		
		int brokenCount=0;
		
		for(WebElement imgElement : imgList)
		{
			String imgUrl=imgElement.getAttribute("src");
			if (!verifyImageUrl(imgUrl))
			{
				brokenCount++;
			}
		}
		System.out.println("Total broken images: "+ brokenCount);
		if(brokenCount>0) {
			throw new AssertionError ("Found " + brokenCount + "broken images on the page");
			
		}		
	}
	
	public boolean verifyImageUrl(String imgUrl)
	{
		try {
		if (imgUrl==null || imgUrl.isEmpty())
		{
			System.out.println("Image src is empty or null");
			return false;
		}
		
		URL url=new URL(imgUrl);
		HttpURLConnection connection=(HttpURLConnection) url.openConnection();
		connection.setRequestMethod("HEAD");
		connection.setConnectTimeout(5000);
		connection.setReadTimeout(5000);
		connection.connect();
		
		int responseCode = connection.getResponseCode();
		if(responseCode==200)
		{
			System.out.println("Valid image: "+ imgUrl);
			return true;
		}
		else
		{
			System.out.println("Broken image: "+imgUrl+" | Response code: " +responseCode);
			return false;		
		}
		}
		catch (Exception e)
		{
			System.out.println("Exception for image: "+imgUrl+" | Exception" + e.getMessage());
			return false;
		}
		
	}
	
	
	

}
