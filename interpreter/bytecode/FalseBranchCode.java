package interpreter.bytecode;

import interpreter.virtualmachine.VirtualMachine;

import java.util.ArrayList;

//public class FalseBranchCode extends ByteCode {
//    private String address;
//
//    public void init(ArrayList<String> args) {
//        address = args.get(0);
//    }
//
//    public String getAddress(){
//        return address;
//    }
//    public void setAddress(int i){
//        address = Integer.toString(i);
//    }
//
//    public void execute(VirtualMachine virtualMachine) {
//        int top = virtualMachine.popRunStack();
//        if (top ==0){
//            virtualMachine.changePC(Integer.parseInt(address));
//        }
//    }
//
//    @Override
//    public String toString() {
//        return null;
//    }
//}

//*****************************************
//*****************************************

/*
 * FALSEBRANCH <label> - pop the top of the stack; if it is false(0) then branch to
 * <label> else execute the next bytecode.
 */

public class FalseBranchCode extends BranchCode {
    private String label;
    private int targetAddress;

    public void init(ArrayList<String> args) {
        label = args.get(0);
    }

    public void execute(VirtualMachine virtualMachine) {
        if(virtualMachine.runTimeStack.pop() == 0) {
            virtualMachine.programCounter = targetAddress;
        }
                //verifying if the dumpMode is ON
        if("ON".equals(virtualMachine.dumpMode)) {
            System.out.println("FALSEBRANCH " + " " + label);
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


