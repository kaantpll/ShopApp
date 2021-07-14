package com.example.northwind.ShopApp.model

import javax.persistence.*


@Entity
@Table(name = "products")
data class Product (

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    val id : Int,

    @Column(name = "product_name")
    val productName : String,

    @Column(name = "quantity_per_unit")
    val quantityPerUnit : String,

    @Column(name = "unit_price")
    val unitPrice :Short,

    @Column(name = "units_in_stock")
    val unitsInStock : Short,

    @ManyToOne()
    @JoinColumn(name="category_id")
    val category : Category

)
{

    constructor(productName: String,quantityPerUnit: String,unitPrice: Short,unitsInStock: Short,category: Category) : this(
        id=78,
        productName = productName,
        quantityPerUnit = quantityPerUnit,
        unitPrice = unitPrice,
        unitsInStock = unitsInStock,
        category = category
    )

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Product

        if (id != other.id) return false
        if (productName != other.productName) return false
        if (quantityPerUnit != other.quantityPerUnit) return false
        if (unitPrice != other.unitPrice) return false
        if (unitsInStock != other.unitsInStock) return false
        if (category != other.category) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id
        result = 31 * result + productName.hashCode()
        result = 31 * result + quantityPerUnit.hashCode()
        result = 31 * result + unitPrice
        result = 31 * result + unitsInStock
        result = 31 * result + category.hashCode()
        return result
    }
}
