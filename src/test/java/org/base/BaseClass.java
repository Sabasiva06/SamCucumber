package org.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class BaseClass {
	public static WebDriver driver;

	// It is used to inili the browser condition
	public void getDriver() {
		System.setProperty("webdriver.chrome.driver", "D:\\12.30MavenFrameWorkBatch\\Driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	// It is used to launch url
	public void launchUrl(String url) {
		driver.get(url);

	}

	// Method for SendKeys
	public void typeText(WebElement element, String data) {
		element.sendKeys(data);
	}

	// Method for click
	public void butnClick(WebElement element) {
		element.click();

	}

	// Method for movetoelement
	public void mouseHoverAction(WebElement target) {
		Actions ac = new Actions(driver);
		ac.moveToElement(target).perform();

	}

	public String getDataFromExcel(String pathname, String sheetName, int rowNo, int cellNo) throws IOException {
		File file = new File(pathname);
		FileInputStream fileInputStream = new FileInputStream(file);
		Workbook workbook = new XSSFWorkbook(fileInputStream);
		Sheet sheet = workbook.getSheet(sheetName);
		Row row = sheet.getRow(rowNo);
		Cell cell = row.getCell(cellNo);
		int cellType = cell.getCellType();
		String value = "";
		if (cellType == 1) {
			value = cell.getStringCellValue();
		} else if (DateUtil.isCellDateFormatted(cell)) {
			Date dateCellValue = cell.getDateCellValue();
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
			value = dateFormat.format(dateCellValue);
		} else {
			double numericCellValue = cell.getNumericCellValue();
			long l = (long) numericCellValue;
			value = String.valueOf(l);
		}

		return value;

	}

	public WebElement findElementById(String id) {
		WebElement findElement = driver.findElement(By.id(id));

		return findElement;

	}

	public List<WebElement> findElementsByXpath(String xpath) {
		List<WebElement> findElements = driver.findElements(By.xpath(xpath));
		return findElements;
	}

}
