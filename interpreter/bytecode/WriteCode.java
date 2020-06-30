package interpreter.bytecode;
import interpreter.virtualmachine.VirtualMachine;
import java.util.ArrayList;


public class WriteCode extends ByteCode {

    public void init(ArrayList<String> args) { }

    public void execute(VirtualMachine virtualMachine) {
        System.out.println(virtualMachine.runTimeStack.peek());

            //verify if the dumpMode is on
        if("ON".equals(virtualMachine.dumpMode)) {
            System.out.println("WRITE");
        }
    }
}




// //**************************************
// //**************************************
//public class WriteCode extends ByteCode {
//
//    public void init(ArrayList<String> args) { }
//
//
//    public void execute(VirtualMachine virtualMachine) {
//        int i = virtualMachine.peekRunStack();
//        System.out.println(i);
//    }
//
//    @Override
//    public String toString() {
//        return "Write";
//    }
//}
