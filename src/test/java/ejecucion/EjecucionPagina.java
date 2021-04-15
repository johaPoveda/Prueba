package ejecucion;

import org.testng.annotations.Test;

import pagina.MyStoreAutomation;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

public class EjecucionPagina {
	
	MyStoreAutomation paginaAutomation = null ; 

  @BeforeClass
  public void beforeClass() {
	  System.out.println("Iniciando ejecución....!");
  }

  @Test
  public void f() throws InterruptedException {
	  
	  paginaAutomation = new MyStoreAutomation();
	  paginaAutomation.main();
	  
  }
  
  @AfterClass
  public void afterClass() {
	  System.out.println("Finalizando ejecución.....!");
  }

}
