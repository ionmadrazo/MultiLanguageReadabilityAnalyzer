package textProcessors;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import datasetHelpers.Dataset;
import datasetHelpers.Paragraph;
import datasetHelpers.Sentence;
import datasetHelpers.Text;
import datasetHelpers.Token;
import edu.upc.freeling.ChartParser;
import edu.upc.freeling.DepTxala;
import edu.upc.freeling.HmmTagger;
import edu.upc.freeling.LangIdent;
import edu.upc.freeling.ListSentence;
import edu.upc.freeling.ListSentenceIterator;
import edu.upc.freeling.ListWord;
import edu.upc.freeling.ListWordIterator;
import edu.upc.freeling.Maco;
import edu.upc.freeling.MacoOptions;
import edu.upc.freeling.Nec;
import edu.upc.freeling.Senses;
import edu.upc.freeling.Splitter;
import edu.upc.freeling.Tokenizer;
import edu.upc.freeling.Ukb;
import edu.upc.freeling.Util;
import edu.upc.freeling.Word;
import processors.DatasetProcessor;
import ioHelpers.FreelingPrintUtils;


public class FreelingProcessor implements DatasetProcessor{
	 private static final String DATA = "data/";
	 
	@Override
	public void process(Dataset d) {
		
		
		 System.loadLibrary( "dll/freeling_javaAPI" );
		 Util.initLocale( "default" );
		 
		 String LANG = d.getLanguage();
		 
		 // Create options set for maco analyzer.
	    // Default values are Ok, except for data files.
	    MacoOptions op = new MacoOptions( LANG );

	    op.setActiveModules(false, true, true, true, 
	                               true, true, true, 
	                               true, true, true);

	    op.setDataFiles(
	      "", 
	      DATA+LANG+"/locucions.dat", 
	      DATA + LANG + "/quantities.dat",
	      DATA + LANG + "/afixos.dat",
	      DATA + LANG + "/probabilitats.dat",
	      DATA + LANG + "/dicc.src",
	      DATA + LANG + "/np.dat",
	      DATA + "common/punct.dat");

	    // Create analyzers.
	    LangIdent lgid = new LangIdent(DATA + "/common/lang_ident/ident-few.dat");

	    Tokenizer tk = new Tokenizer( DATA + LANG + "/tokenizer.dat" );
	    Splitter sp = new Splitter( DATA + LANG + "/splitter.dat" );
	    Maco mf = new Maco( op );

	    HmmTagger tg = new HmmTagger( DATA + LANG + "/tagger.dat", true, 2 );
	    ChartParser parser = new ChartParser(
	      DATA + LANG + "/chunker/grammar-chunk.dat" );
	    DepTxala dep = new DepTxala( DATA + LANG + "/dep/dependences.dat",
	      parser.getStartSymbol() );
	    Nec neclass = new Nec( DATA + LANG + "/nerc/nec/nec-ab-poor1.dat" );

	    Senses sen = new Senses(DATA + LANG + "/senses.dat" ); // sense dictionary
	    Ukb dis = new Ukb( DATA + LANG + "/ukb.dat" ); // sense disambiguator

		   
	    for(Text t: d.getAllTexts())
	    {
	    	for(Paragraph p : t.getAllParagraphs())
	    	{
	    		// Extract the tokens from the line of text.
	    	      ListWord l = tk.tokenize( p.getRawText() );

	    	      // Split the tokens into distinct sentences.
	    	      ListSentence ls = sp.split( l, false );

	    	      // Perform morphological analysis
	    	      mf.analyze( ls );

	    	      // Perform part-of-speech tagging.
	    	      tg.analyze( ls );

	    	      // Perform named entity (NE) classificiation.
	    	      neclass.analyze( ls );

	    	      sen.analyze( ls );
	    	      dis.analyze( ls );
	    	     
	    	      //FreelingPrintUtils.printResults( ls, "tagged" );

	    	      // Chunk parser
	    	      parser.analyze( ls );
	    	      //FreelingPrintUtils.printResults( ls, "parsed" );

	    	      // Dependency parser
	    	      dep.analyze( ls );
	    	     // FreelingPrintUtils.printResults( ls, "dep" );
	    	
	    	      //Put the new information into the paragraph structure
	    	      ListSentenceIterator sIt = new ListSentenceIterator(ls);
	    	      while (sIt.hasNext()) {
	    	        edu.upc.freeling.Sentence s = sIt.next();
	    	        Sentence newSentence = new Sentence();
	    	        newSentence.setFreelingInformation(s);
	    	        
	    	        ListWordIterator wIt = new ListWordIterator(s);
	    	        while (wIt.hasNext()) 
	    	        {
		    	         Word w = wIt.next();
		    	         Token tok = new Token();
		    	         
		    	         tok.setFreelingInformation(w);
		    	         newSentence.appendToken(tok);
	    	        } 	        
	    	        p.appendSentence(newSentence);
	    	       
	    	      }
	    	     
	    	      
	    	
	    	}
	    }
	    
	    
	}

}
