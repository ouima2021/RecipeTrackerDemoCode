package org.example.Models;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Objects;


@Entity
public class Search {

    @Id
    @GeneratedValue
    private int id;
private String lbl;
private String rpe;
private String ing;


public Search(String lbl, String rpe, String ing) {
    this.lbl = lbl;
    this.rpe = rpe;
    this.ing = ing;
}
public Search() {

}

    public void setId(int id) {
        this.id = id;
    }

    public String getLbl() {
        return lbl;
    }

    public void setLbl(String lbl) {
        this.lbl = lbl;
    }

    public String getRpe() {
        return rpe;
    }

    public void setRpe(String rpe) {
        this.rpe = rpe;
    }

    public String getIng() {
        return ing;
    }

    public void setIng(String ing) {
        this.ing = ing;
    }

    public int getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Search)) return false;
        Search search = (Search) o;
        return id == search.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Search{" +
                "label='" + lbl + '\'' +
                ", recipe='" + rpe + '\'' +
                ", ingredient='" + ing + '\'' +
                '}';
    }
}
