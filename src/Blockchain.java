import java.util.ArrayList;
import java.util.Base64;
import java.util.Date;
import java.util.List;

public class Blockchain {
    private List<Block> chain;

    public Blockchain() {
        this.chain = new ArrayList<Block>();
        this.chain.add(genesisBlock());
    }

    private Block genesisBlock() {
        Block genesis = new Block("02", new Date(), "sample data for genesis block");
        genesis.setPrevious_hash(null);
        genesis.compute_hash();
        return genesis;
    }

    public void addBlock(Block block) {
        Block block1 = block;
        block1.setPrevious_hash(chain.get(chain.size() - 1).getHash());
        block1.compute_hash();
        this.chain.add(block1);
    }

    public void showChain(){
        for(int i =0; i<chain.size(); i++){

            System.out.println("block: " +i);
            System.out.println("version: " + chain.get(i).getVersion());
            System.out.println("date: " + chain.get(i).getDate());
            System.out.println("hash: " + chain.get(i).getHash());
            System.out.println("data: " + chain.get(i).getData());
            System.out.println("\n");
        }
    }
}