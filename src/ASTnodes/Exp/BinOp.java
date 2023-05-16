package ASTnodes.Exp;

import org.antlr.v4.runtime.tree.TerminalNode;
import TypeDescriptor.TypeDescriptor;

public class BinOp extends Exp {
	public BinOp(TypeDescriptor type,TerminalNode op, Exp lexp, Exp rexp) {
		super(type);
		this.op = op;
		this.lexp = lexp;
		this.rexp = rexp;
	}
	private TerminalNode op;
	private Exp lexp;
	private Exp rexp;
	public TerminalNode getOp() {
		return op;
	}
	public void setOp(TerminalNode op) {
		this.op = op;
	}
	public Exp getLexp() {
		return lexp;
	}
	public void setLexp(Exp lexp) {
		this.lexp = lexp;
	}
	public Exp getRexp() {
		return rexp;
	}
	public void setRexp(Exp rexp) {
		this.rexp = rexp;
	}
}
