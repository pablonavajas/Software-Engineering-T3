package ic.doc;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.fail;

public class RecentlyUsedListTest {

  private final RecentlyUsedList RUL = new RecentlyUsedList();

  @Test
  public void emptyList() {

    assertThat(RUL.empty(), is(true));
  }

  @Test
  public void addedFirstToList() {

    int obj1 = 3;
    int obj2 = 9;
    int obj3 = 10;

    RUL.add(obj1);
    RUL.add(obj3);
    RUL.add(obj2);

    assertThat(RUL.getFirst(), is(obj2));


  }

  @Test
  public void checkGetItem() {

    boolean thrown = false;
    try {
      RUL.getItem(0);
      fail("My method did not throw when I expected it to");
    }
    catch (IndexOutOfBoundsException e) {
      thrown = true;
    }
    assertThat(thrown, is(true));

    int obj_a = 1;
    thrown = false;

    try {
      RUL.add(obj_a);
      RUL.getItem(0);
    }
    catch (IndexOutOfBoundsException e) {
      thrown = true;
    }
    assertThat(thrown, is(false));
  }

  @Test
  public void checkDuplicate() {
    int obj_a = 4;
    assertThat(RUL.check_duplicate(obj_a), is(false));

    RUL.add(obj_a);
    assertThat(RUL.check_duplicate(obj_a), is(true));

    int obj_b = 4;
    assertThat(RUL.check_duplicate(obj_b), is(true));

    obj_b = 5;
    assertThat(RUL.check_duplicate(obj_b), is(false));

    RUL.add(obj_b);
    assertThat(RUL.check_duplicate(obj_b), is(true));
    assertThat(RUL.check_duplicate(obj_a), is(true));
  }

  @Test
  public void checkAddList() {

    int obj_a = 4;
    RUL.add(obj_a);
    assertThat(RUL.getItem(0), is(4));

    int obj_b = 5;
    RUL.add(obj_b);
    assertThat(RUL.getItem(0), is(5));
    assertThat(RUL.getItem(1), is(4));
  }
}
