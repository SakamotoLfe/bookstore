package com.example.bookstore.model;

import jdk.jfr.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;
import java.util.Objects;
import java.util.UUID;

/**
 * Class created to be {} for {}.
 *
 * @author Alfredo marin
 * @version 1
 * @since 2023-03-28
 */

@Entity
public class Author extends GenericEntity {

    @Column
    private String name;

    @Temporal(TemporalType.DATE)
    private Date birthday;

    /* Constructors */

    public Author(UUID id, Date createdDate, Date lastUpdate, boolean enable, String name, Date birthday) {
        super(id, createdDate, lastUpdate, enable);
        this.name = name;
        this.birthday = birthday;
    }

    public Author(String name, Date birthday) {
        this.name = name;
        this.birthday = birthday;
    }

    public Author() {
    }

    /* Equals and HashCode */

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Author author = (Author) o;
        return Objects.equals(name, author.name) && Objects.equals(birthday, author.birthday);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, birthday);
    }

    /* Getters and Setters */

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    /* To String */

    /**
     * To String Method.
     * @return {@link String}. String with all objects' values.
     */
    @Override
    public String toString() {
        return "Author{" +
                "name='" + name + '\'' +
                ", birthday=" + birthday +
                '}';
    }
}
