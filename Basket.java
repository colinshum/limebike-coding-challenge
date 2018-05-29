import java.util.*;

public class Basket {
    private HashMap<String, Integer> mItems;

    public Basket() {
        mItems = new HashMap<>();
    }

    public Basket(HashMap<String, Integer> items) {
        mItems = items;
    }

    public void addItem(Basket basket) {
        HashMap<String, Integer> items = basket.getItems();

        // 'merge()' generates a key if it doesn't exist, else it adds the value to the existing key
        // Time Complexity: O(n)
        //     - For Loop: O(n) for 'items' iteration
        //     - 'merge()' and 'get()': O(1)
        for (String key : items.keySet()) {
            mItems.merge(key, items.get(key), Integer::sum);
        }
    }

    public void removeItem(Basket basket) {
        HashMap<String, Integer> items = basket.getItems();

        // Iterates through all the keys in the 'items' HashMap and removes their values from 'mItem'
        // Time Complexity: O(n)
        //    - For Loop: O(n) 
        //    - 'get(), remove(), containsKey()': O(1)
        for (String key : items.keySet()) {
            if (mItems.containsKey(key) && mItems.get(key) >= items.get(key)) {
                mItems.put(key, mItems.get(key) - items.get(key));
                if (mItems.get(key) == 0) {
                    mItems.remove(key);
                }
            } else {
                System.err.println("Invalid removal: item does not exist or amount to be removed exceeds item count.");
            }
        }
    }

    public HashMap<String, Integer> getItems() {
        return mItems;
    }

    public void setBasket(HashMap<String, Integer> items) {
        mItems = items;
    }

    public String listItems() {
        // Iterates through all keys in the 'mItems' HashMap and concatenates the values/items into a string
        // Time Complexity: O(n)
        String list = "";

        for (String key : mItems.keySet()) {
            int count = mItems.get(key);
            if (count > 0) {
                list += Integer.toString(count) + " " + key;
                list += (count > 1) ? "s, " : ", ";
            }
        }

        // Format string correctly by truncating traiing characters and adding a newline
        if (list.length() >= 2) {
            list = list.substring(0, list.length() - 2);
        }

        list += "\n";
        return list;
    }

    public void modifyBasket(boolean keepItems, Basket items) {
        // Allows for a Basket object to be mutated by adding or removing items
        if (keepItems) {
            this.addItem(items);
        } else {
            this.removeItem(items);
        }
    }
}
