package com.pucetec.products.services

import com.pucetec.products.exception.ProductAlreadyExistsException
import com.pucetec.products.exception.StockOutOfRangeException
import com.pucetec.products.models.entities.Product
import com.pucetec.products.repositories.ProductRepository
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException


@Service
class ProductService (
    private val productRepository: ProductRepository
)  {

    /**
     * Tengo un almacén en el que solo puedo guardar
     * 10 existencias de cada prodcuto. Si intento guardar mas
     * debo dar un error
     */
    fun save(product: Product): Product {
        if (product.stock >=10){
            throw StockOutOfRangeException("Stock out of range")
        }

        if (productRepository.findByName(product.name) != null){
            throw ProductAlreadyExistsException("Product already exists")
        }

        return productRepository.save(product)

    }

    fun findById(id: Long): Product {
        return productRepository.findById(id)
            .orElseThrow { ResponseStatusException(HttpStatus.NOT_FOUND, "Product not found") }
    }

}