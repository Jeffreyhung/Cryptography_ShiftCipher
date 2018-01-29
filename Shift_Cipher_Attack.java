package Shift_CIpher;
// This is the Java file of Shift Cipher Brute Force Attack for Questions in HW1
import java.util.Scanner;

public class Shift_Cipher_Attack {
	private static void decrypt(){
		int key;
		System.out.println("Input the ciphertext");
		Scanner input = new Scanner(System.in);
		String ciphertext = input.nextLine();
		char ciphertext_array[]= ciphertext.toCharArray();
		char plaintext_array[]= ciphertext.toCharArray();
		int temp=0;
		for(key=0; key<26; key++) {
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
			System.out.println("Key : " + key + "   Plaintext : " + plaintext);
		}
	}
	
	public static void main(String[] args) throws Exception 
	{
		decrypt();
	}
}
