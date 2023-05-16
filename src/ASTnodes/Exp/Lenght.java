package ASTnodes.Exp;

import TypeDescriptor.TypeDescriptor;

public class Lenght extends Exp{

	public Lenght(TypeDescriptor type, Exp exp) {
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
