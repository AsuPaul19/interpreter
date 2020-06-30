package interpreter.bytecode;
import interpreter.virtualmachine.VirtualMachine;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class ReadCode extends ByteCode {

    public void init(ArrayList<String> args) { }

    public void execute(VirtualMachine virtualMachine) {
        //ask the user to enter an integer
        System.out.print("Please input an integer: ");

        try {
            BufferedReader in = new BufferedReader( new InputStreamReader(System.in ) );
            String line = in.readLine();
            virtualMachine.runTimeStack.push(Integer.parseInt(line));
        } catch( java.io.IOException ex ) { }

        //verify if dump mode is on
        if("ON".equals(virtualMachine.dumpMode))
        {
            System.out.println("READ");
        }
    }
}




// //************************************
// //************************************
//public class ReadCode extends ByteCode {
//    public void init(ArrayList<String> args) {
//
//    }
//
//
//    public void execute(VirtualMachine virtualMachine) {
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Enter an integer: ");
//        int val = scanner.nextInt();
//        virtualMachine.pushRunStack(val);
//    }
//
//    @Override
//    public String toString() {
//        return "READ";
//    }
//}
