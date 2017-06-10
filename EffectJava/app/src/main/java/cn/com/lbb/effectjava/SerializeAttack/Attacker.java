package cn.com.lbb.effectjava.SerializeAttack;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;
import java.util.Date;

import cn.com.lbb.effectjava.Serialize.Item76.Period;

/**
 *
 *
 * Created by zengcheng on 2017/6/10.
 */

public class Attacker {
    ByteArrayOutputStream bos = new ByteArrayOutputStream();
    ObjectOutputStream oo;

    public void attack() {
        try {
            Period p = new Period(new Date(),new Date());
            byte[] byteP = obj2byte(p);
//            oo = new ObjectOutputStream(bos);
//            oo.writeObject(p);
//            byte[] bytes = obj2byte(p);
            bos.write(byteP);
            Period p2 = (Period) deserialize(bos.toByteArray());
            byte[] b2 = obj2byte(p2);
            isEqual(byteP,b2);
            System.out.printf("反序列化 %s",p2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private byte[] obj2byte(Object obj) {
        ByteArrayOutputStream bo = new ByteArrayOutputStream();
        ObjectOutputStream oo;
        byte[] bytes = new byte[0];
        try {
            oo = new ObjectOutputStream(bo);
            oo.writeObject(obj);

            bytes = bo.toByteArray();

            bo.close();
            oo.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bytes;
    }

//    private void writePeriod(Period p) {
//        ByteArrayOutputStream bo = new ByteArrayOutputStream();
//        ObjectOutputStream oo;
//        byte[] bytes = new byte[0];
//        try {
//            oo = new ObjectOutputStream(bo);
//            oo.writeObject(p);
//
//            bytes = bo.toByteArray();
//
//            bo.close();
//            oo.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        try {
////            oo.writeObject(p);
//            this.bo.write(bytes);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    private void writeHideObj(Object o) {
//        try {
////            oo.writeObject(o);
//            bo.write(obj2byte(o));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    private Period readPeriod(ObjectInputStream oi) throws IOException, ClassNotFoundException {
//        return (Period) oi.readObject();
//    }
//
//    private <T> T readHideObject(ObjectInputStream oi) throws IOException, ClassNotFoundException {
//        return (T) oi.readObject();
//    }

    public static void main(String[] args) {
        Attacker attacker = new Attacker();
        attacker.attack();
    }
    private static Object deserialize(byte[] sf) {
        try {
            InputStream is = new ByteArrayInputStream(sf);
            ObjectInputStream ois = new ObjectInputStream(is);
            return ois.readObject();
        } catch (Exception e) {
            throw new IllegalArgumentException(e);
        }
    }
    private static boolean isEqual(byte[] b1,byte[] b2){
        return Arrays.equals(b1,b2);
    }
}
