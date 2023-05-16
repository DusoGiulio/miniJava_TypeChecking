package ASTnodes.Stm;

import ASTnodes.Exp.Exp;
import TypeDescriptor.TypeDescriptor;

public class IF extends Stm{

	public IF(TypeDescriptor type, Exp exp2, Stm stm1, Stm stm2) {
		super(type);
		exp = exp2;
		this.setIfstm(stm1);
		this.setElsestm(stm2);
	}
	private Exp exp;
	private Stm ifstm;
	private Stm elsestm;
	public Exp getExp() {
		return exp;
	}
	public void setExp(Exp exp) {
		this.exp = exp;
	}
	public Stm getIfstm() {
		return ifstm;
	}
	public void setIfstm(Stm ifstm) {
		this.ifstm = ifstm;
	}
	public Stm getElsestm() {
		return elsestm;
	}
	public void setElsestm(Stm elsestm) {
		this.elsestm = elsestm;
	}

}

