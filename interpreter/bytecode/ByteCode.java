package interpreter.bytecode;

import interpreter.virtualmachine.VirtualMachine;

import java.util.ArrayList;

public abstract class ByteCode {
    // we initialized bytecode here
    public abstract void init(ArrayList<String> args);

    //we execute virtual machine.
    public abstract void execute(VirtualMachine virtualMachine);
//    public abstract String toString();

//    public abstract String toString();
}
