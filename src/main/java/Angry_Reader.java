public class Angry_Reader {
        private int id;
        private String lastName;
        private String firstName;
        private String faculty;
        private int course;

    public Angry_Reader() {
    }

    Angry_Reader (int id, String lastName, String firstName, String faculty, int course) {
            this.id = id;
            this.lastName = lastName;
            this.firstName = firstName;
            this.faculty = faculty;
            this.course = course;
        }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }
}

