package com.sales.jdbc.model;

public class Student {


    private int id;
    private String studentName;
    private String studentAddress;
    private int invoiceNo;


    public Student(int id, String studentName, String studentAddress, int invoiceNo) {
        this.id = id;
        this.studentName = studentName;
        this.studentAddress = studentAddress;
        this.invoiceNo = invoiceNo;
    }

    public Student(String studentName, String studentAddress, int invoiceNo) {
        this.studentName = studentName;
        this.studentAddress = studentAddress;
        this.invoiceNo = invoiceNo;
    }

    public Student() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentAddress() {
        return studentAddress;
    }

    public void setStudentAddress(String studentAddress) {
        this.studentAddress = studentAddress;
    }

    public int getInvoiceNo() {
        return invoiceNo;
    }

    public void setInvoiceNo(int invoiceNo) {
        this.invoiceNo = invoiceNo;
    }
}
