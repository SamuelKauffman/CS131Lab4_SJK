import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class FileProcessor {

	private String fileName;
	private int stringLength;
	private ArrayList<String> stringList;
	private Scanner input;

	public FileProcessor(String fileName, int stringLength) {
		this.fileName = fileName;
		setStringLength(stringLength);
		stringList = new ArrayList<String>();

	}// end empty-argument constructor

	public int getArrayListSize() {
		return stringList.size();
	}// end getArrayListSize

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

	public String getFileName() {
		return this.fileName;
	}

	public int stringLength() {
		return this.stringLength;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public void setStringLength(int stringLength) {
		if (stringLength < 5) {
			this.stringLength = 5;
		} else {
			this.stringLength = stringLength;
		}
	}
	

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

class StringTooLongException extends Exception{
	public StringTooLongException(String message) {
		super(message);
	}
}
