package com.pucetec.products.models.entities

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Table


@Entity
@Table(name = "products")
data class Product (
    val name : String,
    val price : Double,
    val stock : Long,
    @Column(name = "is_active")
    val isActive: Boolean,
): BaseEntity()