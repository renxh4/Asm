package com.renxh.asm;

import org.objectweb.asm.AnnotationVisitor;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.commons.AdviceAdapter;


public class TrackClassVisitor extends ClassVisitor implements Opcodes {

    public TrackClassVisitor(ClassVisitor classVisitor) {
        super(ASM7, classVisitor);
    }


    @Override
    public MethodVisitor visitMethod(int access, String name, String descriptor, String signature, String[] exceptions) {
        MethodVisitor mv = super.visitMethod(access, name, descriptor, signature, exceptions);
        return new TextMethodVisitor(ASM7, mv);
    }


    public static class TextMethodVisitor extends MethodVisitor {

        public TextMethodVisitor(int api, MethodVisitor methodVisitor) {
            super(api, methodVisitor);
        }

        @Override
        public void visitMethodInsn(int opcode, String owner, String name, String descriptor, boolean isInterface) {
            if (name.equals("onCreate") && descriptor.equals("(Landroid/os/Bundle;)V")) {
                System.out.println("开始了" + opcode + "/" + owner + "/" + name + "/" + descriptor + "/" + isInterface);
                mv.visitLdcInsn("mmm1");
                mv.visitLdcInsn("hahaha1");
                mv.visitMethodInsn(INVOKESTATIC, "android/util/Log", "d", "(Ljava/lang/String;Ljava/lang/String;)I", false);
                mv.visitInsn(POP);
                super.visitMethodInsn(opcode, owner, name, descriptor, isInterface);
                mv.visitMethodInsn(INVOKESTATIC, "java/lang/System", "currentTimeMillis", "()J", false);
                mv.visitInsn(POP2);


                mv.visitMethodInsn(INVOKESTATIC, "java/lang/System", "currentTimeMillis", "()J", false);
                mv.visitVarInsn(LSTORE, 1);

                mv.visitLdcInsn("111");
                mv.visitVarInsn(LLOAD, 1);
                mv.visitMethodInsn(INVOKESTATIC, "com/example/asm/TimeManager", "start", "(Ljava/lang/String;J)V", false);
            } else {
                super.visitMethodInsn(opcode, owner, name, descriptor, isInterface);
            }


        }
    }

}
