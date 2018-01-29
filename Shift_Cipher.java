package Shift_CIpher;
// This is the Java file for HW1 Q2
import java.util.Scanner;

public class Shift_Cipher {
	private static void encrypt(){
		int key = get_key();
		System.out.println("Input the plaintext");
		Scanner input = new Scanner(System.in);
		String plaintext = input.nextLine();
		char plaintext_array[]= plaintext.toCharArray();
		char ciphertext_array[]=plaintext.toCharArray();
		int temp=0;
		for(int i=0;i<plaintext_array.length;i++) {
			if(plaintext_array[i]>64 && plaintext_array[i]<91) {
				temp = (int)plaintext_array[i] + key;
				if(temp>90) {
					temp = temp -26;
				}
			}else if (plaintext_array[i]>96 && plaintext_array[i]<123) {
				temp = (int)plaintext_array[i] + key - 32;
				if(temp>90) {
					temp = temp -26;
				}
			}else {
				temp = (int) plaintext_array[i];
			}
			ciphertext_array[i]=(char)(temp);
		}
		String ciphertext = new String (ciphertext_array);
		System.out.print("The ciphertext is : ");
		System.out.println(ciphertext);
		
	}

	private static void decrypt(){
		int key = get_key();
		System.out.println("Input the ciphertext");
		Scanner input = new Scanner(System.in);
		String ciphertext = input.nextLine();
		char ciphertext_array[]= ciphertext.toCharArray();
		char plaintext_array[]= ciphertext.toCharArray();
		int temp=0;
		for(int i=0;i<ciphertext_array.length;i++) {
			if(ciphertext_array[i]>64 && ciphertext_array[i]<91) {
				temp = (int)ciphertext_array[i] - key;
				if(temp<65) {
					temp = temp + 26;
				}
			}else if (ciphertext_array[i]>96 && ciphertext_array[i]<123) {
				temp = (int)ciphertext_array[i] - key - 32;
				if(temp<65) {
					temp = temp + 26;
				}
			}else {
				temp = (int) ciphertext_array[i];;
			}
			plaintext_array[i]=(char)(temp);
		}
		String plaintext = new String (plaintext_array);
		System.out.print("The plaintext is : ");
		System.out.println(plaintext);
	}
	
	private static int get_key() {
		System.out.println("Input the key for the encryption/decryption (A for 0, B for 1 ... Z for 25)");
		Scanner input = new Scanner(System.in);
		String key="";
		key = input.nextLine();
		char key_char = 0; 
		key_char = key.charAt(0);
		int key_int = 0; 
		key_int = (int) key_char - 65;
		if(key_int < 0 || key_int > 25) {
			System.out.println("Invalid Input, please enter Uppercase Alphabets");
			key_int = get_key();
		}
		return key_int;
	}
	
	private static void function_declare() {
		System.out.println("Input 'D' for Decryption and 'E' for Encryption");
		Scanner input = new Scanner(System.in);
		String function_input = input.nextLine();
		if(function_input.equals("D")) {
			System.out.println("Shift Cipher Decryption");
			decrypt();
		}else if (function_input.equals("E")) {
			System.out.println("Shift Cipher Encryption");
			encrypt();
		}else {
			System.out.println("Invalid Input, please enter 'E' or 'D' in uppercase");
			function_declare();
		}		
	}
	
	public static void main(String[] args) throws Exception 
	{
		function_declare();
	}
}
