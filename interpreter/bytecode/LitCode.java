package interpreter.bytecode;

import interpreter.virtualmachine.VirtualMachine;

import java.util.ArrayList;

public class LitCode extends ByteCode {
    int n;
    String id;

    @Override
    public void init(ArrayList<String> args) {
        this.n = Integer.parseInt(args.get(0));
        if (args.size() > 1) this.id = args.get(1);

        else {
            this.id = "";
        }
    }

    @Override
    public void execute(VirtualMachine virtualMachine) {
        if ("".equals(id)){
            virtualMachine.runTimeStack.push(n);
        }else{
            virtualMachine.runTimeStack.push(0);
        }

        if ("ON".equals(virtualMachine.dumpMode)){
            String op = "LIT" + n + id;
            if (! id.equals("")){
                op = op + " int " + id;
            }
            System.out.println(op);
        }

    }

//    @Override
//    public String toString() {
//        String base = "LIT " + n;
//        if (id != null){
//            base += (" int " + id);
//        }
//        return base;
//    }
}
