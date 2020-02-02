package ic.doc;

import java.util.List;
import java.util.ArrayList;

public class RecentlyUsedList {

  private List itemsList;

  public RecentlyUsedList() {
    itemsList = new ArrayList();
  }

  public boolean empty() {

    if (itemsList.size() == 0) {
      return true;
    }
    else {
      return false;
    }
  }

  public Object getFirst() {

    return itemsList.get(0);
  }

  public Object getItem(int position) throws IndexOutOfBoundsException {

    if (position > itemsList.size()) {
      throw new IndexOutOfBoundsException("Index out of bounds");
    }
    else {
      return itemsList.get(position);
    }
  }

  public boolean check_duplicate(Object item) {
    for (Object o : itemsList){
      if (o == item) {
        return true;
      }
    }
    return false;
  }

  public void add(Object item) {

    if (check_duplicate(item)) {
      itemsList.remove(item);
    }
    itemsList.add(0, item);
  }
}
