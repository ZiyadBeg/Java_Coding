package src.com.java.code;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class SingleTon{
    private static SingleTon singleTon=new SingleTon();
    SingleTon(){};
    public static SingleTon getSingleTonInstance(){
        return singleTon;
    }
}


class SingleTonStatic{
    private static final SingleTonStatic singleTonStatic;
private SingleTonStatic(){};

static {
        try {
            singleTonStatic = new SingleTonStatic();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static SingleTonStatic getSingleTonInstanceStatic(){
        return singleTonStatic;
    }
}



class LazyInitailizationSingleTone{
    private static volatile LazyInitailizationSingleTone lazyInitailizationSingleTone=null;
    private LazyInitailizationSingleTone(){};
    public static synchronized LazyInitailizationSingleTone getLazyInitailizationSingleTone() throws InterruptedException {
        if(lazyInitailizationSingleTone==null){
            lazyInitailizationSingleTone=new LazyInitailizationSingleTone();
        }
return  lazyInitailizationSingleTone;
    }
}

class PillPughSingleTon{
    private  PillPughSingleTon(){};
    private  static  class SingleTonInnerClass{
        private  static final  PillPughSingleTon INSTANCE=new PillPughSingleTon();

    }
  public static  PillPughSingleTon getInstance(){
        return SingleTonInnerClass.INSTANCE;
  }
}


public class SingleToneClass {
    public static void main(String[] args) {
        System.out.println(SingleTon.getSingleTonInstance());
        System.out.println(SingleTonStatic.getSingleTonInstanceStatic());
        //System.out.println(LazyInitailizationSingleTone.getLazyInitailizationSingleTone());
        //SingleTonByLazyInitailization();

    }

    private static void SingleTonByLazyInitailization() {
        Runnable run=()->{
            LazyInitailizationSingleTone lazyInitailizationSingleTone= null;
            try {
                lazyInitailizationSingleTone = LazyInitailizationSingleTone.getLazyInitailizationSingleTone();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(Thread.currentThread().getName()+" "+lazyInitailizationSingleTone.hashCode());
        };
        ExecutorService executorService = null;
        try {
            executorService = Executors.newFixedThreadPool(3);
            executorService.execute(run);
            executorService.execute(run);
            executorService.execute(run);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if(executorService!=null)
                executorService.shutdown();
        }
    }

}
