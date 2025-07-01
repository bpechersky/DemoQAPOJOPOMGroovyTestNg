package com.demoqa.models

class User {
    String name
    String email
    String currentAddress
    String permanentAddress

    User(String name, String email, String currentAddress, String permanentAddress) {
        this.name = name
        this.email = email
        this.currentAddress = currentAddress
        this.permanentAddress = permanentAddress
    }
}
