package hello.core.singleton;

public class StatefulService {
    private int price; // 상태를 유지하는 필드 → 지역변수, ThreadLocal 등 사용해야한다.

    public void order(String name, int price) {
        System.out.println("name = " + name + " price = " + price);
        this.price = price; // 여기가 문제!
//        return price; // 지역변수로 변하는 걸로 해결
    }
    public int getPrice() {
        return price;
    }
}
