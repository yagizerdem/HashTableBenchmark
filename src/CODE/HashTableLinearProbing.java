package CODE;

import javax.swing.*;
import java.util.Iterator;

public class HashTableLinearProbing extends  BaseDictionary {

    public HashTableLinearProbing(float LoadFactor , SelectedHashFunction selectedHashFunction){
        super(LoadFactor , selectedHashFunction);
    }
    @Override
    public HashTableEntry add(String key, HashTableEntry entry) {

        if ((key == null) || (entry == null))
            throw new IllegalArgumentException("Cannot add null to a dictionary.");
        else
        {
            HashTableEntry oldValue; // Value to return
            int index = this.selectedHashFunction == SelectedHashFunction.SSF ? this.SSF(key) : this.PAF(key);
            index = probe(index, key); // Check for and resolve collision
            // Assertion: index is within legal range for hashTable
            assert (index >= 0) && (index < this.store.length);
            if ( (this.store[index] == null) || !this.store[index].IsIn() )
            { // Key not found, so insert new entry
                entry.setEntityState(EntityState.Active);
                this.store[index] = entry;
                this.entryCount++;
                oldValue = null;
            }
            else if(this.store[index].getImdbId().equals(entry.getImdbId())){
                // append new
                this.store[index].AppendPlatforms(entry.getPlatform());
                HashTableEntry e = this.store[index];
                oldValue = null;
            }
            else
            { // Key found; get old value for return and then replace it
                entry.setEntityState(EntityState.Active);
                oldValue = this.store[index];
                this.store[index] = entry;
            }
// Ensure that hash table is large enough for another add
            if (this.isHashTableTooFull()) enlargeHashTable();
            return oldValue;
        } // end if

    }

    private int probe(int index, String key)
    {
        boolean found = false;
        int removedStateIndex = -1; // Index of first location in removed state
        while ( !found && (this.store[index] != null) )
        {
            if (this.store[index].IsIn())
            {
                if (key.equals(this.store[index].getImdbId()))
                    found = true; // Key found
                else // Follow probe sequence
                    index = (index + 1) % this.store.length; // Linear probing
            }
            else // Skip entries that were removed
            {
// Save index of first location in removed state
                if (removedStateIndex == -1)
                    removedStateIndex = index;
                index = (index + 1) % this.store.length; // Linear probing
            }
        } // end while
// Assertion: Either key or null is found at hashTable[index]
        if (found || (removedStateIndex == -1) )
            return index; // Index of either key or null
        else
            return removedStateIndex; // Index of an available location
    }
    private   int locate(int index , String key){
        boolean found = false;
        while (!found && this.store[index] != null ){
            if(this.store[index].IsIn() && key.equals(this.store[index].getImdbId())){
                found = true;
            }
            else{
                index = (index + 1) % this.store.length;
            }
        }
        int result = -1;
        if(found){
            result = index;
        }
        return  result;
    }

    @Override
    public HashTableEntry remove(String key) {
        HashTableEntry removed = null;
        int hashedIndex = this.selectedHashFunction == SelectedHashFunction.SSF ? this.SSF(key) : this.PAF(key);
        int index = locate(hashedIndex , key);
        if(index != -1){
            removed = this.store[index];
            this.store[index].setEntityState(EntityState.Removed);
            this.entryCount--;
        }
        return removed;
    }

    @Override
    public HashTableEntry getValue(String key) {
        int hashedIndex = this.selectedHashFunction == SelectedHashFunction.SSF ? this.SSF(key) : this.PAF(key);
        int index = this.locate(hashedIndex , key);
        if(index == -1){
            return  null;
        }
        return  this.store[index];
    }

    @Override
    public boolean contains(String key) {
        int hashedIndex = this.selectedHashFunction == SelectedHashFunction.SSF ? this.SSF(key) : this.PAF(key);
        int index = this.locate(hashedIndex , key);
        return  index != -1;
    }

    @Override
    public Iterator<String> getKeyIterator() {
        return null;
    }

    @Override
    public Iterator<HashTableEntry> getValueIterator() {
        return null;
    }

    @Override
    public boolean isEmpty() {
        return this.entryCount == 0;
    }

    @Override
    public int getSize() {
        return this.size;
    }

    @Override
    public void clear() {
        this.size = this.INITIAL_SIZE;
        this.store = new HashTableEntry[this.INITIAL_SIZE];
    }


}
