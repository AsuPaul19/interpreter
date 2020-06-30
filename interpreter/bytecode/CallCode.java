package interpreter.bytecode;
import interpreter.virtualmachine.VirtualMachine;
import java.util.ArrayList;

public class CallCode extends BranchCode {
    protected String functionName;
    protected int targetAddress;
    protected int value;

    public void init(ArrayList<String> args) {
        functionName = args.get(0);
    }

    public void execute(VirtualMachine virtualMachine) {
        virtualMachine.returnAddress.push(virtualMachine.programCounter);
        virtualMachine.programCounter = targetAddress;
        value = virtualMachine.runTimeStack.peek();

                //just verifying if the dump is on
        if("ON".equals(virtualMachine.dumpMode)) {
            int n = functionName.indexOf("<");
            String temp;
            if(n < 0){
                temp = functionName;
            }else{
                temp = functionName.substring(0,n);
            }
            System.out.println("CALL " + functionName + " " + temp + "(" + value + ")");
        }
    }

    public int getTargetAddress(){
        return targetAddress;
    }

    public void setTargetAddress(int n){
        targetAddress = n;
    }

    public String getLabel(){
        return functionName;
    }
}



// //*****************************
// //****************************
//public class CallCode extends ByteCode {
//    private String address;
//    public void init(ArrayList<String> args) {
//        address = args.get(0);
//    }
//    public String getAddress(){
//        return address;
//    }
//
//    public void setAddress(int i){
//        address = Integer.toString(i);
//    }
//
//    public void execute(VirtualMachine virtualMachine) {
//        virtualMachine.savePC();
//        virtualMachine.changePC(Integer.parseInt(address));
//
//    }
//
//    @Override
//    public String toString() {
//        String call = "CALL " + address;
//        return call;
//    }
//}
