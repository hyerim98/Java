public class DDBox<U, D> {
    private U v1;
    private D v2;

    public void set(U u, D d){
        v1 = u;
        v2 = d;
    }

    @Override
    public String toString() {
        return v1.toString() + "\n" + v2.toString();
    }
}
