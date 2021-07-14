package com.example.northwind.ShopApp.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import javax.persistence.*


@Entity
@Table(name = "categories")
@JsonIgnoreProperties("hibernateLazyInitializer","handler","products")
data class Category(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "category_id")
    val categoryId : Int,

    @Column(name = "category_name")
    val categoryName : String,
    
    @OneToMany(mappedBy = "category",fetch = FetchType.LAZY)
    val products : List<Product>
)
{
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Category

        if (categoryId != other.categoryId) return false
        if (categoryName != other.categoryName) return false
        if (products != other.products) return false

        return true
    }

    override fun hashCode(): Int {
        var result = categoryId
        result = 31 * result + categoryName.hashCode()
        result = 31 * result + products.hashCode()
        return result
    }
}