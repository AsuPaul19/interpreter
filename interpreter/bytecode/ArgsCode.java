package interpreter.bytecode;
import interpreter.virtualmachine.*;
import interpreter.virtualmachine.VirtualMachine;

import java.util.ArrayList;


public class ArgsCode extends ByteCode {
    private int n;

    public void init(ArrayList<String> args) {
        n = Integer.parseInt(args.get(0));
    }

    public void execute(VirtualMachine virtualMachine) {
        virtualMachine.runTimeStack.newFrameAt(n);
//        virtualMachine.newFrame(frame);

        if ("ON".equals(virtualMachine.dumpMode)) {
            System.out.println("ARGS" + "" + n);
        }
    }

}


    //@Override
//    public String toString(){
//        return "ARGS " + n;
//    }


//}
