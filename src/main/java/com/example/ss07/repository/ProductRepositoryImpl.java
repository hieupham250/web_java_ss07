package com.example.ss07.repository;

import com.example.ss07.model.Product2;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
public class ProductRepositoryImpl implements ProductRepository {
    private List<Product2> products = new ArrayList<>();
    private AtomicInteger nextId = new AtomicInteger(1);

    @Override
    public List<Product2> findAll() {
        return new ArrayList<>(products);
    }

    @Override
    public List<Product2> search(String keyword) {
        if (keyword == null || keyword.isEmpty()) return findAll();
        return products.stream()
                .filter(p -> p.getName().toLowerCase().contains(keyword.toLowerCase()))
                .collect(Collectors.toList());
    }

    @Override
    public Product2 findById(int id) {
        return products.stream().filter(p -> p.getId() == id).findFirst().orElse(null);
    }

    @Override
    public void save(Product2 product) {
        product.setId(nextId.getAndIncrement());
        products.add(product);
    }

    @Override
    public void update(Product2 product) {
        delete(product.getId());
        products.add(product);
    }

    @Override
    public void delete(int id) {
        products.removeIf(p -> p.getId() == id);
    }
}
