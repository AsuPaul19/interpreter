
package interpreter;

import interpreter.bytecode.ByteCode;
import interpreter.virtualmachine.Program;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.StringTokenizer;
import interpreter.bytecode.*;

public class ByteCodeLoader extends Object {
    private BufferedReader byteSource;

    /**
     * Constructor Simply creates a buffered reader.
     * YOU ARE NOT ALLOWED TO READ FILE CONTENTS HERE
     * THIS NEEDS TO HAPPEN IN loadCodes.
     */
    public ByteCodeLoader(String codeFile) throws IOException {
        this.byteSource = new BufferedReader(new FileReader(codeFile));
    }

    /**
     * This function should read one line of source code at a time.
     * For each line it should:
     * Tokenize string to break it into parts. Can also use the split function in the String class.
     * Grab THE correct class name for the given ByteCode from CodeTable
     * Create an instance of the ByteCode class name returned from code table.
     * Parse any additional arguments for the given ByteCode and send them to
     * the newly created ByteCode instance via the init function.
     */

    public Program loadCodes() {
        String line;
        String[] items;
        ArrayList<String> args = new ArrayList<>();
        String byteCodeName;    // ByteCode name from .x.cod file
        String className;       // class name after its mapped from name in source code to class name.
        Class classBlueprint;
        Program program = new Program();
        ByteCode byteCode;
        try {

            while (this.byteSource.ready()) {
                // tokenize read line
                line = this.byteSource.readLine();
                items = line.split("\\s+");
                // grab first token of line
                byteCodeName = items[0];
                // grab class name from token
                className = CodeTable.getClassName(byteCodeName);
                // load class blueprint from classname
                classBlueprint = Class.forName("interpreter.bytecode." + className);
                // get declared constructor(should be no-arg constructor)
                // create a new instance of bytecode using cnstructor
                byteCode = (ByteCode) classBlueprint.getDeclaredConstructor().newInstance();

                // grab remaining arguments.
                // pass args to bytecode init function
                byteCode.init(args);
                // add bytecode to program
                program.add(byteCode);

            }
            line = this.byteSource.readLine();
        } catch (IOException | ClassNotFoundException ex) {
            System.out.println(ex);
            System.exit(255);
        }
        catch (InstantiationException | InvocationTargetException | NoSuchMethodException | IllegalAccessException e) {
            e.printStackTrace();
        }
        program.resolveAddress();
        return program;

    }
}
