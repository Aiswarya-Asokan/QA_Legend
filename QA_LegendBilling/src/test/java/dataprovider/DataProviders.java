package dataprovider;

import org.testng.annotations.DataProvider;

public class DataProviders {
	
		@DataProvider(name="Invalidusercredentials")

		public Object[][] verify_userCredential_datas()
		{
			Object[][] data=new Object[3][2];
			data[0][0]="admin";
			data[0][1]="123";
			
			data[1][0]="amin";
			data[1][1]="123456";
			
			data[2][0]="amin";
			data[2][1]="123";
			return data;
		}
}
