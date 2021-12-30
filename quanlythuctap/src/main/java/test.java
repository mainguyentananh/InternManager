import java.io.IOException;
import java.text.ParseException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class test {
	
	 public static void main(String[] args) throws InvalidFormatException, IOException, ParseException {

		 BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		 System.out.println(encoder.encode("test"));
				 
	}
}
