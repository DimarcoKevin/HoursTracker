package com.dimarco.hourstacker

class Job {
    var id: Int = 0
    var companyName: String = ""
    var positionTitle: String = ""
    var wage: Double = 0.0

    constructor(companyName: String) {
        this.companyName = companyName
    }

    constructor(companyName: String, positionTitle: String, wage: Double) {
        this.companyName = companyName
        this.positionTitle = positionTitle
        this.wage = wage
    }
}