package interpreter.bytecode;

import java.util.ArrayList;
import interpreter.virtualmachine.VirtualMachine;

public class BopCode extends ByteCode {
    private String operator;
    public void init(ArrayList<String> args){
        operator = args.get(0);
    }

    //@Override
    public void execute(VirtualMachine virtualMachine) {
        int firstArg = virtualMachine.runTimeStack.pop();
        int secondArg = virtualMachine.runTimeStack.pop();

        switch (operator){
            case "+":
                virtualMachine.runTimeStack.push(secondArg + firstArg);
                break;
            case "-":
                virtualMachine.runTimeStack.push(secondArg - firstArg);
                break;
            case "/":
                virtualMachine.runTimeStack.push(secondArg / firstArg);
                //virtualMachine.pushRunStack(secondArg / firstArg);
                break;
            case "*":
                virtualMachine.runTimeStack.push(secondArg * firstArg);
                break;
            case "==":
                if (secondArg == firstArg){
                    virtualMachine.runTimeStack.push(1);    //.pushRunStack(1);
                }else {
                    virtualMachine.runTimeStack.push(0);   //.pushRunStack(0);
                }
                break;
            case "!=":
                if (secondArg != firstArg){
                    virtualMachine.runTimeStack.push(1);   //.pushRunStack(1);
                }else {
                    virtualMachine.runTimeStack.push(0); //pushRunStack(0); }
                }
                break;

            case "<=":
                if (secondArg <= firstArg){
                    virtualMachine.runTimeStack.push(1);       //pushRunStack(1);
                }else {
                    virtualMachine.runTimeStack.push(0);     //pushRunStack(0); }
                }
                break;

            case ">":
                if (secondArg > firstArg){
                    virtualMachine.runTimeStack.push(1);
//                    virtualMachine.pushRunStack(1);
                }else { virtualMachine.runTimeStack.push(0); }
                break;

            case ">=":
                if (secondArg >= firstArg){
                    virtualMachine.runTimeStack.push(1);
                }else { virtualMachine.runTimeStack.push(0); }
                break;
            case "<":
                if (secondArg < firstArg){
                    virtualMachine.runTimeStack.push(1);
                }else { virtualMachine.runTimeStack.push(0); }
                break;

            case "|":
                if (secondArg == 0 && firstArg == 0){
                    virtualMachine.runTimeStack.push(0);
                }else { virtualMachine.runTimeStack.push(1); }
                break;
            case "&":
                if (secondArg == 1 && firstArg == 1){
                    virtualMachine.runTimeStack.push(1);
                }else { virtualMachine.runTimeStack.push(0); }
                break;
        }

        // always check if our dump is on.
        if ("ON".equals(virtualMachine.dumpMode)){
            System.out.println("BOP" + "" + operator);
        }
    }

//    @Override
//    public String toString() {
//        return "BOP ";
//    }
}
