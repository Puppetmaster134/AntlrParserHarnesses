import java.util.Timer;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

public class RunnerThread extends Thread {
	private final CharStream program;
	private Timer timer;
	public String treeString;
	public RunnerThread(CharStream program, Timer timer) {
		this.program = program;
		this.timer = timer;
	}
	
	public void run() {
		GLSLLexer lexer = new GLSLLexer(program);  //instantiate a lexer
	    CommonTokenStream tokens = new CommonTokenStream(lexer); //scan stream for tokens
	    GLSLParser parser = new GLSLParser(tokens);  //parse the tokens
        final ParseTree tree = parser.translation_unit();
        this.treeString = tree.toStringTree(parser);
        this.timer.cancel();
	}
}
