
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

import java.util.Arrays;
import java.util.List;
import static org.antlr.v4.runtime.CharStreams.fromFileName;

import org.antlr.v4.gui.*;
public class Runner {
	
	@SuppressWarnings("unused")
	private static void showTree(GLSLParser parser, ParseTree tree) {
        final List<String> ruleNames = Arrays.asList(GLSLParser.ruleNames);
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
		
		
		GLSLLexer lexer = new GLSLLexer(program);  //instantiate a lexer
	    CommonTokenStream tokens = new CommonTokenStream(lexer); //scan stream for tokens


	    GLSLParser parser = new GLSLParser(tokens);  //parse the tokens
        final ParseTree tree = parser.translation_unit();
        System.out.println(tree.toStringTree(parser));
	}

}
