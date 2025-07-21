import java.util.function.ToIntBiFunction;

class IBox {
    private int n;

    public IBox(int n) {
        this.n = n;
    }

    public int larger(IBox b) {
        if(n > b.n) {
            return n;
        }
        
        return b.n;
    }
}

public class NoObjectMethodRef {
    public static void main(String[] args) {
        IBox iBox1 = new IBox(3);
        IBox iBox2 = new IBox(5);

        ToIntBiFunction<IBox, IBox> bi = IBox::larger; // 메소드 참조 방식
        int bigNum = bi.applyAsInt(iBox1, iBox2);
        System.out.println("bigNum : " + bigNum);
    }
}
