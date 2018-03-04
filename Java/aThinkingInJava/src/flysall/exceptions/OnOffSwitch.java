package flysall.exceptions;

public class OnOffSwitch {
    private static Switch sw = new Switch();
    public static void f() throws
            OnOffException1, OnOffException2 {}
    public static void main(String[] args){
        try{
            sw.on();
            f();
            sw.off();
        } catch (OnOffException1 e) {
            System.out.print("OnOffException1");
            sw.off();
        } catch (OnOffException2 e) {
            System.out.print("OnOffException2");
        }
        // With finally:
        System.out.println("-------- With finally --------");
        try{
            sw.on();
            f();
        } catch(OnOffException1 e) {
            System.out.println("OnOffException1");
        } catch(OnOffException2 e) {
            System.out.println("OnOffException2");
        } finally {
            sw.off();
        }
    }
}
