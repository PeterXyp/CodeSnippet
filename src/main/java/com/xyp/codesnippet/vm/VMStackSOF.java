package com.xyp.codesnippet.vm;

/**
 * VM stack memory stack over flow error
 *
 * @author Peter Xu
 *
 */
public class VMStackSOF {

    private int stackFrameLength = 1;

    /**
     * a method in the vm stack is a stack frame
     */
    private void method() {
        stackFrameLength++;
        method();
    }

    /**
     * @param args Vm args -Xss128k
     */
    public static void main(String[] args) {
        VMStackSOF vMStackSOF = new VMStackSOF();
        try {
            vMStackSOF.method();
        } catch (Exception e) {
        } finally {
            System.out.println("stack frame length in the vm stack:" + vMStackSOF.stackFrameLength);
        }
    }
}
