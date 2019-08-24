import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Random;

public class Main {
    private static void swap(ArrayList<PokerCard> list,int i,int j){
        PokerCard tmpI = list.get(i);
        PokerCard tmpJ = list.get(j);
        list.set(i,tmpJ);
        list.set(j,tmpI);
    }

    public static void main(String[] args) {
        ArrayList<PokerCard> cards = new ArrayList<>(52);
        String[] colors = {"♥","♦","♣","♠"};

        for(int i = 0; i < 4; i++){
            for(int j = 1; j <= 13; j++){
                PokerCard card = new PokerCard(j, colors[i]);
                cards.add(card);
            }
        }
        //System.out.println(cards);

        //洗牌

        /*
        Random random = new Random(20190820);
        for(int i = 0; i < 10; i++){
            System.out.println(random.nextInt(20));
        }
        */

        Random random = new Random(20190820);
        for(int i = 51; i > 0; i--){
            int j = random.nextInt(i);
            swap(cards, i, j);
        }
        System.out.println(cards);

        //有三个人,每个人抓 5 张牌
        ArrayList<PokerCard> A = new ArrayList<>();
        ArrayList<PokerCard> B = new ArrayList<>();
        ArrayList<PokerCard> C = new ArrayList<>();

        System.out.println(cards.subList(52 - 15, 52));

        for (int i = 0; i < 15; i++) {
            PokerCard card = cards.remove(cards.size() - 1);
            switch(i % 3){
                case 0:
                    A.add(card);
                    break;
                case 1:
                    B.add(card);
                    break;
                case 2:
                    C.add(card);
                    break;
            }
        }
        System.out.println(cards.size());
        System.out.println(A);
        System.out.println(B);
        System.out.println(C);

        //A抓到的牌中,有没有[红心 A]
        PokerCard heartA = new PokerCard(3,"♣");

        for(PokerCard card: A){
            //如何判断card是不是红心 A
            //自定义类如何判断两个对象相等?
            if(card.equals(heartA)){
                System.out.println("包含");
            }
        }

        if(A.contains(heartA)){
            System.out.println("包含");
        }else{
            System.out.println("不包含");
        }

        /*
        System.out.println(A);
        for(int i = 0; i < A.size(); i++){
            PokerCard o = A.get(i);
            if(o.equals(heartA)){
                A.remove(o);
            }
        }
        System.out.println(A);
        */

        //迭代器
        System.out.println(A);
        Iterator<PokerCard> it = A.iterator();
        while(it.hasNext()){
            PokerCard o = it.next();
            if(o.equals(heartA)){
                it.remove();
            }
        }
        System.out.println(A);

        /*
        System.out.println(A);
        for(PokerCard o : A){
            if(o.equals(heartA)){
                A.remove(o);
            }
        }
        System.out.println(A);
        */

        Iterator<PokerCard> it1 = A.iterator();
        while(it1.hasNext()){
            System.out.println(it1.next());
        }

        ListIterator<PokerCard> it2 = A.listIterator();
        System.out.println(it2.next());
        System.out.println(it2.next());
        System.out.println(it2.previous());
    }
}
