package interpreter.virtualmachine;

import java.util.Iterator;
import java.util.ArrayList;
import java.util.Stack;

public class RunTimeStack
{
    private ArrayList<Integer> runTimeStack;
    private Stack<Integer> framePointer;

    public RunTimeStack() {
        runTimeStack = new ArrayList<Integer>();
        framePointer = new Stack<Integer>();
        // Add initial Frame Pointer, main is the entry
        // point of our language, so its frame pointer is 0.
        framePointer.add(0);
    }

    public void dump() {
        Iterator iter = framePointer.iterator();
        int nextFrame, currentFrame = (Integer) iter.next();
        // we print the contents of runtime stack

        for (int i = 0; i < framePointer.size(); i++) {
            if (iter.hasNext()) {
                nextFrame = (Integer) iter.next();
            } else {
                nextFrame = runTimeStack.size();
            }
            System.out.print("[");

            // let print contents of the current frame
            for (int j = currentFrame; j < nextFrame; j++) {
                System.out.print(runTimeStack.get(j));
                if (j != nextFrame - 1) {
                    System.out.print(",");
                }
            }
            System.out.print("]");
            currentFrame = nextFrame;
        }
        System.out.println();
    }

    private int lastIndex(){
        return this.runTimeStack.size() -1;
    }

    // let retrieves the last element
    public int peek() {
        return this.runTimeStack.get(lastIndex());
    }

    //pop last element
    public int pop() {
        return this.runTimeStack.remove(lastIndex());
    }

    //adds las element.
    public int push(int i){
        this.runTimeStack.add(i);
        return this.peek();
    }

    //we starts a new frame
    public void newFrameAt(int offset) {
        framePointer.push(this.runTimeStack.size() - offset);
    }

    public void popFrame() {
        int temp = this.peek();
        int temp1 = framePointer.pop();
        for (int i = runTimeStack.size() - 1; i >= temp1; i--) {
            this.pop();
        }
        this.push(temp);
    }

    // storing values
    public int store(int offset) {
        int temp = this.pop();
        this.runTimeStack.set(framePointer.peek() + offset, temp);
//        runTimeStack.set(framePointer.peek() + offset, temp);
        return temp;
    }

    //loads value
    public int load(int offset) {
        int temp = runTimeStack.get(framePointer.peek() + offset);
        runTimeStack.add(temp);
        return temp;
    }

    //checking if stack is empty
    public Boolean empty() {
        if (runTimeStack.size() == 0) {
            return true;
        }
        return false;
    }

    //pushes value into the stack
    public Integer push(Integer i) {
        runTimeStack.add(i);
        return i;
    }

    //gets offset
    public int getOffset() {
        return this.runTimeStack.size() - framePointer.peek() - 1;
    }

    //gets the value
    public int getValueAtOffset(int offset) {
        return this.runTimeStack.get(framePointer.peek() + offset);
    }

}
