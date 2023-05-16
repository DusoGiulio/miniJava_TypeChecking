package ASTnodes.Decl;

import ASTnodes.Class.NodeAST;
import TypeDescriptor.TypeDescriptor;

public abstract  class Decl extends NodeAST {

	public Decl(TypeDescriptor type) {
		super(type);
	}

}
