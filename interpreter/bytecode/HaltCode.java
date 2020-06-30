package interpreter.bytecode;
import interpreter.virtualmachine.VirtualMachine;
import java.util.ArrayList;


public class HaltCode extends ByteCode {
    public void init(ArrayList<String> args) { }

    public void execute(VirtualMachine virtualMachine) {
            //this will terminate the program
        virtualMachine.isRunning = false;

            //checking if the dumpMode is on
        if("ON".equals(virtualMachine.dumpMode)) {
            System.out.println("HALT");
        }
    }
}



// //*******************************************
// //*******************************************
//public class HaltCode extends ByteCode {
//    public void init(ArrayList<String> args) {
//
//    }
//
//
//    public void execute(VirtualMachine virtualMachine) {
//        virtualMachine.endProgram();
//    }
//
//    @Override
//    public String toString() {
//        return "HALTCODE ";
//    }
//}
