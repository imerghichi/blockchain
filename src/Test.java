import java.util.Date;

public class Test {
    public static void main (String[] args){
        Blockchain blockchain = new Blockchain();
        Block blockA = new Block("version", new Date(),"data A");
        Block blockB = new Block("version", new Date(),"data B");
        Block blockC = new Block("version", new Date(),"data C");
        Block blockD = new Block("version", new Date(),"data D");

        blockchain.addBlock(blockA);
        blockchain.addBlock(blockB);
        blockchain.addBlock(blockC);
        blockchain.addBlock(blockD);

        blockchain.showChain();
    }
}
