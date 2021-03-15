package optional;

public  class School implements Comparable<School>{
    private String name;
    private int capacitate;

    @Override
    public String toString() {
        return "School{" +
                " name='" + name + '\'' +
                '}';
    }

    public void setName(String name) {
        this.name = name;
    }

    public School(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public int compareTo(School o) {
        int hash = this.name.compareTo(o.getName());
        return hash;
    }
}
