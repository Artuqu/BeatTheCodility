package otherAlgorithms.binarySearch;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

public class MerkleTree {

    public String createMerkleTree(List<String> list) {
        List<String> merkleRoot = merkleTree(list);
        return merkleRoot.get(0);
    }

    private List<String> merkleTree(List<String> hashList) {
        if (hashList.size() == 1) return hashList;

        List<String> parentHashList = new ArrayList<>();
        for (int i = 0; i < hashList.size(); i += 2) {
            if (i != hashList.size() - 1) {
                String hashedString = getSHA(hashList.get(i).concat(hashList.get(i + 1)));
                parentHashList.add(hashedString);
            }
        }
        if (hashList.size() % 2 == 1) {
            String lastHash = hashList.get(hashList.size() - 1);
            String hashedString = getSHA(lastHash.concat(lastHash));
            parentHashList.add(hashedString);
        }
        return merkleTree(parentHashList);
    }

    private String getSHA(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
//            digest() method called to calculate message digest of an input and return array of byte
            byte[] messageDigest = md.digest(input.getBytes());
//            convert byte array into signum representation
            BigInteger number = new BigInteger(1, messageDigest);
//            convert message digest into hex value
            String hashText = number.toString(16);
            while (hashText.length() < 32) {
                hashText = "0" + hashText;
            }
            return hashText;

        } catch (NoSuchAlgorithmException e) {
            System.out.println("Exception thrown for incorrect algorithm " + e);
            return null;
        }
    }


    public static void main(String[] args) {
        MerkleTree merkleTree = new MerkleTree();
        List<String> dataBlocks = new ArrayList<>();
        for (int i = 0; i < 100000; i++) {
            dataBlocks.add("String" + i);
        }
        String hash1 = merkleTree.createMerkleTree(dataBlocks);
        System.out.println(hash1);

        dataBlocks.clear();
        for (int i = 0; i < 100000; i++) {
            dataBlocks.add("String" + i);
        }
        String hash2 = merkleTree.createMerkleTree(dataBlocks);
        System.out.println(hash2);
        System.out.println(hash1.equals(hash2));

        dataBlocks.clear();
        for (int i = 0; i < 100000; i++) {
            if (i == 0) dataBlocks.add("String");
            dataBlocks.add("String" + i);
        }

        String hash3 = merkleTree.createMerkleTree(dataBlocks);
        System.out.println(hash3);
        System.out.println(hash3.equals(hash2));

    }
}
