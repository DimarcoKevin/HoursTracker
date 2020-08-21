package com.dimarco.hourstacker

class Job {
    var id: Int? = null
    var companyName: String? = null
    var positionTitle: String? = null
    var wage: Double? = null

    constructor(id: Int, wage: Double) {
        this.id = id
        this.wage = wage
    }

    constructor(id: Int, companyName: String, positionTitle: String, wage: Double) {
        this.id = id
        this.companyName = companyName
        this.positionTitle = positionTitle
        this.wage = wage
    }
}