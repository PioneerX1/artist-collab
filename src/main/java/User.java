import org.sql2o.*;
import java.util.*;

public class User {
  private int id;
  private String name;
  private String password;
  private String skills;
  private String location;
  private String email;
  private String time_available;
  private String picture_link;
  private String past_works;
  private String past_projects;
  private String recommendations;

  private static final String NO_TIME = "No Time Availability Specified";
  private static final String NO_PICTURE = "No Picture Link Yet";
  private static final String NO_WORKS = "No Past Works Listed";
  private static final String NO_PROJECT = "No Past Artist-Collab Projects Listed";
  private static final String NO_RECOMMENDATION = "No Recommendations Yet";


  public User(String name, String password, String skills, String location, String email){
    this.name = name;
    this.password = password;
    this.skills = skills;
    this.location = location;
    this.email = email;
    this.time_available = NO_TIME;
    this.picture_link = NO_PICTURE;
    this.past_works = NO_WORKS;
    this.past_projects = NO_PROJECT;
    this.recommendations = NO_RECOMMENDATION;
  }

  public String getPastProjects() {
    return past_projects;
  }

  public String getPictureLink() {
    return picture_link;
  }

  public String getPastWorks() {
    return past_works;
  }

  public String getName() {
    return name;
  }

  public String getPassword() {
    return password;
  }

  public String getSkills() {
    return skills;
  }

  public String getLocation() {
    return location;
  }

  public String getEmail() {
    return email;
  }

  public int getId(){
    return id;
  }
  public String getTimeAvailable() {
    return time_available;
  }

  public static List<User> searchSkills(String skills) {
    try(Connection con = DB.sql2o.open()) {
      String sql = "SELECT * FROM users WHERE skills LIKE '%"+skills+"%'";
      return con.createQuery(sql)
              .executeAndFetch(User.class);
    }
  }

  public static List<User> searchLocation(String location) {
    try(Connection con = DB.sql2o.open()) {
      String sql = "SELECT * FROM users WHERE location LIKE '%"+location+"%'";
      return con.createQuery(sql)
              .executeAndFetch(User.class);
    }
  }


  public void save(){
    try(Connection con = DB.sql2o.open()){
      String sql = "INSERT INTO users (name, password, skills, location, email, time_available, picture_link, past_works, past_projects, recommendations) VALUES (:name, :password, :skills, :location, :email, :time_available, :picture_link, :past_works, :past_projects, :recommendations)";
      this.id = (int)con.createQuery(sql, true)
      .addParameter("name", name)
      .addParameter("password", password)
      .addParameter("skills", skills)
      .addParameter("location", location)
      .addParameter("email", email)
      .addParameter("time_available", time_available)
      .addParameter("picture_link", picture_link)
      .addParameter("past_works", past_works)
      .addParameter("past_projects", past_projects)
      .addParameter("recommendations", recommendations)
      .executeUpdate()
      .getKey();
    }
  }

  public static int authenticate(String name, String password) {
    try(Connection con = DB.sql2o.open()) {
      String sql = "SELECT id FROM users WHERE name = :name AND password = :password";
      return con.createQuery(sql)
        .addParameter("name", name)
        .addParameter("password", password)
        .executeAndFetchFirst(Integer.class);
    }
  }

  @Override
  public boolean equals(Object otherUser) {
    if(!(otherUser instanceof User)) {
      return false;
    } else {
      User newUser = (User) otherUser;
      return this.getId() == newUser.getId() &&
             this.getName().equals(newUser.getName()) &&
             this.getSkills().equals(newUser.getSkills()) &&
             this.getLocation().equals(newUser.getLocation()) &&
             this.getEmail().equals(newUser.getEmail());
    }
  }

  public static List<User> all() {
    try(Connection con = DB.sql2o.open()) {
      String sql = "SELECT * FROM users";
      return con.createQuery(sql)
        .executeAndFetch(User.class);
    }
  }

  public static User find(int id){
    try(Connection con = DB.sql2o.open()){
      String sql = "SELECT * FROM users WHERE id = :id";
      return con.createQuery(sql)
            .addParameter("id", id)
            .executeAndFetchFirst(User.class);
    }
  }

  public static User findByName(String name){
    try(Connection con = DB.sql2o.open()){
      String sql = "SELECT * FROM users WHERE name = :name";
      return con.createQuery(sql)
            .addParameter("name", name)
            .executeAndFetchFirst(User.class);
    }
  }


  public void update(String name, String password, String skills, String location, String email, String time_available, String picture_link, String past_works, String past_projects){
    try(Connection con = DB.sql2o.open()){
      String sql = "UPDATE users SET name = :name, password = :password, skills =:skills, location =:location, email=:email, time_available =:time_available, picture_link =:picture_link, past_works =:past_works, past_projects =:past_projects WHERE id =:id;";
      con.createQuery(sql)
      .addParameter("name", name)
      .addParameter("password", password)
      .addParameter("skills", skills)
      .addParameter("location", location)
      .addParameter("email", email)
      .addParameter("time_available", time_available)
      .addParameter("picture_link", picture_link)
      .addParameter("past_works", past_works)
      .addParameter("past_projects", past_projects)
      .addParameter("id", id)
      .executeUpdate();
    }
  }

  public void delete() {
    try(Connection con = DB.sql2o.open()) {
      String sql = "DELETE FROM users WHERE id=:id";
      con.createQuery(sql)
        .addParameter("id", id)
        .executeUpdate();

      String sql2 = "DELETE FROM users_projects WHERE user_id = :user_id";
      con.createQuery(sql2)
        .addParameter("user_id", this.getId())
        .executeUpdate();
    }
  }

  public List<Project> getProjects() {
     try(Connection con = DB.sql2o.open()) {
       String joinQuery = "SELECT project_id FROM users_projects where user_id = :user_id";
       List<Integer> projectIds = con.createQuery(joinQuery)
         .addParameter("user_id", this.getId())
         .executeAndFetch(Integer.class);

       List<Project> projects = new ArrayList<Project>();

       for (Integer projectId : projectIds) {
          String userQuery = "SELECT * FROM projects WHERE id = :id";
          Project project = con.createQuery(userQuery)
            .addParameter("id", projectId)
            .executeAndFetchFirst(Project.class);
          projects.add(project);
        }
        return projects;
     }
   }





  //view projects that user hosts

  //update project IF user is the host
  //delete project IF user is the host
  //add members to project IF user is the host



}
