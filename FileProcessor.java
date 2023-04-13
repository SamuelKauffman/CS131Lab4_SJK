
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

/**
 * @author sam Kauffman
 * @Version 1.0
 * 
 * 	turns each line in a text file into a item in an arraylist
 *
 */
public class FileProcessor {

	private String fileName;
	private int stringLength;
	private ArrayList<String> stringList;
	private Scanner input;

	/**
	 * @param fileName
	 * @param stringLength
	 */
	public FileProcessor(String fileName, int stringLength) {
		this.fileName = fileName;
		setStringLength(stringLength);
		stringList = new ArrayList<String>();

	}// end empty-argument constructor

	/**
	 * @return size of array
	 */
	public int getArrayListSize() {
		return stringList.size();
	}// end getArrayListSize

	/**
	 * catches exception if line is too long or if file is not found
	 */
	public void processFile() {
		try {
			File f = new File(this.fileName);
			Scanner input = new Scanner(f);
			while (input.hasNextLine()) {
				String newString = input.nextLine();
				if (newString.length() <= this.stringLength) {
					stringList.add(newString);
				} else {
					throw new StringTooLongException("String too long!");
				}
			}
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		} catch(StringTooLongException e) {
			System.out.println(e.getMessage());
		}

	}// end processFile

	/**
	 * @return filename
	 */
	public String getFileName() {
		return this.fileName;
	}

	/**
	 * @return stringlength
	 */
	public int stringLength() {
		return this.stringLength;
	}

	/**
	 * @param fileName
	 */
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	/**
	 * @param stringLength
	 */
	public void setStringLength(int stringLength) {
		if (stringLength < 5) {
			this.stringLength = 5;
		} else {
			this.stringLength = stringLength;
		}
	}
	

	/**
	 * prints list
	 */
	public void getString() {
		
		if(stringList == null) {
			System.out.println("null");
			return;
		}
		for(String listItem: stringList) {
			System.out.println(listItem);
		}

	}
}// end class

/**
 * @author sam Kauffman
 * @Version 1.0
 *
 */
class StringTooLongException extends Exception{
	public StringTooLongException(String message) {
		super(message);
	}
}
