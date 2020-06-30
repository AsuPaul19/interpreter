package interpreter.bytecode;

import interpreter.virtualmachine.VirtualMachine;

import java.util.ArrayList;

public class GotoCode extends BranchCode {
    private String label;
    private int targetAddress;

    public void init(ArrayList<String> args) {
        label = args.get(0);
    }

    public void execute(VirtualMachine virtualMachine) {
        virtualMachine.programCounter = targetAddress;
                //verify if the dump is on
        if("ON".equals(virtualMachine.dumpMode)) {
            System.out.println("GOTO" + " " + label);
        }
    }

    public int getTargetAddress(){
        return targetAddress;
    }

    public void setTargetAddress(int n){
        targetAddress = n;
    }

    public String getLabel(){
        return label;
    }
}

