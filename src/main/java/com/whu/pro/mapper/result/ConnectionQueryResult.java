package com.whu.pro.mapper.result;

public class ConnectionQueryResult {
    private int case_id;
    private int element_id;
    private int type_id;
    private double coordinate_x;
    private double coordinate_y;
    private double coordinate_z;
    private String admin;
    private String model;
    private String posture;
    private String trail;

    public int getCase_id() {
        return case_id;
    }

    public void setCase_id(int case_id) {
        this.case_id = case_id;
    }

    public int getElement_id() {
        return element_id;
    }

    public void setElement_id(int element_id) {
        this.element_id = element_id;
    }

    public int getType_id() {
        return type_id;
    }

    public void setType_id(int type_id) {
        this.type_id = type_id;
    }

    public double getCoordinate_x() {
        return coordinate_x;
    }

    public void setCoordinate_x(double coordinate_x) {
        this.coordinate_x = coordinate_x;
    }

    public double getCoordinate_y() {
        return coordinate_y;
    }

    public void setCoordinate_y(double coordinate_y) {
        this.coordinate_y = coordinate_y;
    }

    public double getCoordinate_z() {
        return coordinate_z;
    }

    public void setCoordinate_z(double coordinate_z) {
        this.coordinate_z = coordinate_z;
    }

    public String getAdmin() {
        return admin;
    }

    public void setAdmin(String admin) {
        this.admin = admin;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getPosture() {
        return posture;
    }

    public void setPosture(String posture) {
        this.posture = posture;
    }

    public String getTrail() {
        return trail;
    }

    public void setTrail(String trail) {
        this.trail = trail;
    }

}
