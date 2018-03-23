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

    public Order(int length, int width, int height, int userId, int status) {
        this.length = length;
        this.width = width;
        this.height = height;
        this.userId = userId;
        this.status = status;
    }

    public Order(int id, int length, int width, int height, int userId, int status) {
        this.length = length;
        this.width = width;
        this.height = height;
        this.userId = userId;
        this.status = status;
        this.id = id;
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

}
