package interpreter.bytecode;

import interpreter.virtualmachine.VirtualMachine;

import java.util.ArrayList;

public class PopCode extends ByteCode {
    protected int n;
    public void init(ArrayList<String> args)
    {
        n = Integer.parseInt(args.get(0));
    }

    public void execute(VirtualMachine virtualMachine) {
        //Pop top n levels of runtime stack.
        for(int i = 0; i < n; i++) {
            virtualMachine.runTimeStack.pop();
        }

        //verify if dumpMode is on
        if("ON".equals(virtualMachine.dumpMode)) {
            System.out.println("POP" + " " + n);
        }
    }
}




// //********************************
// //********************************
//public class PopCode extends ByteCode {
//    private int n;
//
//    public void init(ArrayList<String> args) {
//        n = Integer.parseInt(args.get(0));
//    }
//
//    public void execute(VirtualMachine virtualMachine) {
//        virtualMachine.popNFromStack(n);
//    }
//
//    @Override
//    public String toString() {
//        return "POP";
//    }
//}
