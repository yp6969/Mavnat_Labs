import java.util.Objects;

public class HashTableData{
    private String key;                      //family name
    private String name;
    private int id;
    private int age;
    private double avg;

    public HashTableData(String family, String name, int id, int age, double avg) {
        this.key = family;
        this.name = name;
        this.id = id;
        this.age = age;
        this.avg = avg;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HashTableData that = (HashTableData) o;
        return id == that.id && age == that.age && Double.compare(that.avg, avg) == 0 && key.equals(that.key) && name.equals(that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(key, name, id, age, avg);
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getAvg() {
        return avg;
    }

    public void setAvg(double avg) {
        this.avg = avg;
    }
} // class HashTableData