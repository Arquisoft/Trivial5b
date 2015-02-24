package es.uniovi.asw.trivial;

import java.io.IOException;

public class Extractor {
	
	public void usage() throws IOException {
		System.out.println("Wellcome to Trivial Extractor");
		MenuOptions menu = new MenuOptions();
		menu.start();
		
	}
	public int run(String[] args) throws IOException {
		if (args.length == 0) {
			usage();
			return 0;
		}
		return -1 ;
	}
	
	public static void main(String[] args) throws IOException {
        new Extractor().run(args);
    }	
}
