package ASTnodes.Stm;

import ASTnodes.Exp.Exp;
import TypeDescriptor.TypeDescriptor;

public class WHILE extends Stm {

	public WHILE(TypeDescriptor type, Exp exp, Stm stm1) {
		super(type);
		this.exp = exp;
		this.stm1 = stm1;
	}
	private Exp exp;
	private Stm stm1;
	public Exp getExp() {
		return exp;
	}
	public void setExp(Exp exp) {
		this.exp = exp;
	}
	public Stm getStm1() {
		return stm1;
	}
	public void setStm1(Stm stm1) {
		this.stm1 = stm1;
	}

}
