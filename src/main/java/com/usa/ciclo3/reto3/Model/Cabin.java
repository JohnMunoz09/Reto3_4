package com.usa.ciclo3.reto3.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * @Autor John Muñoz
 */
@Entity
@Table(name = "cabin")
public class Cabin implements Serializable {
    /**
     * Variable id Autoincrementable
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    /**
     * Variable name
     */
    private String name;
    /**
     * Variable brand
     */
    private String brand;
    /**
     * Variable rooms
     */
    private Integer rooms;
    /**
     * Variable description
     */
    private String description;

    /**
     * Get Id
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * Set Id
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Get name
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Set name
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get brand
     * @return brand
     */

    public String getBrand() {
        return brand;
    }

    /**
     * Set brand
     * @param brand
     */
    public void setBrand(String brand) {
        this.brand = brand;
    }

    /**
     * Get rooms
     * @return
     */
    public Integer getRooms() {
        return rooms;
    }

    /**
     * Set rooms
     * @param rooms
     */

    public void setRooms(Integer rooms) {
        this.rooms = rooms;
    }

    /**
     * Get description
     * @return
     */
    public String getDescription() {
        return description;
    }

    /**
     * Set description
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Get category
     * @return
     */
    public Category getCategory() {
        return category;
    }

    /**
     * Set category
     * @param category
     */
    public void setCategory(Category category) {
        this.category = category;
    }

    /**
     * Get List Message
     * @return
     */
    public List<Message> getMessages() {
        return messages;
    }

    /**
     * Set List Message
     * @param messages
     */
    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    /**
     * Get List Reservation
     * @return
     */
    public List<Reservation> getReservations() {
        return reservations;
    }

    /**
     * Set List Reservation
     * @param reservations
     */
    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }

    /**
     * Variable Category
     */
    @ManyToOne
    @JoinColumn(name = "idCategory")
    @JsonIgnoreProperties("cabins")
    private Category category;
    /**
     * Variable Client
     */
    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "cabin")
    @JsonIgnoreProperties({"cabin", "client"})
    private List<Message> messages;

    /**
     * Variable Reservation
     */
    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "cabin")
    @JsonIgnoreProperties({"cabin", "client"})
    private List<Reservation> reservations;

}