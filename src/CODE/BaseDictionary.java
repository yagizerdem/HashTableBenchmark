package CODE;

import java.math.BigInteger;

public abstract class BaseDictionary implements  DictionaryInterface<String,HashTableEntry> {

    public int size; // initial size
    public int MAX_SIZE = 1000000;
    public int INITIAL_SIZE = 1000;
    public float LoadFactor = 0.5f;
    public HashTableEntry[] store = null;
    public SelectedHashFunction selectedHashFunction;
    public int entryCount = 0;
    public int collisionCount = 0;

    public BaseDictionary(float LoadFactor, SelectedHashFunction selectedHashFunction) {
        this.size = this.getNextPrimeNumber(this.INITIAL_SIZE);
        this.LoadFactor = LoadFactor;
        this.selectedHashFunction = selectedHashFunction;
        this.store = new HashTableEntry[this.size];
    }

    public int SSF(String key) {
        int sum = 0;
        for (int i = 0; i < key.length(); i++) {
            char ch = key.charAt(i);
            sum += ch;
        }
        return sum % this.size;
    }

    public int PAF(String key) {
        final int BASE = 31;   // A common small prime number used as base
        final int MOD = 1000000007;  // A large prime modulus to reduce overflow
        long hashValue = 0;

        // Iterate over each character in the string
        for (int i = 0; i < key.length(); i++) {
            // Add the contribution of the current character
            char ch = key.charAt(i);
            hashValue = (hashValue * BASE + ch) % MOD;
        }

        // Ensure the hash value fits within the table size
        return (int)(hashValue % this.size);
    }

    public boolean isHashTableTooFull() {
        return (float) this.entryCount / (float) this.size >= this.LoadFactor;
    }

    public void enlargeHashTable() {
        HashTableEntry[] oldStore = this.store;
        int oldSize = this.size;
        int newSize = this.getNextPrimeNumber(this.size * 2);
        HashTableEntry[] temp = new HashTableEntry[newSize];
        this.store = temp;
        this.entryCount = 0;
        this.size = newSize;

        for (int i = 0; i < oldSize; i++) {
            if (oldStore[i] != null && oldStore[i].IsIn()) {
                this.add(oldStore[i].getImdbId(), oldStore[i]);
            }
        }
    }

    public boolean checkPrime(long n) {
        // Converting long to BigInteger
        BigInteger b = new BigInteger(String.valueOf(n));

        return b.isProbablePrime(1);
    }
    public   int getNextPrimeNumber(int num){
        while (true){
            boolean flag = this.checkPrime(num);
            if(flag) {
                break;
            }
            num++;
        }
        return  num;
    }



}