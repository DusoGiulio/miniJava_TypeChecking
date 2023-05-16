package ASTnodes.Exp;

import TypeDescriptor.TypeDescriptor;

public class Paren extends Exp{

	public Paren(TypeDescriptor type, Exp exp) {
		super(type);
		this.setExp(exp);
	}

	public Exp getExp() {
		return exp;
	}

	public void setExp(Exp exp) {
		this.exp = exp;
	}

	private Exp exp;
}
