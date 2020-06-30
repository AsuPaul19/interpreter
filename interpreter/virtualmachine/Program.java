package interpreter.virtualmachine;

import interpreter.bytecode.*;
import interpreter.CodeTable.*;
import java.util.HashMap;
import interpreter.bytecode.ByteCode;

import java.util.ArrayList;
import java.util.HashMap;

public class Program {


    private ArrayList<ByteCode> program;

    public Program() {
        program = new ArrayList<ByteCode>();
    }

    //load the bytecode
    public ByteCode getCode(int programCounter) {
        return this.program.get(programCounter);
    }

    private static HashMap<String, Integer> labelList = new HashMap<String, Integer>();

    public int getSize() {
        return this.program.size();
    }

    public void add(ByteCode byteCode) {
        if (byteCode instanceof LabelCode) {
            LabelCode label = (LabelCode) byteCode;
            labelList.put(label.getLabel(), program.size());
        }
        program.add(byteCode);
    }

    public void resolveAddress() {
        Integer jumpAddress;
        for (int i = 0; i < program.size(); i++) {
            if (program.get(i) instanceof BranchCode) {
                BranchCode temp = (BranchCode) program.get(i);
                jumpAddress = Integer.valueOf(labelList.get(temp.getLabel()));
                temp.setTargetAddress(jumpAddress.intValue());
            }
        }
    }

    public ArrayList<ByteCode> getByteCodeList() {
        return program;
    }
}
