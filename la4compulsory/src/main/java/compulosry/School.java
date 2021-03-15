package compulosry;

public  class School implements Comparable<School>{
    private int capacity;
    private String name;

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
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
