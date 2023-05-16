package ASTnodes.Exp;

import org.antlr.v4.runtime.tree.TerminalNode;
import TypeDescriptor.TypeDescriptor;

public class This extends Exp {

	public This(TypeDescriptor type, TerminalNode op) {
		super(type);
		this.op=op;
	}

	public TerminalNode getOp() {
		return op;
	}

	public void setOp(TerminalNode op) {
		this.op = op;
	}

	private TerminalNode op;
}
