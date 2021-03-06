package models;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import opennlp.tools.tokenize.TokenizerME;
import opennlp.tools.tokenize.TokenizerModel;

public class Tokenizer {
	
	/** 
	 * Tokenizes the text and returns a list of tokens
	 * @param text The text to be tokenized
	 * @return tokens Tokens generated
	 */
	public static String[] tokenize(String text){
		InputStream modelIn = null;
		String[] tokens = null;

		try {
			modelIn = new FileInputStream("./opennlp_models/en-token.bin");
			TokenizerModel model = new TokenizerModel(modelIn);
			TokenizerME tokenizer = new TokenizerME(model);
			tokens = tokenizer.tokenize(text);
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		finally {
			if (modelIn != null) {
				try {
					modelIn.close();
				}
				catch (IOException e) {
				}
			}
		}
		return tokens;
	}
}
