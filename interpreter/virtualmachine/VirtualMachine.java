package interpreter.virtualmachine;

import interpreter.bytecode.ByteCode;
import interpreter.bytecode.DumpCode;

import interpreter.bytecode.*;
import java.util.Stack;

public class VirtualMachine {

    public RunTimeStack runTimeStack;
    public Stack<Integer> returnAddress;
    public Program program;
    public int programCounter;
    public boolean isRunning;
    public String dumpMode = "OFF";
//    private boolean isDumping = false;

    public VirtualMachine(Program program) {
        this.program = program;
    }

    public void executeProgram() {
        programCounter = 0;
        runTimeStack = new RunTimeStack();
        returnAddress = new Stack<Integer>();
        isRunning = true;
        while (isRunning) {
            ByteCode code = program.getCode(programCounter);
            code.execute(this);
            if ("ON".equals(dumpMode) && !(code instanceof DumpCode)) {
//                System.out.println(code);
                this.runTimeStack.dump();
            }
//            System.out.println("programCounter is at : " + programCounter);
            programCounter++;
        }
    }

}
