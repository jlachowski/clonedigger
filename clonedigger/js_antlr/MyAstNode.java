import org.antlr.runtime.tree.*;
import org.antlr.runtime.Token;

import java.io.*;

public class MyAstNode extends CommonTree {
    boolean is_statement = false;
    public MyAstNode(Token t) {
	super(t);
    }
}
