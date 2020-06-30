package interpreter.bytecode;

import interpreter.virtualmachine.VirtualMachine;

import java.util.ArrayList;

public class StoreCode extends ByteCode {
    // offset
    private int n;
    private String id;
    private int value;

    public void init(ArrayList<String> args) {
        n = Integer.parseInt(args.get(0));
        id = args.get(1);
    }

    public void execute(VirtualMachine virtualMachine) {

        value = virtualMachine.runTimeStack.peek();
        virtualMachine.runTimeStack.store(n);

        //verify if the dumpMode is on
        if("ON".equals(virtualMachine.dumpMode)) {
            System.out.println("STORE " + n + " " + id + " " + id + " = " + value);
        }
    }
}




// //****************************************
// //****************************************
//public class StoreCode extends ByteCode {
//    int num;
//    private String var;
//    int printTop;
//    public void init(ArrayList<String> args){
//        num = Integer.parseInt(args.get(0));
//        var = args.get(1);
//    }
//
//    public void execute(VirtualMachine virtualMachine){
//        virtualMachine.store(num);
//        printTop = virtualMachine.peekRunStack();
//    }
//
//    @Override
//    public String toString(){
//        String cal = "STORE " + num + " " + var + "\t" + var + " = "
//                + printTop;
//        return cal;
//    }
//
//}
