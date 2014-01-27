import org.antlr.runtime.tree.*;
import org.antlr.runtime.Token;

class MyAstNodeAdaptor extends CommonTreeAdaptor {
    public Object create(Token t) {
	return new MyAstNode(t);
    }
};
