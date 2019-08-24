public class PokerCard {
    int value;
    String color;

    public PokerCard(int value, String color){
        this.value = value;
        this.color = color;
    }

    @Override
    public String toString() {
        return String.format("[%d, %s]",value,color);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == null){
            return false;
        }

        //返回obj对象能否被PokerCard类型的引用指向
        //obj对象的类型是不是PokerCard类型的小类型
        if(!(obj instanceof PokerCard)){
            return false;
        }

        PokerCard other = (PokerCard)obj;

        //equals方法,判断两个对象是否相等
        return this.value == other.value && this.color.equals(other.color);
    }
}
