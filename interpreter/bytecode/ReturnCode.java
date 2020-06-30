package interpreter.bytecode;
import interpreter.virtualmachine.VirtualMachine;
import java.util.ArrayList;


public class ReturnCode extends ByteCode {
    protected String functionName;
    protected int returnValue;

    public void init(ArrayList<String> args)
    {
        if(args.size() > 0)
        {
            functionName = args.get(0);
        }else{
            functionName = "";
        }
    }

    public void execute(VirtualMachine virtualMachine) {
        virtualMachine.programCounter = virtualMachine.returnAddress.pop();
        virtualMachine.runTimeStack.popFrame();
        returnValue = virtualMachine.runTimeStack.peek();

        //verify if dumpMode is on
        if("ON".equals(virtualMachine.dumpMode)) {
            int n = functionName.indexOf("<");
            String temp;
            if(n < 0){
                temp = functionName;
            }else{
                temp = functionName.substring(0,n);
            }
            System.out.println("RETURN " + functionName + " exit " + temp + ": " + returnValue);
        }
    }
}



// //*************************************
// //*************************************
//public class ReturnCode extends ByteCode {
//    private String id;
//    private int prevPC;
//
//    public void init(ArrayList<String> args) {
//        if (args.size() != 0)
//            id = args.get(0);
//    }
//
//
//    public void execute(VirtualMachine virtualMachine) {
//        virtualMachine.reset();
//        prevPC = virtualMachine.getPrevPC();
//        virtualMachine.changePC(prevPC);
//    }
//
//    @Override
//    public String toString() {
//        String str = "RETURN " + id + " exit: " + prevPC;
//        return str;
//    }
//}
