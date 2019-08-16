public class Categories implements Comparable<Categories>{

    private String id;
    private String name;

    public Categories() { // el constructor por defecto lo usa el compilador si no creo ningun constructor
    }

    public Categories(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public static enum Criteria {
        ID,
        NAME
    }

    public static Criteria criteria = Criteria.NAME;

    @Override
    public int compareTo(Categories o) {
        switch (criteria) {
            case NAME:
                return this.name.compareTo(o.getName());
            case ID:
                return this.id.compareTo(o.getId());
        }
        return 0;
    }

}