/**
 * This class converts binary to decimal, and decimal to binary 
 * 
 * @author Sadraque Nunes
 * @email sadraquenunesmartiniano@gmail.com
 * @date 07/24/2020
 */
public class BinaryDecimalConvertor {
	
	private int decimalNumber;
	private int binaryNumber;	

	/**
	 * get binaryNumber
	 * 
	 * @return binaryNumber
	 */
	public int getBinaryNumber() {
		return binaryNumber;
	}

	/**
	 * get the decimalNumber
	 * 
	 * @return decimalNumber
	 */
	public int getDecinalNumber() {
		return this.decimalNumber;
	}
	
	/**
	 * performs the Binary->Decimal conversion
	 * 
	 * @param binaryNumber
	 * @return decimalNumber, or "" (empty)
	 */
	public String convertBinaryToDecimal(String binaryNumber) {
		
		if(verifyIfBinary(binaryNumber)) {	
			//System.out.println("NUMBER LENGHT = " +this.binaryNumber.length());
			int count = binaryNumber.length() - 1;
			
			for(int i = 0; i <= (binaryNumber.length() - 1); i++) {			
				//System.out.println("Position " +i +" = " +this.binaryNumber.substring(i,i + 1));
				double binaryCalc = Integer.parseInt(binaryNumber.substring(i,i + 1)) * (Math.pow(2, count));
				
				this.decimalNumber += binaryCalc;
				
				count--;
			}
			
			//System.out.println("Conversion successful! DECIMAL = " +this.decimalNumber);			
			return String.valueOf(this.decimalNumber);
			
		} else {
			
			return "";
		}
	}
	

	/**
	 * performs the Decimal->Binary conversion
	 * 
	 * @param decimalNumber
	 * @return decimalNumber
	 */
	public String convertDecimalToBinary(String decimalNumber) {
		if(decimalNumber.equals("0")) {
			
			return "0";
		}
		
		this.binaryNumber = Integer.parseInt(decimalNumber);
		String binaryNumber = "";
		
		while(this.binaryNumber > 1) { 
			binaryNumber += String.valueOf(this.binaryNumber % 2); 
			this.binaryNumber = this.binaryNumber / 2;	
		}
				
		binaryNumber = binaryNumber + "1";
		
		return invertString(binaryNumber);
	}
	
	/**
	 * verify if the binaryNumber is really a valid binary number
	 *
	 * @param binaryNumber
	 */
	private boolean verifyIfBinary(String binaryNumber) {
		
		for(int j = 2; j <= 9; j++) {
			String number = String.valueOf(j);
			
			if(binaryNumber.contains(number)) {
				//System.out.println("Error during conversion! the function param is not a binary number");
				
				return false;
			}
		}
		
		return true;
	}
	
	/**
	 * invert a string. EXAMPLE: "abc" == "cba"
	 * 
	 * @param text
	 * @return reverseText
	 */
	private String invertString(String text) {
		String reverseText = "";
		
		for(int i = text.length(); i >= 1; i--) {			
			reverseText += text.substring((i - 1), i);
		}
		
		return reverseText;
	}

}
