package ic.doc;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.fail;

import org.junit.Test;

public class RecentlyUsedListTest {

  private final RecentlyUsedList recentUsedList = new RecentlyUsedList();

  @Test
  public void emptyList() {

    assertThat(recentUsedList.empty(), is(true));
  }

  @Test
  public void addedFirstToList() {

    int obj1 = 3;
    int obj2 = 9;
    int obj3 = 10;

    recentUsedList.add(obj1);
    recentUsedList.add(obj3);
    recentUsedList.add(obj2);

    assertThat(recentUsedList.getFirst(), is(obj2));


  }

  @Test
  public void checkGetItem() {

    boolean thrown = false;
    try {
      recentUsedList.getItem(0);
      fail("My method did not throw when I expected it to");
    } catch (IndexOutOfBoundsException e) {
      thrown = true;
    }
    assertThat(thrown, is(true));

    int objA = 1;
    thrown = false;

    try {
      recentUsedList.add(objA);
      recentUsedList.getItem(0);
    } catch (IndexOutOfBoundsException e) {
      thrown = true;
    }
    assertThat(thrown, is(false));
  }

  @Test
  public void checkDuplicate() {
    int objA = 4;
    assertThat(recentUsedList.check_duplicate(objA), is(false));

    recentUsedList.add(objA);
    assertThat(recentUsedList.check_duplicate(objA), is(true));

    int objB = 4;
    assertThat(recentUsedList.check_duplicate(objB), is(true));

    objB = 5;
    assertThat(recentUsedList.check_duplicate(objB), is(false));

    recentUsedList.add(objB);
    assertThat(recentUsedList.check_duplicate(objB), is(true));
    assertThat(recentUsedList.check_duplicate(objA), is(true));
  }

  @Test
  public void checkAddList() {

    int objA = 4;
    recentUsedList.add(objA);
    assertThat(recentUsedList.getItem(0), is(4));

    int objB = 5;
    recentUsedList.add(objB);
    assertThat(recentUsedList.getItem(0), is(5));
    assertThat(recentUsedList.getItem(1), is(4));
  }

  @Test
  public void checkSize() {

    String wordA = "Hello";

    recentUsedList.add(wordA);
    assertThat(recentUsedList.getSize(), is(1));

    int objA = 2;
    int objB = 8;

    recentUsedList.add(objA);
    recentUsedList.add(objB);
    assertThat(recentUsedList.getSize(), is(3));
  }
}
