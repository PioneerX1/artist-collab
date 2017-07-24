import org.junit.*;
import static org.junit.Assert.*;
import org.sql2o.*;

public class UserTest {
  @Rule
  public DatabaseRule database = new DatabaseRule();

  @Test
  public void User_instantiatesCorrectly_true() {
    User testUser = new User("Fred", "painting, drafting, AutoCAD", "Seattle", "fredartist@gmail.com");
    assertTrue(testUser instanceof User);
  }
  @Test
  public void getName_retrievesUserName_Fred() {
    User testUser = new User("Fred", "painting, drafting, AutoCAD", "Seattle", "fredartist@gmail.com");
    assertEquals("Fred", testUser.getName());
  }
  @Test
  public void getSkills_retriveUserSkills_paintingdraftingAutoCAD(){
    User testUser = new User("Fred", "painting, drafting, AutoCAD", "Seattle", "fredartist@gmail.com");
    assertEquals("painting, drafting, AutoCAD", testUser.getSkills());
  }
  @Test
  public void getLocation_retriveUserLocations_Seattle(){
    User testUser = new User("Fred", "painting, drafting, AutoCAD", "Seattle", "fredartist@gmail.com");
    assertEquals("Seattle", testUser.getLocation());
  }
  @Test
  public void getEmail_retriveUserEmail_fredartistatgmailcom(){
    User testUser = new User("Fred", "painting, drafting, AutoCAD", "Seattle", "fredartist@gmail.com");
    assertEquals("fredartist@gmail.com", testUser.getEmail());
  }
  @Test
  public void getId_retriveUserId_tru(){
    User testUser = new User("Fred", "painting, drafting, AutoCAD", "Seattle", "fredartist@gmail.com");
    testUser.save();
    assertTrue(testUser.getId() > 0);
  }

  @Test
  public void equals_compareTwoUsersIds_false(){
    User firstUser = new User("Anna", "playing piano", "Seattle", "amma@gmail");
    firstUser.save();
    User secondUser = new User("Anna", "playing piano", "Seattle", "amma@gmail");
    secondUser.save();
    assertFalse(firstUser.equals(secondUser));
  }

  @Test
  public void all_retrievesAllUsers_true() {
    User firstUser = new User("Fred", "painting, drafting, AutoCAD", "Seattle", "fredartist@gmail.com");
    User secondUser = new User("Anna", "playing piano", "Seattle", "amma@gmail");
    firstUser.save();
    secondUser.save();
    assertEquals(true, User.all().get(0).equals(firstUser));
    assertEquals(true, User.all().get(1).equals(secondUser));
  }

  @Test
  public void find_retriveUserById_true(){
    User firstUser = new User("Fred", "painting, drafting, AutoCAD", "Seattle", "fredartist@gmail.com");
    User secondUser = new User("Anna", "playing piano", "Seattle", "amma@gmail");
    firstUser.save();
    secondUser.save();
    assertEquals(secondUser, User.find(secondUser.getId()));
  }
}
