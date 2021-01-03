package usantatecla.utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Console {

	private static Console instance;

	public static Console instance() {
		if (Console.instance == null) {
			Console.instance = new Console();
		}
		return instance;
	}

	private BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

	public String readString(String title) {
		String input = null;
		try {
			this.write(title);
			input = this.bufferedReader.readLine();
		} catch (Exception ex) {
		}
		return input;
	}

	public int readInt(String title) {
		int input = 0;
		boolean ok = false;
		do {
			try {
				input = Integer.parseInt(this.readString(title));
				ok = true;
			} catch (Exception ex) {
				this.writeError("integer");
			}
		} while (!ok);
		return input;
	}

	public void write(String string) {
		System.out.print(string);
	}

	public void write(int integer) {
		System.out.print(integer);
	}

	public void writeln(String string) {
		System.out.println(string);
	}

	private void writeError(String format) {
		System.out.println("FORMAT ERROR! " + "Enter a " + format + " formatted value.");
	}

}
