package pagina;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;

public class MyStoreAutomation {

	public static void main() throws InterruptedException {
		// TODO Auto-generated method stub
		
		// Localizadores
		By locContactUs = By.xpath(" //a[contains(@title,'Contact Us')]"); 
		By locSelectListSubject = By.xpath("//select[@class='form-control']"); 
		By locEmail = By.xpath("//input[@id='email']");
		By locOrder = By.xpath("//input[@name='id_order']");
		By locTextArea = By.xpath("//textarea[@name='message']");
		By locSend = By.xpath("//button[@name='submitMessage']");
		By locMsgResultado = By.xpath("//p[contains(@class,'alert-success')]");
		
		//------------------------------------------------------------------------
		//Se setean las propiedades para el navegador
		 				
		System.setProperty("webdriver.chrome.driver","./src/main/resources/chromedriver");
		ChromeDriver driver = new ChromeDriver();		
		driver.manage().window().maximize();        
		
		// Se ingresa a la url de http://automationpractice.com/index.php
		driver.get("http://automationpractice.com/index.php");		
		Thread.sleep(1000);
		
		// Se toma captura de la pantalla inicial
		File dst = new File("./src/images/1_incio.png");
		if (dst.exists()) dst.delete(); //Lo borra en caso que exista
		
        File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
        	FileHandler.copy(src, dst);
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        // Se da click en el botón contact Us
		driver.findElement(locContactUs).click();
		Thread.sleep(1000);
		
		// Se guarda captura una vez se está adentro
		 dst = new File("./src/images/2_contactanos.png");
		if (dst.exists()) dst.delete(); //Lo borra en caso que exista
		
        src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
        	FileHandler.copy(src, dst);
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        // Se completan los campos del contact us
		WebElement dropdown = driver.findElement(locSelectListSubject);
		Select selectList = new Select(dropdown);
		String msgRetorno = "";
		try {
			selectList.selectByVisibleText("Customer service");
		} catch (NoSuchElementException e) {
			msgRetorno = "Elemento Customer service no presentado.";
		}		
		driver.findElement(locEmail).sendKeys("micorreo@gmail.com");
		Thread.sleep(1000);
		driver.findElement(locOrder).sendKeys("132412");
		Thread.sleep(1000);
		driver.findElement(locTextArea).sendKeys("Los zapatos no se ajustaron a mi talla");
		Thread.sleep(1000);
		
		// Se toma captura de los campos completados
		
		 dst = new File("./src/images/3_campos contact us.png");
			if (dst.exists()) dst.delete(); //Lo borra en caso que exista
			
	        src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	        try {
	        	FileHandler.copy(src, dst);
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        
	     // Se da click en el botón send   
		driver.findElement(locSend).click();
		Thread.sleep(1000);
		
	
		// Se valida que el mensaje obtenido sea el esperado
		String msgResultado = driver.findElement(locMsgResultado).getText();
		 dst = new File("./src/images/4_mesaje contacto exitoso.png");
			if (dst.exists()) dst.delete(); //Lo borra en caso que exista
			
	        src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	        try {
	        	FileHandler.copy(src, dst);
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
		File archivo = new File("./src/reporter.txt");

		
		if(msgResultado.equals("Your message has been successfully sent to our team.")) {
			System.out.println("Se hizo el contacto correctamente");
			
			try {
				if (!archivo.exists()) archivo.createNewFile(); 
				FileWriter fw = new FileWriter(archivo, true);  
				BufferedWriter bw = new BufferedWriter(fw);     
				bw.write("Se hizo el contacto correctamente y el mensaje es el esperado....!" + "\n");
				bw.close();
			} catch (Exception e) {
			    e.printStackTrace();
			}
		}else {
			try {
				if (!archivo.exists()) archivo.createNewFile(); 
				FileWriter fw = new FileWriter(archivo, true);  
				BufferedWriter bw = new BufferedWriter(fw);     
				bw.write("Warning...! Se hizo el contacto correctamente pero el mensaje no es el esperado...!" + "\n");
				bw.close();
			} catch (Exception e) {
			    e.printStackTrace();
			}
		}	
		
		// Se cierra el navegador
		
		driver.quit();
		
	}

}


//a[contains(@title,'Contact Us')]