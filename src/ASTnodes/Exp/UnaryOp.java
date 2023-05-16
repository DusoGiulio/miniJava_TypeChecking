package ASTnodes.Exp;

import org.antlr.v4.runtime.tree.TerminalNode;
import TypeDescriptor.TypeDescriptor;

public class UnaryOp extends Exp{
	public UnaryOp(TypeDescriptor type, TerminalNode op, Exp exp) {
		super(type);
		this.setOp(op);
		this.setExp(exp);
	}
	
	private TerminalNode op;
	private Exp exp;
	
	public TerminalNode getOp() {
		return op;
	}
	public void setOp(TerminalNode op) {
		this.op = op;
	}
	public Exp getExp() {
		return exp;
	}
	public void setExp(Exp exp) {
		this.exp = exp;
	}
}
