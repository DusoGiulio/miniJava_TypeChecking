package ASTnodes.Decl;

import ASTnodes.Class.NodeAST;
import ASTnodes.Class.NodeId;
import ASTnodes.Exp.Exp;
import TypeDescriptor.TypeDescriptor;

public class MainClass extends NodeAST{
	public MainClass(TypeDescriptor type, NodeId name, Exp exp) {
		super(type);
		this.setIdClass(name);
		this.setExp(exp);
	}
	
	private NodeId idClass;
	private Exp exp;
	

	public Exp getExp() {
		return exp;
	}
	public void setExp(Exp exp) {
		this.exp = exp;
	}
	public NodeId getIdClass() {
		return idClass;
	}
	public void setIdClass(NodeId idClass) {
		this.idClass = idClass;
	}


}
