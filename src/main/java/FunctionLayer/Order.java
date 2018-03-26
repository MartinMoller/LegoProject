/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FunctionLayer;

/**
 *
 * @author martin
 */
public class Order {

    private int id;
    private int length;
    private int width;
    private int height;
    private int userId;
    private int status;
    private String email;
    private boolean door;
    private boolean window;

    public Order(int length, int width, int height, int userId, int status, boolean door, boolean window) {
        this.length = length;
        this.width = width;
        this.height = height;
        this.userId = userId;
        this.status = status;
        this.door = door;
        this.window = window;
    }

    public Order(int id, int length, int width, int height, int userId, int status, boolean door, boolean window) {
        this.id = id;
        this.length = length;
        this.width = width;
        this.height = height;
        this.userId = userId;
        this.status = status;
        this.door = door;
        this.window = window;
    }

    public Order(int id, int length, int width, int height, int userId, int status, String email) {
        this.length = length;
        this.width = width;
        this.height = height;
        this.userId = userId;
        this.status = status;
        this.id = id;
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean getDoor() {
        return door;
    }

    public void setDoor(boolean door) {
        this.door = door;
    }

    public boolean getWindow() {
        return window;
    }

    public void setWindow(boolean window) {
        this.window = window;
    }

}
