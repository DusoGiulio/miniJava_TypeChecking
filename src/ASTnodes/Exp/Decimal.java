package ASTnodes.Exp;

import TypeDescriptor.TypeDescriptor;

public class Decimal extends Exp {
	public Decimal(TypeDescriptor type, String val) {
		super(type);
		this.val = val;
	}

	private String val;

	public String getVal() {
		return val;
	}

	public void setVal(String val) {
		this.val = val;
	}

}
