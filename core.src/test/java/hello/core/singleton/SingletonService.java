package hello.core.singleton;

public class SingletonService {

    private static final SingletonService instance = new SingletonService();
    // 스태틱 영역에 딱 하나 올라감

    public static  SingletonService getInstance(){
        return instance; //조회하는 역할
    }

    private SingletonService(){

    }

   public void logic(){
       System.out.println("싱글톤 객체 로직 호출");
   }

}
