
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

import java.util.Arrays;
import java.util.List;
import static org.antlr.v4.runtime.CharStreams.fromFileName;

import org.antlr.v4.gui.*;
public class Runner {
	
	@SuppressWarnings("unused")
	private static void showTree(CPP14Parser parser, ParseTree tree) {
        final List<String> ruleNames = Arrays.asList(CPP14Parser.ruleNames);
        final TreeViewer view = new TreeViewer(ruleNames, tree);
        view.open();
	}
	
	public static void main(String[] args) {
		if (args.length == 0)
		{
			System.err.println("No program provided.");
			return;
		}
		
		String programPath = args[0];
		CharStream program = null;
		try {
		    program = fromFileName(programPath);  //load the file
		}catch(Exception e) {System.err.println(e.getMessage()); return;};
		
		
		CPP14Lexer lexer = new CPP14Lexer(program);  //instantiate a lexer
	    CommonTokenStream tokens = new CommonTokenStream(lexer); //scan stream for tokens


	    CPP14Parser parser = new CPP14Parser(tokens);  //parse the tokens
        final ParseTree tree = parser.translationUnit();
        System.out.println(tree.toStringTree(parser));
	}

}
