
package com.ESS.generic.dataproviderutility;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.DataProvider;

import com.ESS.generic.fileutility.ExcelUtility;

public class StoreTest {
	@DataProvider
	public Object[][] amazonProduct() throws EncryptedDocumentException, IOException
	{
		ExcelUtility ex=new ExcelUtility();
		
		int rowcount = ex.getRowcount("amazon");
		Object[][] obarr=new Object[rowcount][2];
		
		for(int i=0;i<rowcount;i++)
		{
			obarr[i][0]=ex.getDataFromExcel("amazon", i+1, 0);
			obarr[i][1]=ex.getDataFromExcel("amazon", i+1, 1);
		}
	    return obarr;
	}

}
