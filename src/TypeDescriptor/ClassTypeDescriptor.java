package TypeDescriptor;

import SymbolTable.SymbolTable;

public class ClassTypeDescriptor  extends TypeDescriptor{

	private ClassTypeDescriptor parent;
	private String parentName;
	public SymbolTable ST;
	private String name;
	private Coef isCoeff;
	
	public ClassTypeDescriptor(SymbolTable name,ClassTypeDescriptor parent,String parentName, String nameclass) {
		this.ST=name;
		this.parent=parent;
		this.parentName=parentName;
		this.setName(nameclass);
		this.isCoeff=Coef.NOTCOEF;
	}

	public ClassTypeDescriptor getParent() {
		return parent;
	}

	public void setParent(ClassTypeDescriptor parent) {
		this.parent = parent;
	}

	public SymbolTable getST() {
		return ST;
	}

	public void setST(SymbolTable name) {
		this.ST = name;
	}

	public String getParentName() {
		return parentName;
	}

	public void setParentName(String parentName) {
		this.parentName = parentName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Coef isCoeff() {
		return isCoeff;
	}

	public void setCoeff(Coef boolean1) {
		this.isCoeff = boolean1;
	}

}
