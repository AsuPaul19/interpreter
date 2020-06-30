package interpreter.bytecode;

import interpreter.virtualmachine.VirtualMachine;

import java.util.ArrayList;


public class LoadCode extends ByteCode {

    private int n;
    private String id;

    public void init(ArrayList<String> args) {
        n = Integer.parseInt(args.get(0));
        id = args.get(1);
    }

    public void execute(VirtualMachine virtualMachine) {

        virtualMachine.runTimeStack.load(n);

            // we verify if dump mode is on
        if("ON".equals(virtualMachine.dumpMode)) {
            System.out.println("LOAD " + n + " " + id + " < load " + id + ">");
        }
    }
}




// //*********************************
// //*********************************
//public class LoadCode extends ByteCode {
//    private int n;
//    String var;
//
//    public void init(ArrayList<String> args) {
//        n = Integer.parseInt(args.get(0));
//        var = args.get(1);
//    }
//
//
//    public void execute(VirtualMachine virtualMachine) {
//        virtualMachine.load(n);
//    }
//
//    @Override
//    public String toString() {
//        String cal = "LOAD" + n + " ";
//        if (var !=null)
//            cal += var + " " + "<load " + var + ">";
//        return cal;
//    }
//}
