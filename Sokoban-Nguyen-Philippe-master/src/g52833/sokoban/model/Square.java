package g52833.sokoban.model;

import java.util.Objects;

/**
 * This class represents a square.
 *
 * @author G52833
 */
public class Square {

    private Entity entity;

    /**
     * Default constructor of the class Square.
     */
    Square() {
        this.entity = null;
    }

    /**
     * Constructor with parameters of the class Square.
     *
     * @param entity the value to initialize the attribute entity.
     */
    Square(Entity entity) {
        this.entity = entity;
    }

    /**
     * Getter of the class's attribute entity.
     *
     * @return the attribute entity.
     */
    Entity getEntity() {
        return entity;
    }

    /**
     * Method which checks if the square is free.
     *
     * @return true if it's free else false.
     */
    boolean isFree() {
        return entity == null;
    }

    /**
     * Method which puts an entity on the square.
     *
     * @param entity the entity to put.
     */
    void put(Entity entity) {
        if (!isFree()) {
            throw new IllegalStateException("The square is not free");
        }
        this.entity = entity;
    }

    /**
     * Method which removes an entity on the square.
     */
    void remove() {
        if (isFree()) {
            throw new IllegalStateException("The square is free");
        }
        entity = null;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 73 * hash + Objects.hashCode(this.entity);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        final Square other = (Square) obj;
        if (obj == null || getClass() != obj.getClass()
                || !Objects.equals(this.entity, other.entity)) {
            return false;
        }
        return true;
    }
}
