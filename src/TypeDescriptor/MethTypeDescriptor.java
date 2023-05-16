package TypeDescriptor;


import SymbolTable.SymbolTable;

public class MethTypeDescriptor extends TypeDescriptor {
	private SymbolTable  SymbolTable;
	private boolean isStatic;

	public MethTypeDescriptor(SymbolTable symbolTable2, boolean isStatic) {
		super();
		this.SymbolTable = symbolTable2;
		this.isStatic= isStatic;
	}

	public SymbolTable  getSymbolTable() {
		return this.SymbolTable;
	}

	public void setSymbolTable(SymbolTable symbolTable) {
		SymbolTable = symbolTable;
	}

	public boolean isStatic() {
		return this.isStatic;
	}

}
