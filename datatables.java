package Others;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import project_selenium.browsersetup123;
import project_selenium.browsersetup123.Browser;

public class datatables {
	private static WebDriver wd;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		browsersetup123 b=new browsersetup123(Browser.CHROME,false);
		wd=b.invokeBrowser("https://datatables.net/");
		pagination(wd);
		//sort(wd);
		b.closeBrowser();
		System.out.println("browser closed");

	}

	private static void pagination(WebDriver wd) throws InterruptedException {
		// TODO Auto-generated method stub
		WebElement paginate=wd.findElement(By.cssSelector("#example_paginate"));
		WebElement nextpage=wd.findElement(By.cssSelector("#example_next"));
		WebElement lastpage;
		Integer lastpageno;
		do {
			lastpage=paginate.findElement(By.xpath("//a[@id='example_next']/preceding-sibling::span/child::*[last()]"));
			lastpageno=Integer.valueOf(lastpage.getAttribute("data-dt-idx"));
			System.out.println("lastpageno:"+lastpageno);
			nextpage.click();
			Thread.sleep(2000);
			nextpage=paginate.findElement(By.cssSelector("#example_next"));
			
		}while(!nextpage.getAttribute("class").contains("disabled"));
		
		WebElement prevpage=paginate.findElement(By.cssSelector("#example_previous"));
		do {
			prevpage.click();
			Thread.sleep(2000);
			prevpage=paginate.findElement(By.cssSelector("#example_previous"));
			}while(!prevpage.getAttribute("class").contains("disabled"));
		
	}

	private static void closebrowser() {
		// TODO Auto-generated method stub
		wd.quit();
	}

}