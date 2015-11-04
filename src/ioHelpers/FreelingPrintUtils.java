package ioHelpers;

import edu.upc.freeling.Depnode;
import edu.upc.freeling.ListSentence;
import edu.upc.freeling.ListSentenceIterator;
import edu.upc.freeling.ListWordIterator;
import edu.upc.freeling.Sentence;
import edu.upc.freeling.TreeDepnode;
import edu.upc.freeling.TreeNode;
import edu.upc.freeling.Word;

public class FreelingPrintUtils {
	public static void printSenses( Word w ) {
	    String ss = w.getSensesString();

	    // The senses for a FreeLing word are a list of
	    // pair<string,double> (sense and page rank). From java, we
	    // have to get them as a string with format
	    // sense:rank/sense:rank/sense:rank
	    // which will have to be splitted to obtain the info.
	    //
	    // Here, we just output it:
	    System.out.print( " " + ss );
	  }

	  public static void printResults( ListSentence ls, String format ) {

	    if (format == "parsed") {
	      System.out.println( "-------- CHUNKER results -----------" );

	      ListSentenceIterator sIt = new ListSentenceIterator(ls);
	      while (sIt.hasNext()) {
		Sentence s = sIt.next();
	        TreeNode tree = s.getParseTree();
	        printParseTree( 0, tree );
	      }
	    }
	    else if (format == "dep") {
	      System.out.println( "-------- DEPENDENCY PARSER results -----------" );

	      ListSentenceIterator sIt = new ListSentenceIterator(ls);
	      while (sIt.hasNext()) {
		Sentence s = sIt.next();
	        TreeDepnode tree = s.getDepTree();
	        printDepTree( 0, tree);
	      }
	    }
	    else
	    {
	      System.out.println( "-------- TAGGER results -----------" );

	      // get the analyzed words out of ls.
	      ListSentenceIterator sIt = new ListSentenceIterator(ls);
	      while (sIt.hasNext()) {
	        Sentence s = sIt.next();
	        ListWordIterator wIt = new ListWordIterator(s);
	        while (wIt.hasNext()) {
	          Word w = wIt.next();

	          System.out.print(
	            w.getForm() + " " + w.getLemma() + " " + w.getTag() );
	          printSenses( w );
	          System.out.println();
	        }

	        System.out.println();
	      }
	    }
	  }

	  public static void printParseTree( int depth, TreeNode tr ) {
	    Word w;
	    TreeNode child;
	    long nch;

	    // Indentation
	    for( int i = 0; i < depth; i++ ) {
	      System.out.print( "  " );
	    }

	    nch = tr.numChildren();

	    if( nch == 0 ) {
	      // The node represents a leaf
	      if( tr.getInfo().isHead() ) {
	        System.out.print( "+" );
	      }
	      w = tr.getInfo().getWord();
	      System.out.print(
	        "(" + w.getForm() + " " + w.getLemma() + " " + w.getTag() );
	      printSenses( w );
	      System.out.println( ")" );
	    }
	    else
	    {
	      // The node probably represents a tree
	      if( tr.getInfo().isHead() ) {
	        System.out.print( "+" );
	      }

	      System.out.println( tr.getInfo().getLabel() + "_[" );

	      for( int i = 0; i < nch; i++ ) {
	        child = tr.nthChildRef( i );

	        if( child != null ) {
	          printParseTree( depth + 1, child );
	        }
	        else {
	          System.err.println( "ERROR: Unexpected NULL child." );
	        }
	      }
	      for( int i = 0; i < depth; i++ ) {
	        System.out.print( "  " );
	      }

	      System.out.println( "]" );
	    }
	  }

	  public static void printDepTree( int depth, TreeDepnode tr ) {
	    TreeDepnode child = null;
	    TreeDepnode fchild = null;
	    Depnode childnode;
	    long nch;
	    int last, min;
	    Boolean trob;

	    for( int i = 0; i < depth; i++ ) {
	      System.out.print( "  " );
	    }

	    System.out.print(
	      tr.getInfo().getLinkRef().getInfo().getLabel() + "/" +
	      tr.getInfo().getLabel() + "/" );

	    Word w = tr.getInfo().getWord();

	    System.out.print(
	      "(" + w.getForm() + " " + w.getLemma() + " " + w.getTag() );
	    printSenses( w );
	    System.out.print( ")" );

	    nch = tr.numChildren();

	    if( nch > 0 ) {
	      System.out.println( " [" );

	      for( int i = 0; i < nch; i++ ) {
	        child = tr.nthChildRef( i );

	        if( child != null ) {
	          if( !child.getInfo().isChunk() ) {
	            printDepTree( depth + 1, child );
	          }
	        }
	        else {
	          System.err.println( "ERROR: Unexpected NULL child." );
	        }
	      }

	      // Print chunks (in order)
	      last = 0;
	      trob = true;

	      // While an unprinted chunk is found, look for the one with lower
	      // chunk_ord value.
	      while( trob ) {
	        trob = false;
	        min = 9999;

	        for( int i = 0; i < nch; i++ ) {
	          child = tr.nthChildRef( i );
	          childnode = child.getInfo();

	          if( childnode.isChunk() ) {
	            if( (childnode.getChunkOrd() > last) &&
	                (childnode.getChunkOrd() < min) ) {
	              min = childnode.getChunkOrd();
	              fchild = child;
	              trob = true;
	            }
	          }
	        }
	        if( trob && (child != null) ) {
	          printDepTree( depth + 1, fchild );
	        }

	        last = min;
	      }

	      for( int i = 0; i < depth; i++ ) {
	        System.out.print( "  " );
	      }

	      System.out.print( "]" );
	    }

	    System.out.println( "" );
	  }
}
