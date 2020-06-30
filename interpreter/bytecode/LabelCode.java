package interpreter.bytecode;
import interpreter.virtualmachine.VirtualMachine;
import java.util.ArrayList;


//public class LabelCode extends ByteCode {
//    private String label;
//
//    public void init(ArrayList<String> args) {
//        label = args.get(0);
//    }
//
//    public void execute(VirtualMachine virtualMachine) {
//            //check if the dumpMode is on
//        if("ON".equals(virtualMachine.dumpMode)) {
//            System.out.println("LABEL" + " " + label);
//        }
//    }
//
//    public String getLabel() {
//        return label;
//    }
//}


// //********************************************
// //********************************************

public class LabelCode extends ByteCode {
    private String address;

    public void init(ArrayList<String> args) {
        address = args.get(0);
    }

    public String getAddress(){
        return address;
    }
    public void setAddress(int i){
        address = Integer.toString(i);
    }


    public void execute(VirtualMachine virtualMachine) {
        if ("ON".equals(virtualMachine.dumpMode)){
            System.out.println("LABEL" + "" + address);
        }
    }

    public String getLabel(){
        return address;
    }
//    @Override
//    public String toString() {
//        return address;
//    }
}
