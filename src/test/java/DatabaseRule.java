import org.junit.rules.ExternalResource;
import org.sql2o.*;

public class DatabaseRule extends ExternalResource {

  @Override
  protected void before() {
    DB.sql2o = new Sql2o("jdbc:postgresql://localhost:5432/artist_collab_test", null, null);
  }

  @Override
  protected void after() {
    try(Connection con = DB.sql2o.open()) {
      String deleteUsersQuery = "DELETE FROM users *;";
      String deleteProjectsQuery = "DELETE FROM projects *;";
      String deleteUsersProjectsQuery = "DELETE FROM users_projects *;";
      String deleteNotesQuery = "DELETE FROM notes *;";
      con.createQuery(deleteUsersQuery).executeUpdate();
      con.createQuery(deleteProjectsQuery).executeUpdate();
      con.createQuery(deleteUsersProjectsQuery).executeUpdate();
      con.createQuery(deleteNotesQuery).executeUpdate();

    }
  }


}
