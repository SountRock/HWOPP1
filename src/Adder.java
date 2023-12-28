public interface Adder {
    default double adder(double item){
        return item + 1000;
    }
}
