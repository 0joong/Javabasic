package challenge_chap04;
//amount = duplex ? amount*2 : amount
public class PrinterTest {
    public static void main(String[] args){
        Printer p = new Printer(100, true);
        p.addPapers(100);
        p.print(70);
        p.printnumOfPapers();
        p.print(40);
    }
}
class Printer{
    private int numOfPapers;
    private boolean duplex;

    public Printer(int numOfPapers){//constructor
        this.numOfPapers = numOfPapers;
    }
    public Printer(int numOfPapers, boolean duplex){
        this.numOfPapers = numOfPapers;
        this.duplex = duplex;
    }
    public Printer(){}

    public void print(int amount){
        if(duplex==true)
            amount = amount%2==0 ? amount/2 : amount/2+1;

        if(numOfPapers<=0){
            System.out.printf("종이가업어요");
        }
        else if(amount>numOfPapers){
            System.out.printf("모두 출력하려면 용지가 %d장 부족해여 %d장만 뽑을게요", amount-numOfPapers, numOfPapers);
            numOfPapers=0;
        }
        else{
            System.out.printf("%d장 출력!!!!", amount);
            numOfPapers-=amount;
            System.out.printf("출력하고 %d장남앗어요", numOfPapers);
        }
    }

    public void addPapers(int paper){
        numOfPapers+=paper;
    }

    public boolean getDuplex(){
        return duplex;
    }

    public void printnumOfPapers(){
        System.out.printf("%d장 남아잇서요", numOfPapers);
    }

    public void setDuplex(boolean duplex){
        this.duplex = duplex;
    }
}