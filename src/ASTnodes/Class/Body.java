package ASTnodes.Class;

import java.util.ArrayList;

import ASTnodes.Decl.Decl;
import ASTnodes.Decl.VarDecl;
import ASTnodes.Exp.Exp;
import ASTnodes.Stm.Stm;
import TypeDescriptor.TypeDescriptor;

public class Body extends Decl {

	public Body(TypeDescriptor type, ArrayList<VarDecl> decs, ArrayList<Stm> stms, Exp retExp) {
		super(type);
		this.decs = decs;
		this.stms = stms;
		this.retExp = retExp;
	}
	
	
	private ArrayList<VarDecl> decs;
	private ArrayList<Stm> stms;
	private Exp retExp;
	
	
	public ArrayList<VarDecl> getDecs() {
		return decs;
	}
	public void setDecs(ArrayList<VarDecl> decs) {
		this.decs = decs;
	}
	public ArrayList<Stm> getStms() {
		return stms;
	}
	public void setStms(ArrayList<Stm> stms) {
		this.stms = stms;
	}
	public Exp getRetExp() {
		return retExp;
	}
	public void setRetExp(Exp retExp) {
		this.retExp = retExp;
	}
}
