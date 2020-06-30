package interpreter.bytecode;
import interpreter.virtualmachine.VirtualMachine;
import java.util.ArrayList;

public class DumpCode extends ByteCode {
    private String dumpState;
    public void init(ArrayList<String> args) {
        dumpState = args.get(0);
    }

    public void execute(VirtualMachine virtualMachine) {
        //setting the dumpMode
        virtualMachine.dumpMode = dumpState;

    }
}


//  //*****************************
//  //*****************************
//public class DumpCode extends ByteCode {
//    String arg;
//
//    public void init(ArrayList<String> args) {
//        arg = args.get(0);
//    }
//
//    public void execute(VirtualMachine virtualMachine) {
//        if (arg.equals("ON"))
//            virtualMachine.dumpMode(true);
//        if (arg.equals("OFF"))
//            virtualMachine.dumpMode(false);
//    }
//
//    @Override
//    public String toString() {
//        return null;
//    }
//}
